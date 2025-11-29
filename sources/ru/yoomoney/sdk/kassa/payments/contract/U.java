package ru.yoomoney.sdk.kassa.payments.contract;

import android.widget.FrameLayout;
import androidx.view.OnBackPressedCallback;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class U extends OnBackPressedCallback {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(C2264y0 c2264y0) {
        super(true);
        this.a = c2264y0;
    }

    @Override // androidx.view.OnBackPressedCallback
    public final void handleOnBackPressed() {
        C2264y0 c2264y0 = this.a;
        int i = C2264y0.$r8$clinit;
        FrameLayout contentView = c2264y0.a().e;
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        ru.yoomoney.sdk.kassa.payments.extensions.l.a(contentView);
        c2264y0.getParentFragmentManager().popBackStack();
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) c2264y0.b()).a(new ru.yoomoney.sdk.kassa.payments.navigation.j(null));
    }
}
