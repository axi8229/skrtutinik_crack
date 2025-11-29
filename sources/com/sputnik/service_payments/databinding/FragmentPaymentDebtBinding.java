package com.sputnik.service_payments.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;

/* loaded from: classes3.dex */
public final class FragmentPaymentDebtBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final CheckBox chAccessCode;
    public final CheckBox chRegularPayment;
    public final ConstraintLayout constraintLayout;
    public final View divider;
    public final Group grAccessCode;
    public final ImageView ivBlock;
    private final ConstraintLayout rootView;
    public final Toolbar toolbar;
    public final TextView tvAccessCode;
    public final TextView tvAccessCodeDesc;
    public final TextView tvNotice;
    public final TextView tvRegularPayment;
    public final TextView tvRegularPaymentDesc;
    public final TextView tvSum;
    public final TextView tvSumTitle;

    private FragmentPaymentDebtBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, CheckBox checkBox, CheckBox checkBox2, ConstraintLayout constraintLayout2, View view, Group group, ImageView imageView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.btnApply = appCompatButton;
        this.chAccessCode = checkBox;
        this.chRegularPayment = checkBox2;
        this.constraintLayout = constraintLayout2;
        this.divider = view;
        this.grAccessCode = group;
        this.ivBlock = imageView;
        this.toolbar = toolbar;
        this.tvAccessCode = textView;
        this.tvAccessCodeDesc = textView2;
        this.tvNotice = textView3;
        this.tvRegularPayment = textView4;
        this.tvRegularPaymentDesc = textView5;
        this.tvSum = textView6;
        this.tvSumTitle = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPaymentDebtBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.ch_access_code;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
            if (checkBox != null) {
                i = R$id.ch_regular_payment;
                CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, i);
                if (checkBox2 != null) {
                    i = R$id.constraintLayout;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.divider))) != null) {
                        i = R$id.gr_access_code;
                        Group group = (Group) ViewBindings.findChildViewById(view, i);
                        if (group != null) {
                            i = R$id.iv_block;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R$id.toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                if (toolbar != null) {
                                    i = R$id.tv_access_code;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R$id.tv_access_code_desc;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R$id.tv_notice;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R$id.tv_regular_payment;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    i = R$id.tv_regular_payment_desc;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView5 != null) {
                                                        i = R$id.tv_sum;
                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView6 != null) {
                                                            i = R$id.tv_sum_title;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView7 != null) {
                                                                return new FragmentPaymentDebtBinding((ConstraintLayout) view, appCompatButton, checkBox, checkBox2, constraintLayout, viewFindChildViewById, group, imageView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
