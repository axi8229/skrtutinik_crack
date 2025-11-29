package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2285t implements Factory {
    public final r a;
    public final Provider b;

    public C2285t(r rVar, dagger.internal.Provider provider) {
        this.a = rVar;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        r rVar = this.a;
        ru.yoomoney.sdk.kassa.payments.payment.d repository = (ru.yoomoney.sdk.kassa.payments.payment.d) this.b.get();
        rVar.getClass();
        Intrinsics.checkNotNullParameter(repository, "repository");
        return (ru.yoomoney.sdk.kassa.payments.payment.c) Preconditions.checkNotNullFromProvides(repository);
    }
}
