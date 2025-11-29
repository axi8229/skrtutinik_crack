package com.sputnik.service_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public final class FragmentBlockingDebtBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnReject;
    public final CardView cvPayment;
    public final ImageView ivBlock;
    public final ImageView ivClose;
    public final ImageView ivPaymentSettings;
    private final ScrollView rootView;
    public final TextView tvAction;
    public final TextView tvNotice;
    public final TextView tvOffer;
    public final TextView tvPartnerName;
    public final TextView tvPartnerTitle;
    public final TextView tvPaymentTitle;
    public final TextView tvPrice;
    public final View vDivider;

    private FragmentBlockingDebtBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, CardView cardView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view) {
        this.rootView = scrollView;
        this.btnApply = appCompatButton;
        this.btnReject = appCompatButton2;
        this.cvPayment = cardView;
        this.ivBlock = imageView;
        this.ivClose = imageView2;
        this.ivPaymentSettings = imageView3;
        this.tvAction = textView;
        this.tvNotice = textView2;
        this.tvOffer = textView3;
        this.tvPartnerName = textView4;
        this.tvPartnerTitle = textView5;
        this.tvPaymentTitle = textView6;
        this.tvPrice = textView7;
        this.vDivider = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentBlockingDebtBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_blocking_debt, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBlockingDebtBinding bind(View view) {
        View viewFindChildViewById;
        int i = R$id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_reject;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.cv_payment;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R$id.iv_block;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.iv_close;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R$id.iv_payment_settings;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R$id.tv_action;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R$id.tv_notice;
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
                                                    i = R$id.tv_payment_title;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R$id.tv_price;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.v_divider))) != null) {
                                                            return new FragmentBlockingDebtBinding((ScrollView) view, appCompatButton, appCompatButton2, cardView, imageView, imageView2, imageView3, textView, textView2, textView3, textView4, textView5, textView6, textView7, viewFindChildViewById);
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
