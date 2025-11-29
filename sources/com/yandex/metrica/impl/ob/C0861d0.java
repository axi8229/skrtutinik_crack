package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;

/* renamed from: com.yandex.metrica.impl.ob.d0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0861d0 extends B {
    private final C1116n6 p;
    private final C1309v6 q;

    C0861d0(Context context, A3 a3, com.yandex.metrica.i iVar, T1 t1) {
        this(context, a3, iVar, t1, new A0(context));
    }

    @Override // com.yandex.metrica.impl.ob.B, com.yandex.metrica.impl.ob.R0
    public void a(H6 h6) {
        this.p.a(this.q.a(h6, this.b));
        b(h6);
    }

    private C0861d0(Context context, A3 a3, com.yandex.metrica.i iVar, T1 t1, A0 a0) {
        this(context, t1, new Q1(a3, new CounterConfiguration(iVar, CounterConfiguration.b.CRASH), iVar.userProfileID), a0, new C1116n6(context), new C1309v6(), P.g().j(), new Ug(), new Yg(null, null), new X6(), new S6(), new M6(), new K6(), new C1237s6(a0));
    }

    C0861d0(Context context, T1 t1, Q1 q1, A0 a0, C1116n6 c1116n6, C1309v6 c1309v6, InterfaceC0833bm interfaceC0833bm, com.yandex.metrica.rtm.wrapper.d dVar, Yg yg, X6 x6, S6 s6, M6 m6, K6 k6, C1237s6 c1237s6) {
        super(context, t1, q1, a0, interfaceC0833bm, dVar, yg, x6, s6, m6, k6, c1237s6);
        this.p = c1116n6;
        this.q = c1309v6;
    }
}
