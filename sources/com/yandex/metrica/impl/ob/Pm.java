package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.Looper;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.core.api.executors.IHandlerExecutor;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class Pm {
    private final Om a;
    private volatile ICommonExecutor b;
    private volatile ICommonExecutor c;
    private volatile ICommonExecutor d;
    private volatile IHandlerExecutor e;
    private volatile ICommonExecutor f;
    private volatile ICommonExecutor g;
    private volatile ICommonExecutor h;
    private volatile ICommonExecutor i;
    private volatile Executor j;

    public Pm() {
        this(new Om());
    }

    public ICommonExecutor a() {
        if (this.h == null) {
            synchronized (this) {
                try {
                    if (this.h == null) {
                        this.a.getClass();
                        this.h = new Jm("YMM-DE");
                    }
                } finally {
                }
            }
        }
        return this.h;
    }

    public IHandlerExecutor b() {
        if (this.e == null) {
            synchronized (this) {
                try {
                    if (this.e == null) {
                        this.a.getClass();
                        this.e = new Jm("YMM-UH-1");
                    }
                } finally {
                }
            }
        }
        return this.e;
    }

    public ICommonExecutor c() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.a.getClass();
                        this.b = new Jm("YMM-MC");
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public ICommonExecutor d() {
        if (this.f == null) {
            synchronized (this) {
                try {
                    if (this.f == null) {
                        this.a.getClass();
                        this.f = new Jm("YMM-CTH");
                    }
                } finally {
                }
            }
        }
        return this.f;
    }

    public ICommonExecutor e() {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.a.getClass();
                        this.c = new Jm("YMM-MSTE");
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public ICommonExecutor f() {
        if (this.i == null) {
            synchronized (this) {
                try {
                    if (this.i == null) {
                        this.a.getClass();
                        this.i = new Jm("YMM-RTM");
                    }
                } finally {
                }
            }
        }
        return this.i;
    }

    public ICommonExecutor g() {
        if (this.g == null) {
            synchronized (this) {
                try {
                    if (this.g == null) {
                        this.a.getClass();
                        this.g = new Jm("YMM-SIO");
                    }
                } finally {
                }
            }
        }
        return this.g;
    }

    public ICommonExecutor h() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.a.getClass();
                        this.d = new Jm("YMM-TP");
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    public Executor i() {
        if (this.j == null) {
            synchronized (this) {
                try {
                    if (this.j == null) {
                        Om om = this.a;
                        om.getClass();
                        this.j = new Nm(om, new Handler(Looper.getMainLooper()));
                    }
                } finally {
                }
            }
        }
        return this.j;
    }

    Pm(Om om) {
        this.a = om;
    }

    public Lm b(Runnable runnable) {
        this.a.getClass();
        return Mm.a("YMM-IB", runnable);
    }

    public Lm a(Runnable runnable) {
        this.a.getClass();
        return Mm.a("YMM-HMSR", runnable);
    }
}
