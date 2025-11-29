package com.sputnik.service_payments.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;

/* loaded from: classes3.dex */
public final class FragmentPromiseBlockBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnReject;
    public final ImageView ivBlock;
    public final LinearLayout layoutLoader;
    public final ConstraintLayout layoutMain;
    public final ProgressBar pbLoaderMain;
    private final ScrollView rootView;
    public final TextView tvAction;
    public final TextView tvDescription;
    public final TextView tvOffer;
    public final TextView tvPartnerName;
    public final TextView tvPartnerTitle;
    public final TextView tvPrice;
    public final View vDivider;
    public final ScrollView viewMain;

    private FragmentPromiseBlockBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view, ScrollView scrollView2) {
        this.rootView = scrollView;
        this.btnApply = appCompatButton;
        this.btnReject = appCompatButton2;
        this.ivBlock = imageView;
        this.layoutLoader = linearLayout;
        this.layoutMain = constraintLayout;
        this.pbLoaderMain = progressBar;
        this.tvAction = textView;
        this.tvDescription = textView2;
        this.tvOffer = textView3;
        this.tvPartnerName = textView4;
        this.tvPartnerTitle = textView5;
        this.tvPrice = textView6;
        this.vDivider = view;
        this.viewMain = scrollView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentPromiseBlockBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_reject;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.iv_block;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R$id.layout_loader;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R$id.layout_main;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R$id.pb_loader_main;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = R$id.tv_action;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R$id.tv_description;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R$id.tv_offer;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R$id.tv_partner_name;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R$id.tv_partner_title;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R$id.tv_price;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.v_divider))) != null) {
                                                        ScrollView scrollView = (ScrollView) view;
                                                        return new FragmentPromiseBlockBinding(scrollView, appCompatButton, appCompatButton2, imageView, linearLayout, constraintLayout, progressBar, textView, textView2, textView3, textView4, textView5, textView6, viewFindChildViewById, scrollView);
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
