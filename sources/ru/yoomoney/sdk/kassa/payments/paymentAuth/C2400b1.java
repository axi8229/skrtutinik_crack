package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.b1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2400b1 extends Lambda implements Function1 {
    public static final C2400b1 a = new C2400b1();

    public C2400b1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object z1Var;
        O it = (O) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(it, "<this>");
        if (it instanceof K) {
            return w1.a;
        }
        if (it instanceof M) {
            z1Var = new y1(((M) it).a);
        } else if (it instanceof H) {
            z1Var = new t1(((H) it).a);
        } else if (it instanceof I) {
            I i = (I) it;
            z1Var = new u1(i.a, i.b);
        } else if (it instanceof J) {
            J j = (J) it;
            z1Var = new v1(j.a, j.b);
        } else if (it instanceof L) {
            L l = (L) it;
            z1Var = new x1(l.a, l.b);
        } else {
            if (!(it instanceof N)) {
                throw new NoWhenBranchMatchedException();
            }
            N n = (N) it;
            z1Var = new z1(n.a, n.b, n.c);
        }
        return z1Var;
    }
}
