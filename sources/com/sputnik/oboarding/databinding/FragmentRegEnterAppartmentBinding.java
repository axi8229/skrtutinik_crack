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
public final class FragmentRegEnterAppartmentBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final CardView cardRv;
    public final EditText etEnterApartment;
    public final ImageView ivSuccess;
    public final ConstraintLayout rootView;
    private final NestedScrollView rootView_;
    public final TextView title;
    public final TextView tvAddress;
    public final TextView tvAddressTitle;
    public final TextView tvApartmentNumber;
    public final AppCompatButton tvChangeAddress;
    public final TextView tvNotice;
    public final TextView tvNumbers;

    private FragmentRegEnterAppartmentBinding(NestedScrollView nestedScrollView, AppCompatButton appCompatButton, CardView cardView, EditText editText, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, AppCompatButton appCompatButton2, TextView textView5, TextView textView6) {
        this.rootView_ = nestedScrollView;
        this.btnAccept = appCompatButton;
        this.cardRv = cardView;
        this.etEnterApartment = editText;
        this.ivSuccess = imageView;
        this.rootView = constraintLayout;
        this.title = textView;
        this.tvAddress = textView2;
        this.tvAddressTitle = textView3;
        this.tvApartmentNumber = textView4;
        this.tvChangeAddress = appCompatButton2;
        this.tvNotice = textView5;
        this.tvNumbers = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView_;
    }

    public static FragmentRegEnterAppartmentBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.card_rv;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView != null) {
                i = R$id.et_enter_apartment;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = R$id.iv_success;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.root_view;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R$id.title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R$id.tv_address;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R$id.tv_address_title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R$id.tv_apartment_number;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R$id.tv_change_address;
                                            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                                            if (appCompatButton2 != null) {
                                                i = R$id.tv_notice;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R$id.tv_numbers;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        return new FragmentRegEnterAppartmentBinding((NestedScrollView) view, appCompatButton, cardView, editText, imageView, constraintLayout, textView, textView2, textView3, textView4, appCompatButton2, textView5, textView6);
                                                    }
                                                }
                                            }
                                        }
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
