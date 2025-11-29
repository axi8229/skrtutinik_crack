package ru.yoomoney.sdk.kassa.payments.tokenize.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.payment.tokenize.o;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;
import ru.yoomoney.sdk.kassa.payments.tokenize.I;
import ru.yoomoney.sdk.kassa.payments.tokenize.K;

/* loaded from: classes5.dex */
public final class f implements Factory {
    public final e a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public f(e eVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4) {
        this.a = eVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        e eVar = this.a;
        ru.yoomoney.sdk.kassa.payments.payment.c getLoadedPaymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.c) this.b.get();
        o tokenizeRepository = (o) this.c.get();
        ru.yoomoney.sdk.kassa.payments.payment.a checkPaymentAuthRequiredGateway = (ru.yoomoney.sdk.kassa.payments.payment.a) this.d.get();
        r1 paymenPaymentAuthTokenRepository = (r1) this.e.get();
        eVar.getClass();
        Intrinsics.checkNotNullParameter(getLoadedPaymentOptionListRepository, "getLoadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(tokenizeRepository, "tokenizeRepository");
        Intrinsics.checkNotNullParameter(checkPaymentAuthRequiredGateway, "checkPaymentAuthRequiredGateway");
        Intrinsics.checkNotNullParameter(paymenPaymentAuthTokenRepository, "paymenPaymentAuthTokenRepository");
        return (I) Preconditions.checkNotNullFromProvides(new K(getLoadedPaymentOptionListRepository, tokenizeRepository, checkPaymentAuthRequiredGateway, paymenPaymentAuthTokenRepository));
    }
}
