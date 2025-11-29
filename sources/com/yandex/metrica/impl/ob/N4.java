package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.F3;
import com.yandex.metrica.impl.ob.F4;
import com.yandex.metrica.impl.ob.M4;

/* loaded from: classes3.dex */
public class N4<T extends M4, C extends F3> extends F4<T, C> {

    class a implements F4.a<T> {
        final /* synthetic */ C1114n4 a;

        a(N4 n4, C1114n4 c1114n4) {
            this.a = c1114n4;
        }

        @Override // com.yandex.metrica.impl.ob.F4.a
        public boolean a(Object obj, C0836c0 c0836c0) {
            return ((M4) obj).a(c0836c0, this.a);
        }
    }

    public N4(K4<T> k4, C c) {
        super(k4, c);
    }

    public boolean a(C0836c0 c0836c0, C1114n4 c1114n4) {
        return a(c0836c0, new a(this, c1114n4));
    }
}
