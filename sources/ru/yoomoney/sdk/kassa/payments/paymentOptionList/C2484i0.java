package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.i0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2484i0 extends Lambda implements Function0 {
    public final /* synthetic */ C2487j0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2484i0(C2487j0 c2487j0) {
        super(0);
        this.a = c2487j0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ru.yoomoney.sdk.kassa.payments.di.j jVar = this.a.d;
        if (jVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
            jVar = null;
        }
        ru.yoomoney.sdk.kassa.payments.di.b bVar = new ru.yoomoney.sdk.kassa.payments.di.b((String) this.a.c.getValue());
        ru.yoomoney.sdk.kassa.payments.di.k kVar = jVar.a;
        return new ru.yoomoney.sdk.kassa.payments.di.i(bVar, (F1) kVar.a.get(), (PaymentParameters) kVar.b.get(), (ru.yoomoney.sdk.kassa.payments.metrics.F) kVar.c.get(), (ru.yoomoney.sdk.kassa.payments.metrics.e0) kVar.d.get(), (ru.yoomoney.sdk.kassa.payments.metrics.V) kVar.e.get(), (ru.yoomoney.sdk.kassa.payments.logout.c) kVar.f.get(), (ru.yoomoney.sdk.kassa.payments.model.B) kVar.g.get(), (ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.a) kVar.h.get(), (M1) kVar.i.get(), (InterfaceC2468d) kVar.j.get(), (ru.yoomoney.sdk.kassa.payments.config.f) kVar.k.get(), (Context) kVar.l.get());
    }
}
