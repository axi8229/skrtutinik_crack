package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.io.File;

/* loaded from: classes3.dex */
public class Eh {
    private final Context a;
    private final Mh b;
    private final C1296uh c;
    private Jh d;
    private Jh e;
    private C1178pi f;

    public Eh(Context context) {
        this(context, new Mh(), new C1296uh(context));
    }

    public synchronized void a(C1178pi c1178pi) {
        try {
            this.f = c1178pi;
            Jh jh = this.d;
            if (jh == null) {
                Mh mh = this.b;
                Context context = this.a;
                mh.getClass();
                this.d = new Jh(context, c1178pi, new C1224rh(), new Kh(mh), new C1344wh("open", "http"), new C1344wh("port_already_in_use", "http"), "Http");
            } else {
                jh.a(c1178pi);
            }
            this.c.a(c1178pi, this);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void b() {
        try {
            Jh jh = this.d;
            if (jh != null) {
                jh.b();
            }
            Jh jh2 = this.e;
            if (jh2 != null) {
                jh2.b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    Eh(Context context, Mh mh, C1296uh c1296uh) {
        this.a = context;
        this.b = mh;
        this.c = c1296uh;
    }

    public synchronized void b(C1178pi c1178pi) {
        try {
            this.f = c1178pi;
            this.c.a(c1178pi, this);
            Jh jh = this.d;
            if (jh != null) {
                jh.b(c1178pi);
            }
            Jh jh2 = this.e;
            if (jh2 != null) {
                jh2.b(c1178pi);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a() {
        try {
            Jh jh = this.d;
            if (jh != null) {
                jh.a();
            }
            Jh jh2 = this.e;
            if (jh2 != null) {
                jh2.a();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(File file) {
        try {
            Jh jh = this.e;
            if (jh == null) {
                Mh mh = this.b;
                Context context = this.a;
                C1178pi c1178pi = this.f;
                mh.getClass();
                this.e = new Jh(context, c1178pi, new C1320vh(file), new Lh(mh), new C1344wh("open", "https"), new C1344wh("port_already_in_use", "https"), "Https");
            } else {
                jh.a(this.f);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
