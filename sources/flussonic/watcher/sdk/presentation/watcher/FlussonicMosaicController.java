package flussonic.watcher.sdk.presentation.watcher;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.exoplayer2.ExoPlaybackException;
import flussonic.watcher.sdk.data.network.services.SdkNetworkProvider;
import flussonic.watcher.sdk.data.repository.MediaInfoRepository;
import flussonic.watcher.sdk.data.repository.WatcherRepository;
import flussonic.watcher.sdk.domain.exceptions.EmptyStreamException;
import flussonic.watcher.sdk.domain.exceptions.InvalidUrlException;
import flussonic.watcher.sdk.domain.exceptions.UnexpectedException;
import flussonic.watcher.sdk.domain.interactors.MediaInfoInteractor;
import flussonic.watcher.sdk.domain.interactors.WatcherInteractor;
import flussonic.watcher.sdk.domain.pojo.MediaInfo;
import flussonic.watcher.sdk.domain.pojo.PlaybackSpeed;
import flussonic.watcher.sdk.domain.pojo.PlaybackStatus;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.pojo.Range;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.domain.pojo.UpdateProgressEvent;
import flussonic.watcher.sdk.domain.pojo.VisibleRangeChangedEvent;
import flussonic.watcher.sdk.domain.utils.ErrorUtils;
import flussonic.watcher.sdk.presentation.core.FlussonicController;
import flussonic.watcher.sdk.presentation.core.FlussonicPlayer;
import flussonic.watcher.sdk.presentation.core.IFlussonicMosaicController;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicDownloadRequestListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicUpdateProgressEventListener;
import flussonic.watcher.sdk.presentation.utils.DialogUtils;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

