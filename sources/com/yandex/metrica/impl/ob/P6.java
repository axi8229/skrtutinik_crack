package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C0951gf;
import java.util.EnumMap;

/* loaded from: classes3.dex */
public class P6 implements ProtobufConverter {
    private static final EnumMap<EnumC0943g7, Integer> a;

    static {
        EnumMap<EnumC0943g7, Integer> enumMap = new EnumMap<>(EnumC0943g7.class);
        a = enumMap;
        enumMap.put((EnumMap<EnumC0943g7, Integer>) EnumC0943g7.UNKNOWN, (EnumC0943g7) 0);
        enumMap.put((EnumMap<EnumC0943g7, Integer>) EnumC0943g7.BREAKPAD, (EnumC0943g7) 2);
        enumMap.put((EnumMap<EnumC0943g7, Integer>) EnumC0943g7.CRASHPAD, (EnumC0943g7) 3);
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0951gf fromModel(C0868d7 c0868d7) {
        C0951gf c0951gf = new C0951gf();
        c0951gf.f = 1;
        C0951gf.a aVar = new C0951gf.a();
        c0951gf.g = aVar;
        aVar.a = c0868d7.a();
        C0843c7 c0843c7B = c0868d7.b();
        c0951gf.g.b = new Cif();
        Integer num = a.get(c0843c7B.b());
        if (num != null) {
            c0951gf.g.b.a = num.intValue();
        }
        Cif cif = c0951gf.g.b;
        String strA = c0843c7B.a();
        if (strA == null) {
            strA = "";
        }
        cif.b = strA;
        return c0951gf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }
}
