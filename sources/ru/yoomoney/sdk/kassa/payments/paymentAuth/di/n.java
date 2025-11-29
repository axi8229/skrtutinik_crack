package ru.yoomoney.sdk.kassa.payments.paymentAuth.di;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.metrics.F;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.E1;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.H1;
import ru.yoomoney.sdk.march.CodeKt;

/* loaded from: classes5.dex */
public final class n implements Factory {
    public final f a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public n(f fVar, dagger.internal.Provider provider, dagger.internal.Provider provider2, dagger.internal.Provider provider3) {
        this.a = fVar;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        f fVar = this.a;
        H1 requestPaymentAuthUseCase = (H1) this.b.get();
        E1 processPaymentAuthUseCase = (E1) this.c.get();
        F reporter = (F) this.d.get();
        fVar.getClass();
        Intrinsics.checkNotNullParameter(requestPaymentAuthUseCase, "requestPaymentAuthUseCase");
        Intrinsics.checkNotNullParameter(processPaymentAuthUseCase, "processPaymentAuthUseCase");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        return (ViewModel) Preconditions.checkNotNullFromProvides(CodeKt.RuntimeViewModel$default("PaymentAuth", d.a, new e(reporter, processPaymentAuthUseCase, requestPaymentAuthUseCase), null, null, null, null, null, null, null, null, 2040, null));
    }
}
