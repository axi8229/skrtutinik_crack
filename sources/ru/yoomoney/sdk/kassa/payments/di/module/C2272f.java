package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.TestParameters;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2272f implements Factory {
    public final C2267a a;
    public final Provider b;
    public final Provider c;

    public C2272f(C2267a c2267a, dagger.internal.Provider provider, Factory factory) {
        this.a = c2267a;
        this.b = provider;
        this.c = factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2267a c2267a = this.a;
        Context context = (Context) this.b.get();
        TestParameters testParameters = (TestParameters) this.c.get();
        c2267a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(testParameters, "testParameters");
        return (ru.yoomoney.sdk.kassa.payments.navigation.c) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.navigation.a(context, testParameters.getShowLogs()));
    }
}
