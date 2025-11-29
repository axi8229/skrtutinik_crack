package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.in, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1008in<T> extends AbstractC0984hn {
    private final AbstractC0984hn b;

    public C1008in(int i) {
        this(i, null);
    }

    protected int b(T t) {
        throw null;
    }

    public C1008in(int i, AbstractC0984hn abstractC0984hn) {
        super(i);
        this.b = abstractC0984hn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.metrica.impl.ob.AbstractC0984hn
    public C0959gn<List<T>, Xm> a(List<T> list) {
        int iB;
        int i = 0;
        if (list == null || (list.size() <= a() && this.b == null)) {
            iB = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            iB = 0;
            int i2 = 0;
            for (T t : list) {
                if (i2 < a()) {
                    AbstractC0984hn abstractC0984hn = this.b;
                    if (abstractC0984hn != null) {
                        C0959gn<Object, Vm> c0959gnA = abstractC0984hn.a(t);
                        Object obj = c0959gnA.a;
                        iB += c0959gnA.b.a();
                        t = obj;
                    }
                    arrayList.add(t);
                } else {
                    i++;
                    iB += b(t);
                }
                i2++;
            }
            list = arrayList;
        }
        return new C0959gn<>(list, new Xm(i, iB));
    }
}
