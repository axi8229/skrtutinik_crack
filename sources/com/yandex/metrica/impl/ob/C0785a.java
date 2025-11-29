package com.yandex.metrica.impl.ob;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.yandex.metrica.impl.ob.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0785a {
    private static final long f = TimeUnit.SECONDS.toMillis(1);
    private final b a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Thread c = new c();
    private final AtomicBoolean d = new AtomicBoolean();
    private final Runnable e = new RunnableC0288a();

    /* renamed from: com.yandex.metrica.impl.ob.a$a, reason: collision with other inner class name */
    class RunnableC0288a implements Runnable {
        RunnableC0288a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0785a.this.d.set(true);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.a$b */
    public interface b {
        void a();
    }

    /* renamed from: com.yandex.metrica.impl.ob.a$c */
    private class c extends Thread {
        public c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws InterruptedException {
            boolean z = false;
            int i = 0;
            while (!isInterrupted()) {
                if (!z) {
                    C0785a.this.d.set(false);
                    C0785a.this.b.post(C0785a.this.e);
                    i = 0;
                }
                try {
                    Thread.sleep(C0785a.f);
                    if (C0785a.this.d.get()) {
                        z = false;
                    } else {
                        i++;
                        if (i == 4 && !Debug.isDebuggerConnected()) {
                            C0785a.this.b();
                        }
                        z = true;
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    public C0785a(b bVar) {
        this.a = bVar;
    }

    public void b() {
        this.a.a();
    }

    public void c() {
        try {
            this.c.setName("CR-WatchDog");
        } catch (SecurityException unused) {
        }
        this.c.start();
    }
}
