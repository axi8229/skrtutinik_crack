package npi.spay;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: npi.spay.w, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2001w {
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

    public /* synthetic */ C2001w(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        if ((i & 1) == 0) {
            this.a = "";
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = "";
        } else {
            this.b = str2;
        }
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
        this.m = (i & 4096) == 0 ? E2.a() : str13;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2001w)) {
            return false;
        }
        C2001w c2001w = (C2001w) obj;
        return Intrinsics.areEqual(this.a, c2001w.a) && Intrinsics.areEqual(this.b, c2001w.b) && Intrinsics.areEqual(this.c, c2001w.c) && Intrinsics.areEqual(this.d, c2001w.d) && Intrinsics.areEqual(this.e, c2001w.e) && Intrinsics.areEqual(this.f, c2001w.f) && Intrinsics.areEqual(this.g, c2001w.g) && Intrinsics.areEqual(this.h, c2001w.h) && Intrinsics.areEqual(this.i, c2001w.i) && Intrinsics.areEqual(this.j, c2001w.j) && Intrinsics.areEqual(this.k, c2001w.k) && Intrinsics.areEqual(this.l, c2001w.l) && Intrinsics.areEqual(this.m, c2001w.m);
    }

    public final int hashCode() {
        return this.m.hashCode() + AbstractC1553e.a(this.l, AbstractC1553e.a(this.k, AbstractC1553e.a(this.j, AbstractC1553e.a(this.i, AbstractC1553e.a(this.h, AbstractC1553e.a(this.g, AbstractC1553e.a(this.f, AbstractC1553e.a(this.e, AbstractC1553e.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "MetaData(apiKey=" + this.a + ", platform=" + this.b + ", browser=" + this.c + ", operationSystem=" + this.d + ", operationSystemVersion=" + this.e + ", systemLanguage=" + this.f + ", deviceVendor=" + this.g + ", deviceModel=" + this.h + ", screenSize=" + this.i + ", deviceMemorySize=" + this.j + ", deviceAbi=" + this.k + ", applicationName=" + this.l + ", timeStamp=" + this.m + ')';
    }

    public C2001w(String apiKey, String platform, String browser, String operationSystem, String operationSystemVersion, String systemLanguage, String deviceVendor, String deviceModel, String screenSize, String deviceMemorySize, String deviceAbi, String applicationName, String timeStamp) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(browser, "browser");
        Intrinsics.checkNotNullParameter(operationSystem, "operationSystem");
        Intrinsics.checkNotNullParameter(operationSystemVersion, "operationSystemVersion");
        Intrinsics.checkNotNullParameter(systemLanguage, "systemLanguage");
        Intrinsics.checkNotNullParameter(deviceVendor, "deviceVendor");
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(screenSize, "screenSize");
        Intrinsics.checkNotNullParameter(deviceMemorySize, "deviceMemorySize");
        Intrinsics.checkNotNullParameter(deviceAbi, "deviceAbi");
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(timeStamp, "timeStamp");
        this.a = apiKey;
        this.b = platform;
        this.c = browser;
        this.d = operationSystem;
        this.e = operationSystemVersion;
        this.f = systemLanguage;
        this.g = deviceVendor;
        this.h = deviceModel;
        this.i = screenSize;
        this.j = deviceMemorySize;
        this.k = deviceAbi;
        this.l = applicationName;
        this.m = timeStamp;
    }
}
