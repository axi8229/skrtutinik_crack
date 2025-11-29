package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f0 implements Factory {
    public final e0 a;
    public final Provider b;
    public final Provider c;

    public f0(e0 e0Var, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = e0Var;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        e0 e0Var = this.a;
        ru.yoomoney.sdk.kassa.payments.secure.i ivStorage = (ru.yoomoney.sdk.kassa.payments.secure.i) this.b.get();
        ru.yoomoney.sdk.kassa.payments.secure.a keyStorage = (ru.yoomoney.sdk.kassa.payments.secure.a) this.c.get();
        e0Var.getClass();
        Intrinsics.checkNotNullParameter(ivStorage, "ivStorage");
        Intrinsics.checkNotNullParameter(keyStorage, "keyStorage");
        return (ru.yoomoney.sdk.kassa.payments.secure.f) Preconditions.checkNotNullFromProvides(new ru.yoomoney.sdk.kassa.payments.secure.f(new a0(keyStorage), new b0(ivStorage)));
    }
}
