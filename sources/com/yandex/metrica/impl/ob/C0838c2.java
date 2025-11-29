package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.c2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0838c2 {
    private final int a;
    private final int b;
    private final int c;
    private final float d;
    private final com.yandex.metrica.b e;

    public C0838c2(int i, int i2, int i3, float f, com.yandex.metrica.b bVar) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = f;
        this.e = bVar;
    }

    public final com.yandex.metrica.b a() {
        return this.e;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public final float d() {
        return this.d;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0838c2)) {
            return false;
        }
        C0838c2 c0838c2 = (C0838c2) obj;
        return this.a == c0838c2.a && this.b == c0838c2.b && this.c == c0838c2.c && Float.compare(this.d, c0838c2.d) == 0 && Intrinsics.areEqual(this.e, c0838c2.e);
    }

    public int hashCode() {
        int iFloatToIntBits = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31;
        com.yandex.metrica.b bVar = this.e;
        return iFloatToIntBits + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "ScreenInfo(width=" + this.a + ", height=" + this.b + ", dpi=" + this.c + ", scaleFactor=" + this.d + ", deviceType=" + this.e + ")";
    }
}
