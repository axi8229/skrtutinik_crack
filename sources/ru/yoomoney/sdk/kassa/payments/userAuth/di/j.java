package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.e0;

/* loaded from: classes5.dex */
public final class j implements Factory {
    public final d a;
    public final Provider b;
    public final Provider c;

    public j(d dVar, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = dVar;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        d dVar = this.a;
        ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository = (ru.yoomoney.sdk.kassa.payments.payment.b) this.b.get();
        ru.yoomoney.sdk.kassa.payments.payment.a checkPaymentAuthRequiredGateway = (ru.yoomoney.sdk.kassa.payments.payment.a) this.c.get();
        dVar.getClass();
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(checkPaymentAuthRequiredGateway, "checkPaymentAuthRequiredGateway");
        return (e0) Preconditions.checkNotNullFromProvides(new e0(currentUserRepository, checkPaymentAuthRequiredGateway));
    }
}
