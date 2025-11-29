package ru.yoomoney.sdk.kassa.payments.databinding;

import android.view.View;
import android.widget.ViewAnimator;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes5.dex */
public final class h implements ViewBinding {
    public final ViewAnimator a;
    public final ComposeView b;

    public h(ViewAnimator viewAnimator, ComposeView composeView) {
        this.a = viewAnimator;
        this.b = composeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.a;
    }
}
