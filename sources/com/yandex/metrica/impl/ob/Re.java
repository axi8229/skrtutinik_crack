package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1318vf;

/* loaded from: classes3.dex */
public class Re implements Je {
    private final Wm a;

    public Re(Wm wm) {
        this.a = wm;
    }

    @Override // com.yandex.metrica.impl.ob.Je
    public C1318vf.a a(C0801af c0801af, C1318vf.a aVar) {
        if (c0801af.a() == this.a.a()) {
            if (c0801af.a(aVar.b, new String(aVar.a)) != null) {
                c0801af.a(aVar);
            }
        } else if (c0801af.a() < this.a.a()) {
            c0801af.a(aVar);
            c0801af.b();
        }
        return aVar;
    }
}
