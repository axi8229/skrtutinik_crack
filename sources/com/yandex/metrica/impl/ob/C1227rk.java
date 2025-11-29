package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/* renamed from: com.yandex.metrica.impl.ob.rk, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1227rk {
    private final Map<Float, Integer> a = new HashMap();

    public C1227rk(TreeSet<Float> treeSet) {
        Iterator<Float> it = treeSet.descendingSet().iterator();
        int i = 0;
        while (it.hasNext()) {
            this.a.put(it.next(), Integer.valueOf(i));
            i++;
        }
    }

    public void a(C0832bl c0832bl) {
        c0832bl.s = this.a.get(c0832bl.m);
    }
}
