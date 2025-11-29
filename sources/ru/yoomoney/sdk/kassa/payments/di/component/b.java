package ru.yoomoney.sdk.kassa.payments.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Provider;
import ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.Y;
import ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.Z;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.s;
import ru.yoomoney.sdk.kassa.payments.confirmation.sbp.t;
import ru.yoomoney.sdk.kassa.payments.di.module.A;
import ru.yoomoney.sdk.kassa.payments.di.module.B;
import ru.yoomoney.sdk.kassa.payments.di.module.C;
import ru.yoomoney.sdk.kassa.payments.di.module.D;
import ru.yoomoney.sdk.kassa.payments.di.module.E;
import ru.yoomoney.sdk.kassa.payments.di.module.U;
import ru.yoomoney.sdk.kassa.payments.di.module.V;
import ru.yoomoney.sdk.kassa.payments.di.module.W;
import ru.yoomoney.sdk.kassa.payments.di.module.X;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.x0;
import ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.y0;

/* loaded from: classes5.dex */
public final class b {
    public final c a;
    public Factory b;
    public Factory c;
    public Provider d;
    public Factory e;

    public b(c cVar, U u, A a) {
        this.a = cVar;
        a(u, a);
    }

    public final void a(U u, A a) {
        this.b = InstanceFactory.create(new s(new t(DoubleCheck.provider(new C(a, DoubleCheck.provider(new B(a, this.a.C)))))));
        this.c = InstanceFactory.create(new Y(new Z(DoubleCheck.provider(new D(a, DoubleCheck.provider(new E(a, this.a.C)))))));
        c cVar = this.a;
        Provider provider = DoubleCheck.provider(new V(u, this.a.d, DoubleCheck.provider(new W(u, DoubleCheck.provider(new X(u, cVar.z, cVar.B, cVar.x)), this.a.C))));
        this.d = provider;
        this.e = InstanceFactory.create(new x0(new y0(this.a.m, provider)));
    }
}
