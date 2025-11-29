package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ProtobufConverter;
import com.yandex.metrica.impl.ob.C1342wf;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.yandex.metrica.impl.ob.r9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1216r9 implements ProtobufConverter {
    private final C1288u9 a;

    public C1216r9() {
        this(new C1288u9());
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object fromModel(Object obj) {
        C1268td c1268td = (C1268td) obj;
        C1342wf c1342wf = new C1342wf();
        c1342wf.a = new C1342wf.b[c1268td.a.size()];
        int i = 0;
        int i2 = 0;
        for (Bd bd : c1268td.a) {
            C1342wf.b[] bVarArr = c1342wf.a;
            C1342wf.b bVar = new C1342wf.b();
            bVar.a = bd.a;
            bVar.b = bd.b;
            bVarArr[i2] = bVar;
            i2++;
        }
        C1398z c1398z = c1268td.b;
        if (c1398z != null) {
            c1342wf.b = this.a.fromModel(c1398z);
        }
        c1342wf.c = new String[c1268td.c.size()];
        Iterator<String> it = c1268td.c.iterator();
        while (it.hasNext()) {
            c1342wf.c[i] = it.next();
            i++;
        }
        return c1342wf;
    }

    @Override // com.yandex.metrica.core.api.Converter
    public Object toModel(Object obj) {
        C1342wf c1342wf = (C1342wf) obj;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        while (true) {
            C1342wf.b[] bVarArr = c1342wf.a;
            if (i2 >= bVarArr.length) {
                break;
            }
            C1342wf.b bVar = bVarArr[i2];
            arrayList.add(new Bd(bVar.a, bVar.b));
            i2++;
        }
        C1342wf.a aVar = c1342wf.b;
        C1398z model = aVar != null ? this.a.toModel(aVar) : null;
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            String[] strArr = c1342wf.c;
            if (i >= strArr.length) {
                return new C1268td(arrayList, model, arrayList2);
            }
            arrayList2.add(strArr[i]);
            i++;
        }
    }

    C1216r9(C1288u9 c1288u9) {
        this.a = c1288u9;
    }
}
