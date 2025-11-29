package ru.yoomoney.sdk.kassa.payments.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.M1;
import ru.yoomoney.sdk.kassa.payments.paymentOptionList.N1;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2287v implements Factory {
    public final r a;

    public C2287v(r rVar) {
        this.a = rVar;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (M1) Preconditions.checkNotNullFromProvides(new N1());
    }
}
