package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.F1;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.I1;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.M1;

/* loaded from: classes5.dex */
public final class L implements Factory {
    public final J a;
    public final Provider b;
    public final Provider c;
    public final Provider d;
    public final Provider e;
    public final Provider f;
    public final Provider g;
    public final Provider h;

    public L(J j, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3, dagger.internal.Provider provider4, dagger.internal.Provider provider5, dagger.internal.Provider provider6, dagger.internal.Provider provider7) {
        this.a = j;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
        this.h = provider7;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        J j = this.a;
        PaymentParameters paymentParameters = (PaymentParameters) this.b.get();
        ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b paymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b) this.c.get();
        ru.yoomoney.sdk.kassa.payments.payment.e saveLoadedPaymentOptionsListRepository = (ru.yoomoney.sdk.kassa.payments.payment.e) this.d.get();
        ru.yoomoney.sdk.kassa.payments.payment.loadPaymentInfo.a paymentMethodInfoGateway = (ru.yoomoney.sdk.kassa.payments.payment.loadPaymentInfo.a) this.e.get();
        ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository = (ru.yoomoney.sdk.kassa.payments.payment.b) this.f.get();
        ru.yoomoney.sdk.kassa.payments.payment.c loadedPaymentOptionListRepository = (ru.yoomoney.sdk.kassa.payments.payment.c) this.g.get();
        M1 shopPropertiesRepository = (M1) this.h.get();
        j.getClass();
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        Intrinsics.checkNotNullParameter(paymentOptionListRepository, "paymentOptionListRepository");
        Intrinsics.checkNotNullParameter(saveLoadedPaymentOptionsListRepository, "saveLoadedPaymentOptionsListRepository");
        Intrinsics.checkNotNullParameter(paymentMethodInfoGateway, "paymentMethodInfoGateway");
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(loadedPaymentOptionListRepository, "loadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(shopPropertiesRepository, "shopPropertiesRepository");
        return (F1) Preconditions.checkNotNullFromProvides(new I1(paymentParameters.getPaymentMethodTypes(), paymentOptionListRepository, saveLoadedPaymentOptionsListRepository, paymentMethodInfoGateway, currentUserRepository, loadedPaymentOptionListRepository, shopPropertiesRepository));
    }
}
