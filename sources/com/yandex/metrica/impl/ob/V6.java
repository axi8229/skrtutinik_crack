package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class V6 implements ProtobufConverter {
    private final T6 a;

    public V6() {
        this(new T6());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1050kf fromModel(E6 e6) {
        C1050kf c1050kf = new C1050kf();
        Integer num = e6.e;
        c1050kf.e = num == null ? -1 : num.intValue();
        c1050kf.d = e6.d;
        c1050kf.b = e6.b;
        c1050kf.a = e6.a;
        c1050kf.c = e6.c;
        T6 t6 = this.a;
        List<StackTraceElement> list = e6.f;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new D6((StackTraceElement) it.next()));
        }
        c1050kf.f = t6.fromModel(arrayList);
        return c1050kf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    V6(T6 t6) {
        this.a = t6;
    }
}
