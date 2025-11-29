package com.sputnik.subscriptions.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.subscriptions.R$id;
import com.sputnik.subscriptions.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetAboutServiceBinding implements ViewBinding {
    public final AppCompatButton btnSubscribe;
    public final ImageView imageView8;
    public final ImageView imageView9;
    public final ConstraintLayout layoutBeta;
    private final ScrollView rootView;
    public final TextView tvBeta;
    public final TextView tvHeader;
    public final TextView tvTitle1;
    public final TextView tvTitle2;
    public final TextView tvTitle3;

    private BottomSheetAboutServiceBinding(ScrollView scrollView, AppCompatButton appCompatButton, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = scrollView;
        this.btnSubscribe = appCompatButton;
        this.imageView8 = imageView;
        this.imageView9 = imageView2;
        this.layoutBeta = constraintLayout;
        this.tvBeta = textView;
        this.tvHeader = textView2;
        this.tvTitle1 = textView3;
        this.tvTitle2 = textView4;
        this.tvTitle3 = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetAboutServiceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_about_service, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetAboutServiceBinding bind(View view) {
        int i = R$id.btn_subscribe;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.imageView8;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R$id.imageView9;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R$id.layout_beta;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R$id.tv_beta;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R$id.tv_header;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R$id.tv_title_1;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R$id.tv_title_2;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R$id.tv_title_3;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new BottomSheetAboutServiceBinding((ScrollView) view, appCompatButton, imageView, imageView2, constraintLayout, textView, textView2, textView3, textView4, textView5);
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
