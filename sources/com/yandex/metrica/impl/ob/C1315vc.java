package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import com.yandex.metrica.impl.ob.C1178pi;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.vc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1315vc {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile C1315vc n;
    public static final long o = TimeUnit.MINUTES.toMillis(1);
    private static final Object p = new Object();
    public static final /* synthetic */ int q = 0;
    private C1097mc c;
    private C1178pi d;
    private Mc e;
    private c f;
    private Runnable g;
    private final Sb h;
    private final U7 i;
    private final T7 j;
    private final Ed k;
    private boolean b = false;
    private boolean l = false;
    private final Object m = new Object();
    private final WeakHashMap<Object, Object> a = new WeakHashMap<>();

    /* renamed from: com.yandex.metrica.impl.ob.vc$a */
    class a implements Runnable {
        final /* synthetic */ C1178pi a;

        a(C1178pi c1178pi) {
            this.a = c1178pi;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1315vc.this.e != null) {
                C1315vc.this.e.a(this.a);
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.vc$b */
    class b implements Runnable {
        final /* synthetic */ C1097mc a;

        b(C1097mc c1097mc) {
            this.a = c1097mc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1315vc.this.e != null) {
                C1315vc.this.e.a(this.a);
            }
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.vc$c */
    static class c {
        c() {
        }
    }

    C1315vc(Context context, C1339wc c1339wc, c cVar, C1178pi c1178pi) {
        this.h = new Sb(context, c1339wc.a(), c1339wc.d());
        this.i = c1339wc.c();
        this.j = c1339wc.b();
        this.k = c1339wc.e();
        this.f = cVar;
        this.d = c1178pi;
    }

    public void b(Object obj) {
        synchronized (this.m) {
            this.a.remove(obj);
            b();
        }
    }

    public static C1315vc a(Context context) {
        if (n == null) {
            synchronized (p) {
                try {
                    if (n == null) {
                        Context applicationContext = context.getApplicationContext();
                        n = new C1315vc(applicationContext, new C1339wc(applicationContext), new c(), new C1178pi.b(applicationContext).a());
                    }
                } finally {
                }
            }
        }
        return n;
    }

    private void b() {
        if (this.l) {
            if (!this.b || this.a.isEmpty()) {
                this.h.b.execute(new RunnableC1243sc(this));
                Runnable runnable = this.g;
                if (runnable != null) {
                    this.h.b.remove(runnable);
                }
                this.l = false;
                return;
            }
            return;
        }
        if (!this.b || this.a.isEmpty()) {
            return;
        }
        if (this.e == null) {
            c cVar = this.f;
            Nc nc = new Nc(this.h, this.i, this.j, this.d, this.c);
            cVar.getClass();
            this.e = new Mc(nc);
        }
        this.h.b.execute(new RunnableC1267tc(this));
        if (this.g == null) {
            RunnableC1291uc runnableC1291uc = new RunnableC1291uc(this);
            this.g = runnableC1291uc;
            this.h.b.executeDelayed(runnableC1291uc, o);
        }
        this.h.b.execute(new RunnableC1219rc(this));
        this.l = true;
    }

    public void a(Object obj) {
        synchronized (this.m) {
            this.a.put(obj, null);
            b();
        }
    }

    public Location a() {
        Mc mc = this.e;
        if (mc == null) {
            return null;
        }
        return mc.b();
    }

    public void a(boolean z) {
        synchronized (this.m) {
            try {
                if (this.b != z) {
                    this.b = z;
                    this.k.a(z);
                    this.h.c.a(this.k.a());
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(C1178pi c1178pi, C1097mc c1097mc) {
        synchronized (this.m) {
            try {
                this.d = c1178pi;
                this.k.a(c1178pi);
                this.h.c.a(this.k.a());
                this.h.b.execute(new a(c1178pi));
                if (!A2.a(this.c, c1097mc)) {
                    a(c1097mc);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(C1097mc c1097mc) {
        synchronized (this.m) {
            this.c = c1097mc;
        }
        this.h.b.execute(new b(c1097mc));
    }

    static void b(C1315vc c1315vc) {
        c1315vc.h.b.executeDelayed(c1315vc.g, o);
    }
}
