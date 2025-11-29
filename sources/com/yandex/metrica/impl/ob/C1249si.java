package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.si, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1249si {
    private final int a;

    public C1249si(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof C1249si) && this.a == ((C1249si) obj).a;
        }
        return true;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.a + ")";
    }
}
