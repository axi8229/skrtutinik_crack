package com.sputnik.service_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public final class ItemHistoryPaymentBinding implements ViewBinding {
    public final CardView cvPayment;
    public final ConstraintLayout layoutTop;
    private final CardView rootView;
    public final TextView tvAction;
    public final TextView tvPaymentTitle;
    public final TextView tvPrice;
    public final View vDivider;

    private ItemHistoryPaymentBinding(CardView cardView, CardView cardView2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = cardView;
        this.cvPayment = cardView2;
        this.layoutTop = constraintLayout;
        this.tvAction = textView;
        this.tvPaymentTitle = textView2;
        this.tvPrice = textView3;
        this.vDivider = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemHistoryPaymentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.item_history_payment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHistoryPaymentBinding bind(View view) {
        View viewFindChildViewById;
        CardView cardView = (CardView) view;
        int i = R$id.layout_top;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R$id.tv_action;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R$id.tv_payment_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R$id.tv_price;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.v_divider))) != null) {
                        return new ItemHistoryPaymentBinding(cardView, cardView, constraintLayout, textView, textView2, textView3, viewFindChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
