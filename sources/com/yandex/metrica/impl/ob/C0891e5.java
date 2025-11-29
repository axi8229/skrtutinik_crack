package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.impl.ob.InterfaceC0921fa;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.e5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0891e5 extends X4 {
    private final Cd b;
    private final ProtobufStateStorage c;
    private final A d;
    private final C1302v e;
    private final C1350x f;

    public C0891e5(L3 l3, Cd cd) {
        this(l3, cd, InterfaceC0921fa.b.a(C1268td.class).a(l3.g()), new A(l3.g()), new C1302v(), new C1350x(l3.g()));
    }

    @Override // com.yandex.metrica.impl.ob.S4
    public boolean a(C0836c0 c0836c0) {
        C1268td c1268td;
        L3 l3A = a();
        l3A.e().toString();
        if (!l3A.x().k() || !l3A.A()) {
            return false;
        }
        C1268td c1268td2 = (C1268td) this.c.read();
        List<Bd> list = c1268td2.a;
        C1398z c1398z = c1268td2.b;
        C1398z c1398zA = this.d.a();
        List<String> list2 = c1268td2.c;
        List<String> listA = this.f.a();
        List<Bd> listA2 = this.b.a(a().g(), list);
        if (listA2 == null && A2.a(c1398z, c1398zA) && C0810b.a(list2, listA)) {
            c1268td = null;
        } else {
            if (listA2 != null) {
                list = listA2;
            }
            c1268td = new C1268td(list, c1398zA, listA);
        }
        if (c1268td != null) {
            l3A.r().e(C0836c0.a(c0836c0, c1268td.a, c1268td.b, this.e, c1268td.c));
            this.c.save(c1268td);
            return false;
        }
        if (!l3A.E()) {
            return false;
        }
        l3A.r().e(C0836c0.a(c0836c0, c1268td2.a, c1268td2.b, this.e, c1268td2.c));
        return false;
    }

    C0891e5(L3 l3, Cd cd, ProtobufStateStorage protobufStateStorage, A a, C1302v c1302v, C1350x c1350x) {
        super(l3);
        this.b = cd;
        this.c = protobufStateStorage;
        this.d = a;
        this.e = c1302v;
        this.f = c1350x;
    }
}
