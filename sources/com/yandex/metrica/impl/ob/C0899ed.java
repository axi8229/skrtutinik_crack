package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.impl.ob.C1175pf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.ed, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0899ed {
    private final U7 a;
    private final T7 b;
    private final C0824bd c;
    private final Zc d;

    public C0899ed(Context context) {
        this(C1020ja.a(context).f(), C1020ja.a(context).e(), new Vb(context), new C0799ad(), new Yc());
    }

    public C0874dd a(int i) {
        Map<Long, String> mapA = this.a.a(i);
        Map<Long, String> mapA2 = this.b.a(i);
        C1175pf c1175pf = new C1175pf();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = (LinkedHashMap) mapA;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            C1175pf.b bVarA = this.c.a(((Long) entry.getKey()).longValue(), (String) entry.getValue());
            if (bVarA != null) {
                arrayList.add(bVarA);
            }
        }
        c1175pf.a = (C1175pf.b[]) arrayList.toArray(new C1175pf.b[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) mapA2;
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            C1175pf.a aVarA = this.d.a(((Long) entry2.getKey()).longValue(), (String) entry2.getValue());
            if (aVarA != null) {
                arrayList2.add(aVarA);
            }
        }
        c1175pf.b = (C1175pf.a[]) arrayList2.toArray(new C1175pf.a[arrayList2.size()]);
        return new C0874dd(mapA.isEmpty() ? -1L : ((Long) Collections.max(linkedHashMap.keySet())).longValue(), mapA2.isEmpty() ? -1L : ((Long) Collections.max(linkedHashMap2.keySet())).longValue(), c1175pf);
    }

    C0899ed(U7 u7, T7 t7, Vb vb, C0799ad c0799ad, Yc yc) {
        this(u7, t7, new C0824bd(vb, c0799ad), new Zc(vb, yc));
    }

    C0899ed(U7 u7, T7 t7, C0824bd c0824bd, Zc zc) {
        this.a = u7;
        this.b = t7;
        this.c = c0824bd;
        this.d = zc;
    }

    public void a(C0874dd c0874dd) {
        long j = c0874dd.a;
        if (j >= 0) {
            this.a.c(j);
        }
        long j2 = c0874dd.b;
        if (j2 >= 0) {
            this.b.c(j2);
        }
    }
}
