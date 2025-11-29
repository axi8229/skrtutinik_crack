package com.segment.analytics;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ValueMap implements Map<String, Object> {
    private final Map<String, Object> delegate;

    public ValueMap() {
        this.delegate = new LinkedHashMap();
    }

    public ValueMap(Map<String, Object> map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null.");
        }
        this.delegate = map;
    }

    @Override // java.util.Map
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.delegate.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.delegate.entrySet();
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.delegate.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.delegate.keySet();
    }

    @Override // java.util.Map
    public Object put(String str, Object obj) {
        return this.delegate.put(str, obj);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.delegate.putAll(map);
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        return this.delegate.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.delegate.values();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || this.delegate.equals(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }

    public ValueMap putValue(String str, Object obj) {
        this.delegate.put(str, obj);
        return this;
    }
}
