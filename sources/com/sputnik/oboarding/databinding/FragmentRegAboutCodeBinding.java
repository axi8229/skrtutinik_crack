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
public final class FragmentRegAboutCodeBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final CardView cardRv;
    public final ImageView ivEnterPhone;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvAboutCode;
    public final TextView tvAboutCodeInfo;

    private FragmentRegAboutCodeBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, CardView cardView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView_ = nestedScrollView;
        this.btnAccept = appCompatButton;
        this.cardRv = cardView;
        this.ivEnterPhone = imageView;
        this.rootView = constraintLayout;
        this.tvAboutCode = textView;
        this.tvAboutCodeInfo = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegAboutCodeBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.iv_enter_phone;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R$id.root_view;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null) {
                        i = R$id.tv_about_code;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R$id.tv_about_code_info;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new FragmentRegAboutCodeBinding((NestedScrollView) view, appCompatButton, cardView, imageView, constraintLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
