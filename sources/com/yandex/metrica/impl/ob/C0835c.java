package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0835c implements InterfaceC1059l {
    private boolean a;
    private final InterfaceC1109n b;
    private final Map<String, com.yandex.metrica.billing_interface.a> c = new HashMap();

    public C0835c(InterfaceC1109n interfaceC1109n) {
        C0839c3 c0839c3 = (C0839c3) interfaceC1109n;
        for (com.yandex.metrica.billing_interface.a aVar : c0839c3.a()) {
            this.c.put(aVar.b, aVar);
        }
        this.a = c0839c3.b();
        this.b = c0839c3;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public void a(Map<String, com.yandex.metrica.billing_interface.a> map) {
        for (com.yandex.metrica.billing_interface.a aVar : map.values()) {
            this.c.put(aVar.b, aVar);
        }
        ((C0839c3) this.b).a(new ArrayList(this.c.values()), this.a);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public void b() {
        if (this.a) {
            return;
        }
        this.a = true;
        ((C0839c3) this.b).a(new ArrayList(this.c.values()), this.a);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public com.yandex.metrica.billing_interface.a a(String str) {
        return this.c.get(str);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1059l
    public boolean a() {
        return this.a;
    }
}
