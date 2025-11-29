package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class Bb {
    private volatile Ab a;
    private CountDownLatch b = new CountDownLatch(1);
    private final long c = 20;
    private final com.yandex.metrica.appsetid.a d = new a();
    private final Context e;
    private final com.yandex.metrica.appsetid.d f;

    public Bb(Context context, com.yandex.metrica.appsetid.d dVar) {
        this.e = context;
        this.f = dVar;
    }

    public static final class a implements com.yandex.metrica.appsetid.a {
        a() {
        }

        @Override // com.yandex.metrica.appsetid.a
        public void a(String str, com.yandex.metrica.appsetid.c cVar) {
            Bb.this.a = new Ab(str, cVar);
            Bb.this.b.countDown();
        }

        @Override // com.yandex.metrica.appsetid.a
        public void a(Throwable th) {
            Bb.this.b.countDown();
        }
    }

    public final synchronized Ab a() {
        Ab ab;
        if (this.a == null) {
            try {
                this.b = new CountDownLatch(1);
                this.f.a(this.e, this.d);
                this.b.await(this.c, TimeUnit.SECONDS);
            } catch (Throwable unused) {
            }
        }
        ab = this.a;
        if (ab == null) {
            ab = new Ab(null, com.yandex.metrica.appsetid.c.UNKNOWN);
            this.a = ab;
        }
        return ab;
    }
}
