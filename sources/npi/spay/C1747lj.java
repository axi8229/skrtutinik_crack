package npi.spay;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.PluginExceptionsKt;

/* renamed from: npi.spay.lj, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1747lj {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    public /* synthetic */ C1747lj(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, C1722kj.a.getDescriptor());
        }
        this.a = str;
        this.b = str2;
        if ((i & 4) == 0) {
            this.c = "";
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = "";
        } else {
            this.d = str4;
        }
        if ((i & 16) == 0) {
            this.e = "";
        } else {
            this.e = str5;
        }
        if ((i & 32) == 0) {
            this.f = "";
        } else {
            this.f = str6;
        }
        if ((i & 64) == 0) {
            this.g = "";
        } else {
            this.g = str7;
        }
        if ((i & 128) == 0) {
            this.h = "";
        } else {
            this.h = str8;
        }
        if ((i & 256) == 0) {
            this.i = "";
        } else {
            this.i = str9;
        }
        if ((i & 512) == 0) {
            this.j = "";
        } else {
            this.j = str10;
        }
        if ((i & 1024) == 0) {
            this.k = "";
        } else {
            this.k = str11;
        }
        if ((i & 2048) == 0) {
            this.l = "";
        } else {
            this.l = str12;
        }
        if ((i & 4096) == 0) {
            this.m = "";
        } else {
            this.m = str13;
        }
        if ((i & 8192) == 0) {
            this.n = "";
        } else {
            this.n = str14;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1747lj)) {
            return false;
        }
        C1747lj c1747lj = (C1747lj) obj;
        return Intrinsics.areEqual(this.a, c1747lj.a) && Intrinsics.areEqual(this.b, c1747lj.b) && Intrinsics.areEqual(this.c, c1747lj.c) && Intrinsics.areEqual(this.d, c1747lj.d) && Intrinsics.areEqual(this.e, c1747lj.e) && Intrinsics.areEqual(this.f, c1747lj.f) && Intrinsics.areEqual(this.g, c1747lj.g) && Intrinsics.areEqual(this.h, c1747lj.h) && Intrinsics.areEqual(this.i, c1747lj.i) && Intrinsics.areEqual(this.j, c1747lj.j) && Intrinsics.areEqual(this.k, c1747lj.k) && Intrinsics.areEqual(this.l, c1747lj.l) && Intrinsics.areEqual(this.m, c1747lj.m) && Intrinsics.areEqual(this.n, c1747lj.n);
    }

    public final int hashCode() {
        return this.n.hashCode() + AbstractC1553e.a(this.m, AbstractC1553e.a(this.l, AbstractC1553e.a(this.k, AbstractC1553e.a(this.j, AbstractC1553e.a(this.i, AbstractC1553e.a(this.h, AbstractC1553e.a(this.g, AbstractC1553e.a(this.f, AbstractC1553e.a(this.e, AbstractC1553e.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "ProfileData(deviceId=" + this.a + ", applicationLanguage=" + this.b + ", clientBlock=" + this.c + ", sessionId=" + this.d + ", partnerId=" + this.e + ", appId=" + this.f + ", sapId=" + this.g + ", subId=" + this.h + ", adId=" + this.i + ", hashEfsId=" + this.j + ", appVersion=" + this.k + ", appVersionNumber=" + this.l + ", hashEpkId=" + this.m + ", hashUserLoginId=" + this.n + ')';
    }

    public C1747lj(String deviceId, String applicationLanguage, String clientBlock, String sessionId, String partnerId, String appId, String sapId, String subId, String adId, String hashEfsId, String appVersion, String appVersionNumber, String hashEpkId, String hashUserLoginId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(applicationLanguage, "applicationLanguage");
        Intrinsics.checkNotNullParameter(clientBlock, "clientBlock");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(partnerId, "partnerId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(sapId, "sapId");
        Intrinsics.checkNotNullParameter(subId, "subId");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(hashEfsId, "hashEfsId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appVersionNumber, "appVersionNumber");
        Intrinsics.checkNotNullParameter(hashEpkId, "hashEpkId");
        Intrinsics.checkNotNullParameter(hashUserLoginId, "hashUserLoginId");
        this.a = deviceId;
        this.b = applicationLanguage;
        this.c = clientBlock;
        this.d = sessionId;
        this.e = partnerId;
        this.f = appId;
        this.g = sapId;
        this.h = subId;
        this.i = adId;
        this.j = hashEfsId;
        this.k = appVersion;
        this.l = appVersionNumber;
        this.m = hashEpkId;
        this.n = hashUserLoginId;
    }
}
