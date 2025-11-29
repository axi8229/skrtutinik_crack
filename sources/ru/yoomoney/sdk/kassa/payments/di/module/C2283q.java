package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2283q implements Factory {
    public final C2282p a;
    public final Provider b;
    public final Provider c;

    public C2283q(C2282p c2282p, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = c2282p;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2282p c2282p = this.a;
        TestParameters testParameters = (TestParameters) this.b.get();
        ru.yoomoney.sdk.kassa.payments.config.f configRepository = (ru.yoomoney.sdk.kassa.payments.config.f) this.c.get();
        c2282p.getClass();
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        return (ru.yoomoney.sdk.kassa.payments.http.a) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.http.b(configRepository, testParameters.getHostParameters()));
    }
}
