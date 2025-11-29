package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class M implements Factory {
    public final J a;
    public final Provider b;
    public final Provider c;

    public M(J j, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = j;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        J j = this.a;
        ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a unbindCardInfoGateway = (ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a) this.b.get();
        ru.yoomoney.sdk.kassa.payments.payment.c getLoadedPaymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.c) this.c.get();
        j.getClass();
        Intrinsics.checkNotNullParameter(unbindCardInfoGateway, "unbindCardInfoGateway");
        Intrinsics.checkNotNullParameter(getLoadedPaymentOptionListRepository, "getLoadedPaymentOptionListRepository");
        return (ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.a) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.c(unbindCardInfoGateway, getLoadedPaymentOptionListRepository));
    }
}
