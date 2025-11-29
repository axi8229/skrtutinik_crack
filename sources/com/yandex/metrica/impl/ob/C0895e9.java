package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.e9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0895e9 extends AbstractC0870d9 implements InterfaceC1177ph, InterfaceC0919f8 {
    static final Rd c = new Rd("LOCATION_TRACKING_ENABLED", null);
    static final Rd d = new Rd("PREF_KEY_OFFSET", null);
    static final Rd e = new Rd("UNCHECKED_TIME", null);
    static final Rd f = new Rd("STATISTICS_RESTRICTED_IN_MAIN", null);
    static final Rd g;
    static final Rd h;
    static final Rd i;
    static final Rd j;
    static final Rd k;
    static final Rd l;
    static final Rd m;
    private static final Rd n;
    static final Rd o;
    static final Rd p;
    static final Rd q;
    static final Rd r;
    static final Rd s;
    static final Rd t;
    static final Rd u;
    static final Rd v;
    static final Rd w;

    static {
        new Rd("SDKFCE", null);
        new Rd("FST", null);
        new Rd("LSST", null);
        new Rd("FSDKFCO", null);
        new Rd("SRSDKFC", null);
        new Rd("LSDKFCAT", null);
        g = new Rd("LAST_IDENTITY_LIGHT_SEND_TIME", null);
        h = new Rd("NEXT_REPORT_SEND_ATTEMPT_NUMBER", null);
        i = new Rd("NEXT_LOCATION_SEND_ATTEMPT_NUMBER", null);
        j = new Rd("NEXT_STARTUP_SEND_ATTEMPT_NUMBER", null);
        k = new Rd("LAST_REPORT_SEND_ATTEMPT_TIME", null);
        l = new Rd("LAST_LOCATION_SEND_ATTEMPT_TIME", null);
        m = new Rd("LAST_STARTUP_SEND_ATTEMPT_TIME", null);
        n = new Rd("LAST_MIGRATION_VERSION", null);
        o = new Rd("LAST_WIFI_SCANNING_ATTEMPT_TIME", null);
        p = new Rd("LAST_LBS_SCANNING_ATTEMPT_TIME", null);
        q = new Rd("LAST_GPS_SCANNING_ATTEMPT_TIME", null);
        r = new Rd("LAST_FUSED_SCANNING_ATTEMPT_TIME", null);
        s = new Rd("SATELLITE_PRELOAD_INFO_CHECKED", null);
        t = new Rd("SATELLITE_CLIDS_CHECKED", null);
        u = new Rd("CERTIFICATE_REQUEST_ETAG", null);
        v = new Rd("CERTIFICATE_REQUEST_NEXT_ATTEMPT_TIME", null);
        w = new Rd("VITAL_DATA", null);
    }

    public C0895e9(S7 s7) {
        super(s7);
    }

    @Deprecated
    public int a(int i2) {
        return a(n.a(), i2);
    }

    public long b(int i2) {
        return a(d.a(), i2);
    }

    public C0895e9 c(boolean z) {
        return (C0895e9) b(e.a(), z);
    }

    public void d(boolean z) {
        b(c.a(), z).d();
    }

    public long e(long j2) {
        return a(p.a(), j2);
    }

    public Boolean f() {
        Rd rd = f;
        if (c(rd.a())) {
            return Boolean.valueOf(a(rd.a(), true));
        }
        return null;
    }

    public boolean g() {
        return a(c.a(), false);
    }

    public C0895e9 h(long j2) {
        return (C0895e9) b(q.a(), j2);
    }

    public C0895e9 i(long j2) {
        return (C0895e9) b(g.a(), j2);
    }

    public C0895e9 j(long j2) {
        return (C0895e9) b(p.a(), j2);
    }

    public C0895e9 k(long j2) {
        return (C0895e9) b(o.a(), j2);
    }

    public C0895e9 l(long j2) {
        return (C0895e9) b(d.a(), j2);
    }

    public boolean a(boolean z) {
        return a(e.a(), z);
    }

    public C0895e9 b(boolean z) {
        return (C0895e9) b(f.a(), z);
    }

    public long c(long j2) {
        return a(q.a(), j2);
    }

    public long d(long j2) {
        return a(g.a(), j2);
    }

    public C0895e9 g(long j2) {
        return (C0895e9) b(r.a(), j2);
    }

    public C0895e9 h() {
        return (C0895e9) b(t.a(), true);
    }

    public C0895e9 i() {
        return (C0895e9) b(s.a(), true);
    }

    @Deprecated
    public C0895e9 j() {
        return (C0895e9) f(n.a());
    }

    public boolean k() {
        return a(s.a(), false);
    }

    public boolean l() {
        return a(t.a(), false);
    }

    public int a(EnumC1197qd enumC1197qd, int i2) {
        Rd rdB = b(enumC1197qd);
        return rdB == null ? i2 : a(rdB.a(), i2);
    }

    public C0895e9 b(EnumC1197qd enumC1197qd, int i2) {
        Rd rdB = b(enumC1197qd);
        return rdB != null ? (C0895e9) b(rdB.a(), i2) : this;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0919f8
    public String c() {
        return a(w.a(), (String) null);
    }

    public long f(long j2) {
        return a(o.a(), j2);
    }

    public long a(EnumC1197qd enumC1197qd, long j2) {
        Rd rdA = a(enumC1197qd);
        return rdA == null ? j2 : a(rdA.a(), j2);
    }

    public C0895e9 b(EnumC1197qd enumC1197qd, long j2) {
        Rd rdA = a(enumC1197qd);
        return rdA != null ? (C0895e9) b(rdA.a(), j2) : this;
    }

    public C0895e9 a(String str, String str2, String str3) {
        return (C0895e9) b(new Rd("LAST_SOCKET_REPORT_TIMES_" + str + "_" + str2, null).a(), str3);
    }

    public long b(long j2) {
        return a(r.a(), j2);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1177ph
    public String b() {
        return a(u.a(), (String) null);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1177ph
    public long a() {
        return a(v.a(), 0L);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1177ph
    public InterfaceC1177ph b(String str) {
        return (InterfaceC1177ph) b(u.a(), str);
    }

    private Rd b(EnumC1197qd enumC1197qd) {
        int iOrdinal = enumC1197qd.ordinal();
        if (iOrdinal == 0) {
            return h;
        }
        if (iOrdinal == 1) {
            return i;
        }
        if (iOrdinal != 2) {
            return null;
        }
        return j;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1177ph
    public InterfaceC1177ph a(long j2) {
        return (InterfaceC1177ph) b(v.a(), j2);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0919f8
    public void a(String str) {
        b(w.a(), str);
    }

    private Rd a(EnumC1197qd enumC1197qd) {
        int iOrdinal = enumC1197qd.ordinal();
        if (iOrdinal == 0) {
            return k;
        }
        if (iOrdinal == 1) {
            return l;
        }
        if (iOrdinal != 2) {
            return null;
        }
        return m;
    }
}
