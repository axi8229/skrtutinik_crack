package com.sputnik.subscriptions.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.subscriptions.R$id;
import com.sputnik.subscriptions.R$layout;

/* loaded from: classes3.dex */
public final class ItemSubscriptionBinding implements ViewBinding {
    public final TextView btnSubscribe;
    public final ConstraintLayout cardRoot;
    public final ConstraintLayout constraintLayout3;
    public final ImageView imageView2;
    public final LinearLayout lAddition;
    public final ConstraintLayout layoutAttention;
    public final LinearLayout layoutService;
    private final ConstraintLayout rootView;
    public final TextView tvAttention;
    public final TextView tvHeader;
    public final TextView tvSubscriptionDetails;
    public final TextView tvSubscriptionTitle;

    private ItemSubscriptionBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout4, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btnSubscribe = textView;
        this.cardRoot = constraintLayout2;
        this.constraintLayout3 = constraintLayout3;
        this.imageView2 = imageView;
        this.lAddition = linearLayout;
        this.layoutAttention = constraintLayout4;
        this.layoutService = linearLayout2;
        this.tvAttention = textView2;
        this.tvHeader = textView3;
        this.tvSubscriptionDetails = textView4;
        this.tvSubscriptionTitle = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemSubscriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.item_subscription, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemSubscriptionBinding bind(View view) {
        int i = R$id.btn_subscribe;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
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
                                i = R$id.tv_attention;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R$id.tv_header;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R$id.tv_subscription_details;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R$id.tv_subscription_title;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                return new ItemSubscriptionBinding(constraintLayout, textView, constraintLayout, constraintLayout2, imageView, linearLayout, constraintLayout3, linearLayout2, textView2, textView3, textView4, textView5);
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
