package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.ti, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1273ti {
    public final long a;

    public C1273ti(long j) {
        this.a = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C1273ti.class == obj.getClass() && this.a == ((C1273ti) obj).a;
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return "StatSending{disabledReportingInterval=" + this.a + '}';
    }
}
