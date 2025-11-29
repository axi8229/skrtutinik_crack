package com.yandex.metrica.impl.ob;

import android.util.Pair;
import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C0829bi;
import com.yandex.metrica.impl.ob.If;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class S9 implements ProtobufConverter {
    private static final Map<Integer, C0829bi.a> a = Collections.unmodifiableMap(new a());
    private static final Map<C0829bi.a, Integer> b = Collections.unmodifiableMap(new b());

    class a extends HashMap<Integer, C0829bi.a> {
        a() {
            put(1, C0829bi.a.WIFI);
            put(2, C0829bi.a.CELL);
        }
    }

    class b extends HashMap<C0829bi.a, Integer> {
        b() {
            put(C0829bi.a.WIFI, 1);
            put(C0829bi.a.CELL, 2);
        }
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.o fromModel(C0829bi c0829bi) {
        If.o oVar = new If.o();
        oVar.a = c0829bi.a;
        oVar.b = c0829bi.b;
        oVar.c = c0829bi.c;
        List<Pair<String, String>> list = c0829bi.d;
        If.o.a[] aVarArr = new If.o.a[list.size()];
        int i = 0;
        for (Pair<String, String> pair : list) {
            If.o.a aVar = new If.o.a();
            aVar.a = (String) pair.first;
            aVar.b = (String) pair.second;
            aVarArr[i] = aVar;
            i++;
        }
        oVar.d = aVarArr;
        Long l = c0829bi.e;
        oVar.e = l == null ? 0L : l.longValue();
        List<C0829bi.a> list2 = c0829bi.f;
        int[] iArr = new int[list2.size()];
        for (int i2 = 0; i2 < list2.size(); i2++) {
            iArr[i2] = b.get(list2.get(i2)).intValue();
        }
        oVar.f = iArr;
        return oVar;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0829bi toModel(If.o oVar) {
        String str = oVar.a;
        String str2 = oVar.b;
        String str3 = oVar.c;
        If.o.a[] aVarArr = oVar.d;
        ArrayList arrayList = new ArrayList(aVarArr.length);
        for (If.o.a aVar : aVarArr) {
            arrayList.add(new Pair(aVar.a, aVar.b));
        }
        Long lValueOf = Long.valueOf(oVar.e);
        int[] iArr = oVar.f;
        ArrayList arrayList2 = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList2.add(a.get(Integer.valueOf(i)));
        }
        return new C0829bi(str, str2, str3, arrayList, lValueOf, arrayList2);
    }
}
