package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.D3;

/* renamed from: com.yandex.metrica.impl.ob.u4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1283u4 implements InterfaceC1064l4, InterfaceC1139o4<L3> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1139o4
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public L3 a(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new C0865d4(context, i3, aVar, F0.g().u(), c1225ri.d(), new C1345wi(c1225ri));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1139o4
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C1403z4 b(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new C1403z4(context, i3, aVar, c1225ri.d(), new C1345wi(c1225ri), CounterConfiguration.b.MANUAL);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1064l4
    public InterfaceC1039k4 a(Context context, C1164p4 c1164p4, C0990i4 c0990i4, D3 d3) {
        return new C1259t4(context, c1164p4.b(new I3(c0990i4.b(), c0990i4.a()), d3, new Y3(this)));
    }
}
