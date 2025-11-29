package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class h0 implements Factory {
    public final e0 a;
    public final Provider b;
    public final Provider c;

    public h0(e0 e0Var, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = e0Var;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        e0 e0Var = this.a;
        Context context = (Context) this.b.get();
        ru.yoomoney.sdk.kassa.payments.metrics.r errorReporter = (ru.yoomoney.sdk.kassa.payments.metrics.r) this.c.get();
        e0Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        return (ru.yoomoney.sdk.kassa.payments.secure.a) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.secure.a(context, ru.yoomoney.sdk.kassa.payments.secure.h.a(context), errorReporter));
    }
}
