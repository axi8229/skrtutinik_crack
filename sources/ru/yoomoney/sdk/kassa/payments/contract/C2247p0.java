package ru.yoomoney.sdk.kassa.payments.contract;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.p0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2247p0 extends Lambda implements Function1 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2247p0(C2264y0 c2264y0) {
        super(1);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        View it = (View) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C2264y0 c2264y0 = this.a;
        int i = C2264y0.$r8$clinit;
        FrameLayout contentView = c2264y0.a().e;
        Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
        ru.yoomoney.sdk.kassa.payments.extensions.l.a(contentView);
        c2264y0.getParentFragmentManager().popBackStack();
        ((ru.yoomoney.sdk.kassa.payments.navigation.a) c2264y0.b()).a(new ru.yoomoney.sdk.kassa.payments.navigation.j(null));
        return Unit.INSTANCE;
    }
}
