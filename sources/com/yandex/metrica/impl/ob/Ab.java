package com.yandex.metrica.impl.ob;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Ab {
    private final String a;
    private final com.yandex.metrica.appsetid.c b;

    public Ab(String str, com.yandex.metrica.appsetid.c cVar) {
        this.a = str;
        this.b = cVar;
    }

    public final String a() {
        return this.a;
    }

    public final com.yandex.metrica.appsetid.c b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ab)) {
            return false;
        }
        Ab ab = (Ab) obj;
        return Intrinsics.areEqual(this.a, ab.a) && Intrinsics.areEqual(this.b, ab.b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        com.yandex.metrica.appsetid.c cVar = this.b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "AppSetId(id=" + this.a + ", scope=" + this.b + ")";
    }
}
