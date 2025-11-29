package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class k0 implements Factory {
    public final j0 a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public k0(j0 j0Var, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = j0Var;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        j0 j0Var = this.a;
        SharedPreferences sharedPreferences = (SharedPreferences) this.b.get();
        ru.yoomoney.sdk.kassa.payments.secure.g encrypter = (ru.yoomoney.sdk.kassa.payments.secure.g) this.c.get();
        ru.yoomoney.sdk.kassa.payments.secure.f decrypter = (ru.yoomoney.sdk.kassa.payments.secure.f) this.d.get();
        j0Var.getClass();
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(encrypter, "encrypter");
        Intrinsics.checkNotNullParameter(decrypter, "decrypter");
        ru.yoomoney.sdk.kassa.payments.secure.j jVar = new ru.yoomoney.sdk.kassa.payments.secure.j(sharedPreferences, encrypter, decrypter);
        if (j0Var.a) {
            jVar.d = null;
            ru.yoomoney.sdk.kassa.payments.extensions.k.a(sharedPreferences, "paymentAuthToken", null);
            ru.yoomoney.sdk.kassa.payments.extensions.k.a(sharedPreferences, "isYooUserRemember", null);
        }
        return (ru.yoomoney.sdk.kassa.payments.secure.j) Preconditions.checkNotNullFromProvides(jVar);
    }
}
