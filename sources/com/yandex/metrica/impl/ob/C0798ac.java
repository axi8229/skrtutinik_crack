package com.yandex.metrica.impl.ob;

import com.yandex.metrica.gpllibrary.a;

/* renamed from: com.yandex.metrica.impl.ob.ac, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0798ac {
    public final a.b a;
    public final long b;
    public final long c;

    public C0798ac(a.b bVar, long j, long j2) {
        this.a = bVar;
        this.b = j;
        this.c = j2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0798ac.class != obj.getClass()) {
            return false;
        }
        C0798ac c0798ac = (C0798ac) obj;
        return this.b == c0798ac.b && this.c == c0798ac.c && this.a == c0798ac.a;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        long j = this.b;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.c;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "GplArguments{priority=" + this.a + ", durationSeconds=" + this.b + ", intervalSeconds=" + this.c + '}';
    }
}
