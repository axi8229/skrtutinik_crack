package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class D implements Factory {
    public final A a;
    public final Provider b;

    public D(A a, dagger.internal.Provider provider) {
        this.a = a;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        A a = this.a;
        ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.M sberPayRepository = (ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.M) this.b.get();
        a.getClass();
        Intrinsics.checkNotNullParameter(sberPayRepository, "sberPayRepository");
        return (ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.I) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.L(sberPayRepository));
    }
}
