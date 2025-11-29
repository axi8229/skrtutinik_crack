package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.core.api.ProtobufConverter;
import java.util.List;

/* loaded from: classes3.dex */
public class X6 implements ProtobufConverter {
    private final W6 a;
    private final J6 b;
    private final L6 c;
    private final T6 d;
    private final Q6 e;
    private final R6 f;

    public X6() {
        this(new W6(), new J6(new V6()), new L6(), new T6(), new Q6(), new R6());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0951gf fromModel(H6 h6) {
        C0951gf c0951gf = new C0951gf();
        F6 f6 = h6.a;
        if (f6 != null) {
            c0951gf.a = this.a.fromModel(f6);
        }
        C1333w6 c1333w6 = h6.b;
        if (c1333w6 != null) {
            c0951gf.b = this.b.fromModel(c1333w6);
        }
        List<D6> list = h6.c;
        if (list != null) {
            c0951gf.e = this.d.fromModel(list);
        }
        String str = h6.g;
        if (str != null) {
            c0951gf.c = str;
        }
        c0951gf.d = this.c.a(h6.h);
        if (!TextUtils.isEmpty(h6.d)) {
            c0951gf.h = this.e.fromModel(h6.d);
        }
        if (!TextUtils.isEmpty(h6.e)) {
            c0951gf.i = h6.e.getBytes();
        }
        if (!A2.b(h6.f)) {
            c0951gf.j = this.f.fromModel(h6.f);
        }
        return c0951gf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    X6(W6 w6, J6 j6, L6 l6, T6 t6, Q6 q6, R6 r6) {
        this.b = j6;
        this.a = w6;
        this.c = l6;
        this.d = t6;
        this.e = q6;
        this.f = r6;
    }
}
