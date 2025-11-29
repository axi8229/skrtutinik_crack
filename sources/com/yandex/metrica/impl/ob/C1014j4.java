package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.yandex.metrica.impl.ob.j4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1014j4 {
    private final Object a;
    private final C1164p4 b;
    private final HashMap<C0990i4, InterfaceC1039k4> c;
    private final C1229rm<a, C0990i4> d;
    private final Context e;
    private volatile int f;
    private final C1089m4 g;

    /* renamed from: com.yandex.metrica.impl.ob.j4$a */
    private static final class a {
        private final String a;
        private final Integer b;
        private final String c;

        a(String str, Integer num, String str2) {
            this.a = str;
            this.b = num;
            this.c = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.a.equals(aVar.a)) {
                return false;
            }
            Integer num = this.b;
            if (num == null ? aVar.b != null : !num.equals(aVar.b)) {
                return false;
            }
            String str = this.c;
            String str2 = aVar.c;
            return str != null ? str.equals(str2) : str2 == null;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            Integer num = this.b;
            int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.c;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }
    }

    public C1014j4(Context context, C1164p4 c1164p4) {
        this(context, c1164p4, new C1089m4());
    }

    public InterfaceC1039k4 a(C0990i4 c0990i4, D3 d3) {
        InterfaceC1039k4 interfaceC1039k4A;
        synchronized (this.a) {
            try {
                interfaceC1039k4A = this.c.get(c0990i4);
                if (interfaceC1039k4A == null) {
                    interfaceC1039k4A = this.g.a(c0990i4).a(this.e, this.b, c0990i4, d3);
                    this.c.put(c0990i4, interfaceC1039k4A);
                    this.d.a(new a(c0990i4.b(), c0990i4.c(), c0990i4.d()), c0990i4);
                    this.f++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC1039k4A;
    }

    C1014j4(Context context, C1164p4 c1164p4, C1089m4 c1089m4) {
        this.a = new Object();
        this.c = new HashMap<>();
        this.d = new C1229rm<>();
        this.f = 0;
        this.e = context.getApplicationContext();
        this.b = c1164p4;
        this.g = c1089m4;
    }

    public void a(String str, int i, String str2) {
        Integer numValueOf = Integer.valueOf(i);
        synchronized (this.a) {
            try {
                Collection<C0990i4> collectionB = this.d.b(new a(str, numValueOf, str2));
                if (!A2.b(collectionB)) {
                    this.f -= collectionB.size();
                    ArrayList arrayList = new ArrayList(collectionB.size());
                    Iterator<C0990i4> it = collectionB.iterator();
                    while (it.hasNext()) {
                        arrayList.add(this.c.remove(it.next()));
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((InterfaceC1039k4) it2.next()).a();
                    }
                }
            } finally {
            }
        }
    }
}
