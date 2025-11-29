package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Xm extends Um {
    public final int b;

    public Xm(int i, int i2) {
        super(i2);
        this.b = i;
    }

    @Override // com.yandex.metrica.impl.ob.Um
    public String toString() {
        return "CollectionTrimInfo{itemsDropped=" + this.b + ", bytesTruncated=" + this.a + '}';
    }
}
