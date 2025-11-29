package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public final class X implements Factory {
    public final U a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public X(U u, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = u;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        U u = this.a;
        ru.yoomoney.sdk.kassa.payments.http.a aVar = (ru.yoomoney.sdk.kassa.payments.http.a) this.b.get();
        OkHttpClient okHttpClient = (OkHttpClient) this.c.get();
        ru.yoomoney.sdk.kassa.payments.api.failures.a aVar2 = (ru.yoomoney.sdk.kassa.payments.api.failures.a) this.d.get();
        u.getClass();
        return (ru.yoomoney.sdk.kassa.payments.api.f) Preconditions.checkNotNullFromProvides(U.a(aVar, okHttpClient, aVar2));
    }
}
