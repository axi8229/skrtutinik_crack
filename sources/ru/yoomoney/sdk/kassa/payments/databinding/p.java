package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes5.dex */
public final class p implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;

    public p(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = imageView;
        this.d = textView2;
        this.e = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
