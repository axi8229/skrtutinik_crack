package flussonic.watcher.sdk.presentation.watcher;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.gms.location.DeviceOrientationRequest;
import flussonic.watcher.sdk.R$dimen;
import flussonic.watcher.sdk.R$drawable;
import flussonic.watcher.sdk.R$id;
import flussonic.watcher.sdk.R$layout;
import flussonic.watcher.sdk.R$styleable;
import flussonic.watcher.sdk.domain.pojo.PlaybackStatus;
import flussonic.watcher.sdk.domain.pojo.Track;
import flussonic.watcher.sdk.presentation.core.FlussonicController;
import flussonic.watcher.sdk.presentation.core.FlussonicPlayer;
import flussonic.watcher.sdk.presentation.core.FlussonicWatcher;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicBufferingListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicCollapseExpandTimelineListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicDownloadRequestListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicPlayerSessionListener;
import flussonic.watcher.sdk.presentation.core.listeners.FlussonicUpdateProgressEventListener;
import flussonic.watcher.sdk.presentation.timeline.FlussonicTimelineView;
import flussonic.watcher.sdk.presentation.timeline.animation.OnAnimationEndListener;
import flussonic.watcher.sdk.presentation.timeline.animation.TimelineAnimator;
import flussonic.watcher.sdk.presentation.utils.DrawUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class FlussonicWatcherView extends RelativeLayout implements FlussonicWatcher {
    private FragmentActivity activity;
    private boolean allowDownload;
    boolean audioDisabled;
    private FlussonicBufferingListener bufferingListener;
    private FlussonicCollapseExpandTimelineListener collapseExpandTimelineListener;
    private FlussonicDownloadRequestListener downloadRequestListener;
    private ViewGroup errorPauseContainer;
    private View errorView;
    private FlussonicExoPlayerErrorListener exoPlayerErrorListener;
    private FlussonicController flussonicController;
    private FlussonicPlayer flussonicPlayer;
    private FlussonicTimelineView flussonicTimeline;
    private Fragment fragment;
    private final Choreographer.FrameCallback frameCallback;
    private final Runnable hideControlsCallback;
    private boolean hideToolbarInPortrait;
    private final Set<Task> loadingTasks;
    private AppCompatImageButton pauseButton;
    private ViewGroup playerContainer;
    private MaterialProgressBar progressBar;
    private boolean reactNative;
    private FlussonicPlayerSessionListener sessionListener;
    private long startPosition;
    private final TimelineAnimator timelineAnimator;
    private int toolbarHeight;
    private FlussonicUpdateProgressEventListener updateProgressEventListener;
    private String url;
    private boolean withTimelineMarkersV2;

    public interface FlussonicExoPlayerErrorListener {
        void onExoPlayerError(String code, String message, String url);
    }

    public int getAnimationDuration() {
        return TimelineAnimator.DURATION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        tryCollapseTimeline();
        tryHidePauseButton();
    }

    public FlussonicWatcherView(Context context, AttributeSet attrs) throws Resources.NotFoundException {
        super(context, attrs);
        this.timelineAnimator = new TimelineAnimator(getResources().getDimensionPixelSize(R$dimen.fs_timeline_animation_offset));
        this.loadingTasks = new HashSet();
        this.frameCallback = new Choreographer.FrameCallback() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicWatcherView.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long frameTimeNanos) {
                DrawUtils.forceRedraw(FlussonicWatcherView.this);
                Choreographer.getInstance().postFrameCallback(FlussonicWatcherView.this.frameCallback);
            }
        };
        this.allowDownload = true;
        this.withTimelineMarkersV2 = true;
        this.hideControlsCallback = new Runnable() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicWatcherView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        init(attrs);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        setupColors();
    }

    private void setupColors() {
        if (FlussonicColorTheme.getInstance().themeChanged) {
            DrawableCompat.setTint(this.progressBar.getIndeterminateDrawable(), FlussonicColorTheme.getInstance().getColor("fs_progress_bar"));
        }
    }

    private static void checkNonNull(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            throw new IllegalArgumentException("Specify FragmentActivity or Fragment");
        }
    }

    private static void checkUrlNonEmpty(String url) {
        if (TextUtils.isEmpty(url)) {
            throw new IllegalArgumentException("Specify url");
        }
    }

    private static FragmentActivity getActivity(Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalStateException("FlussonicWatcherView initialize: activity is null");
        }
        return fragment.getActivity();
    }

    static FragmentManager getFragmentManager(Fragment fragment) {
        FragmentManager supportFragmentManager = getActivity(fragment).getSupportFragmentManager();
        if (supportFragmentManager != null) {
            return supportFragmentManager;
        }
        throw new IllegalStateException("FlussonicWatcherView initialize: fragment manager is null");
    }

    private void init(AttributeSet attrs) throws Resources.NotFoundException {
        FlussonicColorTheme.getInstance().initDefaultColors(this);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R$styleable.FlussonicWatcherView, 0, 0);
            try {
                this.allowDownload = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlussonicWatcherView_allowDownload, true);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        View.inflate(getContext(), R$layout.fs_view_flussonic_watcher, this);
        setClickable(true);
        setup();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setup() throws Resources.NotFoundException {
        final FlussonicColorTheme flussonicColorTheme = FlussonicColorTheme.getInstance();
        this.flussonicPlayer = (FlussonicPlayer) findViewById(R$id.fs_player_view);
        this.flussonicTimeline = (FlussonicTimelineView) findViewById(R$id.fs_timeline_view);
        MaterialProgressBar materialProgressBar = (MaterialProgressBar) findViewById(R$id.fs_progress_bar);
        this.progressBar = materialProgressBar;
        materialProgressBar.setVisibility(8);
        DrawableCompat.setTint(this.progressBar.getIndeterminateDrawable(), FlussonicColorTheme.getInstance().getColor("fs_progress_bar"));
        View viewFindViewById = findViewById(R$id.fs_error_view);
        this.errorView = viewFindViewById;
        viewFindViewById.setVisibility(8);
        this.playerContainer = (ViewGroup) findViewById(R$id.fs_player_container);
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) findViewById(R$id.fs_pause_btn);
        this.pauseButton = appCompatImageButton;
        appCompatImageButton.setVisibility(8);
        this.errorPauseContainer = (ViewGroup) findViewById(R$id.fs_error_pause_container);
        updateAllowDownload();
        updateTimelineMarkersV2();
        setConfiguration(getResources().getConfiguration());
        this.pauseButton.setOnTouchListener(new View.OnTouchListener() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicWatcherView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f$0.lambda$setup$1(flussonicColorTheme, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setup$1(final FlussonicColorTheme colorTheme, View view, MotionEvent event) {
        if (event.getAction() == 0) {
            this.pauseButton.setColorFilter(colorTheme.getColor("fs_pause_button_pressed"), PorterDuff.Mode.SRC_ATOP);
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
        if (!this.flussonicTimeline.isCollapsed()) {
            hideControlsWithDelay();
        }
        return super.dispatchTouchEvent(ev);
    }

    private void hideControlsWithDelay() {
        removeCallbacks(this.hideControlsCallback);
        postDelayed(this.hideControlsCallback, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
    }

    public void initialize(Fragment fragment) throws Resources.NotFoundException {
        checkNonNull(fragment);
        getActivity(fragment);
        getFragmentManager(fragment);
        this.activity = null;
        this.fragment = fragment;
        initializeControllerIfPossible();
    }

    public void setUrl(String url) throws Resources.NotFoundException {
        checkUrlNonEmpty(url);
        this.url = url;
        initializeControllerIfPossible();
    }

    private void initializeControllerIfPossible() throws Resources.NotFoundException {
        if (this.url != null) {
            FragmentActivity fragmentActivity = this.activity;
            if (fragmentActivity != null) {
                Lifecycle lifecycle = fragmentActivity.getLifecycle();
                FragmentActivity fragmentActivity2 = this.activity;
                initialize(lifecycle, fragmentActivity2, fragmentActivity2.getSupportFragmentManager(), this.url);
            } else {
                Fragment fragment = this.fragment;
                if (fragment != null) {
                    initialize(fragment.getLifecycle(), getActivity(this.fragment), getFragmentManager(this.fragment), this.url);
                }
            }
        }
    }

    private void initialize(Lifecycle lifecycle, FragmentActivity activity, FragmentManager fragmentManager, String url) throws Resources.NotFoundException {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController != null) {
            flussonicController.release();
        }
        FlussonicControllerImpl flussonicControllerImpl = new FlussonicControllerImpl(url, lifecycle, activity, fragmentManager, this.flussonicPlayer, this.flussonicTimeline, this, this.reactNative);
        this.flussonicController = flussonicControllerImpl;
        lifecycle.addObserver(flussonicControllerImpl);
        updateAllowDownload();
        updateTimelineMarkersV2();
        if (this.flussonicController.getStartPosition() <= 0) {
            updateStartPosition();
        }
        updatePlayerSessionListener();
        updateBufferingListener();
        updateDownloadRequestListener();
        updateUpdateProgressEventListener();
        updateAudioDisabled();
        updateHideToolbarInPortrait();
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void disableAudio(boolean audioDisabled) {
        this.audioDisabled = audioDisabled;
        updateAudioDisabled();
    }

    void updateAudioDisabled() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.disableAudio(this.audioDisabled);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void enableTimelineMarkersV2(boolean markersV2Enabled) {
        if (this.withTimelineMarkersV2 == markersV2Enabled) {
            return;
        }
        this.withTimelineMarkersV2 = markersV2Enabled;
        updateTimelineMarkersV2();
    }

    private void updateTimelineMarkersV2() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.enableTimelineMarkersV2(this.withTimelineMarkersV2);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setAllowDownload(boolean allowDownload) {
        if (this.allowDownload == allowDownload) {
            return;
        }
        this.allowDownload = allowDownload;
        updateAllowDownload();
    }

    private void updateAllowDownload() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.setAllowDownload(this.allowDownload);
    }

    public void setHideToolbarInPortrait(boolean hideToolbarInPortrait) throws Resources.NotFoundException {
        if (this.hideToolbarInPortrait == hideToolbarInPortrait) {
            return;
        }
        this.hideToolbarInPortrait = hideToolbarInPortrait;
        updateHideToolbarInPortrait();
    }

    private void updateHideToolbarInPortrait() throws Resources.NotFoundException {
        if (this.flussonicController == null) {
            return;
        }
        setConfiguration(getResources().getConfiguration());
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
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.setStartPosition(this.startPosition);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void seek(long seconds) {
        requireController().seek(seconds);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setBufferingListener(FlussonicBufferingListener bufferingListener) {
        this.bufferingListener = bufferingListener;
        updateBufferingListener();
    }

    private void updateBufferingListener() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.setBufferingListener(this.bufferingListener);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setDownloadRequestListener(FlussonicDownloadRequestListener downloadRequestListener) {
        this.downloadRequestListener = downloadRequestListener;
        updateDownloadRequestListener();
    }

    private void updateDownloadRequestListener() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.setDownloadRequestListener(this.downloadRequestListener);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setUpdateProgressEventListener(FlussonicUpdateProgressEventListener updateProgressEventListener) {
        this.updateProgressEventListener = updateProgressEventListener;
        updateUpdateProgressEventListener();
    }

    private void updateUpdateProgressEventListener() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.setUpdateProgressEventListener(this.updateProgressEventListener);
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void setPlayerSessionListener(FlussonicPlayerSessionListener sessionListener) {
        this.sessionListener = sessionListener;
        updatePlayerSessionListener();
    }

    private void updatePlayerSessionListener() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController == null) {
            return;
        }
        flussonicController.setPlayerSessionListener(this.sessionListener);
    }

    public void setExoPlayerErrorListener(FlussonicExoPlayerErrorListener exoPlayerErrorListener) {
        this.exoPlayerErrorListener = exoPlayerErrorListener;
    }

    public void setCollapseExpandTimelineListener(FlussonicCollapseExpandTimelineListener collapseExpandTimelineListener) {
        this.collapseExpandTimelineListener = collapseExpandTimelineListener;
        if (collapseExpandTimelineListener != null) {
            if (shouldChangeTimlineVisibility(getResources().getConfiguration())) {
                if (this.pauseButton.getVisibility() == 8) {
                    collapseExpandTimelineListener.hideToolbar(getAnimationDuration());
                    return;
                } else {
                    collapseExpandTimelineListener.showToolbar(getAnimationDuration());
                    return;
                }
            }
            collapseExpandTimelineListener.showToolbar(getAnimationDuration());
        }
    }

    public void setToolbarHeight(int toolbarHeight) {
        this.toolbarHeight = toolbarHeight;
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    public void clearCache() {
        requireController().clearCache();
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

    void showProgress(Task task) {
        this.loadingTasks.add(task);
        updateProgress();
    }

    void hideProgress(Task task) {
        this.loadingTasks.remove(task);
        updateProgress();
    }

    private void updateProgress() {
        this.progressBar.setVisibility(this.loadingTasks.isEmpty() ? 8 : 0);
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
        if (this.flussonicTimeline.isCollapsed()) {
            hideControlsWithDelay();
            tryExpandTimeline();
        } else {
            tryCollapseTimeline();
        }
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

    void updateErrorPauseContainerPadding(int chartBarYInWindow) {
        if (shouldChangeTimlineVisibility(getResources().getConfiguration())) {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            setBottomPadding(this.errorPauseContainer, ((iArr[1] + getHeight()) - chartBarYInWindow) - this.toolbarHeight);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) throws Resources.NotFoundException {
        super.onConfigurationChanged(newConfig);
        setConfiguration(newConfig);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startReactNativeRedrawing();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.timelineAnimator.cancelAnimation();
        removeCallbacks(this.hideControlsCallback);
        stopReactRedrawing();
    }

    private void setConfiguration(Configuration newConfig) throws Resources.NotFoundException {
        int i = 0;
        if (shouldChangeTimlineVisibility(newConfig)) {
            this.flussonicTimeline.setTransparent(true);
            if (this.pauseButton.getVisibility() == 8) {
                this.flussonicTimeline.collapse();
                FlussonicCollapseExpandTimelineListener flussonicCollapseExpandTimelineListener = this.collapseExpandTimelineListener;
                if (flussonicCollapseExpandTimelineListener != null) {
                    flussonicCollapseExpandTimelineListener.hideToolbar(getAnimationDuration());
                }
            } else {
                this.flussonicTimeline.expand();
                FlussonicCollapseExpandTimelineListener flussonicCollapseExpandTimelineListener2 = this.collapseExpandTimelineListener;
                if (flussonicCollapseExpandTimelineListener2 != null) {
                    flussonicCollapseExpandTimelineListener2.showToolbar(getAnimationDuration());
                }
            }
        } else {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.fs_player_bottom_padding);
            this.flussonicTimeline.setTransparent(false);
            this.flussonicTimeline.expand();
            this.timelineAnimator.cancelAnimation();
            FlussonicCollapseExpandTimelineListener flussonicCollapseExpandTimelineListener3 = this.collapseExpandTimelineListener;
            if (flussonicCollapseExpandTimelineListener3 != null) {
                flussonicCollapseExpandTimelineListener3.showToolbar(getAnimationDuration());
            }
            i = dimensionPixelSize;
        }
        setBottomPadding(this.playerContainer, i);
        setBottomPadding(this.errorPauseContainer, i);
    }

    private boolean shouldChangeTimlineVisibility(Configuration newConfig) {
        return this.hideToolbarInPortrait || newConfig.orientation == 2;
    }

    private void setBottomPadding(View view, int padding) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), padding);
    }

    private void tryShowPauseButton() {
        PlaybackStatus playbackStatus = this.flussonicPlayer.getPlaybackStatus();
        boolean z = playbackStatus == PlaybackStatus.PLAYING;
        boolean z2 = playbackStatus == PlaybackStatus.PAUSED;
        if ((z || z2) && !this.flussonicTimeline.isCollapsed() && this.errorView.getVisibility() == 8) {
            this.pauseButton.setVisibility(0);
        }
    }

    private void tryHidePauseButton() {
        this.pauseButton.setVisibility(8);
    }

    private void tryExpandTimeline() {
        if (shouldChangeTimlineVisibility(getResources().getConfiguration()) && this.flussonicTimeline.isCollapsed()) {
            this.timelineAnimator.expandTimeline(this.flussonicTimeline);
            this.flussonicTimeline.expand();
            FlussonicCollapseExpandTimelineListener flussonicCollapseExpandTimelineListener = this.collapseExpandTimelineListener;
            if (flussonicCollapseExpandTimelineListener != null) {
                flussonicCollapseExpandTimelineListener.expandToolbar(getAnimationDuration());
            }
        }
    }

    private void tryCollapseTimeline() {
        if (!shouldChangeTimlineVisibility(getResources().getConfiguration()) || this.flussonicTimeline.isCollapsed()) {
            return;
        }
        this.timelineAnimator.collapseTimeline(this.flussonicTimeline, new OnAnimationEndListener() { // from class: flussonic.watcher.sdk.presentation.watcher.FlussonicWatcherView$$ExternalSyntheticLambda1
            @Override // flussonic.watcher.sdk.presentation.timeline.animation.OnAnimationEndListener
            public final void onAnimationEnd() {
                this.f$0.lambda$tryCollapseTimeline$2();
            }
        });
        FlussonicCollapseExpandTimelineListener flussonicCollapseExpandTimelineListener = this.collapseExpandTimelineListener;
        if (flussonicCollapseExpandTimelineListener != null) {
            flussonicCollapseExpandTimelineListener.collapseToolbar(getAnimationDuration());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryCollapseTimeline$2() {
        this.flussonicTimeline.collapse();
        if (this.reactNative) {
            DrawUtils.forceRedraw(this);
        }
    }

    @Override // flussonic.watcher.sdk.presentation.core.FlussonicWatcher
    @SuppressLint({"ClickableViewAccessibility"})
    public void release() {
        Timber.d("release", new Object[0]);
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController != null) {
            flussonicController.release();
            this.flussonicController = null;
        }
        this.timelineAnimator.cancelAnimation();
        removeCallbacks(this.hideControlsCallback);
        stopReactRedrawing();
        this.flussonicPlayer = null;
        this.flussonicTimeline = null;
        this.progressBar = null;
        this.errorView = null;
        this.playerContainer = null;
        this.pauseButton.setOnTouchListener(null);
        this.pauseButton = null;
        this.errorPauseContainer = null;
        this.bufferingListener = null;
        this.downloadRequestListener = null;
        this.updateProgressEventListener = null;
        this.collapseExpandTimelineListener = null;
        this.activity = null;
        this.fragment = null;
    }

    private FlussonicController requireController() {
        FlussonicController flussonicController = this.flussonicController;
        if (flussonicController != null) {
            return flussonicController;
        }
        if (this.url == null) {
            throw new IllegalStateException((this.fragment == null && this.activity == null) ? "Call initialize() and setUrl()" : "Call setUrl()");
        }
        if (this.fragment == null && this.activity == null) {
            throw new IllegalStateException("Call initialize()");
        }
        throw new IllegalStateException("Controller not initialized");
    }

    private void notifyExoPlayerErrorListener(String code, String message, String url) {
        FlussonicExoPlayerErrorListener flussonicExoPlayerErrorListener = this.exoPlayerErrorListener;
        if (flussonicExoPlayerErrorListener != null) {
            flussonicExoPlayerErrorListener.onExoPlayerError(code, message, url);
        }
    }
}
