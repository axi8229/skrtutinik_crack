package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2371b extends Lambda implements Function1 {
    public static final C2371b a = new C2371b();

    public C2371b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object u;
        ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C it = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(it, "<this>");
        if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.z) {
            return W.a;
        }
        if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B b = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B) it;
            u = new Y(b.a, b.b);
        } else if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w wVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w) it;
            u = new T(wVar.b, wVar.a);
        } else if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A a2 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A) it;
            u = new X(a2.a, a2.b);
        } else if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v vVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v) it;
            u = new S(vVar.a, vVar.b, vVar.c, vVar.d);
        } else if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t tVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.t) it;
            u = new P(tVar.a, tVar.b);
        } else if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.u) {
            u = new Q(((ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.u) it).a);
        } else if (it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.y) {
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.y yVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.y) it;
            u = new V(yVar.a, yVar.b, yVar.c);
        } else {
            if (!(it instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.x)) {
                throw new NoWhenBranchMatchedException();
            }
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.x xVar = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.x) it;
            u = new U(xVar.a, xVar.b, xVar.c);
        }
        return u;
    }
}
