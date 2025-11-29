package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class W6 implements ProtobufConverter {
    private final T6 a;

    public W6() {
        this(new T6());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1075lf fromModel(F6 f6) {
        C1075lf c1075lf = new C1075lf();
        String strB = f6.b();
        if (strB == null) {
            strB = "";
        }
        c1075lf.a = strB;
        String strC = f6.c();
        c1075lf.b = strC != null ? strC : "";
        c1075lf.c = this.a.fromModel(f6.d());
        if (f6.a() != null) {
            c1075lf.d = fromModel(f6.a());
        }
        List<F6> listE = f6.e();
        int i = 0;
        if (listE == null) {
            c1075lf.e = new C1075lf[0];
        } else {
            c1075lf.e = new C1075lf[listE.size()];
            Iterator<F6> it = listE.iterator();
            while (it.hasNext()) {
                c1075lf.e[i] = fromModel(it.next());
                i++;
            }
        }
        return c1075lf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    W6(T6 t6) {
        this.a = t6;
    }
}
