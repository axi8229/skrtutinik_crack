package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class V5 {
    private final L3 a;
    private final InterfaceC0867d6 b;
    private final X5 c;
    private long d;
    private long e;
    private AtomicLong f;
    private boolean g;
    private volatile a h;
    private long i;
    private long j;
    private SystemTimeProvider k;

    static class a {
        private final String a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final int f;
        private final int g;

        a(JSONObject jSONObject) {
            this.a = jSONObject.optString("analyticsSdkVersionName", null);
            this.b = jSONObject.optString("kitBuildNumber", null);
            this.c = jSONObject.optString("appVer", null);
            this.d = jSONObject.optString("appBuild", null);
            this.e = jSONObject.optString("osVer", null);
            this.f = jSONObject.optInt("osApiLev", -1);
            this.g = jSONObject.optInt("attribution_id", 0);
        }

        boolean a(Lg lg) {
            lg.getClass();
            return TextUtils.equals("5.3.0", this.a) && TextUtils.equals("45003240", this.b) && TextUtils.equals(lg.f(), this.c) && TextUtils.equals(lg.b(), this.d) && TextUtils.equals(lg.o(), this.e) && this.f == lg.n() && this.g == lg.C();
        }

        public String toString() {
            return "SessionRequestParams{mKitVersionName='" + this.a + "', mKitBuildNumber='" + this.b + "', mAppVersion='" + this.c + "', mAppBuild='" + this.d + "', mOsVersion='" + this.e + "', mApiLevel=" + this.f + ", mAttributionId=" + this.g + '}';
        }
    }

    V5(L3 l3, InterfaceC0867d6 interfaceC0867d6, X5 x5, SystemTimeProvider systemTimeProvider) {
        this.a = l3;
        this.b = interfaceC0867d6;
        this.c = x5;
        this.k = systemTimeProvider;
        g();
    }

    private void g() {
        this.e = this.c.a(this.k.elapsedRealtime());
        this.d = this.c.c(-1L);
        this.f = new AtomicLong(this.c.b(0L));
        this.g = this.c.a(true);
        long jE = this.c.e(0L);
        this.i = jE;
        this.j = this.c.d(jE - this.e);
    }

    long a(long j) {
        InterfaceC0867d6 interfaceC0867d6 = this.b;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j - this.e);
        this.j = seconds;
        ((C0892e6) interfaceC0867d6).b(seconds);
        return this.j;
    }

    long b() {
        return Math.max(this.i - TimeUnit.MILLISECONDS.toSeconds(this.e), this.j);
    }

    public long c() {
        return this.d;
    }

    long d() {
        return this.j;
    }

    long e() {
        long andIncrement = this.f.getAndIncrement();
        ((C0892e6) this.b).c(this.f.get()).b();
        return andIncrement;
    }

    protected EnumC0917f6 f() {
        return this.c.a();
    }

    boolean h() {
        return this.g && this.d > 0;
    }

    synchronized void i() {
        ((C0892e6) this.b).a();
        this.h = null;
    }

    public String toString() {
        return "Session{mId=" + this.d + ", mInitTime=" + this.e + ", mCurrentReportId=" + this.f + ", mSessionRequestParams=" + this.h + ", mSleepStartSeconds=" + this.i + '}';
    }

    boolean b(long j) {
        boolean z = this.d >= 0;
        boolean zA = a();
        long jElapsedRealtime = this.k.elapsedRealtime();
        long j2 = this.i;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return z && zA && !(((timeUnit.toSeconds(jElapsedRealtime) > j2 ? 1 : (timeUnit.toSeconds(jElapsedRealtime) == j2 ? 0 : -1)) < 0) || ((timeUnit.toSeconds(j) - j2) > ((long) this.c.a(this.a.m().N())) ? 1 : ((timeUnit.toSeconds(j) - j2) == ((long) this.c.a(this.a.m().N())) ? 0 : -1)) >= 0 || (timeUnit.toSeconds(j - this.e) > Y5.b ? 1 : (timeUnit.toSeconds(j - this.e) == Y5.b ? 0 : -1)) >= 0);
    }

    void c(long j) {
        InterfaceC0867d6 interfaceC0867d6 = this.b;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(j);
        this.i = seconds;
        ((C0892e6) interfaceC0867d6).e(seconds).b();
    }

    public void a(boolean z) {
        if (this.g != z) {
            this.g = z;
            ((C0892e6) this.b).a(z).b();
        }
    }

    private boolean a() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    try {
                        String asString = this.a.i().a(this.d, this.c.a()).getAsString("report_request_parameters");
                        if (!TextUtils.isEmpty(asString)) {
                            this.h = new a(new JSONObject(asString));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        a aVar = this.h;
        if (aVar != null) {
            return aVar.a(this.a.m());
        }
        return false;
    }
}
