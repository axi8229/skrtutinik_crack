package com.sputnik.service_payments.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;

/* loaded from: classes3.dex */
public final class FragmentIntercomPaymentBinding implements ViewBinding {
    public final ImageButton btnAboutPayments;
    public final ImageButton btnBack;
    public final CardView cvDebtPayment;
    public final CardView cvPayment;
    public final ImageView ivDebtPaymentSettings;
    public final ImageView ivPaymentSettings;
    public final ConstraintLayout layoutPayment;
    public final NestedScrollView layoutScroll;
    public final ProgressBar pbLoader;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPaymentsHistory;
    public final Toolbar toolbar;
    public final TextView tvAction;
    public final TextView tvDebtAction;
    public final TextView tvDebtPaymentTitle;
    public final TextView tvDebtPrice;
    public final TextView tvOffer;
    public final TextView tvPaymentTitle;
    public final TextView tvPaymentsHistory;
    public final TextView tvPrice;
    public final TextView tvToolbarTitle;
    public final TextView tvTopTitle;
    public final View vDebtDivider;
    public final View vDivider;
    public final ConstraintLayout viewMain;

    private FragmentIntercomPaymentBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, CardView cardView, CardView cardView2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, NestedScrollView nestedScrollView, ProgressBar progressBar, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view, View view2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.btnAboutPayments = imageButton;
        this.btnBack = imageButton2;
        this.cvDebtPayment = cardView;
        this.cvPayment = cardView2;
        this.ivDebtPaymentSettings = imageView;
        this.ivPaymentSettings = imageView2;
        this.layoutPayment = constraintLayout2;
        this.layoutScroll = nestedScrollView;
        this.pbLoader = progressBar;
        this.rvPaymentsHistory = recyclerView;
        this.toolbar = toolbar;
        this.tvAction = textView;
        this.tvDebtAction = textView2;
        this.tvDebtPaymentTitle = textView3;
        this.tvDebtPrice = textView4;
        this.tvOffer = textView5;
        this.tvPaymentTitle = textView6;
        this.tvPaymentsHistory = textView7;
        this.tvPrice = textView8;
        this.tvToolbarTitle = textView9;
        this.tvTopTitle = textView10;
        this.vDebtDivider = view;
        this.vDivider = view2;
        this.viewMain = constraintLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentIntercomPaymentBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R$id.btn_about_payments;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R$id.btn_back;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton2 != null) {
                i = R$id.cv_debt_payment;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView != null) {
                    i = R$id.cv_payment;
                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView2 != null) {
                        i = R$id.iv_debt_payment_settings;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R$id.iv_payment_settings;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R$id.layout_payment;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout != null) {
                                    i = R$id.layout_scroll;
                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                    if (nestedScrollView != null) {
                                        i = R$id.pb_loader;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar != null) {
                                            i = R$id.rv_payments_history;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                            if (recyclerView != null) {
                                                i = R$id.toolbar;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                                                if (toolbar != null) {
                                                    i = R$id.tv_action;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        i = R$id.tv_debt_action;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R$id.tv_debt_payment_title;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null) {
                                                                i = R$id.tv_debt_price;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    i = R$id.tv_offer;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R$id.tv_payment_title;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R$id.tv_payments_history;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView7 != null) {
                                                                                i = R$id.tv_price;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView8 != null) {
                                                                                    i = R$id.tv_toolbar_title;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView9 != null) {
                                                                                        i = R$id.tv_top_title;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView10 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R$id.v_debt_divider))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R$id.v_divider))) != null) {
                                                                                            i = R$id.view_main;
                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (constraintLayout2 != null) {
                                                                                                return new FragmentIntercomPaymentBinding((ConstraintLayout) view, imageButton, imageButton2, cardView, cardView2, imageView, imageView2, constraintLayout, nestedScrollView, progressBar, recyclerView, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, viewFindChildViewById, viewFindChildViewById2, constraintLayout2);
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
