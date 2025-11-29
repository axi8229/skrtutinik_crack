package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Sj {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public Sj(String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sj)) {
            return false;
        }
        Sj sj = (Sj) obj;
        return Intrinsics.areEqual(this.a, sj.a) && Intrinsics.areEqual(this.b, sj.b) && Intrinsics.areEqual(this.c, sj.c) && Intrinsics.areEqual(this.d, sj.d) && Intrinsics.areEqual(this.e, sj.e) && Intrinsics.areEqual(this.f, sj.f) && Intrinsics.areEqual(null, null) && Intrinsics.areEqual(null, null);
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f;
        return (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 961;
    }

    public final String toString() {
        return "ScreenData(header=" + this.a + ", text=" + this.b + ", declineText=" + this.c + ", buttonConfirm=" + this.d + ", buttonDecline=" + this.e + ", buttonInform=" + this.f + ", cybercabinetUrlAndroid=null, cybercabinetUrlIOS=null)";
    }

    public /* synthetic */ Sj(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, str5, (i & 32) != 0 ? null : str6);
    }
}
