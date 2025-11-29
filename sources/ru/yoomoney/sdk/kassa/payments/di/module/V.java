package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class V implements Factory {
    public final U a;
    public final Provider b;
    public final Provider c;

    public V(U u, Factory factory, dagger.internal.Provider provider) {
        this.a = u;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        U u = this.a;
        Context context = (Context) this.b.get();
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.k0 bankListRepository = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.k0) this.c.get();
        u.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bankListRepository, "bankListRepository");
        return (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.d0) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.j0(context, bankListRepository));
    }
}
