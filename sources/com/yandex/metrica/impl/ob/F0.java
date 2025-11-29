package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.coreutils.services.UtilityServiceConfiguration;
import com.yandex.metrica.coreutils.services.UtilityServiceLocator;
import com.yandex.metrica.impl.ob.C1233s2;
import com.yandex.metrica.impl.ob.C1362xb;
import com.yandex.metrica.impl.ob.InterfaceC0921fa;
import com.yandex.metrica.impl.ob.Jf;
import com.yandex.metrica.networktasks.api.NetworkServiceLocator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class F0 {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile F0 x;
    private final Context a;
    private volatile C1247sg b;
    private volatile C1052kh c;
    private volatile Jf d;
    private volatile C0997ib e;
    private volatile C1233s2 f;
    private volatile C0878dh g;
    private volatile Xj i;
    private volatile E j;
    private volatile C1012j2 k;
    private volatile C1196qc l;
    private volatile C1362xb m;
    private volatile Bb n;
    private volatile I1 o;
    private volatile I p;
    private volatile C0895e9 q;
    private volatile C0894e8 r;
    private C0912f1 t;
    private C1244sd u;
    private final InterfaceC1062l2 v = new a(this);
    private volatile Pm h = new Pm();
    private C0888e2 s = new C0888e2();
    private C1023jd w = new C1023jd();

    class a implements InterfaceC1062l2 {
        a(F0 f0) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
        public void a() {
            NetworkServiceLocator.getInstance().onCreate();
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1062l2
        public void b() {
            NetworkServiceLocator.getInstance().onDestroy();
        }
    }

    private F0(Context context) {
        this.a = context;
        this.t = new C0912f1(context, this.h.a());
        this.j = new E(this.h.a(), this.t.b());
        NetworkServiceLocator.init();
    }

    public static void a(Context context) {
        if (x == null) {
            synchronized (F0.class) {
                try {
                    if (x == null) {
                        x = new F0(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
    }

    public static F0 g() {
        return x;
    }

    private void y() {
        if (this.o == null) {
            synchronized (this) {
                try {
                    if (this.o == null) {
                        ProtobufStateStorage protobufStateStorageA = InterfaceC0921fa.b.a(Ud.class).a(this.a);
                        Ud ud = (Ud) protobufStateStorageA.read();
                        Context context = this.a;
                        C0825be c0825be = new C0825be();
                        Td td = new Td(ud);
                        C0950ge c0950ge = new C0950ge();
                        C0800ae c0800ae = new C0800ae(this.a);
                        F0 f0G = g();
                        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
                        C0895e9 c0895e9S = f0G.s();
                        Intrinsics.checkNotNullExpressionValue(c0895e9S, "GlobalServiceLocator.get…ance().servicePreferences");
                        this.o = new I1(context, protobufStateStorageA, c0825be, td, c0950ge, c0800ae, new C0850ce(c0895e9S), new Vd(), ud, "[PreloadInfoStorage]");
                    }
                } finally {
                }
            }
        }
    }

    public C1326w b() {
        return this.t.a();
    }

    public E c() {
        return this.j;
    }

    public I d() {
        if (this.p == null) {
            synchronized (this) {
                try {
                    if (this.p == null) {
                        ProtobufStateStorage protobufStateStorageA = InterfaceC0921fa.b.a(C1306v3.class).a(this.a);
                        this.p = new I(this.a, protobufStateStorageA, new C1330w3(), new C1210r3(), new C1378y3(), new C0788a2(this.a), new C1354x3(s()), new C1234s3(), (C1306v3) protobufStateStorageA.read(), "[ClidsInfoStorage]");
                    }
                } finally {
                }
            }
        }
        return this.p;
    }

    public Context e() {
        return this.a;
    }

    public C0997ib f() {
        if (this.e == null) {
            synchronized (this) {
                try {
                    if (this.e == null) {
                        this.e = new C0997ib(this.t.a(), new C0972hb());
                    }
                } finally {
                }
            }
        }
        return this.e;
    }

    public C0912f1 h() {
        return this.t;
    }

    public C1196qc i() {
        C1196qc c1196qc = this.l;
        if (c1196qc == null) {
            synchronized (this) {
                try {
                    c1196qc = this.l;
                    if (c1196qc == null) {
                        c1196qc = new C1196qc(this.a);
                        this.l = c1196qc;
                    }
                } finally {
                }
            }
        }
        return c1196qc;
    }

    public C1023jd j() {
        return this.w;
    }

    public I1 k() {
        y();
        return this.o;
    }

    public Jf l() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        Context context = this.a;
                        ProtobufStateStorage protobufStateStorageA = InterfaceC0921fa.b.a(Jf.e.class).a(this.a);
                        C1233s2 c1233s2U = u();
                        if (this.c == null) {
                            synchronized (this) {
                                if (this.c == null) {
                                    this.c = new C1052kh();
                                }
                            }
                        }
                        this.d = new Jf(context, protobufStateStorageA, c1233s2U, this.c, this.h.g(), new Ml());
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
        return this.d;
    }

    public C1247sg m() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.b = new C1247sg(this.a);
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public C0888e2 n() {
        return this.s;
    }

    public C0878dh o() {
        if (this.g == null) {
            synchronized (this) {
                try {
                    if (this.g == null) {
                        this.g = new C0878dh(this.a, this.h.g());
                    }
                } finally {
                }
            }
        }
        return this.g;
    }

    public synchronized C1012j2 p() {
        return this.k;
    }

    public Pm q() {
        return this.h;
    }

    public C1362xb r() {
        if (this.m == null) {
            synchronized (this) {
                try {
                    if (this.m == null) {
                        this.m = new C1362xb(new C1362xb.h(), new C1362xb.d(), new C1362xb.c(), this.h.a(), "ServiceInternal");
                    }
                } finally {
                }
            }
        }
        return this.m;
    }

    public C0895e9 s() {
        if (this.q == null) {
            synchronized (this) {
                try {
                    if (this.q == null) {
                        this.q = new C0895e9(C1020ja.a(this.a).i());
                    }
                } finally {
                }
            }
        }
        return this.q;
    }

    public synchronized C1244sd t() {
        try {
            if (this.u == null) {
                this.u = new C1244sd(this.a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.u;
    }

    public C1233s2 u() {
        if (this.f == null) {
            synchronized (this) {
                try {
                    if (this.f == null) {
                        this.f = new C1233s2(new C1233s2.b(s()));
                    }
                } finally {
                }
            }
        }
        return this.f;
    }

    public Xj v() {
        if (this.i == null) {
            synchronized (this) {
                try {
                    if (this.i == null) {
                        this.i = new Xj(this.a, this.h.h());
                    }
                } finally {
                }
            }
        }
        return this.i;
    }

    public synchronized C0894e8 w() {
        try {
            if (this.r == null) {
                this.r = new C0894e8(this.a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.r;
    }

    public synchronized void x() {
        UtilityServiceLocator.getInstance().initAsync();
        NetworkServiceLocator.getInstance().initAsync();
        this.t.a(this.v);
        l().a();
        y();
        i().b();
    }

    public synchronized void a(C1178pi c1178pi) {
        try {
            if (this.m != null) {
                this.m.a(c1178pi);
            }
            if (this.g != null) {
                this.g.b(c1178pi);
            }
            UtilityServiceLocator.getInstance().updateConfiguration(new UtilityServiceConfiguration(c1178pi.o(), c1178pi.B()));
            if (this.e != null) {
                this.e.b(c1178pi);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public Bb a() {
        if (this.n == null) {
            synchronized (this) {
                try {
                    if (this.n == null) {
                        this.n = new Bb(this.a, Cb.a());
                    }
                } finally {
                }
            }
        }
        return this.n;
    }

    public synchronized void a(C1037k2 c1037k2) {
        this.k = new C1012j2(this.a, c1037k2);
    }
}
