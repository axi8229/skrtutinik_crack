package com.yandex.metrica.impl.ob;

import java.util.LinkedList;

/* loaded from: classes3.dex */
public class J4 extends K4<X4> {
    private final C0966h5 a;
    private final K5 b;
    private final C0866d5 c;

    public J4(L3 l3) {
        this.a = new C0966h5(l3);
        this.b = new K5(l3);
        this.c = new C0866d5(l3);
    }

    @Override // com.yandex.metrica.impl.ob.K4
    public H4 a(int i) {
        LinkedList linkedList = new LinkedList();
        int iOrdinal = EnumC0787a1.a(i).ordinal();
        if (iOrdinal == 1) {
            linkedList.add(this.a);
        } else if (iOrdinal == 3) {
            linkedList.add(this.c);
        } else if (iOrdinal == 40) {
            linkedList.add(this.b);
            linkedList.add(this.a);
        }
        return new H4(linkedList);
    }
}
