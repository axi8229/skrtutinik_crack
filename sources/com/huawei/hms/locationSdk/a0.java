package com.huawei.hms.locationSdk;

/* loaded from: classes3.dex */
public class a0 {
    private int a;
    private int b;
    private boolean c;
    private int d;
    private int e;

    public float a() {
        return this.b;
    }

    public a0 a(float f) {
        this.e = (int) f;
        return this;
    }

    public a0 a(int i) {
        this.a = i;
        return this;
    }

    public a0 a(boolean z) {
        this.c = z;
        return this;
    }

    public a0 b(float f) {
        this.b = (int) f;
        return this;
    }

    public a0 c(float f) {
        this.d = (int) f;
        return this;
    }

    public String toString() {
        return this.a + "_" + this.b + "_" + (this.c ? 1 : 0) + "_" + this.d + "_" + this.e;
    }
}
