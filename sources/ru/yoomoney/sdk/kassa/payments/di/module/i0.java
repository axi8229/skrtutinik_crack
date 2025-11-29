package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i0 implements Factory {
    public final e0 a;
    public final Provider b;

    public i0(e0 e0Var, Z z) {
        this.a = e0Var;
        this.b = z;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        e0 e0Var = this.a;
        SharedPreferences sharedPreferences = (SharedPreferences) this.b.get();
        e0Var.getClass();
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        return (ru.yoomoney.sdk.kassa.payments.secure.i) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.secure.i(sharedPreferences));
    }
}
