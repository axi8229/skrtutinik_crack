package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.i, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0985i {
    public final int a;
    public final int b;

    public C0985i(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0985i.class != obj.getClass()) {
            return false;
        }
        C0985i c0985i = (C0985i) obj;
        return this.a == c0985i.a && this.b == c0985i.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "BillingConfig{sendFrequencySeconds=" + this.a + ", firstCollectingInappMaxAgeSeconds=" + this.b + "}";
    }
}
