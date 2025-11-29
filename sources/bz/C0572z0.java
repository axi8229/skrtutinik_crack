package bz;

import java.io.Serializable;

/* renamed from: bz.z0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0572z0 {
    public final Serializable a;
    public final long b;

    public C0572z0(Serializable serializable) {
        this.a = serializable;
        this.b = System.currentTimeMillis();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0572z0.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((C0572z0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public C0572z0(Serializable serializable, long j) {
        this.a = serializable;
        this.b = j;
    }
}
