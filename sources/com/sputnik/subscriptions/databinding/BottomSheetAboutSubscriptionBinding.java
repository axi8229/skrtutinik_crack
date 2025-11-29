package com.sputnik.subscriptions.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.subscriptions.R$id;
import com.sputnik.subscriptions.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetAboutSubscriptionBinding implements ViewBinding {
    public final TextView btnOtherSubscriptions;
    public final Button btnSubscribe;
    public final ConstraintLayout cardRoot;
    public final ConstraintLayout constraintLayout3;
    public final ImageView imageView2;
    public final LinearLayout lAddition;
    public final ConstraintLayout layoutAttention;
    public final LinearLayout layoutService;
    public final CoordinatorLayout layoutSnackbar;
    public final LinearLayout linearLayout2;
    private final ScrollView rootView;
    public final LinearLayout serviceLoader;
    public final TextView tvAttention;
    public final TextView tvHeader;
    public final TextView tvPaymentInProgress;
    public final TextView tvSubscriptionTitle;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private BottomSheetAboutSubscriptionBinding(ScrollView scrollView, TextView textView, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, CoordinatorLayout coordinatorLayout, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = scrollView;
        this.btnOtherSubscriptions = textView;
        this.btnSubscribe = button;
        this.cardRoot = constraintLayout;
        this.constraintLayout3 = constraintLayout2;
        this.imageView2 = imageView;
        this.lAddition = linearLayout;
        this.layoutAttention = constraintLayout3;
        this.layoutService = linearLayout2;
        this.layoutSnackbar = coordinatorLayout;
        this.linearLayout2 = linearLayout3;
        this.serviceLoader = linearLayout4;
        this.tvAttention = textView2;
        this.tvHeader = textView3;
        this.tvPaymentInProgress = textView4;
        this.tvSubscriptionTitle = textView5;
        this.tvSubtitle = textView6;
        this.tvTitle = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetAboutSubscriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_about_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetAboutSubscriptionBinding bind(View view) {
        int i = R$id.btn_other_subscriptions;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R$id.btn_subscribe;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = R$id.card_root;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R$id.constraintLayout3;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R$id.imageView2;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R$id.l_addition;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R$id.layout_attention;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R$id.layout_service;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R$id.layout_snackbar;
                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i);
                                        if (coordinatorLayout != null) {
                                            i = R$id.linearLayout2;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                            if (linearLayout3 != null) {
                                                i = R$id.serviceLoader;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    i = R$id.tv_attention;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R$id.tv_header;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R$id.tv_payment_in_progress;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R$id.tv_subscription_title;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    i = R$id.tv_subtitle;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView6 != null) {
                                                                        i = R$id.tv_title;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView7 != null) {
                                                                            return new BottomSheetAboutSubscriptionBinding((ScrollView) view, textView, button, constraintLayout, constraintLayout2, imageView, linearLayout, constraintLayout3, linearLayout2, coordinatorLayout, linearLayout3, linearLayout4, textView2, textView3, textView4, textView5, textView6, textView7);
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
