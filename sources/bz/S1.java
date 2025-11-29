package bz;

import java.util.Objects;

/* loaded from: classes.dex */
public final class S1 {
    public final long a;
    public final zone.bi.mobile.fingerprint.api.g b;
    public final String c;
    public final int d;

    public S1(long j, zone.bi.mobile.fingerprint.api.g gVar, String str, int i) {
        this.a = j;
        this.b = gVar;
        this.c = str;
        this.d = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || S1.class != obj.getClass()) {
            return false;
        }
        S1 s1 = (S1) obj;
        return this.a == s1.a && this.d == s1.d && this.b == s1.b && this.c.equals(s1.c);
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.a), this.b, this.c, Integer.valueOf(this.d));
    }

    public final String toString() {
        return "Event{time=" + this.a + ", priority=" + this.b + ", message='" + this.c + "', code=" + this.d + '}';
    }
}
