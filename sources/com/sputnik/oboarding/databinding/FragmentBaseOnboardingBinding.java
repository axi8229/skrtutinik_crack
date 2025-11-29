package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentBaseOnboardingBinding implements ViewBinding {
    public final AppCompatButton btnBlueAction;
    public final AppCompatButton btnRedAction;
    public final TextView btnShare;
    public final ImageView ivClose;
    public final ImageView ivOnboarding;
    public final TextView notice;
    private final ConstraintLayout rootView;
    public final TextView title;

    private FragmentBaseOnboardingBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnBlueAction = appCompatButton;
        this.btnRedAction = appCompatButton2;
        this.btnShare = textView;
        this.ivClose = imageView;
        this.ivOnboarding = imageView2;
        this.notice = textView2;
        this.title = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBaseOnboardingBinding bind(View view) {
        int i = R$id.btn_blue_action;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_red_action;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.btn_share;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.iv_close;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.iv_onboarding;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R$id.notice;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R$id.title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new FragmentBaseOnboardingBinding((ConstraintLayout) view, appCompatButton, appCompatButton2, textView, imageView, imageView2, textView2, textView3);
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
