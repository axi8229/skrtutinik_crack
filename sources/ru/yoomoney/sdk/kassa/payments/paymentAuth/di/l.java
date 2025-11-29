package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.r;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.D1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.E1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.G1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;

/* loaded from: classes5.dex */
public final class l implements Factory {
    public final f a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public l(f fVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4) {
        this.a = fVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        f fVar = this.a;
        D1 processPaymentAuthRepository = (D1) this.b.get();
        ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository = (ru.yoomoney.sdk.kassa.payments.payment.b) this.c.get();
        r1 paymentAuthTokenRepository = (r1) this.d.get();
        r errorReporter = (r) this.e.get();
        fVar.getClass();
        Intrinsics.checkNotNullParameter(processPaymentAuthRepository, "processPaymentAuthRepository");
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(paymentAuthTokenRepository, "paymentAuthTokenRepository");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        return (E1) Preconditions.checkNotNullFromProvides(new G1(processPaymentAuthRepository, currentUserRepository, paymentAuthTokenRepository, errorReporter));
    }
}
