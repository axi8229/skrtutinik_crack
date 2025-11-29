package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.Ff;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class V9 implements ProtobufConverter {
    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C0903eh c0903eh = (C0903eh) obj;
        Ff ff = new Ff();
        ff.a = new Ff.a[c0903eh.a.size()];
        for (int i = 0; i < c0903eh.a.size(); i++) {
            Ff.a[] aVarArr = ff.a;
            C0978hh c0978hh = c0903eh.a.get(i);
            Ff.a aVar = new Ff.a();
            aVar.a = c0978hh.a;
            List<String> list = c0978hh.b;
            aVar.b = new String[list.size()];
            Iterator<String> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                aVar.b[i2] = it.next();
                i2++;
            }
            aVarArr[i] = aVar;
        }
        ff.b = c0903eh.b;
        ff.c = c0903eh.c;
        ff.d = c0903eh.d;
        ff.e = c0903eh.e;
        return ff;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        Ff ff = (Ff) obj;
        ArrayList arrayList = new ArrayList(ff.a.length);
        int i = 0;
        while (true) {
            Ff.a[] aVarArr = ff.a;
            if (i >= aVarArr.length) {
                return new C0903eh(arrayList, ff.b, ff.c, ff.d, ff.e);
            }
            Ff.a aVar = aVarArr[i];
            ArrayList arrayList2 = new ArrayList();
            String[] strArr = aVar.b;
            if (strArr != null && strArr.length > 0) {
                arrayList2 = new ArrayList(aVar.b.length);
                int i2 = 0;
                while (true) {
                    String[] strArr2 = aVar.b;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    arrayList2.add(strArr2[i2]);
                    i2++;
                }
            }
            String str = aVar.a;
            if (str == null) {
                str = "";
            }
            arrayList.add(new C0978hh(str, arrayList2));
            i++;
        }
    }
}
