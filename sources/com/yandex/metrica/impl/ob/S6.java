package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.core.api.ProtobufConverter;
import java.util.List;

/* loaded from: classes3.dex */
public class S6 implements ProtobufConverter {
    private final W6 a;
    private final J6 b;
    private final L6 c;
    private final T6 d;
    private final Q6 e;
    private final R6 f;

    public S6() {
        this(new W6(), new J6(new V6()), new L6(), new T6(), new Q6(), new R6());
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0976hf fromModel(B6 b6) {
        C0976hf c0976hf = new C0976hf();
        String str = b6.a;
        String str2 = c0976hf.f;
        if (str == null) {
            str = str2;
        }
        c0976hf.f = str;
        H6 h6 = b6.b;
        if (h6 != null) {
            F6 f6 = h6.a;
            if (f6 != null) {
                c0976hf.a = this.a.fromModel(f6);
            }
            C1333w6 c1333w6 = h6.b;
            if (c1333w6 != null) {
                c0976hf.b = this.b.fromModel(c1333w6);
            }
            List<D6> list = h6.c;
            if (list != null) {
                c0976hf.e = this.d.fromModel(list);
            }
            String str3 = h6.g;
            String str4 = c0976hf.c;
            if (str3 == null) {
                str3 = str4;
            }
            c0976hf.c = str3;
            c0976hf.d = this.c.a(h6.h);
            if (!TextUtils.isEmpty(h6.d)) {
                c0976hf.i = this.e.fromModel(h6.d);
            }
            if (!TextUtils.isEmpty(h6.e)) {
                c0976hf.j = h6.e.getBytes();
            }
            if (!A2.b(h6.f)) {
                c0976hf.k = this.f.fromModel(h6.f);
            }
        }
        return c0976hf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    S6(W6 w6, J6 j6, L6 l6, T6 t6, Q6 q6, R6 r6) {
        this.a = w6;
        this.b = j6;
        this.c = l6;
        this.d = t6;
        this.e = q6;
        this.f = r6;
    }
}
