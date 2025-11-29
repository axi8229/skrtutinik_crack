package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Bd {
    public final String a;
    public final boolean b;

    public Bd(String str, boolean z) {
        this.a = str;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Bd.class != obj.getClass()) {
            return false;
        }
        Bd bd = (Bd) obj;
        if (this.b != bd.b) {
            return false;
        }
        return this.a.equals(bd.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    public String toString() {
        return "PermissionState{name='" + this.a + "', granted=" + this.b + '}';
    }
}
