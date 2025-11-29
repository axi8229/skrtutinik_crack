package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.Location;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
class Pc {
    private c a;
    private a b;
    private b c;
    private Context d;
    private C1097mc e;
    private Rc f;
    private Sc g;
    private Rb h;
    private final C1363xc i;
    private Yb j;
    private Map<String, C1387yc> k;

    public static class a {
    }

    public static class b {
    }

    public static class c {
    }

    public Pc(Context context, C1097mc c1097mc, Sc sc, Rb rb, Ph ph) {
        this(context, c1097mc, new c(), new C1363xc(ph), new a(), new b(), sc, rb);
    }

    public void a(Location location) {
        String provider = location.getProvider();
        C1387yc c1387yc = this.k.get(provider);
        if (c1387yc == null) {
            if (this.f == null) {
                c cVar = this.a;
                Context context = this.d;
                cVar.getClass();
                this.f = new Rc(null, C1020ja.a(context).f(), new Vb(context), new SystemTimeProvider(), F0.g().c(), F0.g().b());
            }
            if (this.j == null) {
                a aVar = this.b;
                Rc rc = this.f;
                C1363xc c1363xc = this.i;
                aVar.getClass();
                this.j = new Yb(rc, c1363xc);
            }
            b bVar = this.c;
            C1097mc c1097mc = this.e;
            Yb yb = this.j;
            Sc sc = this.g;
            Rb rb = this.h;
            bVar.getClass();
            c1387yc = new C1387yc(c1097mc, yb, null, 0L, new C1353x2(), sc, rb);
            this.k.put(provider, c1387yc);
        } else {
            c1387yc.a(this.e);
        }
        c1387yc.a(location);
    }

    public C1363xc b() {
        return this.i;
    }

    Pc(Context context, C1097mc c1097mc, c cVar, C1363xc c1363xc, a aVar, b bVar, Sc sc, Rb rb) {
        this.k = new HashMap();
        this.d = context;
        this.e = c1097mc;
        this.a = cVar;
        this.i = c1363xc;
        this.b = aVar;
        this.c = bVar;
        this.g = sc;
        this.h = rb;
    }

    public Location a() {
        return this.i.a();
    }

    public void a(C1097mc c1097mc) {
        this.e = c1097mc;
    }

    public void a(C1178pi c1178pi) {
        if (c1178pi.d() != null) {
            this.i.c(c1178pi.d());
        }
    }
}
