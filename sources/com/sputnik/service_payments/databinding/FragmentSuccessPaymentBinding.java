package com.sputnik.service_payments.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sputnik.service_payments.R$layout;

/* loaded from: classes3.dex */
public abstract class FragmentSuccessPaymentBinding extends ViewDataBinding {
    public final AppCompatButton btnAddSub;
    public final AppCompatButton btnCancel;
    public final View btnDivider;
    public final AppCompatButton btnGoToProfile;
    public final TextView btnShareOrSave;
    public final Group grNewSubscription;
    public final ImageView ivSuccessPayment;
    public final ProgressBar pbLoader;
    public final TextView tvSuccessPayment;

    protected FragmentSuccessPaymentBinding(Object obj, View view, int i, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, View view2, AppCompatButton appCompatButton3, TextView textView, Group group, ImageView imageView, ProgressBar progressBar, TextView textView2) {
        super(obj, view, i);
        this.btnAddSub = appCompatButton;
        this.btnCancel = appCompatButton2;
        this.btnDivider = view2;
        this.btnGoToProfile = appCompatButton3;
        this.btnShareOrSave = textView;
        this.grNewSubscription = group;
        this.ivSuccessPayment = imageView;
        this.pbLoader = progressBar;
        this.tvSuccessPayment = textView2;
    }

    public static FragmentSuccessPaymentBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSuccessPaymentBinding bind(View view, Object obj) {
        return (FragmentSuccessPaymentBinding) ViewDataBinding.bind(obj, view, R$layout.fragment_success_payment);
    }
}
