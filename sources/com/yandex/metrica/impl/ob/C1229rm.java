package com.yandex.metrica.impl.ob;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.yandex.metrica.impl.ob.rm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1229rm<K, V> {
    private final HashMap<K, Collection<V>> a;
    private final boolean b;

    public C1229rm() {
        this(false);
    }

    public Collection<V> a(K k) {
        return this.a.get(k);
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public int c() {
        Iterator<Collection<V>> it = this.a.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public String toString() {
        return this.a.toString();
    }

    public C1229rm(boolean z) {
        this.a = new HashMap<>();
        this.b = z;
    }

    public Collection<V> a(K k, V v) {
        Collection<V> collection = this.a.get(k);
        ArrayList arrayList = collection == null ? new ArrayList() : new ArrayList(collection);
        arrayList.add(v);
        return this.a.put(k, arrayList);
    }

    public Collection<V> b(K k) {
        return this.a.remove(k);
    }

    public Collection<V> b(K k, V v) {
        Collection<V> collection = this.a.get(k);
        if (collection == null || !collection.remove(v)) {
            return null;
        }
        if (collection.isEmpty() && this.b) {
            this.a.remove(k);
        }
        return new ArrayList(collection);
    }

    public Set<? extends Map.Entry<K, ? extends Collection<V>>> a() {
        return this.a.entrySet();
    }
}
