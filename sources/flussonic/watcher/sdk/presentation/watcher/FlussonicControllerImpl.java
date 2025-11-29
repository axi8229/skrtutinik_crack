package flussonic.watcher.sdk.presentation.watcher;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.exoplayer2.ExoPlaybackException;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.data.network.services.SdkNetworkProvider;
import flussonic.watcher.sdk.data.network.services.StreamerNetworkService;
import flussonic.watcher.sdk.data.repository.MediaInfoRepository;
import flussonic.watcher.sdk.data.repository.RecordingStatusRepository;
import flussonic.watcher.sdk.data.repository.WatcherRepository;
import flussonic.watcher.sdk.domain.exceptions.EmptyStreamException;
import flussonic.watcher.sdk.domain.exceptions.InvalidUrlException;
import flussonic.watcher.sdk.domain.exceptions.UnexpectedException;
import flussonic.watcher.sdk.domain.interactors.MediaInfoInteractor;
import flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor;
import flussonic.watcher.sdk.domain.interactors.WatcherInteractor;
import flussonic.watcher.sdk.domain.pojo.MediaInfo;
import flussonic.watcher.sdk.domain.pojo.PlaybackSpeed;
import flussonic.watcher.sdk.domain.pojo.PlaybackStatus;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Ranges;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;
import flussonic.watcher.sdk.domain.utils.ErrorUtils;
import flussonic.watcher.sdk.presentation.core.FlussonicController;
import flussonic.watcher.sdk.presentation.core.FlussonicPlayer;
import flussonic.watcher.sdk.presentation.core.FlussonicTimeline;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicDownloadRequestListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicUpdateProgressEventListener;
import flussonic.watcher.sdk.presentation.player.exo.FlussonicPlaybackStatsListener;
import flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView;
import flussonic.watcher.sdk.presentation.utils.DialogUtils;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

