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
public final class BottomSheetDeleteAccountBinding implements ViewBinding {
    public final AppCompatButton btnDelete;
    public final AppCompatButton btnDismiss;
    private final ConstraintLayout rootView;
    public final TextView tvDeleteTitle;
    public final TextView tvName;
    public final TextView tvPhone;

    private BottomSheetDeleteAccountBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnDelete = appCompatButton;
        this.btnDismiss = appCompatButton2;
        this.tvDeleteTitle = textView;
        this.tvName = textView2;
        this.tvPhone = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetDeleteAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_delete_account, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetDeleteAccountBinding bind(View view) {
        int i = R$id.btn_delete;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_dismiss;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.tv_delete_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.tv_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R$id.tv_phone;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new BottomSheetDeleteAccountBinding((ConstraintLayout) view, appCompatButton, appCompatButton2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
