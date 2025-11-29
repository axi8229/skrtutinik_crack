package com.yandex.metrica.impl.ob;

import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class H0 {
    private final ICommonExecutor a;
    private final J0 b;
    private final d c;
    private final Runnable d = new a();
    private final Runnable e = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            H0.this.b.a();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractC1305v2) H0.this.c).b()) {
                H0.this.d.run();
            }
        }
    }

    public static class c {
        public H0 a(ICommonExecutor iCommonExecutor, J0 j0, d dVar) {
            return new H0(iCommonExecutor, j0, dVar);
        }
    }

    public interface d {
    }

    public H0(ICommonExecutor iCommonExecutor, J0 j0, d dVar) {
        this.a = iCommonExecutor;
        this.b = j0;
        this.c = dVar;
    }

    public void d() {
        this.a.remove(this.d);
        this.a.remove(this.e);
    }

    public void a() {
        this.a.remove(this.d);
        this.a.executeDelayed(this.d, 90L, TimeUnit.SECONDS);
    }

    public void b() {
        this.a.execute(this.e);
    }

    public void c() {
        this.a.remove(this.d);
        this.a.executeDelayed(this.d, 90L, TimeUnit.SECONDS);
    }
}
