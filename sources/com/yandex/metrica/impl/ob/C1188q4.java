package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.D3;

/* renamed from: com.yandex.metrica.impl.ob.q4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1188q4 implements InterfaceC1064l4, InterfaceC1139o4<U3> {
    C1188q4() {
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1064l4
    public InterfaceC1039k4 a(Context context, C1164p4 c1164p4, C0990i4 c0990i4, D3 d3) {
        return new C1211r4(context, c1164p4.b(new W3(c0990i4.b(), c0990i4.a()), d3, new Y3(this)));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1139o4
    public Q3 b(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new C1403z4(context, i3, aVar, c1225ri.d(), new C1345wi(c1225ri), CounterConfiguration.b.MAIN);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1139o4
    public S3 a(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new U3(context, c1225ri.d(), i3, aVar, F0.g().m(), F0.g().u(), new C1345wi(c1225ri));
    }
}
