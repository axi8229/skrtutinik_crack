package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.exoplayer2.ui.PlayerView;
import com.shopgun.android.zoomlayout.ZoomLayout;
import com.sputnik.common.ui.view.ToggleStateButton;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class GlobalCameraFragmentBinding implements ViewBinding {
    public final ToggleStateButton btnCameraSettings;
    public final ToggleStateButton btnReport;
    public final AppCompatButton btnSubscribe;
    public final Guideline guideline2;
    public final View guideline3;
    public final HorizontalScrollView hsPreview;
    public final LinearLayout layoutCameraLocked;
    public final ZoomLayout layoutZoom;
    public final ZoomLayout layoutZoom2;
    public final ImageView playButton;
    public final PlayerView playerExo;
    public final SurfaceViewRenderer playerWebrtc;
    public final ImageView preview;
    public final LinearLayout previewError;
    public final ConstraintLayout root;
    private final ConstraintLayout rootView;
    public final TextView tvCompanyContactsInfo;
    public final TextView tvError;
    public final TextView tvErrorSubtitle;
    public final TextView tvLoader;
    public final TextView tvSubscriptionRequired;
    public final LinearLayout videoLoader;
    public final View viewDimSubscriptionRequired;

    private GlobalCameraFragmentBinding(ConstraintLayout constraintLayout, ToggleStateButton toggleStateButton, ToggleStateButton toggleStateButton2, AppCompatButton appCompatButton, Guideline guideline, View view, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout, ZoomLayout zoomLayout, ZoomLayout zoomLayout2, ImageView imageView, PlayerView playerView, SurfaceViewRenderer surfaceViewRenderer, ImageView imageView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout3, View view2) {
        this.rootView = constraintLayout;
        this.btnCameraSettings = toggleStateButton;
        this.btnReport = toggleStateButton2;
        this.btnSubscribe = appCompatButton;
        this.guideline2 = guideline;
        this.guideline3 = view;
        this.hsPreview = horizontalScrollView;
        this.layoutCameraLocked = linearLayout;
        this.layoutZoom = zoomLayout;
        this.layoutZoom2 = zoomLayout2;
        this.playButton = imageView;
        this.playerExo = playerView;
        this.playerWebrtc = surfaceViewRenderer;
        this.preview = imageView2;
        this.previewError = linearLayout2;
        this.root = constraintLayout2;
        this.tvCompanyContactsInfo = textView;
        this.tvError = textView2;
        this.tvErrorSubtitle = textView3;
        this.tvLoader = textView4;
        this.tvSubscriptionRequired = textView5;
        this.videoLoader = linearLayout3;
        this.viewDimSubscriptionRequired = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GlobalCameraFragmentBinding bind(View view) {
        ToggleStateButton toggleStateButton = (ToggleStateButton) ViewBindings.findChildViewById(view, R.id.btn_camera_settings);
        ToggleStateButton toggleStateButton2 = (ToggleStateButton) ViewBindings.findChildViewById(view, R.id.btn_report);
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_subscribe);
        int i = R.id.guideline2;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline2);
        if (guideline != null) {
            i = R.id.guideline3;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, R.id.guideline3);
            if (viewFindChildViewById != null) {
                i = R.id.hs_preview;
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.hs_preview);
                if (horizontalScrollView != null) {
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layout_camera_locked);
                    i = R.id.layout_zoom;
                    ZoomLayout zoomLayout = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom);
                    if (zoomLayout != null) {
                        i = R.id.layout_zoom2;
                        ZoomLayout zoomLayout2 = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom2);
                        if (zoomLayout2 != null) {
                            i = R.id.playButton;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.playButton);
                            if (imageView != null) {
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
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_company_contacts_info);
                                                i = R.id.tv_error;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_error);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_error_subtitle);
                                                    i = R.id.tv_loader;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_loader);
                                                    if (textView4 != null) {
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subscription_required);
                                                        i = R.id.videoLoader;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.videoLoader);
                                                        if (linearLayout3 != null) {
                                                            return new GlobalCameraFragmentBinding(constraintLayout, toggleStateButton, toggleStateButton2, appCompatButton, guideline, viewFindChildViewById, horizontalScrollView, linearLayout, zoomLayout, zoomLayout2, imageView, playerView, surfaceViewRenderer, imageView2, linearLayout2, constraintLayout, textView, textView2, textView3, textView4, textView5, linearLayout3, ViewBindings.findChildViewById(view, R.id.view_dim_subscription_required));
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
