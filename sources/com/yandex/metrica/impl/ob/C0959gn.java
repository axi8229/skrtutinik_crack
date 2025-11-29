package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Vm;

/* renamed from: com.yandex.metrica.impl.ob.gn, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0959gn<V, M extends Vm> implements Vm {
    public final V a;
    public final M b;

    public C0959gn(V v, M m) {
        this.a = v;
        this.b = m;
    }

    @Override // com.yandex.metrica.impl.ob.Vm
    public int a() {
        return this.b.a();
    }

    public String toString() {
        return "TrimmingResult{value=" + this.a + ", metaInfo=" + this.b + '}';
    }
}
