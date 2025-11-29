package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.Df;
import com.yandex.metrica.impl.ob.H1;
import com.yandex.metrica.impl.ob.Jf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class R9 implements ProtobufConverter {
    private static final Map<Integer, H1.d> a = Collections.unmodifiableMap(new a());
    private static final Map<H1.d, Integer> b = Collections.unmodifiableMap(new b());

    class a extends HashMap<Integer, H1.d> {
        a() {
            put(1, H1.d.WIFI);
            put(2, H1.d.CELL);
        }
    }

    class b extends HashMap<H1.d, Integer> {
        b() {
            put(H1.d.WIFI, 1);
            put(H1.d.CELL, 2);
        }
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        Jf.e eVar = (Jf.e) obj;
        Df df = new Df();
        Set<String> setA = eVar.a();
        df.b = (String[]) setA.toArray(new String[((HashSet) setA).size()]);
        List<Jf.e.a> listB = eVar.b();
        Df.a[] aVarArr = new Df.a[listB.size()];
        for (int i = 0; i < listB.size(); i++) {
            Jf.e.a aVar = listB.get(i);
            Df.a aVar2 = new Df.a();
            aVar2.a = aVar.a;
            aVar2.b = aVar.b;
            Df.a.C0282a[] c0282aArr = new Df.a.C0282a[aVar.d.c()];
            int i2 = 0;
            for (Map.Entry<String, ? extends Collection<String>> entry : aVar.d.a()) {
                for (String str : entry.getValue()) {
                    Df.a.C0282a c0282a = new Df.a.C0282a();
                    c0282a.a = entry.getKey();
                    c0282a.b = str;
                    c0282aArr[i2] = c0282a;
                    i2++;
                }
            }
            aVar2.d = c0282aArr;
            aVar2.c = aVar.c;
            aVar2.e = aVar.e;
            List<H1.d> list = aVar.f;
            int[] iArr = new int[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                iArr[i3] = b.get(list.get(i3)).intValue();
            }
            aVar2.f = iArr;
            aVarArr[i] = aVar2;
        }
        df.a = aVarArr;
        return df;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        Df df = (Df) obj;
        ArrayList arrayList = new ArrayList();
        Df.a[] aVarArr = df.a;
        int length = aVarArr.length;
        boolean z = false;
        int i = 0;
        while (i < length) {
            Df.a aVar = aVarArr[i];
            String str = aVar.a;
            String str2 = aVar.b;
            String str3 = aVar.c;
            Df.a.C0282a[] c0282aArr = aVar.d;
            C1229rm c1229rm = new C1229rm(z);
            int length2 = c0282aArr.length;
            for (?? r14 = z; r14 < length2; r14++) {
                Df.a.C0282a c0282a = c0282aArr[r14];
                c1229rm.a(c0282a.a, c0282a.b);
                aVarArr = aVarArr;
            }
            Df.a[] aVarArr2 = aVarArr;
            long j = aVar.e;
            int[] iArr = aVar.f;
            ArrayList arrayList2 = new ArrayList(iArr.length);
            int length3 = iArr.length;
            int i2 = 0;
            while (i2 < length3) {
                arrayList2.add(a.get(Integer.valueOf(iArr[i2])));
                i2++;
                iArr = iArr;
                length = length;
            }
            arrayList.add(new Jf.e.a(str, str2, str3, c1229rm, j, arrayList2));
            i++;
            aVarArr = aVarArr2;
            z = false;
        }
        return new Jf.e(arrayList, Arrays.asList(df.b));
    }
}
