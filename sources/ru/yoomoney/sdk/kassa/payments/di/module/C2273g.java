package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;
import ru.yoomoney.sdk.yooprofiler.YooProfilerHelper;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.g, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2273g implements Factory {
    public final C2267a a;
    public final Provider b;

    public C2273g(C2267a c2267a, dagger.internal.Provider provider) {
        this.a = c2267a;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2267a c2267a = this.a;
        Context context = (Context) this.b.get();
        c2267a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        return (YooProfiler) Preconditions.checkNotNullFromProvides(YooProfilerHelper.INSTANCE.create(context));
    }
}
