package ru.yoomoney.sdk.kassa.payments.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters;

/* renamed from: ru.yoomoney.sdk.kassa.payments.di.module.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2281o implements Factory {
    public final C2280n a;
    public final Provider b;
    public final Provider c;

    public C2281o(C2280n c2280n, Factory factory, dagger.internal.Provider provider) {
        this.a = c2280n;
        this.b = factory;
        this.c = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        C2280n c2280n = this.a;
        Context context = (Context) this.b.get();
        PaymentParameters paymentParameters = (PaymentParameters) this.c.get();
        c2280n.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentParameters, "paymentParameters");
        return (ru.yoomoney.sdk.kassa.payments.model.B) Preconditions.checkNotNullFromProvides(new C2279m(context, paymentParameters));
    }
}
