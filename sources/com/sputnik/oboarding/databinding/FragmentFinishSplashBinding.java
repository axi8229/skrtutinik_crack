package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentFinishSplashBinding implements ViewBinding {
    public final ImageView ivLogo;
    public final LinearLayout linearLayout4;
    private final ConstraintLayout rootView;
    public final TextView title;

    private FragmentFinishSplashBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.ivLogo = imageView;
        this.linearLayout4 = linearLayout;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFinishSplashBinding bind(View view) {
        int i = R$id.iv_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.linearLayout4;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R$id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new FragmentFinishSplashBinding((ConstraintLayout) view, imageView, linearLayout, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
