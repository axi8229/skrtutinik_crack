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
public final class FragmentRegCheckAddressBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final ImageView btnClose;
    public final CardView cardRv;
    public final ImageView ivAddress;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView title;
    public final TextView tvAddress;
    public final AppCompatButton tvNotMyAddress;

    private FragmentRegCheckAddressBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, ImageView imageView, CardView cardView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, AppCompatButton appCompatButton2) {
        this.rootView_ = nestedScrollView;
        this.btnAccept = appCompatButton;
        this.btnClose = imageView;
        this.cardRv = cardView;
        this.ivAddress = imageView2;
        this.rootView = constraintLayout;
        this.title = textView;
        this.tvAddress = textView2;
        this.tvNotMyAddress = appCompatButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegCheckAddressBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R$id.card_rv;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R$id.iv_address;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R$id.root_view;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R$id.title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R$id.tv_address;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R$id.tv_not_my_address;
                                    AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                    if (appCompatButton2 != null) {
                                        return new FragmentRegCheckAddressBinding((NestedScrollView) view, appCompatButton, imageView, cardView, imageView2, constraintLayout, textView, textView2, appCompatButton2);
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
