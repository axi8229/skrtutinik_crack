package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Uh {
    private final String a;
    private final int b;
    private final int c;
    private final boolean d;
    private final boolean e;

    public Uh(String str, int i, int i2, boolean z, boolean z2) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final boolean d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uh)) {
            return false;
        }
        Uh uh = (Uh) obj;
        return Intrinsics.areEqual(this.a, uh.a) && this.b == uh.b && this.c == uh.c && this.d == uh.d && this.e == uh.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.a;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z2 = this.e;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "EgressConfig(url=" + this.a + ", repeatedDelay=" + this.b + ", randomDelayWindow=" + this.c + ", isBackgroundAllowed=" + this.d + ", isDiagnosticsEnabled=" + this.e + ")";
    }
}
