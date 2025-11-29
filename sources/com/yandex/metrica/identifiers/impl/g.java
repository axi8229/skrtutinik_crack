package com.yandex.metrica.identifiers.impl;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class g {
    private final l a;
    private final f b;
    private final String c;

    public g(l status, f fVar, String str) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.a = status;
        this.b = fVar;
        this.c = str;
    }

    public /* synthetic */ g(l lVar, f fVar, String str, int i) {
        this(lVar, (i & 2) != 0 ? null : fVar, (i & 4) != 0 ? null : str);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        f fVar = this.b;
        if (fVar != null) {
            bundle.putBundle("com.yandex.metrica.identifiers.extra.TRACKING_INFO", fVar.a());
        }
        bundle.putString("com.yandex.metrica.identifiers.extra.STATUS", this.a.a());
        bundle.putString("com.yandex.metrica.identifiers.extra.ERROR_MESSAGE", this.c);
        return bundle;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c);
    }

    public int hashCode() {
        l lVar = this.a;
        int iHashCode = (lVar != null ? lVar.hashCode() : 0) * 31;
        f fVar = this.b;
        int iHashCode2 = (iHashCode + (fVar != null ? fVar.hashCode() : 0)) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AdsIdResult(status=" + this.a + ", adsIdInfo=" + this.b + ", errorExplanation=" + this.c + ")";
    }
}
