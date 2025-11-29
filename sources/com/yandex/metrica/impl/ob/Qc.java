package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Qc {
    public final boolean a;
    public final boolean b;

    public Qc(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qc.class != obj.getClass()) {
            return false;
        }
        Qc qc = (Qc) obj;
        return this.a == qc.a && this.b == qc.b;
    }

    public int hashCode() {
        return ((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0);
    }

    public String toString() {
        return "ProviderAccessFlags{lastKnownEnabled=" + this.a + ", scanningEnabled=" + this.b + '}';
    }
}
