package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;

/* loaded from: classes5.dex */
public final class h implements Factory {
    public final f a;
    public final Provider b;
    public final Provider c;

    public h(f fVar, Factory factory, dagger.internal.Provider provider) {
        this.a = fVar;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        f fVar = this.a;
        TestParameters testParameters = (TestParameters) this.b.get();
        Object tokensStorage = (ru.yoomoney.sdk.kassa.payments.secure.j) this.c.get();
        fVar.getClass();
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        if (testParameters.getMockConfiguration() != null) {
            tokensStorage = new a();
        }
        return (r1) Preconditions.checkNotNullFromProvides(tokensStorage);
    }
}
