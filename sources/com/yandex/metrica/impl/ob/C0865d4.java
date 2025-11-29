package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.D3;

/* renamed from: com.yandex.metrica.impl.ob.d4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0865d4 extends L3 {
    private final String A;
    private final C1233s2 B;

    public C0865d4(Context context, I3 i3, D3.a aVar, C1233s2 c1233s2, C1178pi c1178pi, AbstractC1321vi abstractC1321vi) {
        this(context, i3, new B3(), new C1353x2(), new M3(context, i3, aVar, abstractC1321vi, c1178pi, new C0815b4(c1233s2), F0.g().q().d(), A2.b(context, i3.b()), F0.g().h()), c1233s2);
    }

    @Override // com.yandex.metrica.impl.ob.L3, com.yandex.metrica.impl.ob.S3
    public synchronized void a(D3.a aVar) {
        super.a(aVar);
        this.B.a(this.A, aVar.l);
    }

    C0865d4(Context context, I3 i3, B3 b3, C1353x2 c1353x2, M3 m3, C1233s2 c1233s2) {
        super(context, i3, b3, c1353x2, m3);
        this.A = i3.a();
        this.B = c1233s2;
    }
}
