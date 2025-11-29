package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import com.yandex.metrica.impl.ob.C1159p;
import java.lang.ref.WeakReference;

/* renamed from: com.yandex.metrica.impl.ob.f2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0913f2 implements C1159p.b {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile C0913f2 g;
    private final Context a;
    private C0838c2 b;
    private WeakReference<Activity> c = new WeakReference<>(null);
    private final C0820b9 d;
    private final C0863d2 e;
    private boolean f;

    C0913f2(Context context, C0820b9 c0820b9, C0863d2 c0863d2) {
        this.a = context;
        this.d = c0820b9;
        this.e = c0863d2;
        this.b = c0820b9.s();
        this.f = c0820b9.x();
        P.g().a().a(this);
    }

    public static C0913f2 a(Context context) {
        if (g == null) {
            synchronized (C0913f2.class) {
                try {
                    if (g == null) {
                        g = new C0913f2(context, new C0820b9(C1020ja.a(context).c()), new C0863d2());
                    }
                } finally {
                }
            }
        }
        return g;
    }

    private void b(Context context) {
        C0838c2 c0838c2A;
        if (context == null || (c0838c2A = this.e.a(context)) == null || c0838c2A.equals(this.b)) {
            return;
        }
        this.b = c0838c2A;
        this.d.a(c0838c2A);
    }

    public synchronized C0838c2 a() {
        try {
            b(this.c.get());
            if (this.b == null) {
                if (A2.a(30)) {
                    if (!this.f) {
                        b(this.a);
                        this.f = true;
                        this.d.z();
                    }
                } else {
                    b(this.a);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.b;
    }

    @Override // com.yandex.metrica.impl.ob.C1159p.b
    public synchronized void a(Activity activity) {
        this.c = new WeakReference<>(activity);
        if (this.b == null) {
            b(activity);
        }
    }
}
