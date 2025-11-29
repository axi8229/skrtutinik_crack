package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.Ef;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class T9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        Ef.a aVar;
        Z1 z1 = (Z1) obj;
        Ef ef = new Ef();
        Map<String, String> map = z1.a;
        if (map == null) {
            aVar = null;
        } else {
            Ef.a aVar2 = new Ef.a();
            aVar2.a = new Ef.a.C0283a[map.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Ef.a.C0283a c0283a = new Ef.a.C0283a();
                c0283a.a = entry.getKey();
                c0283a.b = entry.getValue();
                aVar2.a[i] = c0283a;
                i++;
            }
            aVar = aVar2;
        }
        ef.a = aVar;
        ef.b = z1.b;
        return ef;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        HashMap map;
        Ef ef = (Ef) obj;
        Ef.a aVar = ef.a;
        if (aVar == null) {
            map = null;
        } else {
            HashMap map2 = new HashMap();
            for (Ef.a.C0283a c0283a : aVar.a) {
                map2.put(c0283a.a, c0283a.b);
            }
            map = map2;
        }
        return new Z1(map, ef.b);
    }
}
