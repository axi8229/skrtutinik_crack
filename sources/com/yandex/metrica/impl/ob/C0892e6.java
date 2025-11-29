package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.Tl;

/* renamed from: com.yandex.metrica.impl.ob.e6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0892e6 implements InterfaceC0867d6 {
    private final String a;
    protected final C0845c9 b;
    private Tl.a c;

    public C0892e6(C0845c9 c0845c9, String str) {
        this.b = c0845c9;
        this.a = str;
        Tl.a aVar = new Tl.a();
        try {
            String strG = c0845c9.g(str);
            if (!TextUtils.isEmpty(strG)) {
                aVar = new Tl.a(strG);
            }
        } catch (Throwable unused) {
        }
        this.c = aVar;
    }

    public C0892e6 a(long j) {
        a("SESSION_INIT_TIME", Long.valueOf(j));
        return this;
    }

    public C0892e6 b(long j) {
        a("SESSION_LAST_EVENT_OFFSET", Long.valueOf(j));
        return this;
    }

    public Long c() {
        return this.c.a("SESSION_INIT_TIME");
    }

    public C0892e6 d(long j) {
        a("SESSION_ID", Long.valueOf(j));
        return this;
    }

    public Long e() {
        return this.c.a("SESSION_COUNTER_ID");
    }

    public Long f() {
        return this.c.a("SESSION_ID");
    }

    public Long g() {
        return this.c.a("SESSION_SLEEP_START");
    }

    public boolean h() {
        return this.c.length() > 0;
    }

    public Boolean i() {
        Tl.a aVar = this.c;
        aVar.getClass();
        try {
            return Boolean.valueOf(aVar.getBoolean("SESSION_IS_ALIVE_REPORT_NEEDED"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public C0892e6 a(boolean z) {
        a("SESSION_IS_ALIVE_REPORT_NEEDED", Boolean.valueOf(z));
        return this;
    }

    public void b() {
        this.b.c(this.a, this.c.toString());
        this.b.d();
    }

    public C0892e6 c(long j) {
        a("SESSION_COUNTER_ID", Long.valueOf(j));
        return this;
    }

    public Long d() {
        return this.c.a("SESSION_LAST_EVENT_OFFSET");
    }

    public C0892e6 e(long j) {
        a("SESSION_SLEEP_START", Long.valueOf(j));
        return this;
    }

    private void a(String str, Object obj) {
        try {
            this.c.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        this.c = new Tl.a();
        b();
    }
}
