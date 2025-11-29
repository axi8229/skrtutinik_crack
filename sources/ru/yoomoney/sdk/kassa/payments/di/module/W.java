package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0;

/* loaded from: classes5.dex */
public final class W implements Factory {
    public final U a;
    public final Provider b;
    public final Provider c;

    public W(U u, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = u;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        U u = this.a;
        ru.yoomoney.sdk.kassa.payments.api.f sbpApi = (ru.yoomoney.sdk.kassa.payments.api.f) this.b.get();
        ru.yoomoney.sdk.kassa.payments.api.d paymentsApi = (ru.yoomoney.sdk.kassa.payments.api.d) this.c.get();
        u.getClass();
        Intrinsics.checkNotNullParameter(sbpApi, "sbpApi");
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        return (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.k0) Preconditions.checkNotNullFromProvides(new p0(sbpApi, paymentsApi));
    }
}
