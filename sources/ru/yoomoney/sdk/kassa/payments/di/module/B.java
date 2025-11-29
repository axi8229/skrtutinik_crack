package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class B implements Factory {
    public final A a;
    public final Provider b;

    public B(A a, dagger.internal.Provider provider) {
        this.a = a;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        A a = this.a;
        ru.yoomoney.sdk.kassa.payments.api.d paymentsApi = (ru.yoomoney.sdk.kassa.payments.api.d) this.b.get();
        a.getClass();
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        return (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r(paymentsApi));
    }
}
