package ru.yoomoney.sdk.kassa.payments.unbind.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* loaded from: classes5.dex */
public final class d implements Factory {
    public final c a;
    public final Provider b;
    public final Provider c;

    public d(c cVar, Factory factory, dagger.internal.Provider provider) {
        this.a = cVar;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        c cVar = this.a;
        TestParameters testParameters = (TestParameters) this.b.get();
        ru.yoomoney.sdk.kassa.payments.api.d paymentsApi = (ru.yoomoney.sdk.kassa.payments.api.d) this.c.get();
        cVar.getClass();
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        return (ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a) Preconditions.checkNotNullFromProvides(testParameters.getMockConfiguration() != null ? new ru.yoomoney.sdk.kassa.payments.unbind.impl.a() : new ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.f(paymentsApi));
    }
}
