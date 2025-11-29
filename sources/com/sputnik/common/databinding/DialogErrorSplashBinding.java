package com.sputnik.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.sputnik.common.R$layout;

/* loaded from: classes3.dex */
public abstract class DialogErrorSplashBinding extends ViewDataBinding {
    public final AppCompatButton btnRepeat;
    public final TextView errorAdvice;
    public final TextView errorName;

    protected DialogErrorSplashBinding(Object obj, View view, int i, AppCompatButton appCompatButton, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnRepeat = appCompatButton;
        this.errorAdvice = textView;
        this.errorName = textView2;
    }

    public static DialogErrorSplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogErrorSplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogErrorSplashBinding) ViewDataBinding.inflateInternal(layoutInflater, R$layout.dialog_error_splash, viewGroup, z, obj);
    }
}
