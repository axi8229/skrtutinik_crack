package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes5.dex */
public final class l implements ViewBinding {
    public final LinearLayout a;
    public final FrameLayout b;

    public l(LinearLayout linearLayout, FrameLayout frameLayout) {
        this.a = linearLayout;
        this.b = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
