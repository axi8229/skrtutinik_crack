package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.C2440q;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.s1;

/* loaded from: classes5.dex */
public final class i implements Factory {
    public final f a;
    public final Provider b;
    public final Provider c;

    public i(f fVar, Factory factory, dagger.internal.Provider provider) {
        this.a = fVar;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        f fVar = this.a;
        TestParameters testParameters = (TestParameters) this.b.get();
        Object apiV3PaymentAuthRepository = (C2428l) this.c.get();
        fVar.getClass();
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(apiV3PaymentAuthRepository, "apiV3PaymentAuthRepository");
        if (testParameters.getMockConfiguration() != null) {
            apiV3PaymentAuthRepository = new C2440q();
        }
        return (s1) Preconditions.checkNotNullFromProvides(apiV3PaymentAuthRepository);
    }
}
