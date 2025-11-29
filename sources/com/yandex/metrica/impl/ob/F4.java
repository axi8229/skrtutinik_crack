package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.P3;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class F4<T, C extends P3> {
    private final K4<T> a;

    protected interface a<T> {
        boolean a(T t, C0836c0 c0836c0);
    }

    protected F4(K4<T> k4, C c) {
        this.a = k4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean a(C0836c0 c0836c0, a<T> aVar) {
        Iterator<Object> it = this.a.a(c0836c0.o()).a().iterator();
        while (it.hasNext()) {
            if (aVar.a(it.next(), c0836c0)) {
                return true;
            }
        }
        return false;
    }
}
