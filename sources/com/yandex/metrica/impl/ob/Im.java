package com.yandex.metrica.impl.ob;

import android.os.Handler;
import android.os.Looper;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.core.api.executors.IHandlerExecutor;

/* loaded from: classes3.dex */
public class Im {
    private final Hm a;
    private volatile IHandlerExecutor b;
    private volatile ICommonExecutor c;
    private volatile ICommonExecutor d;
    private volatile Handler e;

    public Im() {
        this(new Hm());
    }

    public ICommonExecutor a() {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        this.a.getClass();
                        this.c = new Jm("YMM-APT");
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    public IHandlerExecutor b() {
        if (this.b == null) {
            synchronized (this) {
                try {
                    if (this.b == null) {
                        this.a.getClass();
                        this.b = new Jm("YMM-YM");
                    }
                } finally {
                }
            }
        }
        return this.b;
    }

    public Handler c() {
        if (this.e == null) {
            synchronized (this) {
                try {
                    if (this.e == null) {
                        this.a.getClass();
                        this.e = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return this.e;
    }

    public ICommonExecutor d() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.a.getClass();
                        this.d = new Jm("YMM-RS");
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    Im(Hm hm) {
        this.a = hm;
    }
}
