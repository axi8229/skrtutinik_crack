package com.yandex.metrica.impl.ob;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* renamed from: com.yandex.metrica.impl.ob.o1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1136o1 {
    public static final long j = TimeUnit.SECONDS.toMillis(10);
    private final Context a;
    private final ICommonExecutor b;
    private boolean c;
    private final List<c> d;
    private IMetricaService e;
    private final Object f;
    private final C1400z1 g;
    private final Runnable h;
    private final ServiceConnection i;

    /* renamed from: com.yandex.metrica.impl.ob.o1$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1136o1.a(C1136o1.this);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.o1$b */
    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (C1136o1.this) {
                C1136o1.this.e = IMetricaService.a.a(iBinder);
            }
            C1136o1.b(C1136o1.this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (C1136o1.this) {
                C1136o1.this.e = null;
            }
            C1136o1.c(C1136o1.this);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.o1$c */
    interface c {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public C1136o1(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, P.g().i());
    }

    static void c(C1136o1 c1136o1) {
        Iterator<c> it = c1136o1.d.iterator();
        while (it.hasNext()) {
            it.next().onServiceDisconnected();
        }
    }

    public void b() {
        synchronized (this) {
            try {
                if (this.e != null) {
                    return;
                }
                Intent intentA = C1112n2.a(this.a);
                try {
                    this.g.a(this.a);
                    this.a.bindService(intentA, this.i, 1);
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized IMetricaService d() {
        return this.e;
    }

    public synchronized boolean e() {
        return this.e != null;
    }

    void f() {
        synchronized (this.f) {
            this.b.remove(this.h);
        }
    }

    public void g() {
        ICommonExecutor iCommonExecutor = this.b;
        synchronized (this.f) {
            try {
                iCommonExecutor.remove(this.h);
                if (!this.c) {
                    iCommonExecutor.executeDelayed(this.h, j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void a(C1136o1 c1136o1) {
        synchronized (c1136o1) {
            if (c1136o1.a != null && c1136o1.e()) {
                try {
                    c1136o1.e = null;
                    c1136o1.a.unbindService(c1136o1.i);
                } catch (Throwable unused) {
                }
            }
            c1136o1.e = null;
            Iterator<c> it = c1136o1.d.iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected();
            }
        }
    }

    C1136o1(Context context, ICommonExecutor iCommonExecutor, C1400z1 c1400z1) {
        this.d = new CopyOnWriteArrayList();
        this.e = null;
        this.f = new Object();
        this.h = new a();
        this.i = new b();
        this.a = context.getApplicationContext();
        this.b = iCommonExecutor;
        this.c = false;
        this.g = c1400z1;
    }

    public void c() {
        synchronized (this.f) {
            this.c = true;
            f();
        }
    }

    static void b(C1136o1 c1136o1) {
        Iterator<c> it = c1136o1.d.iterator();
        while (it.hasNext()) {
            it.next().onServiceConnected();
        }
    }

    public void a(c cVar) {
        this.d.add(cVar);
    }

    public void a() {
        synchronized (this.f) {
            this.c = false;
            g();
        }
    }
}
