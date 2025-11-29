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
public final class FragmentRegSmtWrongBinding implements ViewBinding {
    public final AppCompatButton btnChangeApartmentNumber;
    public final CardView cardRv;
    public final ImageView ivError;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView title;
    public final TextView tvApartmentNotFound;
    public final TextView tvError;
    public final AppCompatButton tvSupport;

    private FragmentRegSmtWrongBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, CardView cardView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, AppCompatButton appCompatButton2) {
        this.rootView_ = nestedScrollView;
        this.btnChangeApartmentNumber = appCompatButton;
        this.cardRv = cardView;
        this.ivError = imageView;
        this.rootView = constraintLayout;
        this.title = textView;
        this.tvApartmentNotFound = textView2;
        this.tvError = textView3;
        this.tvSupport = appCompatButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegSmtWrongBinding bind(View view) {
        int i = R$id.btn_change_apartment_number;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.iv_error;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R$id.root_view;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R$id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R$id.tv_apartment_not_found;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R$id.tv_error;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R$id.tv_support;
                                    AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                    if (appCompatButton2 != null) {
                                        return new FragmentRegSmtWrongBinding((NestedScrollView) view, appCompatButton, cardView, imageView, constraintLayout, textView, textView2, textView3, appCompatButton2);
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
