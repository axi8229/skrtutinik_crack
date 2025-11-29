package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1247sg;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.yandex.metrica.impl.ob.ug, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1295ug implements C1247sg.a {
    private final Set<InterfaceC0852cg> a;
    private boolean b;
    private C0877dg c;

    public C1295ug() {
        this(F0.g().m());
    }

    @Override // com.yandex.metrica.impl.ob.C1247sg.a
    public synchronized void a(C0877dg c0877dg) {
        try {
            this.c = c0877dg;
            this.b = true;
            Iterator<InterfaceC0852cg> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a(this.c);
            }
            this.a.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    C1295ug(C1247sg c1247sg) {
        this.a = new HashSet();
        c1247sg.a(new C1391yg(this));
        c1247sg.b();
    }

    public synchronized void a(InterfaceC0852cg interfaceC0852cg) {
        this.a.add(interfaceC0852cg);
        if (this.b) {
            interfaceC0852cg.a(this.c);
            this.a.remove(interfaceC0852cg);
        }
    }
}
