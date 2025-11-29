package com.sputnik.oboarding.databinding;

import android.view.View;
import android.widget.EditText;
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
public final class FragmentRegRegistrationBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final CardView cardRv;
    public final EditText etName;
    public final ImageView ivEnterPhone;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView tvNotice;
    public final TextView tvTitle;
    public final TextView tvTitleName;

    private FragmentRegRegistrationBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, CardView cardView, EditText editText, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView_ = nestedScrollView;
        this.btnAccept = appCompatButton;
        this.cardRv = cardView;
        this.etName = editText;
        this.ivEnterPhone = imageView;
        this.rootView = constraintLayout;
        this.tvNotice = textView;
        this.tvTitle = textView2;
        this.tvTitleName = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegRegistrationBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.et_name;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R$id.iv_enter_phone;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.root_view;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R$id.tv_notice;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R$id.tv_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R$id.tv_title_name;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        return new FragmentRegRegistrationBinding((NestedScrollView) view, appCompatButton, cardView, editText, imageView, constraintLayout, textView, textView2, textView3);
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
