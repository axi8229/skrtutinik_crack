package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.exoplayer2.ui.PlayerView;
import com.shopgun.android.zoomlayout.ZoomLayout;
import org.webrtc.SurfaceViewRenderer;
import sputnik.axmor.com.R;
import sputnik.axmor.com.sputnik.ui.views.OpenDoorButtonView;

/* loaded from: classes5.dex */
public final class FragmentAnswerCallBinding implements ViewBinding {
    public final ImageView declineCallBtn;
    public final ZoomLayout layoutZoom;
    public final ZoomLayout layoutZoom2;
    public final ProgressBar loaderSip;
    public final PlayerView playerExo;
    public final SurfaceViewRenderer playerWebrtc;
    private final ConstraintLayout rootView;
    public final OpenDoorButtonView secondaryOpenDoorBtn;
    public final TextView tvLoading;
    public final LinearLayout videoLoader;

    private FragmentAnswerCallBinding(ConstraintLayout constraintLayout, ImageView imageView, ZoomLayout zoomLayout, ZoomLayout zoomLayout2, ProgressBar progressBar, PlayerView playerView, SurfaceViewRenderer surfaceViewRenderer, OpenDoorButtonView openDoorButtonView, TextView textView, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.declineCallBtn = imageView;
        this.layoutZoom = zoomLayout;
        this.layoutZoom2 = zoomLayout2;
        this.loaderSip = progressBar;
        this.playerExo = playerView;
        this.playerWebrtc = surfaceViewRenderer;
        this.secondaryOpenDoorBtn = openDoorButtonView;
        this.tvLoading = textView;
        this.videoLoader = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAnswerCallBinding bind(View view) {
        int i = R.id.declineCallBtn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.declineCallBtn);
        if (imageView != null) {
            i = R.id.layout_zoom;
            ZoomLayout zoomLayout = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom);
            if (zoomLayout != null) {
                i = R.id.layout_zoom2;
                ZoomLayout zoomLayout2 = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom2);
                if (zoomLayout2 != null) {
                    i = R.id.loader_sip;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.loader_sip);
                    if (progressBar != null) {
                        i = R.id.player_exo;
                        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, R.id.player_exo);
                        if (playerView != null) {
                            i = R.id.player_webrtc;
                            SurfaceViewRenderer surfaceViewRenderer = (SurfaceViewRenderer) ViewBindings.findChildViewById(view, R.id.player_webrtc);
                            if (surfaceViewRenderer != null) {
                                i = R.id.secondaryOpenDoorBtn;
                                OpenDoorButtonView openDoorButtonView = (OpenDoorButtonView) ViewBindings.findChildViewById(view, R.id.secondaryOpenDoorBtn);
                                if (openDoorButtonView != null) {
                                    i = R.id.tv_loading;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_loading);
                                    if (textView != null) {
                                        i = R.id.videoLoader;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.videoLoader);
                                        if (linearLayout != null) {
                                            return new FragmentAnswerCallBinding((ConstraintLayout) view, imageView, zoomLayout, zoomLayout2, progressBar, playerView, surfaceViewRenderer, openDoorButtonView, textView, linearLayout);
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
