package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.U1;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.v6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1309v6 {
    private final N6 a;

    public C1309v6() {
        this(new N6());
    }

    public U1.f a(H6 h6, Q1 q1) {
        String strB;
        F6 f6 = h6.a;
        String str = "";
        if (f6 != null && (strB = f6.b()) != null) {
            str = strB;
        }
        byte[] bArrA = this.a.a(h6);
        C0858cm c0858cmB = Ul.b(q1.b().a());
        List<Integer> list = C1399z0.i;
        J j = new J(bArrA, str, EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_PROTOBUF.b(), c0858cmB);
        j.c(q1.d());
        return new U1.f(j, q1).a(j.t()).a(true);
    }

    C1309v6(N6 n6) {
        this.a = n6;
    }
}
