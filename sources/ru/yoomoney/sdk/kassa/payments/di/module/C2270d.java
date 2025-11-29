package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.d, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2270d implements Factory {
    public final C2267a a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public C2270d(C2267a c2267a, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = c2267a;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2267a c2267a = this.a;
        ru.yoomoney.sdk.kassa.payments.http.a aVar = (ru.yoomoney.sdk.kassa.payments.http.a) this.b.get();
        OkHttpClient okHttpClient = (OkHttpClient) this.c.get();
        ru.yoomoney.sdk.kassa.payments.api.failures.a aVar2 = (ru.yoomoney.sdk.kassa.payments.api.failures.a) this.d.get();
        c2267a.getClass();
        return (ru.yoomoney.sdk.kassa.payments.api.d) Preconditions.checkNotNullFromProvides(C2267a.a(aVar, okHttpClient, aVar2));
    }
}
