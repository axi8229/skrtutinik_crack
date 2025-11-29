package flussonic.watcher.sdk.presentation.player.exo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.ConnectionResult;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.domain.pojo.PlaybackStatus;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.utils.ObjectUtils;
import flussonic.watcher.sdk.presentation.core.FlussonicPlayer;
import flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView;
import flussonic.watcher.sdk.presentation.watcher.StreamerUrlProvider;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class FlussonicPlayerView extends FrameLayout implements FlussonicPlayer {
    private boolean canAddMediaSource;
    private final CompositeDisposable compositeDisposableSpeedControl;
    private ConcatenatingMediaSource concatenatingMediaSource;
    private long currentWindowStartTimeMs;
    private final DefaultDashChunkSource.Factory dashChunkSourceFactory;
    private final FlussonicBandwidthMeter flussonicBandwidthMeter;
    private long from;
    private final GestureDetector gestureDetector;
    private final OnTapConfirmedGestureListener gestureListener;
    private boolean hasPendingPlayArchive;
    private final DefaultHttpDataSourceFactory httpDataSourceFactory;
    private int indexOfAudioRenderer;
    private DefaultLoadControl loadControl;
    private Disposable loadNextMediaSourceDisposable;
    private final DefaultDataSourceFactory manifestDataSourceFactory;
    private final DashManifestParser manifestParser;
    private AnalyticsListener playbackStatsListener;
    private SimpleExoPlayer player;
    private PlayerEventListener playerEventListener;
    private FlussonicPlayer.PlayerListener playerListener;
    private PlayerView playerView;
    private boolean skippedNoManifestException;
    private StreamerUrlProvider streamerUrlProvider;
    private boolean switchToLive;
    private Timeline.Window tmpWindow;
    private DefaultTrackSelector trackSelector;
    private final String userAgent;

    public FlussonicPlayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        String userAgent = Util.getUserAgent(getContext(), "Flussonic Watcher");
        this.userAgent = userAgent;
        FlussonicBandwidthMeter flussonicBandwidthMeter = new FlussonicBandwidthMeter();
        this.flussonicBandwidthMeter = flussonicBandwidthMeter;
        DefaultHttpDataSourceFactory defaultHttpDataSourceFactory = new DefaultHttpDataSourceFactory(userAgent, flussonicBandwidthMeter);
        this.httpDataSourceFactory = defaultHttpDataSourceFactory;
        this.dashChunkSourceFactory = new DefaultDashChunkSource.Factory(defaultHttpDataSourceFactory);
        this.manifestDataSourceFactory = new DefaultDataSourceFactory(getContext(), userAgent);
        this.manifestParser = new DashManifestParser();
        OnTapConfirmedGestureListener onTapConfirmedGestureListener = new OnTapConfirmedGestureListener();
        this.gestureListener = onTapConfirmedGestureListener;
        this.gestureDetector = new GestureDetector(getContext(), onTapConfirmedGestureListener);
        this.concatenatingMediaSource = new ConcatenatingMediaSource(new MediaSource[0]);
        this.tmpWindow = new Timeline.Window();
        this.compositeDisposableSpeedControl = new CompositeDisposable();
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        View.inflate(getContext(), R$layout.fs_view_flussonic_player_exo, this);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.playerView = (PlayerView) findViewById(R$id.player_view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return this.gestureDetector.onTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        disposeLoadNextMediaSource();
        disposeSpeedControlTimers();
        super.onDetachedFromWindow();
    }

    private void disposeLoadNextMediaSource() {
        Disposable disposable = this.loadNextMediaSourceDisposable;
        if (disposable != null) {
            disposable.dispose();
            this.loadNextMediaSourceDisposable = null;
        }
    }

    private void disposeSpeedControlTimers() {
        CompositeDisposable compositeDisposable = this.compositeDisposableSpeedControl;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }

    private void startSpeedControlTimers() {
        this.compositeDisposableSpeedControl.add(Observable.interval(3000L, TimeUnit.MILLISECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.updateSpeed(((Long) obj).longValue());
            }
        }, new Consumer() { // from class: flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.onSpeedControlError((Throwable) obj);
            }
        }));
    }

    private void stopSpeedControlTimers() {
        this.compositeDisposableSpeedControl.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSpeed(long time) {
        if (this.player == null || isSwitchToLive() || this.from > 0) {
            return;
        }
        if (this.player.getBufferedPosition() - this.player.getCurrentPosition() > 1000) {
            this.player.setPlaybackSpeed(Math.min(1.5f, Math.max((Math.round(r5 / 1000) / 10.0f) + 1.0f, 1.25f)));
        } else {
            this.player.setPlaybackSpeed(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSpeedControlError(Throwable throwable) {
        Timber.e(throwable, "onSpeedControlError", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public long getPlaybackTimeUtcInSeconds() {
        long j = this.from;
        return (!isPlayerNonNull() || getPlayer().getPlaybackTimeUtc() == -9223372036854775807L || getPlayer().getPlaybackTimeUtc() < 0) ? j : getPlayer().getPlaybackTimeUtc() / 1000;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public PlaybackStatus getPlaybackStatus() {
        if (isPlayerNonNull()) {
            int playbackState = getPlayer().getPlaybackState();
            if (playbackState == 2) {
                return PlaybackStatus.PREPARING;
            }
            if (playbackState == 3) {
                return getPlayer().getPlayWhenReady() ? PlaybackStatus.PLAYING : PlaybackStatus.PAUSED;
            }
            if (playbackState == 4) {
                return PlaybackStatus.PLAYBACK_COMPLETED;
            }
            if (getPlayer().getPlaybackError() != null) {
                return PlaybackStatus.ERROR;
            }
        }
        return PlaybackStatus.IDLE;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public long getFrom() {
        return this.from;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public boolean isSwitchToLive() {
        return this.switchToLive;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void moveToForeground() {
        initPlayer();
        stopSpeedControlTimers();
        startSpeedControlTimers();
    }

    private void initPlayer() {
        Context context = getContext();
        AdaptiveTrackSelection.Factory factory = new AdaptiveTrackSelection.Factory();
        DefaultRenderersFactory defaultRenderersFactoryExperimental_setMediaCodecOperationMode = new DefaultRenderersFactory(context).setExtensionRendererMode(1).setEnableDecoderFallback(true).experimental_setMediaCodecOperationMode(4);
        this.trackSelector = new DefaultTrackSelector(context, factory);
        this.loadControl = new DefaultLoadControl.Builder().setBufferDurationsMs(10000, ActivityRecognitionConstants.DEFAULT_DETECTION_INTERVAL_MILLIS, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, 3000).setBackBuffer(0, false).createDefaultLoadControl();
        this.player = new SimpleExoPlayer.Builder(context, defaultRenderersFactoryExperimental_setMediaCodecOperationMode).setTrackSelector(this.trackSelector).setLoadControl(this.loadControl).setBandwidthMeter(this.flussonicBandwidthMeter).build();
        if (this.playerView == null) {
            this.playerView = (PlayerView) findViewById(R$id.player_view);
        }
        this.playerView.setPlayer(this.player);
        this.player.setPlayWhenReady(true);
        this.playerView.setKeepContentOnPlayerReset(true);
        PlayerEventListener playerEventListener = new PlayerEventListener(this.playerListener);
        this.playerEventListener = playerEventListener;
        this.player.addListener(playerEventListener);
        AnalyticsListener analyticsListener = this.playbackStatsListener;
        if (analyticsListener != null) {
            this.player.addAnalyticsListener(analyticsListener);
        }
        this.playerView.setUseController(false);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void playLive() {
        if (isStreamerUrlProviderNonNull() && isPlayerNonNull()) {
            this.from = 0L;
            this.hasPendingPlayArchive = false;
            this.switchToLive = false;
            String playerUrl = getStreamerUrlProvider().getPlayerUrl(0L);
            getPlayer().setMediaSource(new ProgressiveMediaSource.Factory(this.httpDataSourceFactory).createMediaSource(MediaItem.fromUri(playerUrl)));
            getPlayer().prepare();
            Timber.d("play live uri %s", playerUrl);
        }
        disposeLoadNextMediaSource();
        stopSpeedControlTimers();
        startSpeedControlTimers();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void playArchive(long from) {
        if (seekWithinManifest(from)) {
            return;
        }
        this.from = from;
        this.hasPendingPlayArchive = false;
        this.skippedNoManifestException = false;
        this.switchToLive = false;
        this.concatenatingMediaSource = new ConcatenatingMediaSource(new MediaSource[0]);
        addMediaSource(from);
        getPlayer().setMediaSource(this.concatenatingMediaSource);
        getPlayer().prepare();
        Timber.d("play archive from %d", Long.valueOf(from));
        stopSpeedControlTimers();
        disposeLoadNextMediaSource();
        this.loadNextMediaSourceDisposable = Flowable.interval(200L, TimeUnit.MILLISECONDS).onBackpressureDrop().observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$playArchive$0((Long) obj);
            }
        }).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$playArchive$1((Long) obj);
            }
        }).doOnNext(new Consumer() { // from class: flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$playArchive$2((Long) obj);
            }
        }).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playArchive$0(Long ignored) throws Exception {
        attemptLoadNextMediaSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playArchive$1(Long ignored) throws Exception {
        removeRedundantMediaSources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playArchive$2(Long ignored) throws Exception {
        checkPendingPlayArchive();
    }

    private boolean seekWithinManifest(long from) {
        if (isPlayerNonNull() && this.concatenatingMediaSource.getSize() > 0 && getPlayer().getCurrentWindowIndex() != -1 && getPlayer().getCurrentTimeline() != null && getPlayer().getPlaybackError() == null) {
            try {
                Timeline.Window window = getPlayer().getCurrentTimeline().getWindow(getPlayer().getCurrentWindowIndex(), this.tmpWindow);
                this.tmpWindow = window;
                long j = from * 1000;
                long j2 = window.windowStartTimeMs;
                if (j >= j2 && j <= j2 + window.getDurationMs() && getPlayer().isCurrentWindowSeekable() && getPlayer().getCurrentWindowIndex() != -1) {
                    Timber.d("player seek %d", Long.valueOf(j));
                    getPlayer().seekTo(getPlayer().getCurrentWindowIndex(), j - this.tmpWindow.windowStartTimeMs);
                    return true;
                }
            } catch (IndexOutOfBoundsException e) {
                Timber.e(e, "Error while seekWithinManifest", new Object[0]);
            }
        }
        return false;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void continuePlayArchive(long from) {
        this.from = from;
        this.skippedNoManifestException = false;
        if (isPlayerNonNull()) {
            this.hasPendingPlayArchive = true;
            Timber.d("player continue play archive %d", Long.valueOf(from));
            removeLastMediaSource();
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void continuePlayLive() {
        if (isPlayerNonNull()) {
            this.switchToLive = true;
            Timber.d("player continue play live", new Object[0]);
            removeLastMediaSource();
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void setResizeMode(int resizeMode) {
        if (isPlayerNonNull()) {
            this.playerView.setResizeMode(resizeMode);
        }
    }

    private void removeLastMediaSource() {
        if (this.concatenatingMediaSource.getSize() > 0) {
            this.concatenatingMediaSource.removeMediaSource(r0.getSize() - 1);
        }
    }

    private void addMediaSource(long from) {
        if (isStreamerUrlProviderNonNull()) {
            String playerUrl = getStreamerUrlProvider().getPlayerUrl(from);
            this.concatenatingMediaSource.addMediaSource(new DashMediaSource.Factory(this.dashChunkSourceFactory, this.manifestDataSourceFactory).setManifestParser(this.manifestParser).createMediaSource(MediaItem.fromUri(playerUrl)));
            Timber.d("added media source %s", playerUrl);
        }
    }

    private void attemptLoadNextMediaSource() {
        if (!isPlayerNonNull() || this.hasPendingPlayArchive || this.switchToLive) {
            return;
        }
        try {
            Timeline.Window window = getPlayer().getCurrentTimeline().getWindow(getPlayer().getCurrentWindowIndex(), this.tmpWindow);
            this.tmpWindow = window;
            long j = window.windowStartTimeMs;
            if (j != this.currentWindowStartTimeMs) {
                this.currentWindowStartTimeMs = j;
                this.canAddMediaSource = true;
            }
        } catch (Exception e) {
            Timber.w(e);
        }
        if (isStreamerUrlProviderNonNull()) {
            long j2 = this.from >= (Calendar.getInstance().getTimeInMillis() / 1000) - 3600 ? 0L : 15000L;
            if (getPlayer().getDuration() == -9223372036854775807L || getPlayer().getCurrentPosition() < getPlayer().getDuration() - j2 || !this.canAddMediaSource) {
                return;
            }
            long j3 = this.from + 3600;
            this.from = j3;
            addMediaSource(j3);
            this.skippedNoManifestException = true;
            this.canAddMediaSource = false;
        }
    }

    private void removeRedundantMediaSources() {
        if (!isPlayerNonNull() || this.concatenatingMediaSource.getSize() <= 2) {
            return;
        }
        for (int i = 0; i < this.concatenatingMediaSource.getSize() - 2; i++) {
            this.concatenatingMediaSource.removeMediaSource(i);
        }
    }

    private void checkPendingPlayArchive() {
        if (isPlayerNonNull()) {
            if (this.hasPendingPlayArchive && getPlayer().getPlaybackState() == 4) {
                Timber.d("player hasPending and play archive %d", Long.valueOf(this.from));
                playArchive(this.from);
            } else {
                if (!this.skippedNoManifestException || getPlayer().getCurrentPosition() <= getPlayer().getDuration() || this.concatenatingMediaSource.getSize() <= 0) {
                    return;
                }
                if (((DashMediaSource) this.concatenatingMediaSource.getMediaSource(r0.getSize() - 1)).getManifest() == null) {
                    Timber.d("player checkPending and play archive %d", Long.valueOf(this.from));
                    playArchive(this.from);
                }
            }
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void moveToBackground() {
        releasePlayer();
    }

    private void releasePlayer() {
        Timber.d(">>> release FlussonicPlayerView <<<", new Object[0]);
        if (isPlayerNonNull()) {
            getPlayer().removeListener(this.playerEventListener);
            getPlayer().stop();
            getPlayer().release();
            this.playerView.setPlayer(null);
        }
        this.player = null;
        this.playerEventListener = null;
        this.playerView = null;
        disposeLoadNextMediaSource();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void pause() {
        if (isPlayerNonNull()) {
            getPlayer().setPlayWhenReady(false);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void resume() {
        if (isPlayerNonNull()) {
            getPlayer().setPlayWhenReady(true);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void stop() {
        if (isPlayerNonNull()) {
            getPlayer().stop(true);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void setPlayerListener(FlussonicPlayer.PlayerListener playerListener) {
        this.playerListener = playerListener;
        this.gestureListener.setPlayerListener(playerListener);
        PlayerEventListener playerEventListener = this.playerEventListener;
        if (playerEventListener != null) {
            playerEventListener.setPlayerListener(playerListener);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void setFlussonicPlaybackStatsListener(FlussonicPlaybackStatsListener playbackStatsListener) {
        AnalyticsListener analyticsListener;
        if (playbackStatsListener == null) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null && (analyticsListener = this.playbackStatsListener) != null) {
                simpleExoPlayer.removeAnalyticsListener(analyticsListener);
            }
            this.playbackStatsListener = null;
        } else {
            SimpleExoPlayer simpleExoPlayer2 = this.player;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.addAnalyticsListener(playbackStatsListener);
            }
        }
        this.playbackStatsListener = playbackStatsListener;
        this.flussonicBandwidthMeter.setFlussonicPlaybackStatsListener(playbackStatsListener);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void setVolume(float volume) {
        if (isPlayerNonNull()) {
            getPlayer().setVolume(volume);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void setSpeed(float speed) {
        if (isPlayerNonNull()) {
            getPlayer().setPlaybackSpeed(speed);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public Format getCurrentTrack() {
        if (isPlayerNonNull()) {
            return getPlayer().getVideoFormat();
        }
        return null;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public List<Format> getAvailableTracks() {
        List<FormatWrapper> availableFormats = getAvailableFormats();
        ArrayList arrayList = new ArrayList();
        Iterator<FormatWrapper> it = availableFormats.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().format);
        }
        return arrayList;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void disableAudioTrack(boolean disableAudio) {
        if (this.trackSelector == null || isAudioTrackDisabled() == disableAudio) {
            return;
        }
        this.indexOfAudioRenderer = -1;
        DefaultTrackSelector.ParametersBuilder parametersBuilderBuildUponParameters = this.trackSelector.buildUponParameters();
        int i = 0;
        while (true) {
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer == null || i >= simpleExoPlayer.getRendererCount()) {
                break;
            }
            if (this.player.getRendererType(i) == 1) {
                this.indexOfAudioRenderer = i;
                parametersBuilderBuildUponParameters.setRendererDisabled(i, disableAudio);
                break;
            }
            i++;
        }
        this.trackSelector.setParameters(parametersBuilderBuildUponParameters);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public boolean isAudioTrackDisabled() {
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null || this.indexOfAudioRenderer < 0) {
            return true;
        }
        return defaultTrackSelector.getParameters().getRendererDisabled(this.indexOfAudioRenderer);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public int setMaxFrameRate(int maxFPS) {
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null) {
            return 0;
        }
        defaultTrackSelector.setParameters(defaultTrackSelector.buildUponParameters().setMaxVideoFrameRate(maxFPS));
        return this.trackSelector.getParameters().maxVideoFrameRate;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public Quality getQuality() {
        Format currentTrack = getCurrentTrack();
        if (currentTrack == null) {
            return null;
        }
        List<Format> availableTracks = getAvailableTracks();
        if (availableTracks.isEmpty()) {
            return null;
        }
        return ObjectUtils.equals(availableTracks.get(0).id, currentTrack.id) ? Quality.HD : Quality.SD;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void setQuality(Quality quality) {
        List<FormatWrapper> availableFormats = getAvailableFormats();
        if (this.trackSelector == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[quality.ordinal()];
        FormatWrapper formatWrapper = null;
        if (i == 1) {
            applySelection(0, null, null);
            return;
        }
        if (i == 2) {
            formatWrapper = (FormatWrapper) ObjectUtils.getFirst(availableFormats);
        } else if (i == 3) {
            formatWrapper = (FormatWrapper) ObjectUtils.getLast(availableFormats);
        }
        if (formatWrapper == null) {
            return;
        }
        applySelection(formatWrapper.r, formatWrapper.trackGroups, new DefaultTrackSelector.SelectionOverride(formatWrapper.g, formatWrapper.f));
    }

    /* renamed from: flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality;

        static {
            int[] iArr = new int[Quality.values().length];
            $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality = iArr;
            try {
                iArr[Quality.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[Quality.HD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[Quality.SD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void applySelection(int rendererIndex, TrackGroupArray trackGroups, DefaultTrackSelector.SelectionOverride override) {
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null) {
            return;
        }
        DefaultTrackSelector.ParametersBuilder parametersBuilderBuildUponParameters = defaultTrackSelector.buildUponParameters();
        if (override != null) {
            parametersBuilderBuildUponParameters.setSelectionOverride(rendererIndex, trackGroups, override);
        } else {
            parametersBuilderBuildUponParameters.clearSelectionOverrides();
        }
        this.trackSelector.setParameters(parametersBuilderBuildUponParameters);
    }

    private List<FormatWrapper> getAvailableFormats() {
        MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        ArrayList arrayList = new ArrayList();
        DefaultTrackSelector defaultTrackSelector = this.trackSelector;
        if (defaultTrackSelector == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return arrayList;
        }
        for (int i = 0; i < currentMappedTrackInfo.getRendererCount(); i++) {
            TrackGroupArray trackGroups = currentMappedTrackInfo.getTrackGroups(i);
            for (int i2 = 0; i2 < trackGroups.length; i2++) {
                TrackGroup trackGroup = trackGroups.get(i2);
                for (int i3 = 0; i3 < trackGroup.length; i3++) {
                    arrayList.add(new FormatWrapper(trackGroup.getFormat(i3), trackGroups, i, i2, i3, null));
                }
            }
        }
        Collections.sort(arrayList, new Comparator() { // from class: flussonic.watcher.sdk.presentation.player.exo.FlussonicPlayerView$$ExternalSyntheticLambda3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return FlussonicPlayerView.lambda$getAvailableFormats$3((FlussonicPlayerView.FormatWrapper) obj, (FlussonicPlayerView.FormatWrapper) obj2);
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getAvailableFormats$3(FormatWrapper o1, FormatWrapper o2) {
        return -Integer.compare(o1.format.bitrate, o2.format.bitrate);
    }

    private boolean isPlayerNonNull() {
        if (this.player != null) {
            return true;
        }
        Timber.w("player is null", new Object[0]);
        return false;
    }

    private boolean isStreamerUrlProviderNonNull() {
        if (this.streamerUrlProvider != null) {
            return true;
        }
        Timber.w("cannot start to play archive. streamerUrlProvider is null", new Object[0]);
        return false;
    }

    private SimpleExoPlayer getPlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer;
        }
        throw new NullPointerException("player is null");
    }

    private StreamerUrlProvider getStreamerUrlProvider() {
        StreamerUrlProvider streamerUrlProvider = this.streamerUrlProvider;
        if (streamerUrlProvider != null) {
            return streamerUrlProvider;
        }
        throw new NullPointerException("streamer url provider is null");
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer
    public void setStreamerUrlProvider(StreamerUrlProvider streamerUrlProvider) {
        this.streamerUrlProvider = streamerUrlProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class FormatWrapper {
        private int f;
        private Format format;
        private int g;
        private int r;
        private TrackGroupArray trackGroups;

        /* synthetic */ FormatWrapper(Format format, TrackGroupArray trackGroupArray, int i, int i2, int i3, AnonymousClass1 anonymousClass1) {
            this(format, trackGroupArray, i, i2, i3);
        }

        private FormatWrapper(Format format, TrackGroupArray trackGroups, int r, int g, int f) {
            this.format = format;
            this.trackGroups = trackGroups;
            this.r = r;
            this.g = g;
            this.f = f;
        }
    }
}
