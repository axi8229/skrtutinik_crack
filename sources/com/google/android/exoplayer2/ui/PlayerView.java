package com.google.android.exoplayer2.ui;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.VideoListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class PlayerView extends FrameLayout {
    private final FrameLayout adOverlayFrameLayout;
    private final ImageView artworkView;
    private final View bufferingView;
    private final ComponentListener componentListener;
    private final AspectRatioFrameLayout contentFrame;
    private final PlayerControlView controller;
    private boolean controllerAutoShow;
    private boolean controllerHideDuringAds;
    private boolean controllerHideOnTouch;
    private int controllerShowTimeoutMs;
    private PlayerControlView.VisibilityListener controllerVisibilityListener;
    private CharSequence customErrorMessage;
    private Drawable defaultArtwork;
    private final TextView errorMessageView;
    private boolean isTouching;
    private boolean keepContentOnPlayerReset;
    private int lastVideoRendererIdx;
    private final FrameLayout overlayFrameLayout;
    private Player player;
    private int showBuffering;
    private final View shutterView;
    private final SubtitleView subtitleView;
    private final View surfaceView;
    private int textureViewRotation;
    private boolean useArtwork;
    private boolean useController;
    private boolean useSensorRotation;

    @SuppressLint({"InlinedApi"})
    private boolean isDpadKey(int keyCode) {
        return keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
    }

    public PlayerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        int i;
        int i2;
        boolean z;
        int integer;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        boolean z6;
        int i7;
        super(context, attrs, defStyleAttr);
        this.lastVideoRendererIdx = -1;
        ComponentListener componentListener = new ComponentListener();
        this.componentListener = componentListener;
        if (isInEditMode()) {
            this.contentFrame = null;
            this.shutterView = null;
            this.surfaceView = null;
            this.artworkView = null;
            this.subtitleView = null;
            this.bufferingView = null;
            this.errorMessageView = null;
            this.controller = null;
            this.adOverlayFrameLayout = null;
            this.overlayFrameLayout = null;
            ImageView imageView = new ImageView(context);
            if (Util.SDK_INT >= 23) {
                configureEditModeLogoV23(getResources(), imageView);
            } else {
                configureEditModeLogo(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = R$layout.exo_player_view;
        this.useSensorRotation = true;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R$styleable.PlayerView, 0, 0);
            try {
                int i9 = R$styleable.PlayerView_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i9);
                int color = typedArrayObtainStyledAttributes.getColor(i9, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_player_layout_id, i8);
                boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R$styleable.PlayerView_default_artwork, 0);
                boolean z8 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_controller, true);
                int i10 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_surface_type, 1);
                int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_resize_mode, 0);
                int i12 = typedArrayObtainStyledAttributes.getInt(R$styleable.PlayerView_show_timeout, 5000);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_on_touch, true);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_auto_show, true);
                integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.PlayerView_show_buffering, 0);
                this.keepContentOnPlayerReset = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_keep_content_on_player_reset, this.keepContentOnPlayerReset);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_hide_during_ads, true);
                this.useSensorRotation = typedArrayObtainStyledAttributes.getBoolean(R$styleable.PlayerView_use_sensor_rotation, this.useSensorRotation);
                typedArrayObtainStyledAttributes.recycle();
                z2 = z9;
                i2 = i11;
                z = z10;
                i3 = i10;
                i = i12;
                z5 = z8;
                i6 = resourceId;
                i5 = resourceId2;
                z6 = z11;
                z4 = z7;
                z3 = zHasValue;
                i4 = color;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i = 5000;
            i2 = 0;
            z = true;
            integer = 0;
            i3 = 1;
            z2 = true;
            i4 = 0;
            z3 = false;
            z4 = true;
            i5 = 0;
            z5 = true;
            i6 = i8;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i6, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(R$id.exo_content_frame);
        this.contentFrame = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            setResizeModeRaw(aspectRatioFrameLayout, i2);
        }
        View viewFindViewById = findViewById(R$id.exo_shutter);
        this.shutterView = viewFindViewById;
        if (viewFindViewById != null && z3) {
            viewFindViewById.setBackgroundColor(i4);
        }
        if (aspectRatioFrameLayout != null && i3 != 0) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i3 == 2) {
                this.surfaceView = new TextureView(context);
            } else if (i3 == 3) {
                SphericalGLSurfaceView sphericalGLSurfaceView = new SphericalGLSurfaceView(context);
                sphericalGLSurfaceView.setSingleTapListener(componentListener);
                sphericalGLSurfaceView.setUseSensorRotation(this.useSensorRotation);
                this.surfaceView = sphericalGLSurfaceView;
            } else if (i3 == 4) {
                this.surfaceView = new VideoDecoderGLSurfaceView(context);
            } else {
                this.surfaceView = new SurfaceView(context);
            }
            this.surfaceView.setLayoutParams(layoutParams);
            aspectRatioFrameLayout.addView(this.surfaceView, 0);
        } else {
            this.surfaceView = null;
        }
        this.adOverlayFrameLayout = (FrameLayout) findViewById(R$id.exo_ad_overlay);
        this.overlayFrameLayout = (FrameLayout) findViewById(R$id.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(R$id.exo_artwork);
        this.artworkView = imageView2;
        this.useArtwork = z4 && imageView2 != null;
        if (i5 != 0) {
            this.defaultArtwork = ContextCompat.getDrawable(getContext(), i5);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(R$id.exo_subtitles);
        this.subtitleView = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        View viewFindViewById2 = findViewById(R$id.exo_buffering);
        this.bufferingView = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.showBuffering = integer;
        TextView textView = (TextView) findViewById(R$id.exo_error_message);
        this.errorMessageView = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i13 = R$id.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i13);
        View viewFindViewById3 = findViewById(R$id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.controller = playerControlView;
            i7 = 0;
        } else if (viewFindViewById3 != null) {
            i7 = 0;
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attrs);
            this.controller = playerControlView2;
            playerControlView2.setId(i13);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            i7 = 0;
            this.controller = null;
        }
        PlayerControlView playerControlView3 = this.controller;
        this.controllerShowTimeoutMs = playerControlView3 != null ? i : i7;
        this.controllerHideOnTouch = z2;
        this.controllerAutoShow = z;
        this.controllerHideDuringAds = z6;
        this.useController = (!z5 || playerControlView3 == null) ? i7 : 1;
        hideController();
        updateContentDescription();
        PlayerControlView playerControlView4 = this.controller;
        if (playerControlView4 != null) {
            playerControlView4.addVisibilityListener(componentListener);
        }
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
            Player.VideoComponent videoComponent = player2.getVideoComponent();
            if (videoComponent != null) {
                videoComponent.removeVideoListener(this.componentListener);
                View view = this.surfaceView;
                if (view instanceof TextureView) {
                    videoComponent.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SphericalGLSurfaceView) {
                    ((SphericalGLSurfaceView) view).setVideoComponent(null);
                } else if (view instanceof VideoDecoderGLSurfaceView) {
                    videoComponent.setVideoDecoderOutputBufferRenderer(null);
                } else if (view instanceof SurfaceView) {
                    videoComponent.clearVideoSurfaceView((SurfaceView) view);
                }
            }
            Player.TextComponent textComponent = player2.getTextComponent();
            if (textComponent != null) {
                textComponent.removeTextOutput(this.componentListener);
            }
        }
        this.player = player;
        if (useController()) {
            this.controller.setPlayer(player);
        }
        SubtitleView subtitleView = this.subtitleView;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        updateBuffering();
        updateErrorMessage();
        updateForCurrentTrackSelections(true);
        if (player != null) {
            Player.VideoComponent videoComponent2 = player.getVideoComponent();
            if (videoComponent2 != null) {
                View view2 = this.surfaceView;
                if (view2 instanceof TextureView) {
                    videoComponent2.setVideoTextureView((TextureView) view2);
                } else if (view2 instanceof SphericalGLSurfaceView) {
                    ((SphericalGLSurfaceView) view2).setVideoComponent(videoComponent2);
                } else if (view2 instanceof VideoDecoderGLSurfaceView) {
                    videoComponent2.setVideoDecoderOutputBufferRenderer(((VideoDecoderGLSurfaceView) view2).getVideoDecoderOutputBufferRenderer());
                } else if (view2 instanceof SurfaceView) {
                    videoComponent2.setVideoSurfaceView((SurfaceView) view2);
                }
                videoComponent2.addVideoListener(this.componentListener);
            }
            Player.TextComponent textComponent2 = player.getTextComponent();
            if (textComponent2 != null) {
                textComponent2.addTextOutput(this.componentListener);
            }
            player.addListener(this.componentListener);
            maybeShowController(false);
            return;
        }
        hideController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetSurfaceView() {
        AspectRatioFrameLayout aspectRatioFrameLayout = this.contentFrame;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.removeView(this.surfaceView);
            this.contentFrame.addView(this.surfaceView, 0);
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        View view = this.surfaceView;
        if (view instanceof SurfaceView) {
            view.setVisibility(visibility);
        }
    }

    public void setResizeMode(int resizeMode) {
        Assertions.checkStateNotNull(this.contentFrame);
        this.contentFrame.setResizeMode(resizeMode);
    }

    public int getResizeMode() {
        Assertions.checkStateNotNull(this.contentFrame);
        return this.contentFrame.getResizeMode();
    }

    public boolean getUseArtwork() {
        return this.useArtwork;
    }

    public void setUseArtwork(boolean useArtwork) {
        Assertions.checkState((useArtwork && this.artworkView == null) ? false : true);
        if (this.useArtwork != useArtwork) {
            this.useArtwork = useArtwork;
            updateForCurrentTrackSelections(false);
        }
    }

    public Drawable getDefaultArtwork() {
        return this.defaultArtwork;
    }

    @Deprecated
    public void setDefaultArtwork(Bitmap defaultArtwork) {
        setDefaultArtwork(defaultArtwork == null ? null : new BitmapDrawable(getResources(), defaultArtwork));
    }

    public void setDefaultArtwork(Drawable defaultArtwork) {
        if (this.defaultArtwork != defaultArtwork) {
            this.defaultArtwork = defaultArtwork;
            updateForCurrentTrackSelections(false);
        }
    }

    public boolean getUseController() {
        return this.useController;
    }

    public void setUseController(boolean useController) {
        Assertions.checkState((useController && this.controller == null) ? false : true);
        if (this.useController == useController) {
            return;
        }
        this.useController = useController;
        if (useController()) {
            this.controller.setPlayer(this.player);
        } else {
            PlayerControlView playerControlView = this.controller;
            if (playerControlView != null) {
                playerControlView.hide();
                this.controller.setPlayer(null);
            }
        }
        updateContentDescription();
    }

    public void setShutterBackgroundColor(int color) {
        View view = this.shutterView;
        if (view != null) {
            view.setBackgroundColor(color);
        }
    }

    public void setKeepContentOnPlayerReset(boolean keepContentOnPlayerReset) {
        if (this.keepContentOnPlayerReset != keepContentOnPlayerReset) {
            this.keepContentOnPlayerReset = keepContentOnPlayerReset;
            updateForCurrentTrackSelections(false);
        }
    }

    public void setUseSensorRotation(boolean useSensorRotation) {
        if (this.useSensorRotation != useSensorRotation) {
            this.useSensorRotation = useSensorRotation;
            View view = this.surfaceView;
            if (view instanceof SphericalGLSurfaceView) {
                ((SphericalGLSurfaceView) view).setUseSensorRotation(useSensorRotation);
            }
        }
    }

    @Deprecated
    public void setShowBuffering(boolean z) {
        setShowBuffering(z ? 1 : 0);
    }

    public void setShowBuffering(int showBuffering) {
        if (this.showBuffering != showBuffering) {
            this.showBuffering = showBuffering;
            updateBuffering();
        }
    }

    public void setErrorMessageProvider(ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider) {
        if (errorMessageProvider != null) {
            updateErrorMessage();
        }
    }

    public void setCustomErrorMessage(CharSequence message) {
        Assertions.checkState(this.errorMessageView != null);
        this.customErrorMessage = message;
        updateErrorMessage();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Player player = this.player;
        if (player != null && player.isPlayingAd()) {
            return super.dispatchKeyEvent(event);
        }
        boolean zIsDpadKey = isDpadKey(event.getKeyCode());
        if (zIsDpadKey && useController() && !this.controller.isVisible()) {
            maybeShowController(true);
            return true;
        }
        if (dispatchMediaKeyEvent(event) || super.dispatchKeyEvent(event)) {
            maybeShowController(true);
            return true;
        }
        if (zIsDpadKey && useController()) {
            maybeShowController(true);
        }
        return false;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent event) {
        return useController() && this.controller.dispatchMediaKeyEvent(event);
    }

    public void showController() {
        showController(shouldShowControllerIndefinitely());
    }

    public void hideController() {
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public void setControllerShowTimeoutMs(int controllerShowTimeoutMs) {
        Assertions.checkStateNotNull(this.controller);
        this.controllerShowTimeoutMs = controllerShowTimeoutMs;
        if (this.controller.isVisible()) {
            showController();
        }
    }

    public boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    public void setControllerHideOnTouch(boolean controllerHideOnTouch) {
        Assertions.checkStateNotNull(this.controller);
        this.controllerHideOnTouch = controllerHideOnTouch;
        updateContentDescription();
    }

    public boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public void setControllerAutoShow(boolean controllerAutoShow) {
        this.controllerAutoShow = controllerAutoShow;
    }

    public void setControllerHideDuringAds(boolean controllerHideDuringAds) {
        this.controllerHideDuringAds = controllerHideDuringAds;
    }

    public void setControllerVisibilityListener(PlayerControlView.VisibilityListener listener) {
        Assertions.checkStateNotNull(this.controller);
        PlayerControlView.VisibilityListener visibilityListener = this.controllerVisibilityListener;
        if (visibilityListener == listener) {
            return;
        }
        if (visibilityListener != null) {
            this.controller.removeVisibilityListener(visibilityListener);
        }
        this.controllerVisibilityListener = listener;
        if (listener != null) {
            this.controller.addVisibilityListener(listener);
        }
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setPlaybackPreparer(playbackPreparer);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setControlDispatcher(controlDispatcher);
    }

    @Deprecated
    public void setRewindIncrementMs(int rewindMs) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setRewindIncrementMs(rewindMs);
    }

    @Deprecated
    public void setFastForwardIncrementMs(int fastForwardMs) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setFastForwardIncrementMs(fastForwardMs);
    }

    public void setRepeatToggleModes(int repeatToggleModes) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setRepeatToggleModes(repeatToggleModes);
    }

    public void setShowShuffleButton(boolean showShuffleButton) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowShuffleButton(showShuffleButton);
    }

    public void setShowMultiWindowTimeBar(boolean showMultiWindowTimeBar) {
        Assertions.checkStateNotNull(this.controller);
        this.controller.setShowMultiWindowTimeBar(showMultiWindowTimeBar);
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener listener) {
        Assertions.checkStateNotNull(this.contentFrame);
        this.contentFrame.setAspectRatioListener(listener);
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!useController() || this.player == null) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.isTouching = true;
            return true;
        }
        if (action != 1 || !this.isTouching) {
            return false;
        }
        this.isTouching = false;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return toggleControllerVisibility();
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent ev) {
        if (!useController() || this.player == null) {
            return false;
        }
        maybeShowController(true);
        return true;
    }

    protected void onContentAspectRatioChanged(float contentAspectRatio, AspectRatioFrameLayout contentFrame, View contentView) {
        if (contentFrame != null) {
            if (contentView instanceof SphericalGLSurfaceView) {
                contentAspectRatio = 0.0f;
            }
            contentFrame.setAspectRatio(contentAspectRatio);
        }
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) Assertions.checkStateNotNull(this.adOverlayFrameLayout, "exo_ad_overlay must be present for ad playback");
    }

    public View[] getAdOverlayViews() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.overlayFrameLayout;
        if (frameLayout != null) {
            arrayList.add(frameLayout);
        }
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            arrayList.add(playerControlView);
        }
        return (View[]) arrayList.toArray(new View[0]);
    }

    private boolean useController() {
        if (!this.useController) {
            return false;
        }
        Assertions.checkStateNotNull(this.controller);
        return true;
    }

    private boolean useArtwork() {
        if (!this.useArtwork) {
            return false;
        }
        Assertions.checkStateNotNull(this.artworkView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toggleControllerVisibility() {
        if (!useController() || this.player == null) {
            return false;
        }
        if (!this.controller.isVisible()) {
            maybeShowController(true);
        } else if (this.controllerHideOnTouch) {
            this.controller.hide();
        }
        return true;
    }

    private void maybeShowController(boolean isForced) {
        if (!(isPlayingAd() && this.controllerHideDuringAds) && useController()) {
            boolean z = this.controller.isVisible() && this.controller.getShowTimeoutMs() <= 0;
            boolean zShouldShowControllerIndefinitely = shouldShowControllerIndefinitely();
            if (isForced || z || zShouldShowControllerIndefinitely) {
                showController(zShouldShowControllerIndefinitely);
            }
        }
    }

    private boolean shouldShowControllerIndefinitely() {
        Player player = this.player;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        return this.controllerAutoShow && (playbackState == 1 || playbackState == 4 || !this.player.getPlayWhenReady());
    }

    private void showController(boolean showIndefinitely) {
        if (useController()) {
            this.controller.setShowTimeoutMs(showIndefinitely ? 0 : this.controllerShowTimeoutMs);
            this.controller.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPlayingAd() {
        Player player = this.player;
        return player != null && player.isPlayingAd() && this.player.getPlayWhenReady();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateForCurrentTrackSelections(boolean isNewPlayer) {
        Player player = this.player;
        if (player == null || player.getCurrentTrackGroups().isEmpty()) {
            if (this.keepContentOnPlayerReset) {
                return;
            }
            hideArtwork();
            closeShutter();
            return;
        }
        if (isNewPlayer && !this.keepContentOnPlayerReset) {
            closeShutter();
        }
        TrackSelectionArray currentTrackSelections = player.getCurrentTrackSelections();
        for (int i = 0; i < currentTrackSelections.length; i++) {
            if (player.getRendererType(i) == 2 && currentTrackSelections.get(i) != null) {
                hideArtwork();
                return;
            }
        }
        closeShutter();
        if (useArtwork()) {
            for (int i2 = 0; i2 < currentTrackSelections.length; i2++) {
                TrackSelection trackSelection = currentTrackSelections.get(i2);
                if (trackSelection != null) {
                    for (int i3 = 0; i3 < trackSelection.length(); i3++) {
                        Metadata metadata = trackSelection.getFormat(i3).metadata;
                        if (metadata != null && setArtworkFromMetadata(metadata)) {
                            return;
                        }
                    }
                }
            }
            if (setDrawableArtwork(this.defaultArtwork)) {
                return;
            }
        }
        hideArtwork();
    }

    private boolean setArtworkFromMetadata(Metadata metadata) {
        byte[] bArr;
        int i;
        boolean drawableArtwork = false;
        int i2 = -1;
        for (int i3 = 0; i3 < metadata.length(); i3++) {
            Metadata.Entry entry = metadata.get(i3);
            if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                bArr = apicFrame.pictureData;
                i = apicFrame.pictureType;
            } else if (entry instanceof PictureFrame) {
                PictureFrame pictureFrame = (PictureFrame) entry;
                bArr = pictureFrame.pictureData;
                i = pictureFrame.pictureType;
            } else {
                continue;
            }
            if (i2 == -1 || i == 3) {
                drawableArtwork = setDrawableArtwork(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                if (i == 3) {
                    break;
                }
                i2 = i;
            }
        }
        return drawableArtwork;
    }

    private boolean setDrawableArtwork(Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(intrinsicWidth / intrinsicHeight, this.contentFrame, this.artworkView);
                this.artworkView.setImageDrawable(drawable);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private void hideArtwork() {
        ImageView imageView = this.artworkView;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.artworkView.setVisibility(4);
        }
    }

    private void closeShutter() {
        View view = this.shutterView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateBuffering() {
        /*
            r4 = this;
            android.view.View r0 = r4.bufferingView
            if (r0 == 0) goto L2b
            com.google.android.exoplayer2.Player r0 = r4.player
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.showBuffering
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            com.google.android.exoplayer2.Player r0 = r4.player
            boolean r0 = r0.getPlayWhenReady()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = r1
        L21:
            android.view.View r0 = r4.bufferingView
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r0.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.PlayerView.updateBuffering():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateErrorMessage() {
        TextView textView = this.errorMessageView;
        if (textView != null) {
            CharSequence charSequence = this.customErrorMessage;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.errorMessageView.setVisibility(0);
            } else {
                Player player = this.player;
                if (player != null) {
                    player.getPlayerError();
                }
                this.errorMessageView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContentDescription() {
        PlayerControlView playerControlView = this.controller;
        if (playerControlView == null || !this.useController) {
            setContentDescription(null);
        } else if (playerControlView.getVisibility() == 0) {
            setContentDescription(this.controllerHideOnTouch ? getResources().getString(R$string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(R$string.exo_controls_show));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateControllerVisibility() {
        if (isPlayingAd() && this.controllerHideDuringAds) {
            hideController();
        } else {
            maybeShowController(false);
        }
    }

    private static void configureEditModeLogoV23(Resources resources, ImageView logo) {
        logo.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo, null));
        logo.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color, null));
    }

    private static void configureEditModeLogo(Resources resources, ImageView logo) {
        logo.setImageDrawable(resources.getDrawable(R$drawable.exo_edit_mode_logo));
        logo.setBackgroundColor(resources.getColor(R$color.exo_edit_mode_background_color));
    }

    private static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrame, int resizeMode) {
        aspectRatioFrame.setResizeMode(resizeMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void applyTextureViewRotation(TextureView textureView, int textureViewRotation) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && textureViewRotation != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(textureViewRotation, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    private final class ComponentListener implements Player.EventListener, TextOutput, VideoListener, View.OnLayoutChangeListener, SingleTapListener, PlayerControlView.VisibilityListener {
        private ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List<Cue> cues) {
            if (PlayerView.this.subtitleView != null) {
                PlayerView.this.subtitleView.onCues(cues);
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onVideoSizeChanged(int width, int height, int unappliedRotationDegrees, float pixelWidthHeightRatio) {
            float f = (height == 0 || width == 0) ? 1.0f : (width * pixelWidthHeightRatio) / height;
            if (PlayerView.this.surfaceView instanceof TextureView) {
                if (unappliedRotationDegrees == 90 || unappliedRotationDegrees == 270) {
                    f = 1.0f / f;
                }
                if (PlayerView.this.textureViewRotation != 0) {
                    PlayerView.this.surfaceView.removeOnLayoutChangeListener(this);
                }
                PlayerView.this.textureViewRotation = unappliedRotationDegrees;
                if (PlayerView.this.textureViewRotation != 0) {
                    PlayerView.this.surfaceView.addOnLayoutChangeListener(this);
                }
                PlayerView.applyTextureViewRotation((TextureView) PlayerView.this.surfaceView, PlayerView.this.textureViewRotation);
            }
            PlayerView playerView = PlayerView.this;
            playerView.onContentAspectRatioChanged(f, playerView.contentFrame, PlayerView.this.surfaceView);
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onRenderedFirstFrame() {
            if (PlayerView.this.shutterView != null) {
                PlayerView.this.shutterView.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(TrackGroupArray tracks, TrackSelectionArray selections) {
            PlayerView.this.updateForCurrentTrackSelections(false);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int playbackState) {
            PlayerView.this.updateBuffering();
            PlayerView.this.updateErrorMessage();
            PlayerView.this.updateControllerVisibility();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean playWhenReady, int reason) {
            PlayerView.this.updateBuffering();
            PlayerView.this.updateControllerVisibility();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int reason) {
            if (PlayerView.this.isPlayingAd() && PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTrackSelected(TrackSelectorResult trackSelectorResult) {
            TrackSelectionArray trackSelectionArray = trackSelectorResult.selections;
            if (PlayerView.this.player != null) {
                for (int i = 0; i < trackSelectionArray.length; i++) {
                    if (PlayerView.this.player.getRendererType(i) == 2 && trackSelectionArray.get(i) != null) {
                        if (PlayerView.this.lastVideoRendererIdx != -1 && PlayerView.this.lastVideoRendererIdx != i && i == 0) {
                            PlayerView.this.resetSurfaceView();
                        }
                        PlayerView.this.lastVideoRendererIdx = i;
                        return;
                    }
                }
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            PlayerView.applyTextureViewRotation((TextureView) view, PlayerView.this.textureViewRotation);
        }

        @Override // com.google.android.exoplayer2.ui.spherical.SingleTapListener
        public boolean onSingleTapUp(MotionEvent e) {
            return PlayerView.this.toggleControllerVisibility();
        }

        @Override // com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener
        public void onVisibilityChange(int visibility) {
            PlayerView.this.updateContentDescription();
        }
    }
}
