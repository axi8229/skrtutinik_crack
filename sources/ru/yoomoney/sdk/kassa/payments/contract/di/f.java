package ru.yoomoney.sdk.kassa.payments.contract.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.MockConfiguration;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.payment.tokenize.h;
import ru.yoomoney.sdk.kassa.payments.payment.tokenize.o;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes5.dex */
public final class f implements Factory {
    public final c a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public f(c cVar, Factory factory, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4, dagger.internal.Provider provider5) {
        this.a = cVar;
        this.b = factory;
        this.c = provider;
        this.d = provider2;
        this.e = provider3;
        this.f = provider4;
        this.g = provider5;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        c cVar = this.a;
        TestParameters testParameters = (TestParameters) this.b.get();
        PaymentParameters paymentParameters = (PaymentParameters) this.c.get();
        YooProfiler profiler = (YooProfiler) this.d.get();
        ru.yoomoney.sdk.kassa.payments.api.d paymentsApi = (ru.yoomoney.sdk.kassa.payments.api.d) this.e.get();
        r1 paymentAuthTokenRepository = (r1) this.f.get();
        ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage = (ru.yoomoney.sdk.kassa.payments.tmx.a) this.g.get();
        cVar.getClass();
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        Intrinsics.checkNotNullParameter(paymentAuthTokenRepository, "paymentAuthTokenRepository");
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        MockConfiguration mockConfiguration = testParameters.getMockConfiguration();
        return (o) Preconditions.checkNotNullFromProvides(mockConfiguration != null ? new h(mockConfiguration.getCompleteWithError()) : new ru.yoomoney.sdk.kassa.payments.payment.tokenize.d(profilingSessionIdStorage, profiler, paymentsApi, paymentParameters.getCustomerId(), paymentAuthTokenRepository));
    }
}
