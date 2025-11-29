package com.sputnik.subscriptions.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.subscriptions.R$id;
import com.sputnik.subscriptions.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetSuccessPaymentBinding implements ViewBinding {
    public final AppCompatButton btnSubscribe;
    private final ScrollView rootView;
    public final TextView tvHeader;
    public final TextView tvTitle1;

    private BottomSheetSuccessPaymentBinding(ScrollView scrollView, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnSubscribe = appCompatButton;
        this.tvHeader = textView;
        this.tvTitle1 = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetSuccessPaymentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_success_payment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetSuccessPaymentBinding bind(View view) {
        int i = R$id.btn_subscribe;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.tv_header;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R$id.tv_title_1;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new BottomSheetSuccessPaymentBinding((ScrollView) view, appCompatButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
