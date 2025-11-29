package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentNeedHelpBinding implements ViewBinding {
    public final AppCompatButton btnResendCode;
    public final TextView btnSupport;
    public final CardView cardRv;
    public final ImageView imageView5;
    public final ProgressBar pbRequestSms;
    public final FrameLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvTitle;

    private FragmentNeedHelpBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, TextView textView, CardView cardView, ImageView imageView, ProgressBar progressBar, FrameLayout frameLayout, TextView textView2) {
        this.rootView_ = nestedScrollView;
        this.btnResendCode = appCompatButton;
        this.btnSupport = textView;
        this.cardRv = cardView;
        this.imageView5 = imageView;
        this.pbRequestSms = progressBar;
        this.rootView = frameLayout;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentNeedHelpBinding bind(View view) {
        int i = R$id.btn_resend_code;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_support;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R$id.card_rv;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R$id.imageView5;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.pb_request_sms;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R$id.root_view;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R$id.tv_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new FragmentNeedHelpBinding((NestedScrollView) view, appCompatButton, textView, cardView, imageView, progressBar, frameLayout, textView2);
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
