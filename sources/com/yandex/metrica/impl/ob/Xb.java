package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Xb {
    public final Qc a;
    public final Wb b;

    public Xb(Qc qc, Wb wb) {
        this.a = qc;
        this.b = wb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Xb.class != obj.getClass()) {
            return false;
        }
        Xb xb = (Xb) obj;
        if (!this.a.equals(xb.a)) {
            return false;
        }
        Wb wb = this.b;
        Wb wb2 = xb.b;
        return wb != null ? wb.equals(wb2) : wb2 == null;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        Wb wb = this.b;
        return iHashCode + (wb != null ? wb.hashCode() : 0);
    }

    public String toString() {
        return "ForcedCollectingConfig{providerAccessFlags=" + this.a + ", arguments=" + this.b + '}';
    }
}
