package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2474f;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.InterfaceC2468d;

/* loaded from: classes5.dex */
public final class K implements Factory {
    public final J a;
    public final Provider b;

    public K(J j, dagger.internal.Provider provider) {
        this.a = j;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        J j = this.a;
        ru.yoomoney.sdk.kassa.payments.config.f configRepository = (ru.yoomoney.sdk.kassa.payments.config.f) this.b.get();
        j.getClass();
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        return (InterfaceC2468d) Preconditions.checkNotNullFromProvides(new C2474f(configRepository));
    }
}
