package ru.yoomoney.sdk.kassa.payments.di.module;

import com.yandex.metrica.IReporter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class T implements Factory {
    public final N a;
    public final Provider b;

    public T(N n, dagger.internal.Provider provider) {
        this.a = n;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        N n = this.a;
        IReporter metrica = (IReporter) this.b.get();
        n.getClass();
        Intrinsics.checkNotNullParameter(metrica, "metrica");
        return (ru.yoomoney.sdk.kassa.payments.metrics.N) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.metrics.j0(metrica));
    }
}
