package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1366xf;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Y2 implements ProtobufConverter {
    private final C0789a3 a;

    public Y2() {
        this(new C0789a3());
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        X2 x2 = (X2) obj;
        C1366xf c1366xf = new C1366xf();
        c1366xf.a = new C1366xf.a[x2.a.size()];
        Iterator<com.yandex.metrica.billing_interface.a> it = x2.a.iterator();
        int i = 0;
        while (it.hasNext()) {
            c1366xf.a[i] = this.a.fromModel(it.next());
            i++;
        }
        c1366xf.b = x2.b;
        return c1366xf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        C1366xf c1366xf = (C1366xf) obj;
        ArrayList arrayList = new ArrayList(c1366xf.a.length);
        for (C1366xf.a aVar : c1366xf.a) {
            arrayList.add(this.a.toModel(aVar));
        }
        return new X2(arrayList, c1366xf.b);
    }

    Y2(C0789a3 c0789a3) {
        this.a = c0789a3;
    }
}
