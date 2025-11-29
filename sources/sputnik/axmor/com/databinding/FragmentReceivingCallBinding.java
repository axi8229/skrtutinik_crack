package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public final class FragmentReceivingCallBinding implements ViewBinding {
    public final ImageView acceptCallBtn;
    public final ImageView declineCallBtn;
    public final ZoomLayout layoutZoom;
    public final ZoomLayout layoutZoom2;
    public final PlayerView playerExo;
    public final SurfaceViewRenderer playerWebrtc;
    private final ConstraintLayout rootView;
    public final OpenDoorButtonView secondaryOpenDoorBtn;
    public final TextView tvLoader;
    public final TextView tvTitleCall;
    public final LinearLayout videoLoader;

    private FragmentReceivingCallBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ZoomLayout zoomLayout, ZoomLayout zoomLayout2, PlayerView playerView, SurfaceViewRenderer surfaceViewRenderer, OpenDoorButtonView openDoorButtonView, TextView textView, TextView textView2, LinearLayout linearLayout) {
        this.rootView = constraintLayout;
        this.acceptCallBtn = imageView;
        this.declineCallBtn = imageView2;
        this.layoutZoom = zoomLayout;
        this.layoutZoom2 = zoomLayout2;
        this.playerExo = playerView;
        this.playerWebrtc = surfaceViewRenderer;
        this.secondaryOpenDoorBtn = openDoorButtonView;
        this.tvLoader = textView;
        this.tvTitleCall = textView2;
        this.videoLoader = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentReceivingCallBinding bind(View view) {
        int i = R.id.acceptCallBtn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.acceptCallBtn);
        if (imageView != null) {
            i = R.id.declineCallBtn;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.declineCallBtn);
            if (imageView2 != null) {
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
                                i = R.id.secondaryOpenDoorBtn;
                                OpenDoorButtonView openDoorButtonView = (OpenDoorButtonView) ViewBindings.findChildViewById(view, R.id.secondaryOpenDoorBtn);
                                if (openDoorButtonView != null) {
                                    i = R.id.tv_loader;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_loader);
                                    if (textView != null) {
                                        i = R.id.tvTitleCall;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvTitleCall);
                                        if (textView2 != null) {
                                            i = R.id.videoLoader;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.videoLoader);
                                            if (linearLayout != null) {
                                                return new FragmentReceivingCallBinding((ConstraintLayout) view, imageView, imageView2, zoomLayout, zoomLayout2, playerView, surfaceViewRenderer, openDoorButtonView, textView, textView2, linearLayout);
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
