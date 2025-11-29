package com.yandex.metrica.impl.ob;

import android.util.SparseArray;
import com.yandex.metrica.impl.ob.C1018j8;
import com.yandex.metrica.impl.ob.X7;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class M7 {
    private final N7 a;
    private final P7 b;
    private final X7.b c;

    public M7(N7 n7, P7 p7, X7.b bVar) {
        this.a = n7;
        this.b = p7;
        this.c = bVar;
    }

    public X7 a() {
        HashMap map = new HashMap();
        map.put("binary_data", C1018j8.b.a);
        return this.c.a("auto_inapp", this.a.a(), this.a.b(), new SparseArray<>(), new Z7("auto_inapp", map));
    }

    public X7 b() {
        HashMap map = new HashMap();
        map.put("preferences", C1018j8.c.a);
        return this.c.a("client storage", this.a.c(), this.a.d(), new SparseArray<>(), new Z7("metrica.db", map));
    }

    public X7 c() {
        return this.c.a("main", this.a.e(), this.a.f(), this.a.l(), new Z7("main", this.b.a()));
    }

    public X7 d() {
        HashMap map = new HashMap();
        map.put("preferences", C1018j8.c.a);
        return this.c.a("metrica_multiprocess.db", this.a.g(), this.a.h(), new SparseArray<>(), new Z7("metrica_multiprocess.db", map));
    }

    public X7 e() {
        HashMap map = new HashMap();
        List<String> list = C1018j8.c.a;
        map.put("preferences", list);
        map.put("binary_data", C1018j8.b.a);
        map.put("startup", list);
        List<String> list2 = C1018j8.a.a;
        map.put("l_dat", list2);
        map.put("lbs_dat", list2);
        return this.c.a("metrica.db", this.a.i(), this.a.j(), this.a.k(), new Z7("metrica.db", map));
    }
}
