package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressLint({"all"})
/* renamed from: com.yandex.metrica.impl.ob.pm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1182pm<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;

    public C1182pm(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int b(K k, V v) {
        int length = C0810b.b(((C1347wk) k).b).length + 12;
        if (length >= 0) {
            return length;
        }
        throw new IllegalStateException("Negative size: " + k + ContainerUtils.KEY_VALUE_DELIMITER + v);
    }

    public final synchronized V a(K k) {
        V v = this.a.get(k);
        if (v != null) {
            this.f++;
            return v;
        }
        this.g++;
        return null;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        try {
            i = this.f;
            i2 = this.g + i;
        } catch (Throwable th) {
            throw th;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public final synchronized V a(K k, V v) {
        V vPut;
        try {
            this.d++;
            this.b += b(k, v);
            vPut = this.a.put(k, v);
            if (vPut != null) {
                this.b -= b(k, vPut);
            }
            a(this.c);
        } catch (Throwable th) {
            throw th;
        }
        return vPut;
    }

    private void a(int i) {
        Map.Entry<K, V> next;
        while (this.b > i && !this.a.isEmpty() && (next = this.a.entrySet().iterator().next()) != null) {
            K key = next.getKey();
            V value = next.getValue();
            this.a.remove(key);
            this.b -= b(key, value);
            this.e++;
        }
        if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
            throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
        }
    }

    public final synchronized void a() {
        a(-1);
    }
}
