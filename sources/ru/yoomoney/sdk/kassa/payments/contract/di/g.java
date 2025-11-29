package ru.yoomoney.sdk.kassa.payments.contract.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.AccountRepository;
import ru.yoomoney.sdk.kassa.payments.contract.X0;
import ru.yoomoney.sdk.kassa.payments.contract.Z0;
import ru.yoomoney.sdk.kassa.payments.secure.j;

/* loaded from: classes5.dex */
public final class g implements Factory {
    public final c a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;

    public g(c cVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4) {
        this.a = cVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        c cVar = this.a;
        ru.yoomoney.sdk.kassa.payments.payment.c getLoadedPaymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.c) this.b.get();
        ru.yoomoney.sdk.kassa.payments.payment.a checkPaymentAuthRequiredGateway = (ru.yoomoney.sdk.kassa.payments.payment.a) this.c.get();
        AccountRepository accountRepository = (AccountRepository) this.d.get();
        j userAuthInfoRepository = (j) this.e.get();
        cVar.getClass();
        Intrinsics.checkNotNullParameter(getLoadedPaymentOptionListRepository, "getLoadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(checkPaymentAuthRequiredGateway, "checkPaymentAuthRequiredGateway");
        Intrinsics.checkNotNullParameter(accountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(userAuthInfoRepository, "userAuthInfoRepository");
        return (X0) Preconditions.checkNotNullFromProvides(new Z0(getLoadedPaymentOptionListRepository, checkPaymentAuthRequiredGateway, accountRepository, userAuthInfoRepository));
    }
}
