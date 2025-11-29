package com.yandex.metrica.impl.ob;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class Zl<K, V> {
    private final Map<K, V> a;
    private final V b;

    public Zl(V v) {
        this(new HashMap(), v);
    }

    public void a(K k, V v) {
        this.a.put(k, v);
    }

    public Zl(Map<K, V> map, V v) {
        this.a = map;
        this.b = v;
    }

    public V a(K k) {
        V v = this.a.get(k);
        return v == null ? this.b : v;
    }

    public Set<K> a() {
        return this.a.keySet();
    }
}
