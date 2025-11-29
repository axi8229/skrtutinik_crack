package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.shopgun.android.zoomlayout.ZoomLayout;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentVisitDetailsBinding implements ViewBinding {
    public final LinearLayout errorLayout;
    public final ImageView errorPicture;
    public final ImageView ivCallDeclined;
    public final ConstraintLayout layoutPicture;
    public final ZoomLayout layoutZoom;
    public final ZoomLayout layoutZoomVideo;
    public final ProgressBar pbVisits;
    public final ImageView picture;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvError;
    public final VideoView videoView;
    public final TextView visitorDetailDate;
    public final TextView visitorDetailTime;

    private FragmentVisitDetailsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ZoomLayout zoomLayout, ZoomLayout zoomLayout2, ProgressBar progressBar, ImageView imageView3, Toolbar toolbar, TextView textView, VideoView videoView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.errorLayout = linearLayout;
        this.errorPicture = imageView;
        this.ivCallDeclined = imageView2;
        this.layoutPicture = constraintLayout2;
        this.layoutZoom = zoomLayout;
        this.layoutZoomVideo = zoomLayout2;
        this.pbVisits = progressBar;
        this.picture = imageView3;
        this.toolbar = toolbar;
        this.tvError = textView;
        this.videoView = videoView;
        this.visitorDetailDate = textView2;
        this.visitorDetailTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVisitDetailsBinding bind(View view) {
        int i = R.id.error_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.error_layout);
        if (linearLayout != null) {
            i = R.id.error_picture;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.error_picture);
            if (imageView != null) {
                i = R.id.iv_call_declined;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_call_declined);
                if (imageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.layout_zoom;
                    ZoomLayout zoomLayout = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom);
                    if (zoomLayout != null) {
                        i = R.id.layout_zoom_video;
                        ZoomLayout zoomLayout2 = (ZoomLayout) ViewBindings.findChildViewById(view, R.id.layout_zoom_video);
                        if (zoomLayout2 != null) {
                            i = R.id.pb_visits;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pb_visits);
                            if (progressBar != null) {
                                i = R.id.picture;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.picture);
                                if (imageView3 != null) {
                                    i = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar != null) {
                                        i = R.id.tv_error;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_error);
                                        if (textView != null) {
                                            i = R.id.videoView;
                                            VideoView videoView = (VideoView) ViewBindings.findChildViewById(view, R.id.videoView);
                                            if (videoView != null) {
                                                i = R.id.visitor_detail_date;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.visitor_detail_date);
                                                if (textView2 != null) {
                                                    i = R.id.visitor_detail_time;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.visitor_detail_time);
                                                    if (textView3 != null) {
                                                        return new FragmentVisitDetailsBinding(constraintLayout, linearLayout, imageView, imageView2, constraintLayout, zoomLayout, zoomLayout2, progressBar, imageView3, toolbar, textView, videoView, textView2, textView3);
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
