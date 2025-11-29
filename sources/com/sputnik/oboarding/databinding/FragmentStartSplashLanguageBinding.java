package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentStartSplashLanguageBinding implements ViewBinding {
    public final CardView cardRv;
    public final ImageView ivDicLogo;
    public final ConstraintLayout rootView;
    private final ConstraintLayout rootView_;
    public final TextView title;
    public final TextSwitcher tvTitleSplash;

    private FragmentStartSplashLanguageBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextSwitcher textSwitcher) {
        this.rootView_ = constraintLayout;
        this.cardRv = cardView;
        this.ivDicLogo = imageView;
        this.rootView = constraintLayout2;
        this.title = textView;
        this.tvTitleSplash = textSwitcher;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }

    public static FragmentStartSplashLanguageBinding bind(View view) {
        int i = R$id.card_rv;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R$id.iv_dic_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R$id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.tv_title_splash;
                    TextSwitcher textSwitcher = (TextSwitcher) ViewBindings.findChildViewById(view, i);
                    if (textSwitcher != null) {
                        return new FragmentStartSplashLanguageBinding(constraintLayout, cardView, imageView, constraintLayout, textView, textSwitcher);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
