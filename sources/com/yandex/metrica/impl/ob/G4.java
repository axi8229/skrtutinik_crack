package com.yandex.metrica.impl.ob;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public class G4 extends K4<M4> {
    private final C1284u5 a;

    public G4(F3 f3) {
        this.a = new C1284u5(f3);
    }

    @Override // com.yandex.metrica.impl.ob.K4
    public H4 a(int i) {
        ArrayList arrayList = new ArrayList();
        int iOrdinal = EnumC0787a1.a(i).ordinal();
        if (iOrdinal == 16) {
            arrayList.add(this.a.a());
        } else if (iOrdinal == 24) {
            arrayList.add(this.a.b());
        } else if (iOrdinal == 47) {
            arrayList.add(this.a.c());
        }
        return new H4(arrayList);
    }
}
