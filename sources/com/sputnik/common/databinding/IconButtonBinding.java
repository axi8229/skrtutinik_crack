package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class IconButtonBinding implements ViewBinding {
    public final ImageView ivIcon;
    public final ConstraintLayout layoutPb;
    public final LinearLayout layoutViews;
    public final ProgressBar pb;
    private final View rootView;
    public final TextView tvNumber;

    private IconButtonBinding(View view, ImageView imageView, ConstraintLayout constraintLayout, LinearLayout linearLayout, ProgressBar progressBar, TextView textView) {
        this.rootView = view;
        this.ivIcon = imageView;
        this.layoutPb = constraintLayout;
        this.layoutViews = linearLayout;
        this.pb = progressBar;
        this.tvNumber = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static IconButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.icon_button, viewGroup);
        return bind(viewGroup);
    }

    public static IconButtonBinding bind(View view) {
        int i = R$id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.layout_pb;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R$id.layout_views;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R$id.pb;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        i = R$id.tv_number;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new IconButtonBinding(view, imageView, constraintLayout, linearLayout, progressBar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
