package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.cc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0848cc {
    public final Qc a;
    public final C0798ac b;

    public C0848cc(Qc qc, C0798ac c0798ac) {
        this.a = qc;
        this.b = c0798ac;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0848cc.class != obj.getClass()) {
            return false;
        }
        C0848cc c0848cc = (C0848cc) obj;
        if (!this.a.equals(c0848cc.a)) {
            return false;
        }
        C0798ac c0798ac = this.b;
        C0798ac c0798ac2 = c0848cc.b;
        return c0798ac != null ? c0798ac.equals(c0798ac2) : c0798ac2 == null;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        C0798ac c0798ac = this.b;
        return iHashCode + (c0798ac != null ? c0798ac.hashCode() : 0);
    }

    public String toString() {
        return "GplCollectingConfig{providerAccessFlags=" + this.a + ", arguments=" + this.b + '}';
    }
}
