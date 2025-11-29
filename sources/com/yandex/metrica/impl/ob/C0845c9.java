package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1230s;
import java.util.Collections;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.c9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0845c9 extends AbstractC0870d9 implements InterfaceC0919f8 {
    private static final Rd c = new Rd("IDENTITY_SEND_TIME", null);
    private static final Rd d = new Rd("PERMISSIONS_CHECK_TIME", null);
    private static final Rd e = new Rd("USER_INFO", null);
    private static final Rd f = new Rd("PROFILE_ID", null);
    private static final Rd g = new Rd("APP_ENVIRONMENT", null);
    private static final Rd h = new Rd("APP_ENVIRONMENT_REVISION", null);
    private static final Rd i = new Rd("LAST_MIGRATION_VERSION", null);
    private static final Rd j = new Rd("LAST_APP_VERSION_WITH_FEATURES", null);
    private static final Rd k = new Rd("APPLICATION_FEATURES", null);
    private static final Rd l = new Rd("LAST_STAT_SENDING_DISABLED_REPORTING_TIMESTAMP", null);
    private static final Rd m = new Rd("CERTIFICATES_SHA1_FINGERPRINTS", null);
    static final Rd n = new Rd("DEPRECATED_NATIVE_CRASHES_CHECKED", null);
    private static final Rd o = new Rd("REFERRER_HANDLED", null);
    private static final Rd p = new Rd("VITAL_DATA", null);

    public C0845c9(S7 s7) {
        super(s7);
    }

    public C0845c9 a(C1230s.a aVar) {
        synchronized (this) {
            b(g.a(), aVar.a);
            b(h.a(), aVar.b);
        }
        return this;
    }

    public long b(long j2) {
        return a(c.a(), j2);
    }

    public C0845c9 c(long j2) {
        return (C0845c9) b(c.a(), j2);
    }

    public C0845c9 d(long j2) {
        return (C0845c9) b(l.a(), j2);
    }

    public C0845c9 e(long j2) {
        return (C0845c9) b(d.a(), j2);
    }

    public C1230s.a f() {
        C1230s.a aVar;
        synchronized (this) {
            aVar = new C1230s.a(a(g.a(), "{}"), a(h.a(), 0L));
        }
        return aVar;
    }

    public String g() {
        return a(k.a(), "");
    }

    public C0845c9 h(String str) {
        return (C0845c9) b(k.a(), str);
    }

    public int i() {
        return a(j.a(), -1);
    }

    public C0845c9 j(String str) {
        return (C0845c9) b(e.a(), str);
    }

    public long k() {
        return a(l.a(), 0L);
    }

    public long l() {
        return a(d.a(), 0L);
    }

    public String m() {
        return e(f.a());
    }

    public String n() {
        return a(e.a(), (String) null);
    }

    public boolean o() {
        return a(n.a(), false);
    }

    public C0845c9 p() {
        return (C0845c9) b(n.a(), true);
    }

    @Deprecated
    public C0845c9 q() {
        return (C0845c9) b(o.a(), true);
    }

    @Deprecated
    public C0845c9 r() {
        return (C0845c9) f(i.a());
    }

    @Deprecated
    public C0845c9 s() {
        return (C0845c9) f(o.a());
    }

    @Deprecated
    public Boolean t() {
        Rd rd = o;
        if (c(rd.a())) {
            return Boolean.valueOf(a(rd.a(), false));
        }
        return null;
    }

    public C0845c9 c(String str, String str2) {
        return (C0845c9) b(new Rd("SESSION_", str).a(), str2);
    }

    public String g(String str) {
        return a(new Rd("SESSION_", str).a(), "");
    }

    public List<String> h() {
        return a(m.a(), Collections.emptyList());
    }

    public C0845c9 i(String str) {
        return (C0845c9) b(f.a(), str);
    }

    @Deprecated
    public Integer j() {
        Rd rd = i;
        if (c(rd.a())) {
            return Integer.valueOf((int) a(rd.a(), 0L));
        }
        return null;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0919f8
    public String c() {
        return a(p.a(), (String) null);
    }

    public C0845c9 a(int i2) {
        return (C0845c9) b(j.a(), i2);
    }

    public C0845c9 a(List<String> list) {
        return (C0845c9) b(m.a(), list);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0919f8
    public void a(String str) {
        b(p.a(), str);
    }
}
