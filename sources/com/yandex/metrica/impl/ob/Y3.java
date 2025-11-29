package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.P3;
import com.yandex.metrica.impl.ob.S3;

/* loaded from: classes3.dex */
public class Y3<COMPONENT extends S3 & P3> implements N3<X3> {
    private final InterfaceC1139o4<COMPONENT> a;

    public Y3(InterfaceC1139o4<COMPONENT> interfaceC1139o4) {
        this.a = interfaceC1139o4;
    }

    @Override // com.yandex.metrica.impl.ob.N3
    public R3 a(Context context, I3 i3, D3 d3) {
        return new X3(context, i3, d3, new C0840c4(d3.b), this.a, new J3(), C0904ei.a());
    }
}
