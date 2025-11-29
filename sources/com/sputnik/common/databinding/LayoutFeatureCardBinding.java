package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class LayoutFeatureCardBinding implements ViewBinding {
    public final ImageButton btnMoreInfo;
    public final ImageView imageView8;
    public final ImageView imageView9;
    public final ImageView ivSpecialIcon;
    public final ConstraintLayout layoutBeta;
    private final View rootView;
    public final TextView tvSubtitle;
    public final TextView tvTitle;

    private LayoutFeatureCardBinding(View view, ImageButton imageButton, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = view;
        this.btnMoreInfo = imageButton;
        this.imageView8 = imageView;
        this.imageView9 = imageView2;
        this.ivSpecialIcon = imageView3;
        this.layoutBeta = constraintLayout;
        this.tvSubtitle = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutFeatureCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_feature_card, viewGroup);
        return bind(viewGroup);
    }

    public static LayoutFeatureCardBinding bind(View view) {
        int i = R$id.btn_more_info;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R$id.imageView8;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R$id.imageView9;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R$id.iv_special_icon;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R$id.layout_beta;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R$id.tv_subtitle;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R$id.tv_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new LayoutFeatureCardBinding(view, imageButton, imageView, imageView2, imageView3, constraintLayout, textView, textView2);
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
