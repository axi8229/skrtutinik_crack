package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.H1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.J1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.s1;

/* loaded from: classes5.dex */
public final class m implements Factory {
    public final f a;
    public final Provider b;

    public m(f fVar, dagger.internal.Provider provider) {
        this.a = fVar;
        this.b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        f fVar = this.a;
        s1 paymentAuthTypeRepository = (s1) this.b.get();
        fVar.getClass();
        Intrinsics.checkNotNullParameter(paymentAuthTypeRepository, "paymentAuthTypeRepository");
        return (H1) Preconditions.checkNotNullFromProvides(new J1(paymentAuthTypeRepository));
    }
}
