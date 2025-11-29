package com.yandex.metrica.impl.ob;

import android.util.Pair;
import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.If;
import com.yandex.metrica.impl.ob.Oh;
import java.util.ArrayList;

/* renamed from: com.yandex.metrica.impl.ob.s9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1240s9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.a fromModel(Oh oh) {
        If.a.C0284a c0284a;
        If.a aVar = new If.a();
        aVar.a = new If.a.b[oh.a.size()];
        for (int i = 0; i < oh.a.size(); i++) {
            If.a.b bVar = new If.a.b();
            Pair<String, Oh.a> pair = oh.a.get(i);
            bVar.a = (String) pair.first;
            if (pair.second != null) {
                bVar.b = new If.a.C0284a();
                Oh.a aVar2 = (Oh.a) pair.second;
                if (aVar2 == null) {
                    c0284a = null;
                } else {
                    If.a.C0284a c0284a2 = new If.a.C0284a();
                    c0284a2.a = aVar2.a;
                    c0284a = c0284a2;
                }
                bVar.b = c0284a;
            }
            aVar.a[i] = bVar;
        }
        return aVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Oh toModel(If.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (If.a.b bVar : aVar.a) {
            String str = bVar.a;
            If.a.C0284a c0284a = bVar.b;
            arrayList.add(new Pair(str, c0284a == null ? null : new Oh.a(c0284a.a)));
        }
        return new Oh(arrayList);
    }
}
