package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import com.yandex.metrica.IReporter;
import com.yandex.metrica.YandexMetrica;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class n0 implements Factory {
    public final m0 a;
    public final Provider b;

    public n0(m0 m0Var, Factory factory) {
        this.a = m0Var;
        this.b = factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        m0 m0Var = this.a;
        Context context = (Context) this.b.get();
        m0Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        IReporter reporter = YandexMetrica.getReporter(context.getApplicationContext(), "304c54b9-e8cd-424a-9e4c-a29cf9e9f6b5");
        Intrinsics.checkNotNullExpressionValue(reporter, "getReporter(...)");
        return (IReporter) Preconditions.checkNotNullFromProvides(reporter);
    }
}
