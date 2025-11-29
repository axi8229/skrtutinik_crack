package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.F4;
import com.yandex.metrica.impl.ob.L3;
import com.yandex.metrica.impl.ob.S4;

/* loaded from: classes3.dex */
public class L4<T extends S4, C extends L3> extends F4<T, C> {

    class a implements F4.a<T> {
        a(L4 l4) {
        }

        @Override // com.yandex.metrica.impl.ob.F4.a
        public boolean a(Object obj, C0836c0 c0836c0) {
            return ((S4) obj).a(c0836c0);
        }
    }

    public L4(K4<T> k4, C c) {
        super(k4, c);
    }

    public boolean a(C0836c0 c0836c0) {
        return a(c0836c0, new a(this));
    }
}
