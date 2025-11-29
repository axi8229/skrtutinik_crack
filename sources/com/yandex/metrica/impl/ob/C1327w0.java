package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.w0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1327w0 {
    private final long a;

    public C1327w0(long j) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C1327w0) && this.a == ((C1327w0) obj).a;
        }
        return true;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "EasyCollectingConfig(firstLaunchDelaySeconds=" + this.a + ")";
    }
}
