package com.yandex.metrica.impl.ob;

import android.util.SparseArray;
import com.yandex.metrica.impl.ob.C1318vf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.yandex.metrica.impl.ob.af, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0801af {
    private static final int[] c = {0, 1, 2, 3};
    private final SparseArray<HashMap<String, C1318vf.a>> a;
    private int b;

    public C0801af() {
        this(c);
    }

    public C1318vf.a a(int i, String str) {
        return this.a.get(i).get(str);
    }

    public void b() {
        this.b++;
    }

    public C1318vf c() {
        C1318vf c1318vf = new C1318vf();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            SparseArray<HashMap<String, C1318vf.a>> sparseArray = this.a;
            Iterator<C1318vf.a> it = sparseArray.get(sparseArray.keyAt(i)).values().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        c1318vf.a = (C1318vf.a[]) arrayList.toArray(new C1318vf.a[arrayList.size()]);
        return c1318vf;
    }

    C0801af(int[] iArr) {
        this.a = new SparseArray<>();
        this.b = 0;
        for (int i : iArr) {
            this.a.put(i, new HashMap<>());
        }
    }

    void a(C1318vf.a aVar) {
        this.a.get(aVar.b).put(new String(aVar.a), aVar);
    }

    public int a() {
        return this.b;
    }
}
