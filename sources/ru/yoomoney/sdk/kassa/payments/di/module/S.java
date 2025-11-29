package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import com.yandex.metrica.IReporter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* loaded from: classes5.dex */
public final class S implements Factory {
    public final N a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public S(N n, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = n;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        N n = this.a;
        IReporter metrica = (IReporter) this.b.get();
        TestParameters testParameters = (TestParameters) this.c.get();
        Context context = (Context) this.d.get();
        n.getClass();
        Intrinsics.checkNotNullParameter(metrica, "metrica");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(context, "context");
        return (ru.yoomoney.sdk.kassa.payments.metrics.F) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.logging.a(new ru.yoomoney.sdk.kassa.payments.metrics.i0(metrica), testParameters.getShowLogs(), context));
    }
}
