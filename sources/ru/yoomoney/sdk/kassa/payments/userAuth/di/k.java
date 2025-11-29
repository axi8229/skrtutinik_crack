package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.F1;
import ru.yoomoney.sdk.kassa.payments.userAuth.InterfaceC2538a;
import ru.yoomoney.sdk.march.CodeKt;

/* loaded from: classes5.dex */
public final class k implements Factory {
    public final d a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;
    public final Provider i;

    public k(d dVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4, dagger.internal.Provider provider5, dagger.internal.Provider provider6, dagger.internal.Provider provider7, dagger.internal.Provider provider8) {
        this.a = dVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
        this.i = provider8;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        d dVar = this.a;
        F reporter = (F) this.b.get();
        PaymentParameters paymentParameters = (PaymentParameters) this.c.get();
        ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage = (ru.yoomoney.sdk.kassa.payments.tmx.a) this.d.get();
        ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository = (ru.yoomoney.sdk.kassa.payments.payment.b) this.e.get();
        ru.yoomoney.sdk.kassa.payments.secure.j tokensStorage = (ru.yoomoney.sdk.kassa.payments.secure.j) this.f.get();
        F1 useCase = (F1) this.g.get();
        InterfaceC2538a getTransferDataUseCase = (InterfaceC2538a) this.h.get();
        ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.c) this.i.get();
        dVar.getClass();
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(tokensStorage, "tokensStorage");
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        Intrinsics.checkNotNullParameter(getTransferDataUseCase, "getTransferDataUseCase");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        return (ViewModel) Preconditions.checkNotNullFromProvides(CodeKt.RuntimeViewModel$default("MoneyAuth", b.a, new c(paymentParameters, reporter, currentUserRepository, loadedPaymentOptionListRepository, useCase, tokensStorage, profilingSessionIdStorage, getTransferDataUseCase), null, null, null, null, null, null, null, null, 2040, null));
    }
}
