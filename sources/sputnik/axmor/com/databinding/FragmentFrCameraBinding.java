package sputnik.axmor.com.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.view.PreviewView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class FragmentFrCameraBinding implements ViewBinding {
    public final AppCompatButton btnRepeat;
    public final ImageView faceState;
    public final Guideline frGuideline;
    public final CardView frView;
    public final ImageView imageView3;
    public final ProgressBar progressFrStatus;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final Toolbar title;
    public final LinearLayout tvLayout;
    public final TextView tvScanAttention;
    public final TextView tvScanState;
    public final TextView tvScanning;
    public final PreviewView viewFinder;

    private FragmentFrCameraBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, ImageView imageView, Guideline guideline, CardView cardView, ImageView imageView2, ProgressBar progressBar, ScrollView scrollView, Toolbar toolbar, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, PreviewView previewView) {
        this.rootView = linearLayout;
        this.btnRepeat = appCompatButton;
        this.faceState = imageView;
        this.frGuideline = guideline;
        this.frView = cardView;
        this.imageView3 = imageView2;
        this.progressFrStatus = progressBar;
        this.scrollView = scrollView;
        this.title = toolbar;
        this.tvLayout = linearLayout2;
        this.tvScanAttention = textView;
        this.tvScanState = textView2;
        this.tvScanning = textView3;
        this.viewFinder = previewView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFrCameraBinding bind(View view) {
        int i = R.id.btn_repeat;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_repeat);
        if (appCompatButton != null) {
            i = R.id.face_state;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.face_state);
            if (imageView != null) {
                i = R.id.fr_guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.fr_guideline);
                if (guideline != null) {
                    i = R.id.fr_view;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.fr_view);
                    if (cardView != null) {
                        i = R.id.imageView3;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView3);
                        if (imageView2 != null) {
                            i = R.id.progress_fr_status;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_fr_status);
                            if (progressBar != null) {
                                i = R.id.scroll_view;
                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                if (scrollView != null) {
                                    i = R.id.title;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.title);
                                    if (toolbar != null) {
                                        i = R.id.tv_layout;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.tv_layout);
                                        if (linearLayout != null) {
                                            i = R.id.tv_scan_attention;
                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_scan_attention);
                                            if (textView != null) {
                                                i = R.id.tv_scan_state;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_scan_state);
                                                if (textView2 != null) {
                                                    i = R.id.tv_scanning;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_scanning);
                                                    if (textView3 != null) {
                                                        i = R.id.view_finder;
                                                        PreviewView previewView = (PreviewView) ViewBindings.findChildViewById(view, R.id.view_finder);
                                                        if (previewView != null) {
                                                            return new FragmentFrCameraBinding((LinearLayout) view, appCompatButton, imageView, guideline, cardView, imageView2, progressBar, scrollView, toolbar, linearLayout, textView, textView2, textView3, previewView);
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
