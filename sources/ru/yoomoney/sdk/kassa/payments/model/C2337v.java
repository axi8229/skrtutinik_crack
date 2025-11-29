package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.model.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2337v {
    public final EnumC2338w a;
    public final String b;
    public final String c;
    public final String d;
    public final Integer e;

    public /* synthetic */ C2337v(EnumC2338w enumC2338w) {
        this(enumC2338w, null, null, null, null);
    }

    public final EnumC2338w a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2337v)) {
            return false;
        }
        C2337v c2337v = (C2337v) obj;
        return this.a == c2337v.a && Intrinsics.areEqual(this.b, c2337v.b) && Intrinsics.areEqual(this.c, c2337v.c) && Intrinsics.areEqual(this.d, c2337v.d) && Intrinsics.areEqual(this.e, c2337v.e);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.e;
        return iHashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        return "Error(errorCode=" + this.a + ", id=" + this.b + ", description=" + this.c + ", parameter=" + this.d + ", retryAfter=" + this.e + ")";
    }

    public C2337v(EnumC2338w errorCode, String str, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.a = errorCode;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = num;
    }
}
