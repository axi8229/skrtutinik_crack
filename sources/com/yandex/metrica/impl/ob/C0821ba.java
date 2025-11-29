package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ListConverter;
import com.yandex.metrica.impl.ob.C1420zl;
import com.yandex.metrica.impl.ob.If;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.ba, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0821ba implements ListConverter {
    C0821ba() {
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.y[] fromModel(List<C1420zl> list) {
        If.y[] yVarArr = new If.y[list.size()];
        for (int i = 0; i < list.size(); i++) {
            C1420zl c1420zl = list.get(i);
            If.y yVar = new If.y();
            yVar.a = c1420zl.a.a;
            yVar.b = c1420zl.b;
            yVarArr[i] = yVar;
        }
        return yVarArr;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C1420zl> toModel(If.y[] yVarArr) {
        ArrayList arrayList = new ArrayList(yVarArr.length);
        for (If.y yVar : yVarArr) {
            arrayList.add(new C1420zl(C1420zl.b.a(yVar.a), yVar.b));
        }
        return arrayList;
    }
}