/* loaded from: classes3.dex */
class FlussonicMosaicController implements FlussonicController, IFlussonicMosaicController {
    private static final String DATE_TIME_PICKER_SUFFIX = "flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController";
    private final FragmentActivity activity;
    private FlussonicBufferingListener bufferingListener;
    private final FlussonicMosaicView flussonicMosaicView;
    private final FlussonicPlayer flussonicPlayer;
    private final FragmentManager fragmentManager;
    private long lastPosition;
    private final Lifecycle lifecycle;
    private MediaInfo mediaInfo;
    private MediaInfoInteractor mediaInfoInteractor;
    private PlaybackStatus playbackStatus;
    private final boolean reactNative;
    private int resizeMode;
    private long startPosition;
    private final StreamerConnectionParameters streamerConnectionParameters;
    private StreamerUrlProvider streamerUrlProvider;
    private String tag;
    private FlussonicUpdateProgressEventListener updateProgressEventListener;
    private WatcherInteractor watcherInteractor;
    private final CompositeDisposable compositeDisposableRecordingStatus = new CompositeDisposable();
    private final CompositeDisposable compositeDisposableUpdateProgress = new CompositeDisposable();
    private final Subject<VisibleRangeChangedEvent> visibleWindowChanges = ReplaySubject.create(1);
    private FlussonicPlaybackStateImpl playbackState = new FlussonicPlaybackStateImpl();
    private boolean isFirstBuffering = true;
    private final FlussonicPlayer.PlayerListener playerListener = new FlussonicPlayer.PlayerListener() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController.1
        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onBufferingStart() {
            if (!FlussonicMosaicController.this.isFirstBuffering && FlussonicMosaicController.this.playbackState.isLive() && FlussonicMosaicController.this.playbackState.getLiveQuality() == Quality.AUTO && FlussonicMosaicController.this.mediaInfo != null && FlussonicMosaicController.this.playbackState.getLiveTrack() != null) {
                Track lowerStreamBitrate = FlussonicMosaicController.this.mediaInfo.getLowerStreamBitrate(FlussonicMosaicController.this.playbackState.getLiveTrack());
                if (!lowerStreamBitrate.equals(FlussonicMosaicController.this.playbackState.getLiveTrack())) {
                    FlussonicMosaicController.this.setLiveTrackInfo(lowerStreamBitrate, Quality.SD);
                    FlussonicMosaicController.this.play(0L);
                }
            }
            FlussonicMosaicController.this.flussonicMosaicView.showProgress(Task.BUFFERING);
            if (FlussonicMosaicController.this.bufferingListener != null) {
                FlussonicMosaicController.this.bufferingListener.onBufferingStart();
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onBufferingStop() {
            if (FlussonicMosaicController.this.playbackState.isLive()) {
                FlussonicMosaicController.this.isFirstBuffering = false;
            }
            FlussonicMosaicController.this.flussonicMosaicView.hideProgress(Task.BUFFERING);
            if (FlussonicMosaicController.this.bufferingListener != null) {
                FlussonicMosaicController.this.bufferingListener.onBufferingStop();
            }
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onTapConfirmed() {
            FlussonicMosaicController.this.flussonicMosaicView.showOrHideControls();
        }

        @Override // flussonic.watcher.sdk.presentation.core.FlussonicPlayer.PlayerListener
        public void onTrackChanged() {
            Quality archiveQuality;
            if (!FlussonicMosaicController.this.playbackState.isArchive() || (archiveQuality = FlussonicMosaicController.this.playbackState.getArchiveQuality()) == Quality.AUTO || archiveQuality == null || FlussonicMosaicController.this.flussonicPlayer.getQuality() == archiveQuality) {
                return;
            }
            FlussonicMosaicController.this.flussonicPlayer.setQuality(archiveQuality);
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoPlayingStarted() {
            FlussonicMosaicController.this.flussonicMosaicView.hideProgress(Task.LOADING);
            FlussonicMosaicController.this.flussonicMosaicView.hideError();
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoLoadingFailed(ExoPlaybackException error) {
            Track liveTrack;
            Track lowerStreamBitrate;
            if (ExoPlaybackException.isEmptyManifest(error)) {
                long from = FlussonicMosaicController.this.flussonicPlayer.getFrom();
                long jCorrectFrom = FlussonicMosaicController.this.playbackState.correctFrom(from);
                if (from == jCorrectFrom) {
                    jCorrectFrom = FlussonicMosaicController.this.playbackState.correctFrom(from + 10);
                }
                FlussonicMosaicController.this.flussonicPlayer.continuePlayArchive(jCorrectFrom);
                return;
            }
            if (ExoPlaybackException.isPositionOutOfRange(error)) {
                FlussonicMosaicController.this.flussonicPlayer.continuePlayLive();
                return;
            }
            if (FlussonicController.isStoppedBeforePreparingCompleted(error)) {
                FlussonicMosaicController.this.flussonicPlayer.stop();
                FlussonicMosaicController.this.flussonicMosaicView.hideProgress(Task.LOADING);
                FlussonicMosaicController.this.flussonicMosaicView.hideError();
                return;
            }
            FlussonicMosaicController.this.flussonicMosaicView.hideProgress(Task.LOADING);
            FlussonicMosaicController.this.flussonicMosaicView.showError();
            FlussonicMosaicController.this.flussonicMosaicView.notifyError(error);
            if (!FlussonicMosaicController.this.playbackState.isLive() || FlussonicMosaicController.this.playbackState.getLiveQuality() != Quality.AUTO || (liveTrack = FlussonicMosaicController.this.playbackState.getLiveTrack()) == null || (lowerStreamBitrate = FlussonicMosaicController.this.mediaInfo.getLowerStreamBitrate(liveTrack)) == null || lowerStreamBitrate.equals(FlussonicMosaicController.this.playbackState.getLiveTrack())) {
                return;
            }
            FlussonicMosaicController.this.setLiveTrackInfo(lowerStreamBitrate, Quality.SD);
            FlussonicMosaicController.this.play(0L);
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoIdle() {
            FlussonicMosaicController.this.flussonicMosaicView.hideProgress(Task.LOADING);
            FlussonicMosaicController.this.playbackState.setPlaybackStoppedAtTime(FlussonicMosaicController.this.playbackState.getTimelinePosition());
        }

        @Override // flussonic.watcher.sdk.presentation.player.exo.PlayerStateListener
        public void onVideoCompleted() {
            if (FlussonicMosaicController.this.flussonicPlayer.isSwitchToLive()) {
                FlussonicMosaicController.this.play(0L);
            } else {
                FlussonicMosaicController.this.playbackState.setPlaybackStoppedAtTime(FlussonicMosaicController.this.playbackState.getTimelinePosition());
            }
        }
    };

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void enableTimelineMarkersV2(boolean markersV2Enabled) {
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setPlayerSessionListener(FlussonicPlayerSessionListener sessionListener) {
    }

    FlussonicMosaicController(URL streamUrl, Lifecycle lifecycle, FragmentActivity activity, FragmentManager fragmentManager, FlussonicPlayer flussonicPlayer, FlussonicMosaicView flussonicMosaicView, boolean reactNative) {
        StreamerConnectionParameters streamerConnectionParametersCreate = StreamerConnectionParameters.create(streamUrl.toString());
        this.streamerConnectionParameters = streamerConnectionParametersCreate;
        this.tag = String.format("playback_state_%s", streamerConnectionParametersCreate.stream());
        this.resizeMode = 3;
        setStartPosition(0L);
        this.watcherInteractor = null;
        this.lifecycle = lifecycle;
        this.activity = activity;
        this.fragmentManager = fragmentManager;
        this.flussonicPlayer = flussonicPlayer;
        this.flussonicMosaicView = flussonicMosaicView;
        this.reactNative = reactNative;
    }

    FlussonicMosaicController(String url, Lifecycle lifecycle, FragmentActivity activity, FragmentManager fragmentManager, FlussonicPlayer flussonicPlayer, FlussonicMosaicView flussonicMosaicView, boolean reactNative) {
        try {
            WatcherConnectionParameters watcherConnectionParametersCreate = WatcherConnectionParameters.create(url);
            this.watcherInteractor = new WatcherInteractor(new WatcherRepository(watcherConnectionParametersCreate, new SdkNetworkProvider().provideWatcherNetworkService(new WatcherUrlProvider(watcherConnectionParametersCreate).getBaseUrl())));
            this.tag = String.format("playback_state_%s", watcherConnectionParametersCreate.stream());
            this.resizeMode = 3;
            setStartPosition(watcherConnectionParametersCreate.from());
        } catch (InvalidUrlException e) {
            Timber.e(e);
        }
        this.lifecycle = lifecycle;
        this.activity = activity;
        this.fragmentManager = fragmentManager;
        this.flussonicPlayer = flussonicPlayer;
        this.flussonicMosaicView = flussonicMosaicView;
        this.reactNative = reactNative;
        this.streamerConnectionParameters = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Timber.d("lifecycle state: onCreate %s", this.lifecycle.getState());
        this.flussonicPlayer.setPlayerListener(this.playerListener);
        initBorders(Range.empty());
        this.flussonicMosaicView.hideError();
        DialogUtils.hideDateTimePicker(this.activity.getSupportFragmentManager(), DATE_TIME_PICKER_SUFFIX);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Timber.d("lifecycle state: onStart %s", this.lifecycle.getState());
        this.flussonicPlayer.moveToForeground();
        this.flussonicPlayer.setResizeMode(this.resizeMode);
        this.flussonicPlayer.setMaxFrameRate(5);
        WatcherInteractor watcherInteractor = this.watcherInteractor;
        if (watcherInteractor != null) {
            this.compositeDisposableRecordingStatus.add(watcherInteractor.initStreamer().doOnSuccess(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    this.f$0.initInteractors((StreamerConnectionParameters) obj);
                }
            }).flatMapCompletable(new Function() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return this.f$0.lambda$onStart$0((StreamerConnectionParameters) obj);
                }
            }).doOnSubscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$onStart$1((Disposable) obj);
                }
            }).doFinally(new Action() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$onStart$2();
                }
            }).subscribe(new Action() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Action
                public final void run() {
                    this.f$0.startPlayer();
                }
            }, new FlussonicMosaicController$$ExternalSyntheticLambda2(this)));
        } else {
            StreamerConnectionParameters streamerConnectionParameters = this.streamerConnectionParameters;
            if (streamerConnectionParameters != null) {
                this.compositeDisposableRecordingStatus.add(Single.just(streamerConnectionParameters).doOnSuccess(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        this.f$0.initInteractors((StreamerConnectionParameters) obj);
                    }
                }).flatMapCompletable(new Function() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda6
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return this.f$0.lambda$onStart$3((StreamerConnectionParameters) obj);
                    }
                }).doOnSubscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda7
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) throws Exception {
                        this.f$0.lambda$onStart$4((Disposable) obj);
                    }
                }).doFinally(new Action() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda8
                    @Override // io.reactivex.functions.Action
                    public final void run() throws Exception {
                        this.f$0.lambda$onStart$5();
                    }
                }).subscribe(new Action() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        this.f$0.startPlayer();
                    }
                }, new FlussonicMosaicController$$ExternalSyntheticLambda2(this)));
            }
        }
        startUpdateProgressTimers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$onStart$0(StreamerConnectionParameters ignored) throws Exception {
        return mediaInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$1(Disposable disposable) throws Exception {
        this.flussonicMosaicView.showProgress(Task.INIT_STREAMER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$2() throws Exception {
        this.flussonicMosaicView.hideProgress(Task.INIT_STREAMER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CompletableSource lambda$onStart$3(StreamerConnectionParameters ignored) throws Exception {
        return mediaInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$4(Disposable disposable) throws Exception {
        this.flussonicMosaicView.showProgress(Task.INIT_STREAMER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$5() throws Exception {
        this.flussonicMosaicView.hideProgress(Task.INIT_STREAMER);
    }

    private Completable mediaInfo() {
        MediaInfoInteractor mediaInfoInteractor = this.mediaInfoInteractor;
        return mediaInfoInteractor == null ? Completable.complete() : mediaInfoInteractor.mediaInfo().doOnSuccess(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$mediaInfo$6((MediaInfo) obj);
            }
        }).toCompletable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$mediaInfo$6(MediaInfo mediaInfo) throws Exception {
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
        stop();
        destroy();
    }

    private void stop() {
        stopRecordingStatusTimers();
        stopUpdateProgressTimers();
        this.flussonicPlayer.moveToBackground();
    }

    private void destroy() {
        FlussonicPlayer flussonicPlayer = this.flussonicPlayer;
        if (flussonicPlayer != null) {
            flussonicPlayer.setPlayerListener(null);
        }
        this.compositeDisposableRecordingStatus.dispose();
        this.compositeDisposableUpdateProgress.dispose();
    }

    private void checkAndPlay(long from) {
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
        this.flussonicMosaicView.showPause();
    }

    private void startUpdateProgressTimers() {
        this.compositeDisposableUpdateProgress.add(Observable.interval(1000L, TimeUnit.MILLISECONDS, Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.updateProgress(((Long) obj).longValue());
            }
        }, new FlussonicMosaicController$$ExternalSyntheticLambda2(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initInteractors(StreamerConnectionParameters streamerConnectionParameters) {
        this.streamerUrlProvider = new StreamerUrlProvider(streamerConnectionParameters);
        this.mediaInfoInteractor = new MediaInfoInteractor(new MediaInfoRepository(streamerConnectionParameters, new SdkNetworkProvider().provideStreamerNetworkService(this.streamerUrlProvider.getBaseUrl())));
    }

    private void maybeStartPlaying() {
        if (isPlayerStopped() && this.playbackState.isLive() && this.playbackState.shouldRestartLivePlayback()) {
            Timber.d("restarting live playback", new Object[0]);
            this.flussonicMosaicView.hideError();
            checkAndPlay(0L);
        }
    }

    private boolean isPlayerStopped() {
        PlaybackStatus playbackStatus = this.playbackStatus;
        return playbackStatus == PlaybackStatus.IDLE || playbackStatus == PlaybackStatus.PLAYBACK_COMPLETED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlayer() {
        initializeState();
        this.playbackState.beforeStartingRequests();
        checkAndPlay(this.playbackState.getLastPosition());
    }

    private void initializeState() {
        boolean z;
        MediaInfo mediaInfo;
        FlussonicFragment flussonicFragment = (FlussonicFragment) this.fragmentManager.findFragmentByTag(this.tag);
        if (flussonicFragment == null) {
            flussonicFragment = new FlussonicFragment();
            this.fragmentManager.beginTransaction().add(flussonicFragment, this.tag).commitAllowingStateLoss();
            z = true;
        } else {
            z = false;
        }
        FlussonicPlaybackStateImpl playbackState = flussonicFragment.getPlaybackState();
        this.playbackState = playbackState;
        if (z) {
            playbackState.setStartPosition(this.startPosition);
        }
        this.playbackState.getLoadedRanges();
        setVolume(this.flussonicMosaicView.audioDisabled ? 0.0f : this.playbackState.getVolume());
        Track liveTrack = this.playbackState.getLiveTrack();
        Quality liveQuality = this.playbackState.getLiveQuality();
        if (this.playbackState.getLiveTrack() == null && (mediaInfo = this.mediaInfo) != null && mediaInfo.getMaxStreamBitrate() != null) {
            liveTrack = this.mediaInfo.getMaxStreamBitrate();
            liveQuality = Quality.SD;
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
        boolean zIsLive = this.playbackState.isLive();
        boolean zIsArchive = this.playbackState.isArchive();
        this.playbackStatus = this.flussonicPlayer.getPlaybackStatus();
        long playbackTimeUtcInSeconds = this.flussonicPlayer.getPlaybackTimeUtcInSeconds();
        Timber.d("update progress: %s %s %d %s", zIsArchive ? "archive" : "live", this.playbackStatus, Long.valueOf(playbackTimeUtcInSeconds), isAudioDisabled() ? "Audio OFF" : "Audio ON");
        PlaybackStatus playbackStatus = this.playbackStatus;
        boolean z = playbackStatus == PlaybackStatus.PLAYING;
        boolean z2 = playbackStatus == PlaybackStatus.PREPARING;
        this.flussonicMosaicView.updateQuality();
        this.flussonicMosaicView.updateAudioDisabled();
        if (z || (zIsLive && z2)) {
            this.playbackState.setPlayerPosition(playbackTimeUtcInSeconds);
            updateTimelinePosition();
        } else {
            maybeStartPlaying();
        }
        fireUpdateProgressEvent();
    }

    private void fireUpdateProgressEvent() {
        FlussonicUpdateProgressEventListener flussonicUpdateProgressEventListener = this.updateProgressEventListener;
        if (flussonicUpdateProgressEventListener != null) {
            flussonicUpdateProgressEventListener.onUpdateProgress(UpdateProgressEvent.builder().setCurrentUtcInSeconds(getCurrentUtcInSeconds()).setPlaybackStatus(getPlaybackStatus()).setSpeed(getSpeed()).setAudioDisabled(isAudioDisabled()).build());
        }
    }

    private void initBorders(Range range) {
        if (isArchiveAvailable()) {
            updateTimelinePosition();
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
            return;
        }
        throw new UnexpectedException(throwable);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setAllowDownload(boolean allowDownload) {
        throw new NoSuchMethodError("setAllowDownload not implemented in FlussonicMosaicControoler");
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

    @Override // flussonic.watcher.sdk.presentation.core.IFlussonicMosaicController
    public void setResizeMode(int resizeMode) {
        this.resizeMode = resizeMode;
        this.flussonicPlayer.setResizeMode(resizeMode);
    }

    private void doPause() {
        Timber.d("pause", new Object[0]);
        this.flussonicPlayer.pause();
        this.flussonicMosaicView.showPlay();
        Timber.d("update progress: paused at %d", Long.valueOf(this.playbackState.getLastPosition()));
    }

    private void doResume() {
        Timber.d("resume", new Object[0]);
        this.flussonicPlayer.resume();
        this.flussonicMosaicView.showPause();
        if (this.playbackState.isLive()) {
            play(0L);
        }
    }

    private void setVolume(float volume) {
        boolean z = volume == 0.0f;
        this.flussonicMosaicView.disableAudio(z);
        if (z) {
            return;
        }
        this.flussonicPlayer.setVolume(volume);
        this.playbackState.setVolume(volume);
    }

    @Override // flussonic.watcher.sdk.presentation.core.IFlussonicMosaicController
    public void setQuality(Quality quality) {
        Timber.d("setQuality: %s", quality);
        if (this.playbackState.isLive()) {
            Track liveTrackByQuality = getLiveTrackByQuality(quality);
            if (liveTrackByQuality != null) {
                if (liveTrackByQuality.equals(this.playbackState.getLiveTrack()) && this.playbackState.getLiveQuality() == quality) {
                    return;
                }
                setLiveTrackInfo(liveTrackByQuality, quality);
                play(0L);
                return;
            }
            return;
        }
        setArchiveQuality(quality);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void disableAudio(boolean audioDisabled) {
        this.flussonicPlayer.disableAudioTrack(audioDisabled);
    }

    @Override // flussonic.watcher.sdk.presentation.core.IFlussonicMosaicController
    public int setMaxFrameRate(int maxFps) {
        return this.flussonicPlayer.setMaxFrameRate(maxFps);
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
        Timber.e("setDownloadRequestListener not implemented in FlussonicMosaicController", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setUpdateProgressEventListener(FlussonicUpdateProgressEventListener updateProgressEventListener) {
        this.updateProgressEventListener = updateProgressEventListener;
        fireUpdateProgressEvent();
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

    public boolean isAudioDisabled() {
        return this.flussonicPlayer.isAudioTrackDisabled();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public float getSpeed() {
        return this.playbackState.getSpeed().speed;
    }

    private void setSpeed(PlaybackSpeed speed) {
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

    @Override // flussonic.watcher.sdk.presentation.core.IFlussonicMosaicController
    public Quality getQuality() {
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

    private void setArchiveQuality(Quality quality) {
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

    private Track getLiveTrackByQuality(Quality quality) {
        if (this.mediaInfo == null || quality == null) {
            return null;
        }
        int i = AnonymousClass2.$SwitchMap$flussonic$watcher$sdk$domain$pojo$Quality[quality.ordinal()];
        if (i == 1 || i == 2) {
            return this.mediaInfo.getMaxStreamBitrate();
        }
        if (i != 3) {
            return null;
        }
        return this.mediaInfo.getMinStreamBitrate();
    }

    /* renamed from: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicController$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
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
        FlussonicFragment flussonicFragment = (FlussonicFragment) this.fragmentManager.findFragmentByTag(this.tag);
        if (flussonicFragment != null) {
            FlussonicMosaicView.getFragmentManager(flussonicFragment).beginTransaction().remove(flussonicFragment).commitAllowingStateLoss();
        }
        FlussonicPlaybackStateImpl flussonicPlaybackStateImpl = this.playbackState;
        if (flussonicPlaybackStateImpl != null) {
            flussonicPlaybackStateImpl.clearCache();
            this.playbackState = null;
        }
        stop();
        destroy();
        this.bufferingListener = null;
        this.updateProgressEventListener = null;
        this.watcherInteractor = null;
        this.mediaInfoInteractor = null;
    }

    private void updateTimelinePosition() {
        this.lastPosition = this.playbackState.getTimelinePosition();
    }

    private boolean isArchiveAvailable() {
        return this.playbackState.isArchiveAvailable();
    }
}
