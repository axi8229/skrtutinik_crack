package bz;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import npi.spay.Rj;

/* loaded from: classes.dex */
public final class H1 {
    public final Context a;
    public final zone.bi.mobile.fingerprint.api.settings.a b;
    public final InterfaceC0544p1 c;
    public final C0573z1 d;
    public final TreeMap f = a();
    public final ArrayList e = b();

    public H1(Context context, zone.bi.mobile.fingerprint.api.settings.a aVar, C0519h1 c0519h1, C0573z1 c0573z1, Y1 y1) {
        this.a = context;
        this.b = aVar;
        this.c = c0519h1;
        this.d = c0573z1;
    }

    public final TreeMap a() {
        TreeMap treeMap = new TreeMap(new zone.bi.mobile.fingerprint.api.e());
        Rj rj = (Rj) this.b;
        rj.getClass();
        Iterator it = new HashSet(rj.b).iterator();
        while (it.hasNext()) {
            zone.bi.mobile.fingerprint.api.f fVar = (zone.bi.mobile.fingerprint.api.f) it.next();
            Context context = this.a;
            zone.bi.mobile.fingerprint.api.settings.a aVar = this.b;
            InterfaceC0544p1 interfaceC0544p1 = this.c;
            C0573z1 c0573z1 = this.d;
            ((Rj) aVar).getClass();
            zone.bi.mobile.fingerprint.api.b bVar = zone.bi.mobile.fingerprint.api.b.b;
            this.b.getClass();
            treeMap.put(fVar, E0.a(fVar, context, aVar, interfaceC0544p1, c0573z1, bVar));
        }
        return treeMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList b() throws ClassNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0538n1 abstractC0538n1 : this.f.values()) {
            if (abstractC0538n1 instanceof S0) {
                if (abstractC0538n1 instanceof B0) {
                    try {
                        abstractC0538n1.j();
                    } catch (C0564w1 unused) {
                    }
                }
                arrayList.add((S0) abstractC0538n1);
            }
        }
        return arrayList;
    }

    public final void finalize() throws Throwable {
        try {
            for (Object obj : this.f.values()) {
                if (obj instanceof U1) {
                    ((U1) obj).d();
                }
            }
        } finally {
            super.finalize();
        }
    }
}
