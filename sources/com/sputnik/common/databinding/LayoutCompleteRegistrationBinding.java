package com.sputnik.common.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.common.R$id;

/* loaded from: classes3.dex */
public final class LayoutCompleteRegistrationBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    private final LinearLayout rootView;
    public final TextView tvTitle;

    private LayoutCompleteRegistrationBinding(LinearLayout linearLayout, AppCompatButton appCompatButton, TextView textView) {
        this.rootView = linearLayout;
        this.btnApply = appCompatButton;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCompleteRegistrationBinding bind(View view) {
        int i = R$id.btnApply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.tv_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LayoutCompleteRegistrationBinding((LinearLayout) view, appCompatButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
