package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.z, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1398z {
    public final a a;
    public final Boolean b;

    /* renamed from: com.yandex.metrica.impl.ob.z$a */
    public enum a {
        ACTIVE,
        WORKING_SET,
        FREQUENT,
        RARE,
        RESTRICTED
    }

    public C1398z(a aVar, Boolean bool) {
        this.a = aVar;
        this.b = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1398z.class != obj.getClass()) {
            return false;
        }
        C1398z c1398z = (C1398z) obj;
        if (this.a != c1398z.a) {
            return false;
        }
        Boolean bool = this.b;
        return bool != null ? bool.equals(c1398z.b) : c1398z.b == null;
    }

    public int hashCode() {
        a aVar = this.a;
        int iHashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }
}
