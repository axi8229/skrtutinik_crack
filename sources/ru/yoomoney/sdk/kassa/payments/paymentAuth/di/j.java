package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes5.dex */
public final class j implements Factory {
    public final f a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public j(f fVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = fVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        f fVar = this.a;
        ru.yoomoney.sdk.kassa.payments.http.a aVar = (ru.yoomoney.sdk.kassa.payments.http.a) this.b.get();
        OkHttpClient okHttpClient = (OkHttpClient) this.c.get();
        ru.yoomoney.sdk.kassa.payments.api.failures.a aVar2 = (ru.yoomoney.sdk.kassa.payments.api.failures.a) this.d.get();
        fVar.getClass();
        return (ru.yoomoney.sdk.kassa.payments.api.e) Preconditions.checkNotNullFromProvides(f.a(aVar, okHttpClient, aVar2));
    }
}
