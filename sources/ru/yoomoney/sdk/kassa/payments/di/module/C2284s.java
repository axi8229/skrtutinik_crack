package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.s, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2284s implements Factory {
    public final r a;

    public C2284s(r rVar) {
        this.a = rVar;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (ru.yoomoney.sdk.kassa.payments.payment.d) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.payment.d());
    }
}
