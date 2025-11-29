package com.huawei.hms.common.data;

import com.yandex.metrica.impl.ob.U;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        U.a aVar = (ArrayList<T>) new ArrayList();
        if (iterable == null) {
            return aVar;
        }
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            aVar.add(it.next().freeze());
        }
        return aVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}
