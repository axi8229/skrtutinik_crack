package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;

/* loaded from: classes3.dex */
public final class FragmentStartRegistrationBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final ImageView btnClose;
    public final AppCompatButton btnHasAccount;
    public final CardView card3;
    public final ImageView ivConnect1;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView title;
    public final TextView tvInfo;

    private FragmentStartRegistrationBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, ImageView imageView, AppCompatButton appCompatButton2, CardView cardView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView_ = nestedScrollView;
        this.btnAccept = appCompatButton;
        this.btnClose = imageView;
        this.btnHasAccount = appCompatButton2;
        this.card3 = cardView;
        this.ivConnect1 = imageView2;
        this.rootView = constraintLayout;
        this.title = textView;
        this.tvInfo = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentStartRegistrationBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R$id.btn_has_account;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                if (appCompatButton2 != null) {
                    i = R$id.card_3;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView != null) {
                        i = R$id.ivConnect1;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R$id.root_view;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout != null) {
                                i = R$id.title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R$id.tv_info;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        return new FragmentStartRegistrationBinding((NestedScrollView) view, appCompatButton, imageView, appCompatButton2, cardView, imageView2, constraintLayout, textView, textView2);
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
