package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class I3 {
    private final String a;
    private final String b;

    public I3(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.a + "_" + A2.a(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        I3 i3 = (I3) obj;
        String str = this.a;
        if (str == null ? i3.a != null : !str.equals(i3.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = i3.b;
        return str2 != null ? str2.equals(str3) : str3 == null;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.a + "_" + this.b;
    }
}
