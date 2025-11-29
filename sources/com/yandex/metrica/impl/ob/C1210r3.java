package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1306v3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* renamed from: com.yandex.metrica.impl.ob.r3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1210r3 implements InterfaceC1401z2<C1306v3.a, C1306v3.a> {
    @Override // com.yandex.metrica.impl.ob.InterfaceC1401z2, kotlin.jvm.functions.Function2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<C1306v3.a> invoke(List<C1306v3.a> list, C1306v3.a aVar) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((C1306v3.a) it.next()).a() == aVar.a()) {
                    if (aVar.a() != EnumC1279u0.APP) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((C1306v3.a) obj).a() != EnumC1279u0.APP) {
                            arrayList.add(obj);
                        }
                    }
                    return CollectionsKt.plus((Collection<? extends C1306v3.a>) arrayList, aVar);
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends C1306v3.a>) list, aVar);
    }
}
