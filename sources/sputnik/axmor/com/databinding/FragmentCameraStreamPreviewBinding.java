package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.exoplayer2.ui.PlayerView;
import com.shopgun.android.zoomlayout.ZoomLayout;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentCameraStreamPreviewBinding implements ViewBinding {
    public final ImageView btnBack;
    public final AppCompatButton btnSubscribe;
    public final HorizontalScrollView hsPreview;
    public final LinearLayout layoutCameraLocked;
    public final ZoomLayout layoutZoom;
    public final ZoomLayout layoutZoom2;
    public final PlayerView playerExo;
    public final SurfaceViewRenderer playerWebrtc;
    public final ImageView preview;
    public final LinearLayout previewError;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final TextView tvError;
    public final TextView tvLoader;
    public final TextView tvSubscriptionRequired;
    public final LinearLayout videoLoader;
    public final View viewDimSubscriptionRequired;

    private FragmentCameraStreamPreviewBinding(ConstraintLayout constraintLayout, ImageView imageView, AppCompatButton appCompatButton, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout, ZoomLayout zoomLayout, ZoomLayout zoomLayout2, PlayerView playerView, SurfaceViewRenderer surfaceViewRenderer, ImageView imageView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout3, View view) {
        this.rootView = constraintLayout;
        this.btnBack = imageView;
        this.btnSubscribe = appCompatButton;
        this.hsPreview = horizontalScrollView;
        this.layoutCameraLocked = linearLayout;
        this.layoutZoom = zoomLayout;
        this.layoutZoom2 = zoomLayout2;
        this.playerExo = playerView;
        this.playerWebrtc = surfaceViewRenderer;
        this.preview = imageView2;
        this.previewError = linearLayout2;
        this.root = constraintLayout2;
        this.tvError = textView;
        this.tvLoader = textView2;
        this.tvSubscriptionRequired = textView3;
        this.videoLoader = linearLayout3;
        this.viewDimSubscriptionRequired = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCameraStreamPreviewBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btn_back);
        if (imageView != null) {
            i = R.id.btn_subscribe;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
            if (appCompatButton != null) {
                i = R.id.hs_preview;
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.hs_preview);
                if (horizontalScrollView != null) {
                    i = R.id.layout_camera_locked;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_camera_locked);
                    if (linearLayout != null) {
                        i = R.id.layout_zoom;
                        ZoomLayout zoomLayout = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom);
                        if (zoomLayout != null) {
                            i = R.id.layout_zoom2;
                            ZoomLayout zoomLayout2 = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom2);
                            if (zoomLayout2 != null) {
                                i = R.id.player_exo;
                                PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, R.id.player_exo);
                                if (playerView != null) {
                                    i = R.id.player_webrtc;
                                    SurfaceViewRenderer surfaceViewRenderer = (SurfaceViewRenderer) ViewBindings.findChildViewById(view, R.id.player_webrtc);
                                    if (surfaceViewRenderer != null) {
                                        i = R.id.preview;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.preview);
                                        if (imageView2 != null) {
                                            i = R.id.previewError;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.previewError);
                                            if (linearLayout2 != null) {
                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                i = R.id.tv_error;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_error);
                                                if (textView != null) {
                                                    i = R.id.tv_loader;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_loader);
                                                    if (textView2 != null) {
                                                        i = R.id.tv_subscription_required;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subscription_required);
                                                        if (textView3 != null) {
                                                            i = R.id.videoLoader;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.videoLoader);
                                                            if (linearLayout3 != null) {
                                                                i = R.id.view_dim_subscription_required;
                                                                View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.view_dim_subscription_required);
                                                                if (viewFindChildViewById != null) {
                                                                    return new FragmentCameraStreamPreviewBinding(constraintLayout, imageView, appCompatButton, horizontalScrollView, linearLayout, zoomLayout, zoomLayout2, playerView, surfaceViewRenderer, imageView2, linearLayout2, constraintLayout, textView, textView2, textView3, linearLayout3, viewFindChildViewById);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
