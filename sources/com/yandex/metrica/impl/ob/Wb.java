package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Wb {
    public final long a;
    public final long b;

    public Wb(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Wb.class != obj.getClass()) {
            return false;
        }
        Wb wb = (Wb) obj;
        return this.a == wb.a && this.b == wb.b;
    }

    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.b;
        return i + ((int) ((j2 >>> 32) ^ j2));
    }

    public String toString() {
        return "ForcedCollectingArguments{durationSeconds=" + this.a + ", intervalSeconds=" + this.b + '}';
    }
}
