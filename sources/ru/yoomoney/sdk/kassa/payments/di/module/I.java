package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2465c;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2480h;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2495m;

/* loaded from: classes5.dex */
public final class I implements Factory {
    public final H a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;

    public I(H h, Factory factory, Factory factory2, Factory factory3, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = h;
        this.b = factory;
        this.c = factory2;
        this.d = factory3;
        this.e = provider;
        this.f = provider2;
        this.g = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        H h = this.a;
        Context context = (Context) this.b.get();
        PaymentParameters paymentParameters = (PaymentParameters) this.c.get();
        TestParameters testParameters = (TestParameters) this.d.get();
        ru.yoomoney.sdk.kassa.payments.metrics.r errorReporter = (ru.yoomoney.sdk.kassa.payments.metrics.r) this.e.get();
        ru.yoomoney.sdk.kassa.payments.config.f configRepository = (ru.yoomoney.sdk.kassa.payments.config.f) this.f.get();
        ru.yoomoney.sdk.kassa.payments.api.d paymentsApi = (ru.yoomoney.sdk.kassa.payments.api.d) this.g.get();
        h.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        return (ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b) Preconditions.checkNotNullFromProvides(testParameters.getMockConfiguration() != null ? new C2495m(testParameters.getMockConfiguration().getLinkedCardsCount(), new ru.yoomoney.sdk.kassa.payments.model.A(testParameters.getMockConfiguration().getServiceFee(), null), paymentParameters.getCustomerId()) : new C2480h(context, new C2465c(paymentsApi, configRepository, paymentParameters.getGatewayId(), paymentParameters.getSavePaymentMethod(), paymentParameters.getCustomerId()), errorReporter));
    }
}
