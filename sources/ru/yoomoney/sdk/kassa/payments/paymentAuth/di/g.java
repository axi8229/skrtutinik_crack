package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.C2428l;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.M1;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes5.dex */
public final class g implements Factory {
    public final f a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public g(f fVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = fVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        f fVar = this.a;
        YooProfiler profiler = (YooProfiler) this.b.get();
        ru.yoomoney.sdk.kassa.payments.tmx.a profilingSessionIdStorage = (ru.yoomoney.sdk.kassa.payments.tmx.a) this.c.get();
        ru.yoomoney.sdk.kassa.payments.api.e paymentsAuthApi = (ru.yoomoney.sdk.kassa.payments.api.e) this.d.get();
        fVar.getClass();
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(profilingSessionIdStorage, "profilingSessionIdStorage");
        Intrinsics.checkNotNullParameter(paymentsAuthApi, "paymentsAuthApi");
        return (C2428l) Preconditions.checkNotNullFromProvides(new C2428l(profilingSessionIdStorage, profiler, new M1(), paymentsAuthApi));
    }
}
