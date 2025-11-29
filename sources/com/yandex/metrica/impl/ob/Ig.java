package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.Tl;

/* loaded from: classes3.dex */
public class Ig {
    public final String a;
    public final String b;

    @Deprecated
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
    public final String o;
    public final String p;

    public Ig(Tl.a aVar) {
        this.a = aVar.c("dId");
        this.b = aVar.c("uId");
        this.c = aVar.b("kitVer");
        this.d = aVar.c("analyticsSdkVersionName");
        this.e = aVar.c("kitBuildNumber");
        this.f = aVar.c("kitBuildType");
        this.g = aVar.c("appVer");
        this.h = aVar.optString("app_debuggable", "0");
        this.i = aVar.c("appBuild");
        this.j = aVar.c("osVer");
        this.l = aVar.c("lang");
        this.m = aVar.c("root");
        this.p = aVar.c("commit_hash");
        this.n = aVar.optString("app_framework", C0963h2.a());
        int iOptInt = aVar.optInt("osApiLev", -1);
        this.k = iOptInt == -1 ? null : String.valueOf(iOptInt);
        int iOptInt2 = aVar.optInt("attribution_id", 0);
        this.o = iOptInt2 > 0 ? String.valueOf(iOptInt2) : null;
    }

    public String toString() {
        return "DbNetworkTaskConfig{deviceId='" + this.a + "', uuid='" + this.b + "', kitVersion='" + this.c + "', analyticsSdkVersionName='" + this.d + "', kitBuildNumber='" + this.e + "', kitBuildType='" + this.f + "', appVersion='" + this.g + "', appDebuggable='" + this.h + "', appBuildNumber='" + this.i + "', osVersion='" + this.j + "', osApiLevel='" + this.k + "', locale='" + this.l + "', deviceRootStatus='" + this.m + "', appFramework='" + this.n + "', attributionId='" + this.o + "', commitHash='" + this.p + "'}";
    }

    public Ig() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
    }
}
