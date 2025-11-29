package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.fb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0922fb extends C1008in<Sa> {
    public C0922fb(int i) {
        super(i);
    }

    @Override // com.yandex.metrica.impl.ob.C1008in
    protected int b(Sa sa) {
        Sa sa2 = sa;
        if (sa2 == null) {
            return 0;
        }
        return C0810b.b(sa2.b).length + 12;
    }
}
