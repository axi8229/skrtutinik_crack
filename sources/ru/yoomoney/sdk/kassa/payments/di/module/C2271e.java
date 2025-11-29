package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2271e implements Factory {
    public final C2267a a;

    public C2271e(C2267a c2267a) {
        this.a = c2267a;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (ru.yoomoney.sdk.kassa.payments.tmx.a) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.tmx.a());
    }
}
