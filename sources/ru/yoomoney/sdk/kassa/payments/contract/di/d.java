package ru.yoomoney.sdk.kassa.payments.contract.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d implements Factory {
    public final c a;
    public final Provider b;

    public d(c cVar, dagger.internal.Provider provider) {
        this.a = cVar;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        c cVar = this.a;
        ru.yoomoney.sdk.kassa.payments.logout.a logoutRepository = (ru.yoomoney.sdk.kassa.payments.logout.a) this.b.get();
        cVar.getClass();
        Intrinsics.checkNotNullParameter(logoutRepository, "logoutRepository");
        return (ru.yoomoney.sdk.kassa.payments.logout.c) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.logout.d(logoutRepository));
    }
}
