package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.networktasks.api.RetryPolicyConfig;

/* loaded from: classes3.dex */
public class Eg {
    private String a;
    private U b;
    private C0838c2 c;
    private final String d = y();
    private String e = C0963h2.a();
    private String f;
    private String g;
    private Ab h;
    private C1410zb i;
    private String j;
    private String k;
    private C1178pi l;

    public static abstract class a<I, O> implements Dg<I, O> {
        public final String a;
        public final String b;
        public final String c;

        public a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    protected static abstract class b<T extends Eg, A extends a> implements d<T, c<A>> {
        final Context a;
        final String b;

        protected b(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        protected abstract T a();
    }

    public static class c<A> {
        public final C1178pi a;
        public final A b;

        public c(C1178pi c1178pi, A a) {
            this.a = c1178pi;
            this.b = a;
        }
    }

    public interface d<T extends Eg, D> {
        T a(D d);
    }

    private static String y() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty("public")) {
            sb.append("public");
        }
        if (!TextUtils.isEmpty("binary")) {
            sb.append("_binary");
        }
        if (!TextUtils.isEmpty("")) {
            sb.append("_");
        }
        return sb.toString();
    }

    protected void a(U u) {
        this.b = u;
    }

    public String b() {
        String str = this.g;
        return str == null ? "" : str;
    }

    public String c() {
        return this.e;
    }

    public synchronized String d() {
        String strA;
        Ab ab = this.h;
        strA = ab == null ? null : ab.a();
        if (strA == null) {
            strA = "";
        }
        return strA;
    }

    protected void e(String str) {
        this.a = str;
    }

    public String f() {
        String str = this.f;
        return str == null ? "" : str;
    }

    public synchronized String g() {
        String strI;
        strI = this.l.i();
        if (strI == null) {
            strI = "";
        }
        return strI;
    }

    public String h() {
        return this.b.e;
    }

    public String i() {
        String str = this.j;
        return str == null ? com.yandex.metrica.b.PHONE.a() : str;
    }

    public String j() {
        return this.d;
    }

    public String k() {
        String str = this.k;
        return str == null ? "" : str;
    }

    public String l() {
        String str = this.b.a;
        return str == null ? "" : str;
    }

    public String m() {
        return this.b.b;
    }

    public int n() {
        return this.b.d;
    }

    public String o() {
        return this.b.c;
    }

    public String p() {
        return this.a;
    }

    public RetryPolicyConfig q() {
        return this.l.J();
    }

    public float r() {
        return this.c.d();
    }

    public int s() {
        return this.c.b();
    }

    public int t() {
        return this.c.c();
    }

    public String toString() {
        return "BaseRequestConfig{mPackageName='" + this.a + "', mConstantDeviceInfo=" + this.b + ", screenInfo=" + this.c + ", mSdkVersionName='5.3.0', mSdkBuildNumber='45003240', mSdkBuildType='" + this.d + "', mAppPlatform='android', mProtocolVersion='2', mAppFramework='" + this.e + "', mCommitHash='a72bf6f57701ed3c2b8ed570054febbff4e58c12', mAppVersion='" + this.f + "', mAppBuildNumber='" + this.g + "', appSetId=" + this.h + ", mAdvertisingIdsHolder=" + this.i + ", mDeviceType='" + this.j + "', mLocale='" + this.k + "', mStartupState=" + this.l + '}';
    }

    public int u() {
        return this.c.e();
    }

    protected C1178pi v() {
        return this.l;
    }

    public synchronized String w() {
        String strV;
        strV = this.l.V();
        if (strV == null) {
            strV = "";
        }
        return strV;
    }

    public synchronized boolean x() {
        return C1128ni.a(this.l);
    }

    protected void a(C0838c2 c0838c2) {
        this.c = c0838c2;
    }

    protected void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f = str;
    }

    void c(String str) {
        this.j = str;
    }

    final void d(String str) {
        this.k = str;
    }

    public synchronized String e() {
        String strA;
        Ab ab = this.h;
        strA = ab == null ? null : ab.b().a();
        if (strA == null) {
            strA = "";
        }
        return strA;
    }

    protected void a(C1178pi c1178pi) {
        this.l = c1178pi;
    }

    protected void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g = str;
    }

    public synchronized void a(Ab ab) {
        this.h = ab;
    }

    public C1410zb a() {
        return this.i;
    }

    protected void a(C1410zb c1410zb) {
        this.i = c1410zb;
    }
}
