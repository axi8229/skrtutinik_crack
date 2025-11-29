package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

/* loaded from: classes3.dex */
public class L {
    private final W0 a;
    private final W0 b;
    private final W0 c;
    private final W0 d;
    private final W0 e;
    private final W0 f;
    private final W0 g;
    private final W0 h;
    private final W0 i;
    private final W0 j;
    private final W0 k;
    private final long l;
    private final C0932fl m;
    private final C1217ra n;
    private final long o;
    private final Xh p;

    L(C1178pi c1178pi, C1410zb c1410zb, Map<String, String> map) {
        this(a(c1178pi.V()), a(c1178pi.i()), a(c1178pi.j()), a(c1178pi.G()), a(c1178pi.p()), a(Tl.a(Tl.a(c1178pi.n()))), a(Tl.a(map)), new W0(c1410zb.a().a == null ? null : c1410zb.a().a.b, c1410zb.a().b, c1410zb.a().c), new W0(c1410zb.b().a == null ? null : c1410zb.b().a.b, c1410zb.b().b, c1410zb.b().c), new W0(c1410zb.c().a != null ? c1410zb.c().a.b : null, c1410zb.c().b, c1410zb.c().c), a(Tl.b(c1178pi.h())), new C0932fl(c1178pi), c1178pi.l(), C0810b.a(), c1178pi.C() + c1178pi.O().a(), a(c1178pi.f().x));
    }

    public W0 a() {
        return this.g;
    }

    public W0 b() {
        return this.k;
    }

    public W0 c() {
        return this.b;
    }

    public W0 d() {
        return this.c;
    }

    public C1217ra e() {
        return this.n;
    }

    public Xh f() {
        return this.p;
    }

    public W0 g() {
        return this.h;
    }

    public W0 h() {
        return this.e;
    }

    public W0 i() {
        return this.i;
    }

    public long j() {
        return this.o;
    }

    public W0 k() {
        return this.d;
    }

    public W0 l() {
        return this.f;
    }

    public long m() {
        return this.l;
    }

    public C0932fl n() {
        return this.m;
    }

    public W0 o() {
        return this.a;
    }

    public W0 p() {
        return this.j;
    }

    public String toString() {
        return "ClientIdentifiersHolder{mUuidData=" + this.a + ", mDeviceIdData=" + this.b + ", mDeviceIdHashData=" + this.c + ", mReportAdUrlData=" + this.d + ", mGetAdUrlData=" + this.e + ", mResponseClidsData=" + this.f + ", mClientClidsForRequestData=" + this.g + ", mGaidData=" + this.h + ", mHoaidData=" + this.i + ", yandexAdvIdData=" + this.j + ", customSdkHostsData=" + this.k + ", customSdkHosts=" + this.k + ", mServerTimeOffset=" + this.l + ", mUiAccessConfig=" + this.m + ", diagnosticsConfigsHolder=" + this.n + ", nextStartupTime=" + this.o + ", features=" + this.p + '}';
    }

    private static Bundle a(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppMeasurementSdk.ConditionalUserProperty.VALUE, parcelable);
        return bundle;
    }

    private static C0932fl b(Bundle bundle) {
        return (C0932fl) a(bundle.getBundle("UiAccessConfig"), C0932fl.class.getClassLoader());
    }

    public void c(Bundle bundle) {
        bundle.putBundle("Uuid", a(this.a));
        bundle.putBundle("DeviceId", a(this.b));
        bundle.putBundle("DeviceIdHash", a(this.c));
        bundle.putBundle("AdUrlReport", a(this.d));
        bundle.putBundle("AdUrlGet", a(this.e));
        bundle.putBundle("Clids", a(this.f));
        bundle.putBundle("RequestClids", a(this.g));
        bundle.putBundle("GAID", a(this.h));
        bundle.putBundle("HOAID", a(this.i));
        bundle.putBundle("YANDEX_ADV_ID", a(this.j));
        bundle.putBundle("CUSTOM_SDK_HOSTS", a(this.k));
        bundle.putBundle("UiAccessConfig", a(this.m));
        bundle.putBundle("DiagnosticsConfigsHolder", a(this.n));
        bundle.putLong("ServerTimeOffset", this.l);
        bundle.putLong("NextStartupTime", this.o);
        bundle.putBundle("features", a(this.p));
    }

    private static Parcelable a(Bundle bundle, ClassLoader classLoader) {
        if (bundle == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return bundle.getParcelable(AppMeasurementSdk.ConditionalUserProperty.VALUE);
    }

    private static W0 b(Bundle bundle, String str) {
        W0 w0 = (W0) a(bundle.getBundle(str), W0.class.getClassLoader());
        return w0 == null ? new W0(null, U0.UNKNOWN, "bundle serialization error") : w0;
    }

    private static C1217ra a(Bundle bundle) {
        C1217ra c1217ra = (C1217ra) a(bundle.getBundle("DiagnosticsConfigsHolder"), C1217ra.class.getClassLoader());
        return c1217ra == null ? new C1217ra() : c1217ra;
    }

    private static Xh a(Bundle bundle, String str) {
        Xh xh = (Xh) a(bundle.getBundle(str), Xh.class.getClassLoader());
        return xh == null ? new Xh(null, U0.UNKNOWN, "bundle serialization error") : xh;
    }

    private static W0 a(String str) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        return new W0(str, zIsEmpty ? U0.UNKNOWN : U0.OK, zIsEmpty ? "no identifier in startup state" : null);
    }

    private static Xh a(Boolean bool) {
        boolean z = bool != null;
        return new Xh(bool, z ? U0.OK : U0.UNKNOWN, z ? null : "no identifier in startup state");
    }

    public L(Bundle bundle) {
        this(b(bundle, "Uuid"), b(bundle, "DeviceId"), b(bundle, "DeviceIdHash"), b(bundle, "AdUrlReport"), b(bundle, "AdUrlGet"), b(bundle, "Clids"), b(bundle, "RequestClids"), b(bundle, "GAID"), b(bundle, "HOAID"), b(bundle, "YANDEX_ADV_ID"), b(bundle, "CUSTOM_SDK_HOSTS"), b(bundle), a(bundle), bundle.getLong("ServerTimeOffset"), bundle.getLong("NextStartupTime"), a(bundle, "features"));
    }

    public L(W0 w0, W0 w02, W0 w03, W0 w04, W0 w05, W0 w06, W0 w07, W0 w08, W0 w09, W0 w010, W0 w011, C0932fl c0932fl, C1217ra c1217ra, long j, long j2, Xh xh) {
        this.a = w0;
        this.b = w02;
        this.c = w03;
        this.d = w04;
        this.e = w05;
        this.f = w06;
        this.g = w07;
        this.h = w08;
        this.i = w09;
        this.j = w010;
        this.k = w011;
        this.m = c0932fl;
        this.n = c1217ra;
        this.l = j;
        this.o = j2;
        this.p = xh;
    }
}
