package ru.yoomoney.sdk.kassa.payments.unbind.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.unbind.impl.x;
import ru.yoomoney.sdk.kassa.payments.unbind.impl.z;

/* loaded from: classes5.dex */
public final class e implements Factory {
    public final c a;
    public final Provider b;
    public final Provider c;

    public e(c cVar, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = cVar;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        c cVar = this.a;
        ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a unbindCardInfoGateway = (ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a) this.b.get();
        ru.yoomoney.sdk.kassa.payments.payment.c getLoadedPaymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.c) this.c.get();
        cVar.getClass();
        Intrinsics.checkNotNullParameter(unbindCardInfoGateway, "unbindCardInfoGateway");
        Intrinsics.checkNotNullParameter(getLoadedPaymentOptionListRepository, "getLoadedPaymentOptionListRepository");
        return (x) Preconditions.checkNotNullFromProvides(new z(unbindCardInfoGateway, getLoadedPaymentOptionListRepository));
    }
}
