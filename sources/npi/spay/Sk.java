package npi.spay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;

/* loaded from: classes4.dex */
public final class Sk implements Factory {
    public final C1767me a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public Sk(C1767me c1767me, Provider provider, Provider provider2, Provider provider3) {
        this.a = c1767me;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C1767me c1767me = this.a;
        InterfaceC1997vk sslInteractor = (InterfaceC1997vk) this.b.get();
        OkHttpClient.Builder okHttpBuilder = (OkHttpClient.Builder) this.c.get();
        C1993vg featuresHandler = (C1993vg) this.d.get();
        c1767me.getClass();
        Intrinsics.checkNotNullParameter(sslInteractor, "sslInteractor");
        Intrinsics.checkNotNullParameter(okHttpBuilder, "okHttpBuilder");
        Intrinsics.checkNotNullParameter(featuresHandler, "featuresHandler");
        return (C1951u) Preconditions.checkNotNullFromProvides(new C1951u(sslInteractor, okHttpBuilder, featuresHandler));
    }
}
