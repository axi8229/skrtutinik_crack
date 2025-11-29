package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;

/* loaded from: classes3.dex */
public class K6 implements ProtobufConverter {
    private final J6 a;
    private final L6 b;

    public K6() {
        this(new J6(new V6()), new L6());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0901ef fromModel(C1357x6 c1357x6) {
        C0901ef c0901ef = new C0901ef();
        c0901ef.a = this.a.fromModel(c1357x6.a);
        String str = c1357x6.b;
        if (str != null) {
            c0901ef.b = str;
        }
        c0901ef.c = this.b.a(c1357x6.c);
        return c0901ef;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    K6(J6 j6, L6 l6) {
        this.a = j6;
        this.b = l6;
    }
}
