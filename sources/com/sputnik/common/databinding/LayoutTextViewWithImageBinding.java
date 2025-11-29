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
public final class LayoutTextViewWithImageBinding implements ViewBinding {
    public final ImageView ivIcon;
    private final View rootView;
    public final TextView tvNumber;

    private LayoutTextViewWithImageBinding(View view, ImageView imageView, TextView textView) {
        this.rootView = view;
        this.ivIcon = imageView;
        this.tvNumber = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static LayoutTextViewWithImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.layout_text_view_with_image, viewGroup);
        return bind(viewGroup);
    }

    public static LayoutTextViewWithImageBinding bind(View view) {
        int i = R$id.iv_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R$id.tv_number;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LayoutTextViewWithImageBinding(view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
