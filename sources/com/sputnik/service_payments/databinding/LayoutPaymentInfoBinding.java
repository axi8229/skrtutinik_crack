package com.sputnik.service_payments.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;

/* loaded from: classes3.dex */
public final class LayoutPaymentInfoBinding implements ViewBinding {
    public final LinearLayout accountLayout;
    public final LinearLayout dateLayout;
    public final ConstraintLayout lInfoPrice;
    public final LinearLayout priceLayout;
    private final ConstraintLayout rootView;
    public final TextView tvAccountTitle;
    public final TextView tvAccountValue;
    public final TextView tvDateTitle;
    public final TextView tvDateValue;
    public final TextView tvPriceTitle;
    public final TextView tvPriceValue;
    public final TextView tvTitle;

    private LayoutPaymentInfoBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.accountLayout = linearLayout;
        this.dateLayout = linearLayout2;
        this.lInfoPrice = constraintLayout2;
        this.priceLayout = linearLayout3;
        this.tvAccountTitle = textView;
        this.tvAccountValue = textView2;
        this.tvDateTitle = textView3;
        this.tvDateValue = textView4;
        this.tvPriceTitle = textView5;
        this.tvPriceValue = textView6;
        this.tvTitle = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPaymentInfoBinding bind(View view) {
        int i = R$id.account_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R$id.date_layout;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R$id.price_layout;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R$id.tv_account_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R$id.tv_account_value;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R$id.tv_date_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R$id.tv_date_value;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R$id.tv_price_title;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R$id.tv_price_value;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView6 != null) {
                                            i = R$id.tv_title;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView7 != null) {
                                                return new LayoutPaymentInfoBinding(constraintLayout, linearLayout, linearLayout2, constraintLayout, linearLayout3, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
