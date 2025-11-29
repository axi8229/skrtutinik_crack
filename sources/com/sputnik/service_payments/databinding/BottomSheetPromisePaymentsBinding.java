package com.sputnik.service_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.sputnik.service_payments.R$id;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public final class BottomSheetPromisePaymentsBinding implements ViewBinding {
    public final AppCompatButton btnApply;
    public final AppCompatButton btnReject;
    public final ImageView ivMascotte;
    public final CoordinatorLayout layoutCoordinator;
    private final ScrollView rootView;
    public final TextView tvCancelTitle;
    public final TextView tvDescription;

    private BottomSheetPromisePaymentsBinding(ScrollView scrollView, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, ImageView imageView, CoordinatorLayout coordinatorLayout, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnApply = appCompatButton;
        this.btnReject = appCompatButton2;
        this.ivMascotte = imageView;
        this.layoutCoordinator = coordinatorLayout;
        this.tvCancelTitle = textView;
        this.tvDescription = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static BottomSheetPromisePaymentsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R$layout.bottom_sheet_promise_payments, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BottomSheetPromisePaymentsBinding bind(View view) {
        int i = R$id.btn_apply;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, i);
        if (appCompatButton != null) {
            i = R$id.btn_reject;
            AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, i);
            if (appCompatButton2 != null) {
                i = R$id.iv_mascotte;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R$id.layout_coordinator;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i);
                    if (coordinatorLayout != null) {
                        i = R$id.tv_cancel_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R$id.tv_description;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new BottomSheetPromisePaymentsBinding((ScrollView) view, appCompatButton, appCompatButton2, imageView, coordinatorLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
