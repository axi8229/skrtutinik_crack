package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetSetupRssiBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnCancel;
    public final ImageView imageView3;
    public final ImageView ivStatus;
    public final ConstraintLayout layoutDetermining;
    public final ConstraintLayout layoutStatus;
    public final ProgressBar progress;
    private final LinearLayout rootView;
    public final TextView tvDeterminingTitle;
    public final TextView tvSeconds;
    public final TextView tvStatus;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private BottomSheetSetupRssiBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.btnCancel = appCompatButton2;
        this.imageView3 = imageView;
        this.ivStatus = imageView2;
        this.layoutDetermining = constraintLayout;
        this.layoutStatus = constraintLayout2;
        this.progress = progressBar;
        this.tvDeterminingTitle = textView;
        this.tvSeconds = textView2;
        this.tvStatus = textView3;
        this.tvSubtitle = textView4;
        this.tvTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetSetupRssiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_setup_rssi, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetSetupRssiBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.btn_cancel;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_cancel);
            if (appCompatButton2 != null) {
                i = R.id.imageView3;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView3);
                if (imageView != null) {
                    i = R.id.iv_status;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_status);
                    if (imageView2 != null) {
                        i = R.id.layout_determining;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_determining);
                        if (constraintLayout != null) {
                            i = R.id.layout_status;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.layout_status);
                            if (constraintLayout2 != null) {
                                i = R.id.progress;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress);
                                if (progressBar != null) {
                                    i = R.id.tv_determining_title;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_determining_title);
                                    if (textView != null) {
                                        i = R.id.tv_seconds;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_seconds);
                                        if (textView2 != null) {
                                            i = R.id.tv_status;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_status);
                                            if (textView3 != null) {
                                                i = R.id.tv_subtitle;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_subtitle);
                                                if (textView4 != null) {
                                                    i = R.id.tv_title;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                                    if (textView5 != null) {
                                                        return new BottomSheetSetupRssiBinding((LinearLayout) view, appCompatButton, appCompatButton2, imageView, imageView2, constraintLayout, constraintLayout2, progressBar, textView, textView2, textView3, textView4, textView5);
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
