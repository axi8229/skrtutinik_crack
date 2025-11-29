package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;

/* renamed from: com.yandex.metrica.impl.ob.l1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1061l1 extends B {
    C1061l1(Context context, A3 a3, com.yandex.metrica.e eVar, T1 t1) {
        this(context, a3, eVar, t1, new A0(context));
    }

    private C1061l1(Context context, A3 a3, com.yandex.metrica.e eVar, T1 t1, A0 a0) {
        this(context, t1, eVar, new Q1(a3, new CounterConfiguration(eVar), eVar.userProfileID), a0, P.g().j(), new Zg(), new Yg(null, null), new X6(), new S6(), new M6(), new K6(), new C1237s6(a0), P.g().k());
    }

    C1061l1(Context context, T1 t1, com.yandex.metrica.e eVar, Q1 q1, A0 a0, InterfaceC0833bm interfaceC0833bm, Zg zg, Yg yg, X6 x6, S6 s6, M6 m6, K6 k6, C1237s6 c1237s6, C1415zg c1415zg) {
        super(context, t1, q1, a0, interfaceC0833bm, zg.a(t1.b(), eVar.apiKey, false), yg, x6, s6, m6, k6, c1237s6);
        c1415zg.a(eVar.apiKey, new Ag(eVar, t1));
    }
}
