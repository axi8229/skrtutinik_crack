package com.yandex.metrica.identifiers.impl;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class f {
    private final String a;
    private final String b;
    private final Boolean c;

    public f(String provider, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.a = provider;
        this.b = str;
        this.c = bool;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("com.yandex.metrica.identifiers.extra.PROVIDER", this.a);
        bundle.putString("com.yandex.metrica.identifiers.extra.ID", this.b);
        Boolean bool = this.c;
        if (bool != null) {
            bundle.putBoolean("com.yandex.metrica.identifiers.extra.LIMITED", bool.booleanValue());
        }
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.a, fVar.a) && Intrinsics.areEqual(this.b, fVar.b) && Intrinsics.areEqual(this.c, fVar.c);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.c;
        return iHashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "AdsIdInfo(provider=" + this.a + ", advId=" + this.b + ", limitedAdTracking=" + this.c + ")";
    }
}
