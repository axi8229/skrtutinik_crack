package flussonic.watcher.sdk.presentation.watcher;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import flussonic.watcher.sdk.R$drawable;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.domain.pojo.PlaybackStatus;
import flussonic.watcher.sdk.domain.pojo.Quality;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.presentation.core.FlussonicControlsVisibilityListener;
import flussonic.watcher.sdk.presentation.core.FlussonicPlayer;
import flussonic.watcher.sdk.presentation.core.FlussonicWatcher;
import flussonic.watcher.sdk.presentation.core.IFlussonicMosaicController;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicDownloadRequestListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicUpdateProgressEventListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class FlussonicMosaicView extends FrameLayout implements FlussonicWatcher {
    private FragmentActivity activity;
    boolean audioDisabled;
    private FlussonicBufferingListener bufferingListener;
    private ViewGroup errorPauseContainer;
    private View errorView;
    private IFlussonicMosaicController flussonicController;
    private FlussonicPlayer flussonicPlayer;
    private Fragment fragment;
    private final Choreographer.FrameCallback frameCallback;
    private final Runnable hideControlsCallback;
    private final Set<Task> loadingTasks;
    private AppCompatImageButton pauseButton;
    private ViewGroup playerContainer;
    private Quality quality;
    private boolean reactNative;
    private long startPosition;
    private URL streamUrl;
    private FlussonicUpdateProgressEventListener updateProgressEventListener;
    private String url;

    public interface FlussonicExoPlayerErrorListener {
    }

    private void fireControlsVisibilityChanged(boolean controlsVisible) {
    }

    private void notifyExoPlayerErrorListener(String code, String message, String url) {
    }

    public void setControlsVisibilityListener(FlussonicControlsVisibilityListener controlsVisibilityListener) {
    }

    public void setExoPlayerErrorListener(FlussonicExoPlayerErrorListener exoPlayerErrorListener) {
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setPlayerSessionListener(FlussonicPlayerSessionListener sessionListener) {
    }

    private static void checkUrlNonEmpty(String url) {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("Specify url");
        }
    }

    private static FragmentActivity getActivity(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalStateException("FlussonicMosaicView initialize: activity is null");
        }
        return fragment.getActivity();
    }

    static FragmentManager getFragmentManager(Fragment fragment) {
        FragmentManager supportFragmentManager = getActivity(fragment).getSupportFragmentManager();
        if (supportFragmentManager != null) {
            return supportFragmentManager;
        }
        throw new IllegalStateException("FlussonicMosaicView initialize: fragment manager is null");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setup() {
        this.flussonicPlayer = (FlussonicPlayer) findViewById(R$id.fs_player_view);
        View viewFindViewById = findViewById(R$id.fs_error_view);
        this.errorView = viewFindViewById;
        viewFindViewById.setVisibility(8);
        this.playerContainer = (ViewGroup) findViewById(R$id.fs_player_container);
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) findViewById(R$id.fs_pause_btn);
        this.pauseButton = appCompatImageButton;
        appCompatImageButton.setVisibility(8);
        this.errorPauseContainer = (ViewGroup) findViewById(R$id.fs_error_pause_container);
        this.pauseButton.setOnTouchListener(new View.OnTouchListener() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicMosaicView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setup$1(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setup$1(View view, MotionEvent event) {
        if (event.getAction() == 0) {
            this.pauseButton.setColorFilter(FlussonicColorTheme.getInstance().getColor("fs_pause_button_pressed"), PorterDuff.Mode.SRC_ATOP);
            requireController().doPauseOrResume();
        } else if (event.getAction() == 1) {
            this.pauseButton.clearColorFilter();
        }
        return view.performClick();
    }

    private void startReactNativeRedrawing() {
        stopReactRedrawing();
        if (this.reactNative) {
            Choreographer.getInstance().postFrameCallback(this.frameCallback);
        }
    }

    private void stopReactRedrawing() {
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (this.pauseButton.getVisibility() != 8) {
            hideControlsWithDelay();
        }
        return super.dispatchTouchEvent(ev);
    }

    private void hideControlsWithDelay() {
        removeCallbacks(this.hideControlsCallback);
        postDelayed(this.hideControlsCallback, 3000L);
    }

    public void setUrl(String url) {
        checkUrlNonEmpty(url);
        this.url = url;
        initializeControllerIfPossible();
    }

    public void setStreamUrl(String url) throws MalformedURLException {
        checkUrlNonEmpty(url);
        this.streamUrl = new URL(url);
        initializeControllerIfPossible();
    }

    private void initializeControllerIfPossible() {
        if (this.url == null && this.streamUrl == null) {
            return;
        }
        if (this.flussonicPlayer == null) {
            setup();
        }
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            Lifecycle lifecycle = fragmentActivity.getLifecycle();
            FragmentActivity fragmentActivity2 = this.activity;
            initialize(lifecycle, fragmentActivity2, fragmentActivity2.getSupportFragmentManager());
        } else {
            Fragment fragment = this.fragment;
            if (fragment != null) {
                initialize(fragment.getLifecycle(), getActivity(this.fragment), getFragmentManager(this.fragment));
            }
        }
    }

    private void initialize(Lifecycle lifecycle, FragmentActivity activity, FragmentManager fragmentManager) {
        IFlussonicMosaicController iFlussonicMosaicController = this.flussonicController;
        if (iFlussonicMosaicController != null) {
            iFlussonicMosaicController.release();
        }
        if (this.url != null) {
            this.flussonicController = new FlussonicMosaicController(this.url, lifecycle, activity, fragmentManager, this.flussonicPlayer, this, this.reactNative);
        } else if (this.streamUrl != null) {
            this.flussonicController = new FlussonicMosaicController(this.streamUrl, lifecycle, activity, fragmentManager, this.flussonicPlayer, this, this.reactNative);
        }
        lifecycle.addObserver(this.flussonicController);
        if (this.flussonicController.getStartPosition() <= 0) {
            updateStartPosition();
        }
        updateBufferingListener();
        updateUpdateProgressEventListener();
        updateAudioDisabled();
        updateQuality();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setAllowDownload(boolean allowDownload) {
        throw new NoSuchMethodError("setAllowDownload not implemented in FlussonicMosaicView");
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setStartPosition(long dateTimeInSecs) {
        if (this.startPosition == dateTimeInSecs) {
            return;
        }
        if (dateTimeInSecs <= 0) {
            dateTimeInSecs = 0;
        }
        this.startPosition = dateTimeInSecs;
        updateStartPosition();
    }

    private void updateStartPosition() {
        IFlussonicMosaicController iFlussonicMosaicController = this.flussonicController;
        if (iFlussonicMosaicController == null) {
            return;
        }
        iFlussonicMosaicController.setStartPosition(this.startPosition);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setBufferingListener(FlussonicBufferingListener bufferingListener) {
        this.bufferingListener = bufferingListener;
        updateBufferingListener();
    }

    private void updateBufferingListener() {
        IFlussonicMosaicController iFlussonicMosaicController = this.flussonicController;
        if (iFlussonicMosaicController == null) {
            return;
        }
        iFlussonicMosaicController.setBufferingListener(this.bufferingListener);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setDownloadRequestListener(FlussonicDownloadRequestListener downloadRequestListener) {
        Timber.e("setDownloadRequestListener not implemented in FlussonicMosaicView", new Object[0]);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setUpdateProgressEventListener(FlussonicUpdateProgressEventListener updateProgressEventListener) {
        this.updateProgressEventListener = updateProgressEventListener;
        updateUpdateProgressEventListener();
    }

    private void updateUpdateProgressEventListener() {
        IFlussonicMosaicController iFlussonicMosaicController = this.flussonicController;
        if (iFlussonicMosaicController == null) {
            return;
        }
        iFlussonicMosaicController.setUpdateProgressEventListener(this.updateProgressEventListener);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public long getCurrentUtcInSeconds() {
        return requireController().getCurrentUtcInSeconds();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public PlaybackStatus getPlaybackStatus() {
        return requireController().getPlaybackStatus();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public float getSpeed() {
        return requireController().getSpeed();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public List<Track> getAvailableTracks() {
        return requireController().getAvailableTracks();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public Track getCurrentTrack() {
        return requireController().getCurrentTrack();
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
        updateQuality();
    }

    void updateQuality() {
        IFlussonicMosaicController iFlussonicMosaicController = this.flussonicController;
        if (iFlussonicMosaicController == null) {
            return;
        }
        iFlussonicMosaicController.setQuality(this.quality);
    }

    public Quality getQuality() {
        return requireController().getQuality();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void disableAudio(boolean audioDisabled) {
        this.audioDisabled = audioDisabled;
        updateAudioDisabled();
    }

    void updateAudioDisabled() {
        IFlussonicMosaicController iFlussonicMosaicController = this.flussonicController;
        if (iFlussonicMosaicController == null) {
            return;
        }
        iFlussonicMosaicController.disableAudio(this.audioDisabled);
    }

    public void setResizeMode(int resizeMode) {
        requireController().setResizeMode(resizeMode);
    }

    public void setMaxFrameRate(int maxFps) {
        requireController().setMaxFrameRate(maxFps);
    }

    void showProgress(Task task) {
        this.loadingTasks.add(task);
    }

    void hideProgress(Task task) {
        this.loadingTasks.remove(task);
    }

    void showError() {
        this.errorView.setVisibility(0);
        this.pauseButton.setVisibility(8);
    }

    void notifyError(Throwable error) {
        String strValueOf = "PLAYBACK_ERROR_HARDWARE";
        Throwable cause = error;
        while (true) {
            if (cause == null) {
                break;
            }
            if ((error instanceof ParserException) && ((ParserException) error).getLocalizedMessage().contains("Loading finished before preparation is complete")) {
                Timber.d("IGNORED error because of restarting playback %s", error.getLocalizedMessage());
                return;
            }
            if (cause instanceof HttpDataSource.InvalidResponseCodeException) {
                strValueOf = String.valueOf(((HttpDataSource.InvalidResponseCodeException) cause).responseCode);
                break;
            }
            if (cause instanceof ExoPlaybackException) {
                ExoPlaybackException exoPlaybackException = (ExoPlaybackException) error;
                if (exoPlaybackException.type == 0) {
                    cause = exoPlaybackException.getSourceException();
                    strValueOf = "408";
                }
            }
            cause = cause.getCause();
        }
        notifyExoPlayerErrorListener(strValueOf, Log.getStackTraceString(error), this.url);
    }

    void hideError() {
        this.errorView.setVisibility(8);
    }

    void showOrHideControls() {
        if (this.pauseButton.getVisibility() == 8) {
            hideControlsWithDelay();
            tryShowPauseButton();
        } else {
            tryHidePauseButton();
        }
    }

    void showPlay() {
        this.pauseButton.setImageResource(R$drawable.fs_btn_play_big);
    }

    void showPause() {
        this.pauseButton.setImageResource(R$drawable.fs_btn_pause);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Timber.d("onConfigurationChanged", new Object[0]);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startReactNativeRedrawing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.hideControlsCallback);
        stopReactRedrawing();
    }

    private void tryShowPauseButton() {
        PlaybackStatus playbackStatus = this.flussonicPlayer.getPlaybackStatus();
        boolean z = playbackStatus == PlaybackStatus.PLAYING;
        boolean z2 = playbackStatus == PlaybackStatus.PAUSED;
        if ((z || z2) && this.errorView.getVisibility() == 8 && this.pauseButton.getVisibility() != 0) {
            this.pauseButton.setVisibility(0);
            fireControlsVisibilityChanged(true);
        }
    }

    private void tryHidePauseButton() {
        if (this.pauseButton.getVisibility() != 8) {
            this.pauseButton.setVisibility(8);
            fireControlsVisibilityChanged(false);
        }
    }

    private IFlussonicMosaicController requireController() {
        IFlussonicMosaicController iFlussonicMosaicController = this.flussonicController;
        if (iFlussonicMosaicController != null) {
            return iFlussonicMosaicController;
        }
        if (this.url == null) {
            throw new IllegalStateException((this.fragment == null && this.activity == null) ? "Call initialize() and setUrl()" : "Call setUrl()");
        }
        if (this.fragment == null && this.activity == null) {
            throw new IllegalStateException("Call initialize()");
        }
        throw new IllegalStateException("Controller not initialized");
    }
}
