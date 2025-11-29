package com.sputnik.service_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public final class DialogSuccessPromiseBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnReject;
    public final ImageView ivMascotte;
    private final ScrollView rootView;
    public final TextView tvDescription;
    public final TextView tvTitle;

    private DialogSuccessPromiseBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnApply = appCompatButton;
        this.btnReject = appCompatButton2;
        this.ivMascotte = imageView;
        this.tvDescription = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static DialogSuccessPromiseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_success_promise, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogSuccessPromiseBinding bind(View view) {
        int i = R$id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_reject;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.iv_mascotte;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R$id.tv_description;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R$id.tv_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new DialogSuccessPromiseBinding((ScrollView) view, appCompatButton, appCompatButton2, imageView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
