package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;

/* loaded from: classes3.dex */
public class U6 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1025jf fromModel(D6 d6) {
        C1025jf c1025jf = new C1025jf();
        String strA = d6.a();
        String str = c1025jf.a;
        if (strA == null) {
            strA = str;
        }
        c1025jf.a = strA;
        String strC = d6.c();
        String str2 = c1025jf.b;
        if (strC == null) {
            strC = str2;
        }
        c1025jf.b = strC;
        Integer numD = d6.d();
        Integer numValueOf = Integer.valueOf(c1025jf.c);
        if (numD == null) {
            numD = numValueOf;
        }
        c1025jf.c = numD.intValue();
        Integer numB = d6.b();
        Integer numValueOf2 = Integer.valueOf(c1025jf.f);
        if (numB == null) {
            numB = numValueOf2;
        }
        c1025jf.f = numB.intValue();
        String strE = d6.e();
        String str3 = c1025jf.d;
        if (strE == null) {
            strE = str3;
        }
        c1025jf.d = strE;
        Boolean boolF = d6.f();
        Boolean boolValueOf = Boolean.valueOf(c1025jf.e);
        if (boolF == null) {
            boolF = boolValueOf;
        }
        c1025jf.e = boolF.booleanValue();
        return c1025jf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }
}
