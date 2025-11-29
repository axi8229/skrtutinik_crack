package ru.yoomoney.sdk.kassa.payments.unbind.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.unbind.impl.x;
import ru.yoomoney.sdk.march.CodeKt;

/* loaded from: classes5.dex */
public final class f implements Factory {
    public final c a;
    public final Provider b;
    public final Provider c;

    public f(c cVar, dagger.internal.Provider provider, dagger.internal.Provider provider2) {
        this.a = cVar;
        this.b = provider;
        this.c = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        c cVar = this.a;
        F reporter = (F) this.b.get();
        x unbindCardUseCase = (x) this.c.get();
        cVar.getClass();
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(unbindCardUseCase, "unbindCardUseCase");
        return (ViewModel) Preconditions.checkNotNullFromProvides(CodeKt.RuntimeViewModel$default("UNBIND_CARD", a.a, new b(reporter, unbindCardUseCase), null, null, null, null, null, null, null, null, 2040, null));
    }
}
