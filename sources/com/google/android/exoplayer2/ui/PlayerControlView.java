package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class PlayerControlView extends FrameLayout {
    private long[] adGroupTimesMs;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final ComponentListener componentListener;
    private ControlDispatcher controlDispatcher;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    private final View fastForwardButton;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private boolean isAttachedToWindow;
    private boolean multiWindowTimeBar;
    private final View nextButton;
    private final View pauseButton;
    private final Timeline.Period period;
    private final View playButton;
    private boolean[] playedAdGroups;
    private Player player;
    private final TextView positionView;
    private final View previousButton;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private final View rewindButton;
    private boolean scrubbing;
    private boolean showMultiWindowTimeBar;
    private boolean showShuffleButton;
    private int showTimeoutMs;
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList<VisibilityListener> visibilityListeners;
    private final View vrButton;
    private final Timeline.Window window;

    public interface ProgressUpdateListener {
    }

    public interface VisibilityListener {
        void onVisibilityChange(int visibility);
    }

    @SuppressLint({"InlinedApi"})
    private static boolean isHandledMediaKey(int keyCode) {
        return keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88;
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
    }

    public void setProgressUpdateListener(ProgressUpdateListener listener) {
    }

    static /* synthetic */ PlaybackPreparer access$1900(PlayerControlView playerControlView) {
        playerControlView.getClass();
        return null;
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(Context context, AttributeSet attrs, int defStyleAttr, AttributeSet playbackAttrs) {
        super(context, attrs, defStyleAttr);
        int resourceId = R$layout.exo_player_control_view;
        int i = 5000;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        this.hideAtMs = -9223372036854775807L;
        this.showShuffleButton = false;
        int i2 = 15000;
        if (playbackAttrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(playbackAttrs, R$styleable.PlayerControlView, 0, 0);
            try {
                i = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_rewind_increment, 5000);
                i2 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_fastforward_increment, 15000);
                this.showTimeoutMs = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_show_timeout, this.showTimeoutMs);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerControlView_controller_layout_id, resourceId);
                this.repeatToggleModes = getRepeatToggleModes(typedArrayObtainStyledAttributes, this.repeatToggleModes);
                this.showShuffleButton = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerControlView_show_shuffle_button, this.showShuffleButton);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerControlView_time_bar_min_update_interval, this.timeBarMinUpdateIntervalMs));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.visibilityListeners = new CopyOnWriteArrayList<>();
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.formatBuilder = sb;
        this.formatter = new Formatter(sb, Locale.getDefault());
        this.adGroupTimesMs = new long[0];
        this.playedAdGroups = new boolean[0];
        this.extraAdGroupTimesMs = new long[0];
        this.extraPlayedAdGroups = new boolean[0];
        ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        this.controlDispatcher = new DefaultControlDispatcher(i2, i);
        this.updateProgressAction = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlayerControlView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateProgress();
            }
        };
        this.hideAction = new Runnable() { // from class: com.google.android.exoplayer2.ui.PlayerControlView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.hide();
            }
        };
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i3 = R$id.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i3);
        View viewFindViewById = findViewById(R$id.exo_progress_placeholder);
        if (timeBar != null) {
            this.timeBar = timeBar;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, playbackAttrs);
            defaultTimeBar.setId(i3);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.timeBar = defaultTimeBar;
        } else {
            this.timeBar = null;
        }
        this.durationView = (TextView) findViewById(R$id.exo_duration);
        this.positionView = (TextView) findViewById(R$id.exo_position);
        TimeBar timeBar2 = this.timeBar;
        if (timeBar2 != null) {
            timeBar2.addListener(componentListener);
        }
        View viewFindViewById2 = findViewById(R$id.exo_play);
        this.playButton = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(componentListener);
        }
        View viewFindViewById3 = findViewById(R$id.exo_pause);
        this.pauseButton = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(componentListener);
        }
        View viewFindViewById4 = findViewById(R$id.exo_prev);
        this.previousButton = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(componentListener);
        }
        View viewFindViewById5 = findViewById(R$id.exo_next);
        this.nextButton = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(componentListener);
        }
        View viewFindViewById6 = findViewById(R$id.exo_rew);
        this.rewindButton = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(componentListener);
        }
        View viewFindViewById7 = findViewById(R$id.exo_ffwd);
        this.fastForwardButton = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(componentListener);
        }
        ImageView imageView = (ImageView) findViewById(R$id.exo_repeat_toggle);
        this.repeatToggleButton = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_shuffle);
        this.shuffleButton = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
        }
        this.vrButton = findViewById(R$id.exo_vr);
        setShowVrButton(false);
        Resources resources = context.getResources();
        this.buttonAlphaEnabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.buttonAlphaDisabled = resources.getInteger(R$integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.repeatOffButtonDrawable = resources.getDrawable(R$drawable.exo_controls_repeat_off);
        this.repeatOneButtonDrawable = resources.getDrawable(R$drawable.exo_controls_repeat_one);
        this.repeatAllButtonDrawable = resources.getDrawable(R$drawable.exo_controls_repeat_all);
        this.shuffleOnButtonDrawable = resources.getDrawable(R$drawable.exo_controls_shuffle_on);
        this.shuffleOffButtonDrawable = resources.getDrawable(R$drawable.exo_controls_shuffle_off);
        this.repeatOffButtonContentDescription = resources.getString(R$string.exo_controls_repeat_off_description);
        this.repeatOneButtonContentDescription = resources.getString(R$string.exo_controls_repeat_one_description);
        this.repeatAllButtonContentDescription = resources.getString(R$string.exo_controls_repeat_all_description);
        this.shuffleOnContentDescription = resources.getString(R$string.exo_controls_shuffle_on_description);
        this.shuffleOffContentDescription = resources.getString(R$string.exo_controls_shuffle_off_description);
    }

    private static int getRepeatToggleModes(TypedArray a, int repeatToggleModes) {
        return a.getInt(R$styleable.PlayerControlView_repeat_toggle_modes, repeatToggleModes);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        Assertions.checkArgument(player == null || player.getApplicationLooper() == Looper.getMainLooper());
        Player player2 = this.player;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.componentListener);
        }
        this.player = player;
        if (player != null) {
            player.addListener(this.componentListener);
        }
        updateAll();
    }

    public void setShowMultiWindowTimeBar(boolean showMultiWindowTimeBar) {
        this.showMultiWindowTimeBar = showMultiWindowTimeBar;
        updateTimeline();
    }

    public void addVisibilityListener(VisibilityListener listener) {
        this.visibilityListeners.add(listener);
    }

    public void removeVisibilityListener(VisibilityListener listener) {
        this.visibilityListeners.remove(listener);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
        if (this.controlDispatcher != controlDispatcher) {
            this.controlDispatcher = controlDispatcher;
            updateNavigation();
        }
    }

    @Deprecated
    public void setRewindIncrementMs(int rewindMs) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setRewindIncrementMs(rewindMs);
            updateNavigation();
        }
    }

    @Deprecated
    public void setFastForwardIncrementMs(int fastForwardMs) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        if (controlDispatcher instanceof DefaultControlDispatcher) {
            ((DefaultControlDispatcher) controlDispatcher).setFastForwardIncrementMs(fastForwardMs);
            updateNavigation();
        }
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public void setShowTimeoutMs(int showTimeoutMs) {
        this.showTimeoutMs = showTimeoutMs;
        if (isVisible()) {
            hideAfterTimeout();
        }
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public void setRepeatToggleModes(int repeatToggleModes) {
        this.repeatToggleModes = repeatToggleModes;
        Player player = this.player;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (repeatToggleModes == 0 && repeatMode != 0) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 0);
            } else if (repeatToggleModes == 1 && repeatMode == 2) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 1);
            } else if (repeatToggleModes == 2 && repeatMode == 1) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 2);
            }
        }
        updateRepeatModeButton();
    }

    public boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public void setShowShuffleButton(boolean showShuffleButton) {
        this.showShuffleButton = showShuffleButton;
        updateShuffleButton();
    }

    public boolean getShowVrButton() {
        View view = this.vrButton;
        return view != null && view.getVisibility() == 0;
    }

    public void setShowVrButton(boolean showVrButton) {
        View view = this.vrButton;
        if (view != null) {
            view.setVisibility(showVrButton ? 0 : 8);
        }
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setTimeBarMinUpdateInterval(int minUpdateIntervalMs) {
        this.timeBarMinUpdateIntervalMs = Util.constrainValue(minUpdateIntervalMs, 16, 1000);
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            Iterator<VisibilityListener> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            updateAll();
            requestPlayPauseFocus();
        }
        hideAfterTimeout();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            Iterator<VisibilityListener> it = this.visibilityListeners.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
            this.hideAtMs = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    private void hideAfterTimeout() {
        removeCallbacks(this.hideAction);
        if (this.showTimeoutMs > 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i = this.showTimeoutMs;
            this.hideAtMs = jUptimeMillis + i;
            if (this.isAttachedToWindow) {
                postDelayed(this.hideAction, i);
                return;
            }
            return;
        }
        this.hideAtMs = -9223372036854775807L;
    }

    private void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTimeline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlayPauseButton() {
        boolean z;
        if (isVisible() && this.isAttachedToWindow) {
            boolean zShouldShowPauseButton = shouldShowPauseButton();
            View view = this.playButton;
            if (view != null) {
                z = zShouldShowPauseButton && view.isFocused();
                this.playButton.setVisibility(zShouldShowPauseButton ? 8 : 0);
            } else {
                z = false;
            }
            View view2 = this.pauseButton;
            if (view2 != null) {
                z |= !zShouldShowPauseButton && view2.isFocused();
                this.pauseButton.setVisibility(zShouldShowPauseButton ? 0 : 8);
            }
            if (z) {
                requestPlayPauseFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateNavigation() {
        /*
            r8 = this;
            boolean r0 = r8.isVisible()
            if (r0 == 0) goto L88
            boolean r0 = r8.isAttachedToWindow
            if (r0 != 0) goto Lc
            goto L88
        Lc:
            com.google.android.exoplayer2.Player r0 = r8.player
            r1 = 0
            if (r0 == 0) goto L69
            com.google.android.exoplayer2.Timeline r2 = r0.getCurrentTimeline()
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L69
            boolean r3 = r0.isPlayingAd()
            if (r3 != 0) goto L69
            int r3 = r0.getCurrentWindowIndex()
            com.google.android.exoplayer2.Timeline$Window r4 = r8.window
            r2.getWindow(r3, r4)
            com.google.android.exoplayer2.Timeline$Window r2 = r8.window
            boolean r3 = r2.isSeekable
            r4 = 1
            if (r3 != 0) goto L3e
            boolean r2 = r2.isDynamic
            if (r2 == 0) goto L3e
            boolean r2 = r0.hasPrevious()
            if (r2 == 0) goto L3c
            goto L3e
        L3c:
            r2 = r1
            goto L3f
        L3e:
            r2 = r4
        L3f:
            if (r3 == 0) goto L4b
            com.google.android.exoplayer2.ControlDispatcher r5 = r8.controlDispatcher
            boolean r5 = r5.isRewindEnabled()
            if (r5 == 0) goto L4b
            r5 = r4
            goto L4c
        L4b:
            r5 = r1
        L4c:
            if (r3 == 0) goto L58
            com.google.android.exoplayer2.ControlDispatcher r6 = r8.controlDispatcher
            boolean r6 = r6.isFastForwardEnabled()
            if (r6 == 0) goto L58
            r6 = r4
            goto L59
        L58:
            r6 = r1
        L59:
            com.google.android.exoplayer2.Timeline$Window r7 = r8.window
            boolean r7 = r7.isDynamic
            if (r7 != 0) goto L65
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L66
        L65:
            r1 = r4
        L66:
            r0 = r1
            r1 = r2
            goto L6d
        L69:
            r0 = r1
            r3 = r0
            r5 = r3
            r6 = r5
        L6d:
            android.view.View r2 = r8.previousButton
            r8.setButtonEnabled(r1, r2)
            android.view.View r1 = r8.rewindButton
            r8.setButtonEnabled(r5, r1)
            android.view.View r1 = r8.fastForwardButton
            r8.setButtonEnabled(r6, r1)
            android.view.View r1 = r8.nextButton
            r8.setButtonEnabled(r0, r1)
            com.google.android.exoplayer2.ui.TimeBar r0 = r8.timeBar
            if (r0 == 0) goto L88
            r0.setEnabled(r3)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.updateNavigation():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                imageView.setVisibility(8);
                return;
            }
            Player player = this.player;
            if (player == null) {
                setButtonEnabled(false, imageView);
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                return;
            }
            setButtonEnabled(true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
            } else if (repeatMode == 1) {
                this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
            } else if (repeatMode == 2) {
                this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
            }
            this.repeatToggleButton.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShuffleButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.shuffleButton) != null) {
            Player player = this.player;
            if (!this.showShuffleButton) {
                imageView.setVisibility(8);
                return;
            }
            if (player == null) {
                setButtonEnabled(false, imageView);
                this.shuffleButton.setImageDrawable(this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(this.shuffleOffContentDescription);
            } else {
                setButtonEnabled(true, imageView);
                this.shuffleButton.setImageDrawable(player.getShuffleModeEnabled() ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable);
                this.shuffleButton.setContentDescription(player.getShuffleModeEnabled() ? this.shuffleOnContentDescription : this.shuffleOffContentDescription);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateTimeline() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerControlView.updateTimeline():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress() {
        long contentPosition;
        long contentBufferedPosition;
        if (isVisible() && this.isAttachedToWindow) {
            Player player = this.player;
            if (player != null) {
                contentPosition = this.currentWindowOffset + player.getContentPosition();
                contentBufferedPosition = this.currentWindowOffset + player.getContentBufferedPosition();
            } else {
                contentPosition = 0;
                contentBufferedPosition = 0;
            }
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, contentPosition));
            }
            TimeBar timeBar = this.timeBar;
            if (timeBar != null) {
                timeBar.setPosition(contentPosition);
                this.timeBar.setBufferedPosition(contentBufferedPosition);
            }
            removeCallbacks(this.updateProgressAction);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.updateProgressAction, 1000L);
                return;
            }
            TimeBar timeBar2 = this.timeBar;
            long jMin = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float playbackSpeed = player.getPlaybackSpeed();
            postDelayed(this.updateProgressAction, Util.constrainValue(playbackSpeed > 0.0f ? (long) (jMin / playbackSpeed) : 1000L, this.timeBarMinUpdateIntervalMs, 1000L));
        }
    }

    private void requestPlayPauseFocus() {
        View view;
        View view2;
        boolean zShouldShowPauseButton = shouldShowPauseButton();
        if (!zShouldShowPauseButton && (view2 = this.playButton) != null) {
            view2.requestFocus();
        } else {
            if (!zShouldShowPauseButton || (view = this.pauseButton) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    private void setButtonEnabled(boolean enabled, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(enabled);
        view.setAlpha(enabled ? this.buttonAlphaEnabled : this.buttonAlphaDisabled);
        view.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToTimeBarPosition(Player player, long positionMs) {
        int currentWindowIndex;
        Timeline currentTimeline = player.getCurrentTimeline();
        if (this.multiWindowTimeBar && !currentTimeline.isEmpty()) {
            int windowCount = currentTimeline.getWindowCount();
            currentWindowIndex = 0;
            while (true) {
                long durationMs = currentTimeline.getWindow(currentWindowIndex, this.window).getDurationMs();
                if (positionMs < durationMs) {
                    break;
                }
                if (currentWindowIndex == windowCount - 1) {
                    positionMs = durationMs;
                    break;
                } else {
                    positionMs -= durationMs;
                    currentWindowIndex++;
                }
            }
        } else {
            currentWindowIndex = player.getCurrentWindowIndex();
        }
        if (seekTo(player, currentWindowIndex, positionMs)) {
            return;
        }
        updateProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean seekTo(Player player, int windowIndex, long positionMs) {
        return this.controlDispatcher.dispatchSeekTo(player, windowIndex, positionMs);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        long j = this.hideAtMs;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.hideAction, jUptimeMillis);
            }
        } else if (isVisible()) {
            hideAfterTimeout();
        }
        updateAll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            removeCallbacks(this.hideAction);
        } else if (ev.getAction() == 1) {
            hideAfterTimeout();
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        return dispatchMediaKeyEvent(event) || super.dispatchKeyEvent(event);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        Player player = this.player;
        if (player == null || !isHandledMediaKey(keyCode)) {
            return false;
        }
        if (event.getAction() == 0) {
            if (keyCode == 90) {
                this.controlDispatcher.dispatchFastForward(player);
            } else if (keyCode == 89) {
                this.controlDispatcher.dispatchRewind(player);
            } else if (event.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(player, !player.getPlayWhenReady());
                } else if (keyCode == 87) {
                    this.controlDispatcher.dispatchNext(player);
                } else if (keyCode == 88) {
                    this.controlDispatcher.dispatchPrevious(player);
                } else if (keyCode == 126) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(player, true);
                } else if (keyCode == 127) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(player, false);
                }
            }
        }
        return true;
    }

    private boolean shouldShowPauseButton() {
        Player player = this.player;
        return (player == null || player.getPlaybackState() == 4 || this.player.getPlaybackState() == 1 || !this.player.getPlayWhenReady()) ? false : true;
    }

    private static boolean canShowMultiWindowTimeBar(Timeline timeline, Timeline.Window window) {
        if (timeline.getWindowCount() > 100) {
            return false;
        }
        int windowCount = timeline.getWindowCount();
        for (int i = 0; i < windowCount; i++) {
            if (timeline.getWindow(i, window).durationUs == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private final class ComponentListener implements Player.EventListener, TimeBar.OnScrubListener, View.OnClickListener {
        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(TimeBar timeBar, long position) {
            PlayerControlView.this.scrubbing = true;
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, position));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(TimeBar timeBar, long position) {
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, position));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(TimeBar timeBar, long position, boolean canceled) {
            PlayerControlView.this.scrubbing = false;
            if (canceled || PlayerControlView.this.player == null) {
                return;
            }
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.seekToTimeBarPosition(playerControlView.player, position);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int playbackState) {
            PlayerControlView.this.updatePlayPauseButton();
            PlayerControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            PlayerControlView.this.updatePlayPauseButton();
            PlayerControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsPlayingChanged(boolean isPlaying) {
            PlayerControlView.this.updateProgress();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int repeatMode) {
            PlayerControlView.this.updateRepeatModeButton();
            PlayerControlView.this.updateNavigation();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
            PlayerControlView.this.updateShuffleButton();
            PlayerControlView.this.updateNavigation();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int reason) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(Timeline timeline, int reason) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Player player = PlayerControlView.this.player;
            if (player == null) {
                return;
            }
            if (PlayerControlView.this.nextButton == view) {
                PlayerControlView.this.controlDispatcher.dispatchNext(player);
                return;
            }
            if (PlayerControlView.this.previousButton == view) {
                PlayerControlView.this.controlDispatcher.dispatchPrevious(player);
                return;
            }
            if (PlayerControlView.this.fastForwardButton == view) {
                PlayerControlView.this.controlDispatcher.dispatchFastForward(player);
                return;
            }
            if (PlayerControlView.this.rewindButton == view) {
                PlayerControlView.this.controlDispatcher.dispatchRewind(player);
                return;
            }
            if (PlayerControlView.this.playButton != view) {
                if (PlayerControlView.this.pauseButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(player, false);
                    return;
                } else {
                    if (PlayerControlView.this.repeatToggleButton != view) {
                        if (PlayerControlView.this.shuffleButton == view) {
                            PlayerControlView.this.controlDispatcher.dispatchSetShuffleModeEnabled(player, !player.getShuffleModeEnabled());
                            return;
                        }
                        return;
                    }
                    PlayerControlView.this.controlDispatcher.dispatchSetRepeatMode(player, RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), PlayerControlView.this.repeatToggleModes));
                    return;
                }
            }
            if (player.getPlaybackState() == 1) {
                PlayerControlView.access$1900(PlayerControlView.this);
            } else if (player.getPlaybackState() == 4) {
                PlayerControlView.this.seekTo(player, player.getCurrentWindowIndex(), -9223372036854775807L);
            }
            PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(player, true);
        }
    }
}
