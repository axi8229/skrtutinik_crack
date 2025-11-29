package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.Converter;
import com.yandex.metrica.impl.ob.If;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class N9 implements Converter {
    private final C1023jd a;

    public N9() {
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        C1023jd c1023jdJ = f0G.j();
        Intrinsics.checkNotNullExpressionValue(c1023jdJ, "GlobalServiceLocator.get…tance().modulesController");
        this.a = c1023jdJ;
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public If.l[] fromModel(Map<String, ? extends Object> map) {
        If.l lVar;
        Map<String, C0974hd> mapC = this.a.c();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            C0974hd c0974hd = mapC.get(key);
            if (c0974hd == null || value == null) {
                lVar = null;
            } else {
                lVar = new If.l();
                lVar.a = key;
                lVar.b = c0974hd.a(value);
            }
            if (lVar != null) {
                arrayList.add(lVar);
            }
        }
        Object[] array = arrayList.toArray(new If.l[0]);
        if (array != null) {
            return (If.l[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // com.yandex.metrica.core.api.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map<String, Object> toModel(If.l[] lVarArr) {
        Map<String, C0974hd> mapC = this.a.c();
        ArrayList arrayList = new ArrayList();
        for (If.l lVar : lVarArr) {
            C0974hd c0974hd = mapC.get(lVar.a);
            Pair pair = c0974hd != null ? TuplesKt.to(lVar.a, c0974hd.a(lVar.b)) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
