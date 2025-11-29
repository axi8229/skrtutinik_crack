package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Ud;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Td implements InterfaceC1401z2<Ud.a, C0900ee> {
    private final boolean a;

    public Td(Ud ud) {
        boolean z;
        List<Ud.a> list = ud.b;
        Intrinsics.checkNotNullExpressionValue(list, "stateFromDisk.candidates");
        if ((list instanceof Collection) && list.isEmpty()) {
            z = true;
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Ud.a) it.next()).c == EnumC1279u0.APP) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        this.a = z;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1401z2, kotlin.jvm.functions.Function2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Ud.a> invoke(List<? extends Ud.a> list, C0900ee c0900ee) {
        Ud.a aVar = new Ud.a(c0900ee.a, c0900ee.b, c0900ee.e);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Ud.a) it.next()).c == c0900ee.e) {
                    if (aVar.c == EnumC1279u0.APP && this.a) {
                        return CollectionsKt.plus((Collection<? extends Ud.a>) list, aVar);
                    }
                    return null;
                }
            }
        }
        return CollectionsKt.plus((Collection<? extends Ud.a>) list, aVar);
    }
}
