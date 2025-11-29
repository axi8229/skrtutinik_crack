package sputnik.axmor.com.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import sputnik.axmor.com.R;

/* loaded from: classes5.dex */
public final class BottomSheetAboutBetaProgramBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnCancel;
    public final ConstraintLayout constraintLayout2;
    public final ConstraintLayout constraintLayout3;
    public final ImageView imageView2;
    public final ScrollView layoutContent;
    private final LinearLayout rootView;
    public final TextView tvAttention;
    public final TextView tvTellUs;
    public final TextView tvTitle;

    private BottomSheetAboutBetaProgramBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.btnCancel = appCompatButton2;
        this.constraintLayout2 = constraintLayout;
        this.constraintLayout3 = constraintLayout2;
        this.imageView2 = imageView;
        this.layoutContent = scrollView;
        this.tvAttention = textView;
        this.tvTellUs = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetAboutBetaProgramBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.bottom_sheet_about_beta_program, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetAboutBetaProgramBinding bind(View view) {
        int i = R.id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btnApply);
        if (appCompatButton != null) {
            i = R.id.btn_cancel;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.btn_cancel);
            if (appCompatButton2 != null) {
                i = R.id.constraintLayout2;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout2);
                if (constraintLayout != null) {
                    i = R.id.constraintLayout3;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.constraintLayout3);
                    if (constraintLayout2 != null) {
                        i = R.id.imageView2;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView2);
                        if (imageView != null) {
                            i = R.id.layout_content;
                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.layout_content);
                            if (scrollView != null) {
                                i = R.id.tv_attention;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_attention);
                                if (textView != null) {
                                    i = R.id.tv_tell_us;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_tell_us);
                                    if (textView2 != null) {
                                        i = R.id.tv_title;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                                        if (textView3 != null) {
                                            return new BottomSheetAboutBetaProgramBinding((LinearLayout) view, appCompatButton, appCompatButton2, constraintLayout, constraintLayout2, imageView, scrollView, textView, textView2, textView3);
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
