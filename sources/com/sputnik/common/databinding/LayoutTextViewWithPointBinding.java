package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public final class LayoutTextViewWithPointBinding implements ViewBinding {
    public final ImageView ivIcon;
    public final ImageView ivSpecialIcon;
    private final View rootView;
    public final TextView tvNumber;

    private LayoutTextViewWithPointBinding(View view, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = view;
        this.ivIcon = imageView;
        this.ivSpecialIcon = imageView2;
        this.tvNumber = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutTextViewWithPointBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_text_view_with_point, viewGroup);
        return bind(viewGroup);
    }

    public static LayoutTextViewWithPointBinding bind(View view) {
        int i = R$id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.iv_special_icon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R$id.tv_number;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new LayoutTextViewWithPointBinding(view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
