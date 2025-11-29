package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1318vf;

/* loaded from: classes3.dex */
public class Ye extends Ne<String> {
    private final InterfaceC0934fn<String> g;

    public Ye(String str, String str2, InterfaceC0934fn<String> interfaceC0934fn, Kn<String> kn, Ke ke) {
        super(0, str, str2, kn, ke);
        this.g = interfaceC0934fn;
    }

    @Override // com.yandex.metrica.impl.ob.Ne
    protected void a(C1318vf.a aVar) {
        String strA = this.g.a(f());
        aVar.d.a = strA == null ? new byte[0] : strA.getBytes();
    }
}
