package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Vm;

/* loaded from: classes3.dex */
public class Na<R, M extends Vm> implements Vm {
    public final R a;
    public final M b;

    public Na(R r, M m) {
        this.a = r;
        this.b = m;
    }

    @Override // com.yandex.metrica.impl.ob.Vm
    public int a() {
        return this.b.a();
    }

    public String toString() {
        return "Result{result=" + this.a + ", metaInfo=" + this.b + '}';
    }
}
