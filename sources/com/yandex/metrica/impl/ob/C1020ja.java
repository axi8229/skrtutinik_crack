package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.ja, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1020ja {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile C1020ja y;
    private final Map<String, O7> a = new HashMap();
    private final Map<String, S7> b = new HashMap();
    private final Map<String, R7> c = new HashMap();
    private final M7 d;
    private final Context e;
    private O7 f;
    private O7 g;
    private R7 h;
    private R7 i;
    private R7 j;
    private R7 k;
    private S7 l;
    private S7 m;
    private S7 n;
    private S7 o;
    private S7 p;
    private S7 q;
    private U7 r;
    private T7 s;
    private V7 t;
    private S7 u;
    private C0969h8 v;
    private final B0 w;
    private final C1045ka x;

    public C1020ja(Context context, M7 m7, B0 b0) {
        this.e = context;
        this.d = m7;
        this.w = b0;
        this.x = new C1045ka(context, b0);
    }

    public static C1020ja a(Context context) {
        if (y == null) {
            synchronized (C1020ja.class) {
                try {
                    if (y == null) {
                        y = new C1020ja(context.getApplicationContext(), C1018j8.a(), new B0());
                    }
                } finally {
                }
            }
        }
        return y;
    }

    private R7 k() {
        O7 o7;
        if (this.j == null) {
            synchronized (this) {
                try {
                    if (this.g == null) {
                        this.g = new O7(this.e, a("metrica_aip.db"), this.d.a());
                    }
                    o7 = this.g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.j = new C0971ha(new C0994i8(o7), "binary_data");
        }
        return this.j;
    }

    private S7 l() {
        C0969h8 c0969h8;
        if (this.p == null) {
            synchronized (this) {
                try {
                    if (this.v == null) {
                        String strA = a("metrica_client_data.db");
                        Context context = this.e;
                        this.v = new C0969h8(context, strA, new C1277tm(context, "metrica_client_data.db"), this.d.b());
                    }
                    c0969h8 = this.v;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.p = new C1070la("preferences", c0969h8);
        }
        return this.p;
    }

    private R7 m() {
        if (this.h == null) {
            this.h = new C0971ha(new C0994i8(r()), "binary_data");
        }
        return this.h;
    }

    public synchronized S7 b(I3 i3) {
        S7 c1070la;
        String string = i3.toString();
        c1070la = this.b.get(string);
        if (c1070la == null) {
            c1070la = new C1070la(c(i3), "preferences");
            this.b.put(string, c1070la);
        }
        return c1070la;
    }

    public synchronized S7 c() {
        try {
            if (this.q == null) {
                this.q = new C1095ma(this.e, W7.CLIENT, l());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.q;
    }

    public synchronized S7 d() {
        return l();
    }

    public synchronized T7 e() {
        try {
            if (this.s == null) {
                this.s = new T7(r());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.s;
    }

    public synchronized U7 f() {
        try {
            if (this.r == null) {
                this.r = new U7(r());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.r;
    }

    public synchronized S7 g() {
        try {
            if (this.u == null) {
                String strA = a("metrica_multiprocess_data.db");
                Context context = this.e;
                this.u = new C1070la("preferences", new C0969h8(context, strA, new C1277tm(context, "metrica_multiprocess_data.db"), this.d.d()));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.u;
    }

    public synchronized V7 h() {
        try {
            if (this.t == null) {
                this.t = new V7(r(), "permissions");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.t;
    }

    public synchronized S7 i() {
        try {
            if (this.m == null) {
                Context context = this.e;
                W7 w7 = W7.SERVICE;
                if (this.l == null) {
                    this.l = new C1070la(r(), "preferences");
                }
                this.m = new C1095ma(context, w7, this.l);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.m;
    }

    public synchronized S7 j() {
        try {
            if (this.l == null) {
                this.l = new C1070la(r(), "preferences");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.l;
    }

    public synchronized R7 n() {
        try {
            if (this.i == null) {
                this.i = new C0996ia(this.e, W7.SERVICE, m());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.i;
    }

    public synchronized R7 o() {
        return m();
    }

    public synchronized S7 p() {
        try {
            if (this.o == null) {
                Context context = this.e;
                W7 w7 = W7.SERVICE;
                if (this.n == null) {
                    this.n = new C1070la(r(), "startup");
                }
                this.o = new C1095ma(context, w7, this.n);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.o;
    }

    public synchronized S7 q() {
        try {
            if (this.n == null) {
                this.n = new C1070la(r(), "startup");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.n;
    }

    public synchronized O7 r() {
        String strA;
        try {
            if (this.f == null) {
                File fileC = this.w.c(this.e);
                X7 x7E = this.d.e();
                Context context = this.e;
                if (fileC == null || (strA = this.x.a("metrica_data.db", fileC)) == null) {
                    strA = a("metrica_data.db");
                }
                this.f = new O7(context, strA, x7E);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f;
    }

    public synchronized R7 b() {
        return k();
    }

    public synchronized O7 c(I3 i3) {
        O7 o7;
        String strA;
        try {
            String str = "db_metrica_" + i3;
            o7 = this.a.get(str);
            if (o7 == null) {
                File fileC = this.w.c(this.e);
                X7 x7C = this.d.c();
                Context context = this.e;
                if (fileC == null || (strA = this.x.a(str, fileC)) == null) {
                    strA = a(str);
                }
                O7 o72 = new O7(context, strA, x7C);
                this.a.put(str, o72);
                o7 = o72;
            }
        } finally {
        }
        return o7;
    }

    public synchronized R7 a(I3 i3) {
        R7 c0971ha;
        String string = i3.toString();
        c0971ha = this.c.get(string);
        if (c0971ha == null) {
            c0971ha = new C0971ha(new C0994i8(c(i3)), "binary_data");
            this.c.put(string, c0971ha);
        }
        return c0971ha;
    }

    public synchronized R7 a() {
        try {
            if (this.k == null) {
                this.k = new C0996ia(this.e, W7.AUTO_INAPP, k());
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.k;
    }

    private String a(String str) {
        return A2.a(21) ? this.x.a(str) : str;
    }
}
