package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.D3;

/* renamed from: com.yandex.metrica.impl.ob.h4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0965h4 extends C1283u4 {
    C0965h4() {
    }

    @Override // com.yandex.metrica.impl.ob.C1283u4, com.yandex.metrica.impl.ob.InterfaceC1139o4
    public S3 a(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new C3(context, c1225ri.d(), i3, aVar, new C0890e4(F0.g().u()), new C1417zi());
    }

    @Override // com.yandex.metrica.impl.ob.C1283u4, com.yandex.metrica.impl.ob.InterfaceC1139o4
    public Q3 b(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new C1403z4(context, i3, aVar, c1225ri.d(), new C1417zi(), CounterConfiguration.b.APPMETRICA);
    }

    @Override // com.yandex.metrica.impl.ob.C1283u4
    /* renamed from: c */
    public L3 a(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new C3(context, c1225ri.d(), i3, aVar, new C0890e4(F0.g().u()), new C1417zi());
    }

    @Override // com.yandex.metrica.impl.ob.C1283u4
    /* renamed from: d */
    public C1403z4 b(Context context, I3 i3, D3.a aVar, C1225ri c1225ri) {
        return new C1403z4(context, i3, aVar, c1225ri.d(), new C1417zi(), CounterConfiguration.b.APPMETRICA);
    }
}
