package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.C1298uj;

/* renamed from: com.yandex.metrica.impl.ob.xj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1370xj {
    private boolean a(Integer num) {
        return (num == null || num.intValue() == Integer.MAX_VALUE) ? false : true;
    }

    public C1298uj a(C1298uj c1298uj) {
        C1298uj.a aVar = new C1298uj.a();
        aVar.a(c1298uj.c());
        if (a(c1298uj.p())) {
            aVar.l(c1298uj.p());
        }
        if (a(c1298uj.k())) {
            aVar.i(c1298uj.k());
        }
        if (a(c1298uj.l())) {
            aVar.j(c1298uj.l());
        }
        if (a(c1298uj.e())) {
            aVar.c(c1298uj.e());
        }
        if (a(c1298uj.b())) {
            aVar.b(c1298uj.b());
        }
        if (!TextUtils.isEmpty(c1298uj.n())) {
            aVar.b(c1298uj.n());
        }
        if (!TextUtils.isEmpty(c1298uj.m())) {
            aVar.a(c1298uj.m());
        }
        aVar.a(c1298uj.q());
        if (a(c1298uj.o())) {
            aVar.k(c1298uj.o());
        }
        aVar.a(c1298uj.d());
        if (a(c1298uj.h())) {
            aVar.f(c1298uj.h());
        }
        if (a(c1298uj.j())) {
            aVar.h(c1298uj.j());
        }
        if (a(c1298uj.a())) {
            aVar.a(c1298uj.a());
        }
        if (a(c1298uj.i())) {
            aVar.g(c1298uj.i());
        }
        if (a(c1298uj.f())) {
            aVar.d(c1298uj.f());
        }
        if (a(c1298uj.g())) {
            aVar.e(c1298uj.g());
        }
        return new C1298uj(aVar);
    }
}
