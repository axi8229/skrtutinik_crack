package com.sputnik.common.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;

/* loaded from: classes3.dex */
public final class FragmentUpdateRequiredBinding implements ViewBinding {
    public final AppCompatButton btnAccept;
    public final ImageView imageView;
    public final LinearLayout linearLayout;
    private final ConstraintLayout rootView;
    public final TextView tvHeader;
    public final TextView tvSubtitle;

    private FragmentUpdateRequiredBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnAccept = appCompatButton;
        this.imageView = imageView;
        this.linearLayout = linearLayout;
        this.tvHeader = textView;
        this.tvSubtitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentUpdateRequiredBinding bind(View view) {
        int i = R$id.btn_accept;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.imageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R$id.linearLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R$id.tv_header;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R$id.tv_subtitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentUpdateRequiredBinding((ConstraintLayout) view, appCompatButton, imageView, linearLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
