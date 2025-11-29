package com.google.android.gms.common.data;

import com.yandex.metrica.impl.ob.U;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes2.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        U.a aVar = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            aVar.add(arrayList.get(i).freeze());
        }
        return aVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        U.a aVar = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            aVar.add(it.next().freeze());
        }
        return aVar;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        U.a aVar = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            aVar.add(e.freeze());
        }
        return aVar;
    }
}
