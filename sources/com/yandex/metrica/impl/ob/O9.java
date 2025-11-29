package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.ListConverter;
import com.yandex.metrica.impl.ob.If;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class O9 implements ListConverter {
    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.m[] fromModel(List<Bd> list) {
        If.m[] mVarArr = new If.m[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Bd bd = list.get(i);
            If.m mVar = new If.m();
            mVar.a = bd.a;
            mVar.b = bd.b;
            mVarArr[i] = mVar;
        }
        return mVarArr;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Bd> toModel(If.m[] mVarArr) {
        ArrayList arrayList = new ArrayList(mVarArr.length);
        for (If.m mVar : mVarArr) {
            arrayList.add(new Bd(mVar.a, mVar.b));
        }
        return arrayList;
    }
}
