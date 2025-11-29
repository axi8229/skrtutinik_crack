package com.sputnik.oboarding.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.oboarding.R$id;
import com.sputnik.oboarding.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetRegRegistrationBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    private final ConstraintLayout rootView;
    public final TextView tvNotice;
    public final AppCompatButton tvSetupLater;
    public final TextView tvTitle;

    private BottomSheetRegRegistrationBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, TextView textView, AppCompatButton appCompatButton2, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnApply = appCompatButton;
        this.tvNotice = textView;
        this.tvSetupLater = appCompatButton2;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetRegRegistrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_reg_registration, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetRegRegistrationBinding bind(View view) {
        int i = R$id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.tv_notice;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R$id.tv_setup_later;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
                if (appCompatButton2 != null) {
                    i = R$id.tv_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new BottomSheetRegRegistrationBinding((ConstraintLayout) view, appCompatButton, textView, appCompatButton2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
