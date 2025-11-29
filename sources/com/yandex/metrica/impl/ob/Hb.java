package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Hb implements Gb {
    private final int a;
    private final int b;
    private int c = 0;

    public Hb(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.yandex.metrica.impl.ob.Gb
    public int a() {
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.Gb
    public boolean b() {
        int i = this.c;
        this.c = i + 1;
        return i < this.a;
    }

    @Override // com.yandex.metrica.impl.ob.Gb
    public void c() {
        this.c = 0;
    }
}
