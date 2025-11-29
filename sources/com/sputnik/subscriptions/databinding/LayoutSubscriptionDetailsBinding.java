package com.sputnik.subscriptions.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.subscriptions.R$id;

/* loaded from: classes3.dex */
public final class LayoutSubscriptionDetailsBinding implements ViewBinding {
    public final View btnAnchor;
    public final ConstraintLayout constraintLayout;
    public final ConstraintLayout constraintLayout3;
    public final ImageView imageView;
    public final ImageView imageView2;
    public final LinearLayout layout1;
    public final ConstraintLayout layoutAttention;
    public final LinearLayout layoutFeatures;
    public final LinearLayout layoutFeaturesSecond;
    public final ConstraintLayout linearLayout;
    private final NestedScrollView rootView;
    public final TextView tvAgreement;
    public final TextView tvAttention;
    public final TextView tvTitle1;
    public final TextView tvTitle2;
    public final TextView tvTitleSub;
    public final NestedScrollView viewMain;

    private LayoutSubscriptionDetailsBinding(NestedScrollView nestedScrollView, View view, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, LinearLayout linearLayout2, LinearLayout linearLayout3, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, NestedScrollView nestedScrollView2) {
        this.rootView = nestedScrollView;
        this.btnAnchor = view;
        this.constraintLayout = constraintLayout;
        this.constraintLayout3 = constraintLayout2;
        this.imageView = imageView;
        this.imageView2 = imageView2;
        this.layout1 = linearLayout;
        this.layoutAttention = constraintLayout3;
        this.layoutFeatures = linearLayout2;
        this.layoutFeaturesSecond = linearLayout3;
        this.linearLayout = constraintLayout4;
        this.tvAgreement = textView;
        this.tvAttention = textView2;
        this.tvTitle1 = textView3;
        this.tvTitle2 = textView4;
        this.tvTitleSub = textView5;
        this.viewMain = nestedScrollView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static LayoutSubscriptionDetailsBinding bind(View view) {
        int i = R$id.btn_anchor;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            i = R$id.constraintLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R$id.constraintLayout3;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout2 != null) {
                    i = R$id.imageView;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R$id.imageView2;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R$id.layout_1;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R$id.layout_attention;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout3 != null) {
                                    i = R$id.layout_features;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R$id.layout_features_second;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R$id.linearLayout;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                            if (constraintLayout4 != null) {
                                                i = R$id.tv_agreement;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R$id.tv_attention;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R$id.tv_title1;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R$id.tv_title2;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R$id.tv_title_sub;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView5 != null) {
                                                                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                                                                    return new LayoutSubscriptionDetailsBinding(nestedScrollView, viewFindChildViewById, constraintLayout, constraintLayout2, imageView, imageView2, linearLayout, constraintLayout3, linearLayout2, linearLayout3, constraintLayout4, textView, textView2, textView3, textView4, textView5, nestedScrollView);
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
