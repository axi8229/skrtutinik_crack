package ru.yoomoney.sdk.kassa.payments.userAuth.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ru.yoomoney.sdk.kassa.payments.metrics.V;

/* loaded from: classes5.dex */
public final class h implements Factory {
    public final d a;

    public h(d dVar) {
        this.a = dVar;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        this.a.getClass();
        return (V) Preconditions.checkNotNullFromProvides(new V());
    }
}
