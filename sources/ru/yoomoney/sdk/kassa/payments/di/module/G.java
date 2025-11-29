package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* loaded from: classes5.dex */
public final class G implements Factory {
    public final F a;
    public final Provider b;
    public final Provider c;

    public G(F f, dagger.internal.Provider provider, Factory factory) {
        this.a = f;
        this.b = provider;
        this.c = factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        F f = this.a;
        ru.yoomoney.sdk.kassa.payments.api.d paymentsApi = (ru.yoomoney.sdk.kassa.payments.api.d) this.b.get();
        TestParameters testParameters = (TestParameters) this.c.get();
        f.getClass();
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        return (ru.yoomoney.sdk.kassa.payments.payment.loadPaymentInfo.a) Preconditions.checkNotNullFromProvides(testParameters.getMockConfiguration() != null ? new ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.d() : new ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.b(paymentsApi));
    }
}
