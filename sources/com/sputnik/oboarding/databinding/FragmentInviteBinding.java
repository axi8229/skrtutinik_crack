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
public final class FragmentInviteBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final AppCompatButton btnReject;
    public final CardView cardRv;
    public final ImageView ivEnterPhone;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvAddress;
    public final TextView tvNotice;
    public final TextView tvTitle;

    private FragmentInviteBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, CardView cardView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView_ = nestedScrollView;
        this.btnAccept = appCompatButton;
        this.btnReject = appCompatButton2;
        this.cardRv = cardView;
        this.ivEnterPhone = imageView;
        this.rootView = constraintLayout;
        this.tvAddress = textView;
        this.tvNotice = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentInviteBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_reject;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.card_rv;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R$id.iv_enter_phone;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.root_view;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R$id.tv_address;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R$id.tv_notice;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R$id.tv_title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new FragmentInviteBinding((NestedScrollView) view, appCompatButton, appCompatButton2, cardView, imageView, constraintLayout, textView, textView2, textView3);
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
