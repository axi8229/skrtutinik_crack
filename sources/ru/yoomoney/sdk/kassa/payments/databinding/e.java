package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import ru.yoomoney.sdk.kassa.payments.ui.DialogTopBar;

/* loaded from: classes5.dex */
public final class e implements ViewBinding {
    public final LinearLayout a;
    public final FrameLayout b;
    public final DialogTopBar c;

    public e(LinearLayout linearLayout, FrameLayout frameLayout, DialogTopBar dialogTopBar) {
        this.a = linearLayout;
        this.b = frameLayout;
        this.c = dialogTopBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
