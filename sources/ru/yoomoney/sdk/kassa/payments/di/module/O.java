package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import com.yandex.metrica.IReporter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;
import ru.yoomoney.sdk.kassa.payments.metrics.InterfaceC2308q;

/* loaded from: classes5.dex */
public final class O implements Factory {
    public final N a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public O(N n, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = n;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        N n = this.a;
        TestParameters testParameters = (TestParameters) this.b.get();
        Context context = (Context) this.c.get();
        IReporter metrica = (IReporter) this.d.get();
        n.getClass();
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(metrica, "metrica");
        return (InterfaceC2308q) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.metrics.h0(testParameters.getShowLogs(), context, new ru.yoomoney.sdk.kassa.payments.metrics.f0(metrica)));
    }
}
