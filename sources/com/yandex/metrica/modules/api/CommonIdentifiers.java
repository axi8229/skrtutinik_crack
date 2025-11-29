package com.yandex.metrica.modules.api;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class CommonIdentifiers {
    private final String a;
    private final String b;

    public CommonIdentifiers(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonIdentifiers)) {
            return false;
        }
        CommonIdentifiers commonIdentifiers = (CommonIdentifiers) obj;
        return Intrinsics.areEqual(this.a, commonIdentifiers.a) && Intrinsics.areEqual(this.b, commonIdentifiers.b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CommonIdentifiers(uuid=" + this.a + ", device=" + this.b + ")";
    }
}
