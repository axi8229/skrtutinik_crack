package com.sputnik.service_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetPaymentInfoBinding implements ViewBinding {
    public final LayoutPaymentInfoBinding infoLayout;
    private final ScrollView rootView;
    public final AppCompatButton subsStopButton;
    public final TextView tvCancelTitle;
    public final TextView tvSubtitle;

    private BottomSheetPaymentInfoBinding(ScrollView scrollView, LayoutPaymentInfoBinding layoutPaymentInfoBinding, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.infoLayout = layoutPaymentInfoBinding;
        this.subsStopButton = appCompatButton;
        this.tvCancelTitle = textView;
        this.tvSubtitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetPaymentInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_payment_info, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetPaymentInfoBinding bind(View view) {
        int i = R$id.info_layout;
        View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
        if (viewFindChildViewById != null) {
            LayoutPaymentInfoBinding layoutPaymentInfoBindingBind = LayoutPaymentInfoBinding.bind(viewFindChildViewById);
            i = R$id.subsStopButton;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton != null) {
                i = R$id.tv_cancel_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R$id.tv_subtitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new BottomSheetPaymentInfoBinding((ScrollView) view, layoutPaymentInfoBindingBind, appCompatButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
