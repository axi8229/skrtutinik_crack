package ru.yoomoney.sdk.kassa.payments.contract;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.M1;

/* renamed from: ru.yoomoney.sdk.kassa.payments.contract.x0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2262x0 extends Lambda implements Function0 {
    public final /* synthetic */ C2264y0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2262x0(C2264y0 c2264y0) {
        super(0);
        this.a = c2264y0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        P0 p0 = this.a.b;
        if (p0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
            p0 = null;
        }
        int iIntValue = ((Number) this.a.h.getValue()).intValue();
        String str = (String) this.a.i.getValue();
        Q0 q0 = p0.a;
        return new O0((Context) q0.a.get(), (X0) q0.b.get(), (PaymentParameters) q0.c.get(), (ru.yoomoney.sdk.kassa.payments.logout.c) q0.d.get(), (ru.yoomoney.sdk.kassa.payments.metrics.F) q0.e.get(), (ru.yoomoney.sdk.kassa.payments.metrics.e0) q0.f.get(), (ru.yoomoney.sdk.kassa.payments.model.B) q0.g.get(), (ru.yoomoney.sdk.kassa.payments.payment.c) q0.h.get(), (ru.yoomoney.sdk.kassa.payments.secure.j) q0.i.get(), (ru.yoomoney.sdk.kassa.payments.metrics.V) q0.j.get(), (M1) q0.k.get(), (ru.yoomoney.sdk.kassa.payments.config.f) q0.l.get(), iIntValue, str);
    }
}
