package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.MockConfiguration;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* loaded from: classes5.dex */
public final class f implements Factory {
    public final d a;
    public final Provider b;
    public final Provider c;

    public f(d dVar, Factory factory, dagger.internal.Provider provider) {
        this.a = dVar;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        d dVar = this.a;
        TestParameters testParameters = (TestParameters) this.b.get();
        Object tokensStorage = (ru.yoomoney.sdk.kassa.payments.secure.j) this.c.get();
        dVar.getClass();
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        MockConfiguration mockConfiguration = testParameters.getMockConfiguration();
        if (mockConfiguration != null && mockConfiguration.getPaymentAuthPassed()) {
            tokensStorage = new a();
        }
        return (ru.yoomoney.sdk.kassa.payments.payment.a) Preconditions.checkNotNullFromProvides(tokensStorage);
    }
}