/* loaded from: classes3.dex */
class FlussonicControllerImpl implements FlussonicController {
    private static final String DATE_TIME_PICKER_SUFFIX = "flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl";
    private final FragmentActivity activity;
    private boolean allowDownload;
    private FlussonicBufferingListener bufferingListener;
    private FlussonicDownloadRequestListener downloadRequestListener;
    private final FlussonicPlayer flussonicPlayer;
    private final FlussonicTimeline flussonicTimeline;
    private final FlussonicWatcherView flussonicWatcher;
    private final FragmentManager fragmentManager;
    private boolean isStateInitialized;
    private long lastPosition;
    private final Lifecycle lifecycle;
    private MediaInfo mediaInfo;
    private MediaInfoInteractor mediaInfoInteractor;
    private PlaybackStatus playbackStatus;
    private final boolean reactNative;
    private RecordingStatusInteractor recordingStatusInteractor;
    private FlussonicPlayerSessionListener sessionListener;
    private long startPosition;
    private StreamerUrlProvider streamerUrlProvider;
    private String tag;
    private FlussonicUpdateProgressEventListener updateProgressEventListener;
    private WatcherInteractor watcherInteractor;
    private boolean withTimelineMarkersV2;
    private final CompositeDisposable compositeDisposableRecordingStatus = new CompositeDisposable();
    private final CompositeDisposable compositeDisposableUpdateProgress = new CompositeDisposable();
    private final Subject<VisibleRangeChangedEvent> visibleWindowChanges = ReplaySubject.create(1);
    private FlussonicPlaybackStateImpl playbackState = new FlussonicPlaybackStateImpl();
    private boolean isFirstBuffering = true;
    private final FlussonicTimeline.TimelineListener timelineListener = new AnonymousClass1();
    private final FlussonicPlaybackStatsListener flussonicPlaybackStatsListener = new FlussonicPlaybackStatsListener(new FlussonicPlayerSessionListener() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl.2
        @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener
        public void onPlaybackSessionCreated(String playbackSession) {
            if (FlussonicControllerImpl.this.sessionListener != null) {
                FlussonicControllerImpl.this.sessionListener.onPlaybackSessionCreated(playbackSession);
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener
        public void onPlaybackSessionActive(String playbackSession) {
            if (FlussonicControllerImpl.this.sessionListener != null) {
                FlussonicControllerImpl.this.sessionListener.onPlaybackSessionActive(playbackSession);
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener
        public void onPlaybackSessionFinished(String playbackSession) {
            if (FlussonicControllerImpl.this.sessionListener != null) {
                FlussonicControllerImpl.this.sessionListener.onPlaybackSessionFinished(playbackSession);
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener
        public void onMediaSessionChanged(String mediaSession) {
            if (FlussonicControllerImpl.this.sessionListener != null) {
                FlussonicControllerImpl.this.sessionListener.onMediaSessionChanged(mediaSession);
            }
        }
    });
    private final FlussonicPlayer.PlayerListener playerListener = new FlussonicPlayer.PlayerListener() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl.3
        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onBufferingStart() {
            if (!FlussonicControllerImpl.this.isFirstBuffering && FlussonicControllerImpl.this.playbackState.isLive()) {
                Quality liveQuality = FlussonicControllerImpl.this.playbackState.getLiveQuality();
                Quality quality = Quality.AUTO;
                if (liveQuality == quality && FlussonicControllerImpl.this.mediaInfo != null && FlussonicControllerImpl.this.playbackState.getLiveTrack() != null) {
                    Track lowerStreamBitrate = FlussonicControllerImpl.this.mediaInfo.getLowerStreamBitrate(FlussonicControllerImpl.this.playbackState.getLiveTrack());
                    if (!lowerStreamBitrate.equals(FlussonicControllerImpl.this.playbackState.getLiveTrack())) {
                        FlussonicControllerImpl.this.setLiveTrackInfo(lowerStreamBitrate, quality);
                        FlussonicControllerImpl.this.play(0L);
                    }
                }
            }
            FlussonicControllerImpl.this.flussonicWatcher.showProgress(Task.BUFFERING);
            if (FlussonicControllerImpl.this.bufferingListener != null) {
                FlussonicControllerImpl.this.bufferingListener.onBufferingStart();
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onBufferingStop() {
            if (FlussonicControllerImpl.this.playbackState.isLive()) {
                FlussonicControllerImpl.this.isFirstBuffering = false;
            }
            FlussonicControllerImpl.this.flussonicWatcher.hideProgress(Task.BUFFERING);
            if (FlussonicControllerImpl.this.bufferingListener != null) {
                FlussonicControllerImpl.this.bufferingListener.onBufferingStop();
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onTapConfirmed() {
            FlussonicControllerImpl.this.flussonicWatcher.showOrHideControls();
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onTrackChanged() {
            Quality archiveQuality;
            if (!FlussonicControllerImpl.this.playbackState.isArchive() || (archiveQuality = FlussonicControllerImpl.this.playbackState.getArchiveQuality()) == Quality.AUTO || archiveQuality == null || FlussonicControllerImpl.this.flussonicPlayer.getQuality() == archiveQuality) {
                return;
            }
            FlussonicControllerImpl.this.flussonicPlayer.setQuality(archiveQuality);
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoPlayingStarted() {
            FlussonicControllerImpl.this.flussonicWatcher.hideProgress(Task.LOADING);
            FlussonicControllerImpl.this.flussonicWatcher.hideError();
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoLoadingFailed(ExoPlaybackException error) {
            Track liveTrack;
            Track lowerStreamBitrate;
            if (ExoPlaybackException.isEmptyManifest(error)) {
                long from = FlussonicControllerImpl.this.flussonicPlayer.getFrom();
                long jCorrectFrom = FlussonicControllerImpl.this.playbackState.correctFrom(from);
                if (from == jCorrectFrom) {
                    jCorrectFrom = FlussonicControllerImpl.this.playbackState.correctFrom(from + 10);
                }
                FlussonicControllerImpl.this.flussonicPlayer.continuePlayArchive(jCorrectFrom);
                return;
            }
            if (ExoPlaybackException.isPositionOutOfRange(error)) {
                FlussonicControllerImpl.this.flussonicPlayer.continuePlayLive();
                return;
            }
            if (FlussonicController.isStoppedBeforePreparingCompleted(error)) {
                FlussonicControllerImpl.this.flussonicPlayer.stop();
                FlussonicControllerImpl.this.flussonicWatcher.hideProgress(Task.LOADING);
                FlussonicControllerImpl.this.flussonicWatcher.hideError();
                return;
            }
            FlussonicControllerImpl.this.flussonicWatcher.hideProgress(Task.LOADING);
            FlussonicControllerImpl.this.flussonicWatcher.showError();
            FlussonicControllerImpl.this.flussonicWatcher.notifyError(error);
            if (FlussonicControllerImpl.this.playbackState.isLive()) {
                Quality liveQuality = FlussonicControllerImpl.this.playbackState.getLiveQuality();
                Quality quality = Quality.AUTO;
                if (liveQuality != quality || (liveTrack = FlussonicControllerImpl.this.playbackState.getLiveTrack()) == null || (lowerStreamBitrate = FlussonicControllerImpl.this.mediaInfo.getLowerStreamBitrate(liveTrack)) == null || lowerStreamBitrate.equals(FlussonicControllerImpl.this.playbackState.getLiveTrack())) {
                    return;
                }
                FlussonicControllerImpl.this.setLiveTrackInfo(lowerStreamBitrate, quality);
                FlussonicControllerImpl.this.play(0L);
            }
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoIdle() {
            FlussonicControllerImpl.this.flussonicWatcher.hideProgress(Task.LOADING);
            FlussonicControllerImpl.this.playbackState.setPlaybackStoppedAtTime(FlussonicControllerImpl.this.playbackState.getTimelinePosition());
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoCompleted() {
            if (FlussonicControllerImpl.this.flussonicPlayer.isSwitchToLive()) {
                FlussonicControllerImpl.this.play(0L);
            } else {
                FlussonicControllerImpl.this.playbackState.setPlaybackStoppedAtTime(FlussonicControllerImpl.this.playbackState.getTimelinePosition());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startRecordingStatusTimers$6(Ranges resultRangesWithEvents) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startRecordingStatusTimers$7(Ranges resultRanges) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startRecordingStatusTimers$8(Ranges resultRanges) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void access$1500(FlussonicControllerImpl flussonicControllerImpl, long j) {
        flussonicControllerImpl.checkAndMove(j);
    }

    /* renamed from: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$1, reason: invalid class name */
    class AnonymousClass1 implements FlussonicTimeline.TimelineListener {
        AnonymousClass1() {
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void showDatePicker(long minDateTimeInSecs, long maxDateTimeInSecs, long nowInSecs) {
            if (FlussonicControllerImpl.this.isArchiveAvailable()) {
                FragmentManager supportFragmentManager = FlussonicControllerImpl.this.activity.getSupportFragmentManager();
                String str = FlussonicControllerImpl.DATE_TIME_PICKER_SUFFIX;
                final FlussonicControllerImpl flussonicControllerImpl = FlussonicControllerImpl.this;
                DialogUtils.showDateTimePicker(supportFragmentManager, str, minDateTimeInSecs, maxDateTimeInSecs, nowInSecs, new DialogUtils.DateTimePickerListener() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$1$$ExternalSyntheticLambda0
                    @Override // flussonic.watcher.sdk.presentation.utils.DialogUtils.DateTimePickerListener
                    public final void onDateTimeSelected(long j) {
                        FlussonicControllerImpl.access$1500(flussonicControllerImpl, j);
                    }
                });
                return;
            }
            Timber.w("archive isn't available", new Object[0]);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onPlayClick(long position) {
            Timber.d("onPlayClick %d", Long.valueOf(position));
            if (FlussonicControllerImpl.this.isArchiveAvailable()) {
                FlussonicControllerImpl.this.checkAndPlay(position);
            } else {
                Timber.w("archive isn't available", new Object[0]);
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onLiveClick() {
            Timber.d("onLiveClick", new Object[0]);
            FlussonicControllerImpl.this.checkAndPlay(0L);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onMuteClick() {
            Timber.d("on mute clicked", new Object[0]);
            FlussonicControllerImpl.this.setVolume(0.0f);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onUnmuteClick() {
            Timber.d("on unmute clicked", new Object[0]);
            FlussonicControllerImpl.this.setVolume(1.0f);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onQualityClick(Quality quality) {
            Timber.d("quality click", new Object[0]);
            FlussonicControllerImpl.this.flussonicTimeline.showQualityMenu(quality);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onQualityChanged(Quality quality) {
            Timber.d("onQualityChanged: %s", quality);
            if (FlussonicControllerImpl.this.playbackState.isLive()) {
                Track liveTrackByQuality = FlussonicControllerImpl.this.getLiveTrackByQuality(quality);
                if (liveTrackByQuality != null) {
                    if (liveTrackByQuality.equals(FlussonicControllerImpl.this.playbackState.getLiveTrack()) && FlussonicControllerImpl.this.playbackState.getLiveQuality() == quality) {
                        return;
                    }
                    FlussonicControllerImpl.this.setLiveTrackInfo(liveTrackByQuality, quality);
                    FlussonicControllerImpl.this.play(0L);
                    return;
                }
                return;
            }
            FlussonicControllerImpl.this.setArchiveQuality(quality);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onPlaybackSpeedClick() {
            Timber.d("playback speed click", new Object[0]);
            if (FlussonicControllerImpl.this.isArchiveAvailable()) {
                FlussonicControllerImpl.this.flussonicTimeline.showPlaybackSpeedMenu(FlussonicControllerImpl.this.playbackState.getSpeed());
            } else {
                Timber.w("archive isn't available", new Object[0]);
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onPlaybackSpeedChanged(PlaybackSpeed speed) {
            Timber.d("playback speed changed: %f", Float.valueOf(speed.speed));
            if (FlussonicControllerImpl.this.isArchiveAvailable()) {
                FlussonicControllerImpl.this.setSpeed(speed);
            } else {
                Timber.w("archive isn't available", new Object[0]);
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onDownloadRequest(long from, long to) {
            Timber.d("download request: from=%d to=%d", Long.valueOf(from), Long.valueOf(to));
            if (FlussonicControllerImpl.this.isArchiveAvailable()) {
                if (FlussonicControllerImpl.this.downloadRequestListener != null) {
                    FlussonicControllerImpl.this.downloadRequestListener.onDownloadRequest(from, to);
                    return;
                }
                return;
            }
            Timber.w("archive isn't available", new Object[0]);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onVisibleIntervalChanged(VisibleRangeChangedEvent event) {
            Timber.d("visible interval changed: from=%d to=%d duration=%d %s", Long.valueOf(event.range().from()), Long.valueOf(event.range().to()), Long.valueOf(event.range().duration()), event.eventType());
            FlussonicControllerImpl.this.visibleWindowChanges.onNext(event);
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicTimeline.TimelineListener
        public void onChartBarYChanged(int yInWindow) {
            FlussonicControllerImpl.this.flussonicWatcher.updateErrorPauseContainerPadding(yInWindow);
        }
    }

    FlussonicControllerImpl(String url, Lifecycle lifecycle, FragmentActivity activity, FragmentManager fragmentManager, FlussonicPlayer flussonicPlayer, FlussonicTimeline flussonicTimeline, FlussonicWatcherView flussonicWatcher, boolean reactNative) {
        try {
            WatcherConnectionParameters watcherConnectionParametersCreate = WatcherConnectionParameters.create(url);
            this.watcherInteractor = new WatcherInteractor(new WatcherRepository(watcherConnectionParametersCreate, new SdkNetworkProvider().provideWatcherNetworkService(new WatcherUrlProvider(watcherConnectionParametersCreate).getBaseUrl())));
            this.tag = String.format("playback_state_%s", watcherConnectionParametersCreate.stream());
            setStartPosition(watcherConnectionParametersCreate.from());
        } catch (InvalidUrlException e) {
            Timber.e(e);
        }
        this.lifecycle = lifecycle;
        this.activity = activity;
        this.fragmentManager = fragmentManager;
        this.flussonicPlayer = flussonicPlayer;
        this.flussonicTimeline = flussonicTimeline;
        this.flussonicWatcher = flussonicWatcher;
        this.reactNative = reactNative;
        this.withTimelineMarkersV2 = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Timber.d("lifecycle state: onCreate %s", this.lifecycle.getState());
        this.flussonicPlayer.setPlayerListener(this.playerListener);
        this.flussonicPlayer.setFlussonicPlaybackStatsListener(this.flussonicPlaybackStatsListener);
        this.flussonicTimeline.setTimelineListener(this.timelineListener);
        initBorders(Range.empty());
        this.flussonicWatcher.hideError();
        DialogUtils.hideDateTimePicker(this.activity.getSupportFragmentManager(), DATE_TIME_PICKER_SUFFIX);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Timber.d("lifecycle state: onStart %s", this.lifecycle.getState());
        this.flussonicPlayer.moveToForeground();
        WatcherInteractor watcherInteractor = this.watcherInteractor;
        if (watcherInteractor != null) {
            this.compositeDisposableRecordingStatus.add(watcherInteractor.initStreamer().doOnSuccess(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    this.f$0.initInteractors((StreamerConnectionParameters) obj);
                }
            }).flatMapCompletable(new Function() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.lambda$onStart$0((StreamerConnectionParameters) obj);
                }
            }).doOnSubscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$onStart$1((Disposable) obj);
                }
            }).doFinally(new Action() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$onStart$2();
                }
            }).subscribe(new Action() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Action
                public final void run() {
                    this.f$0.startRecordingStatusTimers();
                }
            }, new FlussonicControllerImpl$$ExternalSyntheticLambda5(this)));
        }
        startUpdateProgressTimers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$onStart$0(StreamerConnectionParameters ignored) throws Exception {
        return mediaInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$1(Disposable disposable) throws Exception {
        this.flussonicWatcher.showProgress(Task.INIT_STREAMER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$2() throws Exception {
        this.flussonicWatcher.hideProgress(Task.INIT_STREAMER);
    }

    private Completable mediaInfo() {
        MediaInfoInteractor mediaInfoInteractor = this.mediaInfoInteractor;
        return mediaInfoInteractor == null ? Completable.complete() : mediaInfoInteractor.mediaInfo().doOnSuccess(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$mediaInfo$3((MediaInfo) obj);
            }
        }).toCompletable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mediaInfo$3(MediaInfo mediaInfo) throws Exception {
        this.mediaInfo = mediaInfo;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Timber.d("lifecycle state: onResume %s", this.lifecycle.getState());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Timber.d("lifecycle state: onPause %s", this.lifecycle.getState());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Timber.d("lifecycle state: onStop %s", this.lifecycle.getState());
        stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Timber.d("lifecycle state: onDestroy %s", this.lifecycle.getState());
        destroy();
    }

    private void stop() {
        stopRecordingStatusTimers();
        stopUpdateProgressTimers();
        this.flussonicPlayer.moveToBackground();
    }

    private void destroy() {
        this.flussonicPlayer.setPlayerListener(null);
        this.flussonicPlayer.setFlussonicPlaybackStatsListener(null);
        this.flussonicTimeline.setTimelineListener(null);
        this.compositeDisposableRecordingStatus.dispose();
        this.compositeDisposableUpdateProgress.dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndPlay(long from) {
        long dateTimeInBorders = this.playbackState.getDateTimeInBorders(from);
        boolean z = this.flussonicPlayer.getPlaybackStatus() == PlaybackStatus.PLAYING;
        if (dateTimeInBorders == 0 && this.playbackState.isLive() && z) {
            Timber.w("already playing live", new Object[0]);
            updateTimelinePosition();
        } else {
            play(dateTimeInBorders);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndMove(long from) {
        long timelinePosition;
        FlussonicPlaybackStateImpl flussonicPlaybackStateImpl = this.playbackState;
        if (flussonicPlaybackStateImpl == null) {
            return;
        }
        long dateTimeInBorders = flussonicPlaybackStateImpl.getDateTimeInBorders(from);
        if (dateTimeInBorders == 0) {
            this.playbackState.setFrom(0L);
            timelinePosition = this.playbackState.getTimelinePosition();
        } else {
            timelinePosition = dateTimeInBorders;
        }
        this.flussonicTimeline.moveToPosition(timelinePosition);
        play(dateTimeInBorders);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play(long from) {
        long jCorrectFrom = this.playbackState.correctFrom(from);
        this.playbackState.setPlayerPosition(jCorrectFrom);
        this.playbackState.setFrom(jCorrectFrom);
        if (this.playbackState.isLive()) {
            this.isFirstBuffering = true;
            setSpeed(PlaybackSpeed.NORMAL);
            this.flussonicPlayer.playLive();
        } else {
            this.flussonicPlayer.playArchive(jCorrectFrom);
        }
        Timber.d("update progress: playing from %d", Long.valueOf(jCorrectFrom));
        updateTimelinePosition();
        this.flussonicWatcher.showPause();
        updateControlsVisibility();
    }

    private void startUpdateProgressTimers() {
        this.compositeDisposableUpdateProgress.add(Observable.interval(500L, TimeUnit.MILLISECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.updateProgress(((Long) obj).longValue());
            }
        }, new FlussonicControllerImpl$$ExternalSyntheticLambda5(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInteractors(StreamerConnectionParameters streamerConnectionParameters) {
        this.streamerUrlProvider = new StreamerUrlProvider(streamerConnectionParameters);
        StreamerNetworkService streamerNetworkServiceProvideStreamerNetworkService = new SdkNetworkProvider().provideStreamerNetworkService(this.streamerUrlProvider.getBaseUrl());
        this.recordingStatusInteractor = new RecordingStatusInteractor(new RecordingStatusRepository(streamerConnectionParameters, streamerNetworkServiceProvideStreamerNetworkService));
        this.mediaInfoInteractor = new MediaInfoInteractor(new MediaInfoRepository(streamerConnectionParameters, streamerNetworkServiceProvideStreamerNetworkService));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecordingStatusTimers() {
        WatcherInteractor watcherInteractor;
        initializeState();
        this.playbackState.beforeStartingRequests();
        initBorders(this.playbackState.getAvailableRange());
        RecordingStatusInteractor recordingStatusInteractor = this.recordingStatusInteractor;
        if (recordingStatusInteractor != null) {
            this.compositeDisposableRecordingStatus.add(recordingStatusInteractor.initRecordingStatus(this.playbackState).doOnSubscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda7
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$startRecordingStatusTimers$4((Disposable) obj);
                }
            }).doFinally(new Action() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda10
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$startRecordingStatusTimers$5();
                }
            }).subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    this.f$0.initBorders((Range) obj);
                }
            }, new FlussonicControllerImpl$$ExternalSyntheticLambda5(this)));
            if (this.withTimelineMarkersV2 && (watcherInteractor = this.watcherInteractor) != null) {
                CompositeDisposable compositeDisposable = this.compositeDisposableRecordingStatus;
                Subject<VisibleRangeChangedEvent> subject = this.visibleWindowChanges;
                FlussonicPlaybackStateImpl flussonicPlaybackStateImpl = this.playbackState;
                final FlussonicTimeline flussonicTimeline = this.flussonicTimeline;
                flussonicTimeline.getClass();
                compositeDisposable.add(watcherInteractor.visibleWindowChanges(subject, flussonicPlaybackStateImpl, new RecordingStatusInteractor.ProcessRangesOnUiFunction() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda8
                    @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.ProcessRangesOnUiFunction
                    public final void processRangesOnUi(Ranges ranges) {
                        flussonicTimeline.setRanges(ranges);
                    }
                }).subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda12
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) throws Exception {
                        FlussonicControllerImpl.lambda$startRecordingStatusTimers$6((Ranges) obj);
                    }
                }, new FlussonicControllerImpl$$ExternalSyntheticLambda5(this)));
            }
            CompositeDisposable compositeDisposable2 = this.compositeDisposableRecordingStatus;
            RecordingStatusInteractor recordingStatusInteractor2 = this.recordingStatusInteractor;
            FlussonicPlaybackStateImpl flussonicPlaybackStateImpl2 = this.playbackState;
            final FlussonicTimeline flussonicTimeline2 = this.flussonicTimeline;
            flussonicTimeline2.getClass();
            compositeDisposable2.add(recordingStatusInteractor2.updateRecordingStatus(flussonicPlaybackStateImpl2, new RecordingStatusInteractor.ProcessRangesOnUiFunction() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda8
                @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.ProcessRangesOnUiFunction
                public final void processRangesOnUi(Ranges ranges) {
                    flussonicTimeline2.setRanges(ranges);
                }
            }).subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda13
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    FlussonicControllerImpl.lambda$startRecordingStatusTimers$7((Ranges) obj);
                }
            }, new FlussonicControllerImpl$$ExternalSyntheticLambda5(this)));
            CompositeDisposable compositeDisposable3 = this.compositeDisposableRecordingStatus;
            RecordingStatusInteractor recordingStatusInteractor3 = this.recordingStatusInteractor;
            Subject<VisibleRangeChangedEvent> subject2 = this.visibleWindowChanges;
            FlussonicPlaybackStateImpl flussonicPlaybackStateImpl3 = this.playbackState;
            final FlussonicTimeline flussonicTimeline3 = this.flussonicTimeline;
            flussonicTimeline3.getClass();
            compositeDisposable3.add(recordingStatusInteractor3.visibleWindowChanges(subject2, flussonicPlaybackStateImpl3, new RecordingStatusInteractor.ProcessRangesOnUiFunction() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda8
                @Override // flussonic.watcher.sdk.domain.interactors.RecordingStatusInteractor.ProcessRangesOnUiFunction
                public final void processRangesOnUi(Ranges ranges) {
                    flussonicTimeline3.setRanges(ranges);
                }
            }).subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$$ExternalSyntheticLambda9
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    FlussonicControllerImpl.lambda$startRecordingStatusTimers$8((Ranges) obj);
                }
            }, new FlussonicControllerImpl$$ExternalSyntheticLambda5(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordingStatusTimers$4(Disposable disposable) throws Exception {
        this.flussonicWatcher.showProgress(Task.INIT_BORDERS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startRecordingStatusTimers$5() throws Exception {
        this.flussonicWatcher.hideProgress(Task.INIT_BORDERS);
    }

    private void maybeStartPlaying() {
        if (isPlayerStopped() && this.playbackState.isLive() && this.playbackState.shouldRestartLivePlayback()) {
            Timber.d("restarting live playback", new Object[0]);
            this.flussonicWatcher.hideError();
            checkAndPlay(0L);
        }
    }

    private boolean isPlayerStopped() {
        PlaybackStatus playbackStatus = this.playbackStatus;
        return playbackStatus == PlaybackStatus.IDLE || playbackStatus == PlaybackStatus.PLAYBACK_COMPLETED;
    }

    private void initializeState() {
        MediaInfo mediaInfo;
        boolean z = true;
        this.isStateInitialized = true;
        FlussonicFragment flussonicFragment = (FlussonicFragment) this.fragmentManager.findFragmentByTag(this.tag);
        if (flussonicFragment == null) {
            flussonicFragment = new FlussonicFragment();
            this.fragmentManager.beginTransaction().add(flussonicFragment, this.tag).commitAllowingStateLoss();
        } else {
            z = false;
        }
        FlussonicPlaybackStateImpl playbackState = flussonicFragment.getPlaybackState();
        this.playbackState = playbackState;
        if (z) {
            playbackState.setStartPosition(this.startPosition);
        }
        this.flussonicTimeline.setRanges(this.playbackState.getLoadedRanges());
        setVolume(this.flussonicWatcher.audioDisabled ? 0.0f : this.playbackState.getVolume());
        Track liveTrack = this.playbackState.getLiveTrack();
        Quality liveQuality = this.playbackState.getLiveQuality();
        if (this.playbackState.getLiveTrack() == null && (mediaInfo = this.mediaInfo) != null && mediaInfo.getMaxStreamBitrate() != null) {
            liveTrack = this.mediaInfo.getMaxStreamBitrate();
            liveQuality = Quality.AUTO;
        }
        setLiveTrackInfo(liveTrack, liveQuality);
        this.flussonicPlayer.setStreamerUrlProvider(this.streamerUrlProvider);
        this.flussonicPlayer.setSpeed(this.playbackState.getSpeed().speed);
    }

    private void stopUpdateProgressTimers() {
        this.compositeDisposableUpdateProgress.clear();
    }

    private void stopRecordingStatusTimers() {
        this.compositeDisposableRecordingStatus.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long time) {
        View viewFindViewById;
        if (this.reactNative) {
            FlussonicTimeline flussonicTimeline = this.flussonicTimeline;
            boolean z = flussonicTimeline instanceof FlussonicTimelineView;
            if (z) {
                ((FlussonicTimelineView) flussonicTimeline).fixScroll();
            }
            if ((z || (this.flussonicTimeline instanceof View)) && (viewFindViewById = ((View) this.flussonicTimeline).findViewById(R$id.fs_chart_view)) != null) {
                viewFindViewById.requestLayout();
            }
        }
        boolean zIsLive = this.playbackState.isLive();
        boolean zIsArchive = this.playbackState.isArchive();
        this.playbackStatus = this.flussonicPlayer.getPlaybackStatus();
        long playbackTimeUtcInSeconds = this.flussonicPlayer.getPlaybackTimeUtcInSeconds();
        Timber.d("update progress: %s %s %d %s", zIsArchive ? "archive" : "live", this.playbackStatus, Long.valueOf(playbackTimeUtcInSeconds), isAudioDisabled() ? "Audio OFF" : "Audio ON");
        PlaybackStatus playbackStatus = this.playbackStatus;
        boolean z2 = playbackStatus == PlaybackStatus.PLAYING;
        boolean z3 = playbackStatus == PlaybackStatus.PREPARING;
        if (z2 || (zIsLive && z3)) {
            this.playbackState.setPlayerPosition(playbackTimeUtcInSeconds);
            updateTimelinePosition();
        } else {
            maybeStartPlaying();
        }
        Quality quality = getQuality();
        fireUpdateProgressEvent();
        int videoTracksCount = getVideoTracksCount();
        if (videoTracksCount == 0) {
            return;
        }
        if (quality != null) {
            boolean z4 = videoTracksCount > 1;
            FlussonicTimeline flussonicTimeline2 = this.flussonicTimeline;
            if (!z4) {
                quality = null;
            }
            flussonicTimeline2.setQuality(quality);
        }
        boolean zIsAudioDisabled = isAudioDisabled();
        FlussonicWatcherView flussonicWatcherView = this.flussonicWatcher;
        if (zIsAudioDisabled != flussonicWatcherView.audioDisabled) {
            flussonicWatcherView.updateAudioDisabled();
        }
    }

    private int getVideoTracksCount() {
        List<Track> availableTracks = getAvailableTracks();
        int i = 0;
        for (int i2 = 0; i2 < availableTracks.size(); i2++) {
            if (availableTracks.get(i2).width() > 0) {
                i++;
            }
        }
        return i;
    }

    private void fireUpdateProgressEvent() {
        FlussonicUpdateProgressEventListener flussonicUpdateProgressEventListener = this.updateProgressEventListener;
        if (flussonicUpdateProgressEventListener != null) {
            flussonicUpdateProgressEventListener.onUpdateProgress(UpdateProgressEvent.builder().setCurrentUtcInSeconds(getCurrentUtcInSeconds()).setPlaybackStatus(getPlaybackStatus()).setSpeed(getSpeed()).setAudioDisabled(isAudioDisabled()).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initBorders(Range range) {
        this.flussonicTimeline.setBorders(range);
        updateControlsVisibility();
        boolean zIsArchiveAvailable = isArchiveAvailable();
        if (zIsArchiveAvailable) {
            this.flussonicTimeline.setCameraStatus(true);
            this.flussonicTimeline.setCalendarClickable(true);
            updateTimelinePosition();
        } else {
            this.flussonicTimeline.clearPosition();
        }
        if (zIsArchiveAvailable) {
            if (this.playbackState.getStartPosition() > 0) {
                checkAndPlay(this.playbackState.getStartPosition());
                this.playbackState.setStartPosition(0L);
            } else {
                checkAndPlay(this.playbackState.getLastPosition());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(Throwable throwable) {
        Timber.e(throwable, "onError", new Object[0]);
        if (ErrorUtils.isNoInternetError(throwable)) {
            return;
        }
        if (throwable instanceof EmptyStreamException) {
            stopRecordingStatusTimers();
            initializeState();
            checkAndPlay(0L);
            this.playbackState.setStartPosition(0L);
            updateControlsVisibility();
            this.flussonicTimeline.setCameraStatus(true);
            this.flussonicTimeline.setCalendarClickable(false);
            return;
        }
        throw new UnexpectedException(throwable);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void disableAudio(boolean audioDisabled) {
        this.flussonicPlayer.disableAudioTrack(audioDisabled);
    }

    public boolean isAudioDisabled() {
        return this.flussonicPlayer.isAudioTrackDisabled();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void enableTimelineMarkersV2(boolean markersV2Enabled) {
        this.withTimelineMarkersV2 = markersV2Enabled;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setAllowDownload(boolean allowDownload) {
        this.allowDownload = allowDownload;
        updateControlsVisibility();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicController
    public long getStartPosition() {
        return this.startPosition;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setStartPosition(long dateTimeInSecs) {
        this.startPosition = dateTimeInSecs;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicController
    public void doPauseOrResume() {
        PlaybackStatus playbackStatus = this.flussonicPlayer.getPlaybackStatus();
        boolean z = playbackStatus == PlaybackStatus.PLAYING;
        if (playbackStatus == PlaybackStatus.PAUSED) {
            doResume();
        } else if (z) {
            doPause();
        } else {
            Timber.w("player is not in paused or playing state", new Object[0]);
        }
    }

    private void doPause() {
        Timber.d("pause", new Object[0]);
        this.flussonicPlayer.pause();
        this.flussonicWatcher.showPlay();
        Timber.d("update progress: paused at %d", Long.valueOf(this.playbackState.getLastPosition()));
    }

    private void doResume() {
        Timber.d("resume", new Object[0]);
        this.flussonicPlayer.resume();
        this.flussonicWatcher.showPause();
        if (this.playbackState.isLive()) {
            play(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolume(float volume) {
        boolean z = volume == 0.0f;
        this.flussonicWatcher.disableAudio(z);
        this.flussonicTimeline.setMute(z);
        if (z) {
            return;
        }
        this.playbackState.setVolume(volume);
        this.flussonicPlayer.setVolume(volume);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void seek(long seconds) {
        if (!isArchiveAvailable()) {
            Timber.w("archive isn't available", new Object[0]);
        } else {
            Timber.d("seek %d", Long.valueOf(seconds));
            checkAndPlay(seconds);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setBufferingListener(FlussonicBufferingListener bufferingListener) {
        this.bufferingListener = bufferingListener;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setDownloadRequestListener(FlussonicDownloadRequestListener downloadRequestListener) {
        this.downloadRequestListener = downloadRequestListener;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setUpdateProgressEventListener(FlussonicUpdateProgressEventListener updateProgressEventListener) {
        this.updateProgressEventListener = updateProgressEventListener;
        fireUpdateProgressEvent();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setPlayerSessionListener(FlussonicPlayerSessionListener sessionListener) {
        this.sessionListener = sessionListener;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void clearCache() {
        Timber.d("clear cache", new Object[0]);
        if (!isArchiveAvailable()) {
            Timber.w("archive isn't available", new Object[0]);
            return;
        }
        long lastPosition = this.playbackState.getLastPosition();
        this.playbackState.clearCache();
        checkAndPlay(lastPosition);
        VisibleRangeChangedEvent visibleRangeChangedEventBlockingFirst = this.visibleWindowChanges.blockingFirst(null);
        if (visibleRangeChangedEventBlockingFirst != null) {
            this.visibleWindowChanges.onNext(visibleRangeChangedEventBlockingFirst);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public long getCurrentUtcInSeconds() {
        if (this.playbackState.isLive() && this.flussonicPlayer.getPlaybackStatus() == PlaybackStatus.PREPARING) {
            return 0L;
        }
        return this.lastPosition;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public PlaybackStatus getPlaybackStatus() {
        return this.flussonicPlayer.getPlaybackStatus();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public float getSpeed() {
        return this.playbackState.getSpeed().speed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeed(PlaybackSpeed speed) {
        this.playbackState.setSpeed(speed);
        this.flussonicPlayer.setSpeed(speed.speed);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public List<Track> getAvailableTracks() {
        if (this.playbackState.isLive()) {
            MediaInfo mediaInfo = this.mediaInfo;
            return mediaInfo == null ? Collections.emptyList() : mediaInfo.streams();
        }
        return Track.createFromFormat(this.flussonicPlayer.getAvailableTracks());
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public Track getCurrentTrack() {
        if (this.playbackState.isLive()) {
            return this.playbackState.getLiveTrack();
        }
        return Track.createFromFormat(this.flussonicPlayer.getCurrentTrack());
    }

    private Quality getQuality() {
        if (this.playbackState.isLive()) {
            return this.playbackState.getLiveQuality();
        }
        Quality archiveQuality = this.playbackState.getArchiveQuality();
        Quality quality = Quality.AUTO;
        return archiveQuality == quality ? quality : this.flussonicPlayer.getPlaybackStatus() == PlaybackStatus.ERROR ? archiveQuality : this.flussonicPlayer.getQuality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLiveTrackInfo(Track track, Quality quality) {
        this.playbackState.setArchiveQuality(quality);
        this.playbackState.setLiveTrackInfo(track, quality);
        StreamerUrlProvider streamerUrlProvider = this.streamerUrlProvider;
        if (streamerUrlProvider != null) {
            streamerUrlProvider.setTrack(track);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setArchiveQuality(Quality quality) {
        this.playbackState.setArchiveQuality(quality);
        FlussonicPlaybackStateImpl flussonicPlaybackStateImpl = this.playbackState;
        flussonicPlaybackStateImpl.setLiveTrackInfo(flussonicPlaybackStateImpl.getLiveTrack(), quality);
        Track liveTrackByQuality = getLiveTrackByQuality(quality);
        if (liveTrackByQuality != null && !liveTrackByQuality.equals(this.playbackState.getLiveTrack()) && quality != Quality.AUTO) {
            this.playbackState.setLiveTrackInfo(liveTrackByQuality, quality);
            StreamerUrlProvider streamerUrlProvider = this.streamerUrlProvider;
            if (streamerUrlProvider != null) {
                streamerUrlProvider.setTrack(liveTrackByQuality);
            }
        }
        this.flussonicPlayer.setQuality(quality);
        if (this.flussonicPlayer.getPlaybackStatus() == PlaybackStatus.ERROR) {
            checkAndPlay(this.playbackState.getLastPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Track getLiveTrackByQuality(Quality quality) {
        if (this.mediaInfo == null) {
            return null;
        }
        int i = AnonymousClass4.$SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[quality.ordinal()];
        if (i == 1 || i == 2) {
            return this.mediaInfo.getMaxStreamBitrate();
        }
        if (i != 3) {
            return null;
        }
        return this.mediaInfo.getMinStreamBitrate();
    }

    /* renamed from: flussonic.watcher.sdk.presentation.watcher.FlussonicControllerImpl$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
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

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void release() {
        Timber.d("release", new Object[0]);
        stop();
        destroy();
        FlussonicFragment flussonicFragment = (FlussonicFragment) this.fragmentManager.findFragmentByTag(this.tag);
        if (flussonicFragment != null) {
            FlussonicWatcherView.getFragmentManager(flussonicFragment).beginTransaction().remove(flussonicFragment).commitAllowingStateLoss();
        }
        FlussonicPlaybackStateImpl flussonicPlaybackStateImpl = this.playbackState;
        if (flussonicPlaybackStateImpl != null) {
            flussonicPlaybackStateImpl.clearCache();
            this.playbackState = null;
        }
        this.downloadRequestListener = null;
        this.bufferingListener = null;
        this.updateProgressEventListener = null;
        this.watcherInteractor = null;
        this.recordingStatusInteractor = null;
        this.mediaInfoInteractor = null;
    }

    private void updateTimelinePosition() {
        long timelinePosition = this.playbackState.getTimelinePosition();
        this.flussonicTimeline.updateProgress(timelinePosition);
        this.lastPosition = timelinePosition;
    }

    private void updateControlsVisibility() {
        boolean zIsArchiveAvailable = isArchiveAvailable();
        this.flussonicTimeline.setMuteVisibility(this.isStateInitialized);
        boolean z = false;
        this.flussonicTimeline.setPlaybackSpeedVisibility(zIsArchiveAvailable && this.playbackState.isArchive());
        FlussonicTimeline flussonicTimeline = this.flussonicTimeline;
        if (zIsArchiveAvailable && this.allowDownload) {
            z = true;
        }
        flussonicTimeline.setAllowDownload(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isArchiveAvailable() {
        return this.playbackState.isArchiveAvailable();
    }
}
