package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.impl.ob.C1147oc;
import com.yandex.metrica.impl.ob.H0;
import java.util.Collection;

/* renamed from: com.yandex.metrica.impl.ob.hc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0973hc {
    private final C0998ic a;
    private final C1022jc b;
    private final SystemTimeProvider c;
    private C1097mc d;
    private final E e;
    private final H2 f;
    private final Xc g;
    private final C1326w h;
    private boolean i;
    private final Runnable j;

    /* renamed from: com.yandex.metrica.impl.ob.hc$a */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0973hc.this.b();
            C0973hc.this.c();
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.hc$b */
    class b implements InterfaceC1322vj {
        final /* synthetic */ C1072lc a;

        b(C0973hc c0973hc, C1072lc c1072lc) {
            this.a = c1072lc;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1322vj
        public void a(Collection<C1298uj> collection) {
            this.a.a(Tl.a(collection));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0973hc(C0998ic c0998ic) {
        Context context = c0998ic.a.a;
        C1097mc c1097mc = c0998ic.e;
        this(c0998ic, new Xc(context, c1097mc == null ? null : c1097mc.m));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        C1097mc c1097mc = this.d;
        if (c1097mc != null) {
            long j = c1097mc.h;
            if (j > 0) {
                this.a.a.b.executeDelayed(this.j, j);
            }
        }
    }

    public void b() {
        C1072lc c1072lc = new C1072lc();
        c1072lc.b(this.c.currentTimeMillis());
        c1072lc.a(this.c.elapsedRealtime());
        this.g.b();
        c1072lc.b(F2.a(this.f.a().a()));
        this.a.b.a(new b(this, c1072lc));
        c1072lc.a(this.e.b());
        c1072lc.a(C1147oc.a.a(this.h.c()));
        this.b.a(c1072lc);
        this.a.c.a();
        this.a.d.a();
    }

    public void d() {
        a();
    }

    public void e() {
        this.a.a.b.remove(this.j);
    }

    private void a() {
        C1097mc c1097mc = this.d;
        boolean z = c1097mc != null && c1097mc.i;
        if (this.i != z) {
            this.i = z;
            if (z) {
                c();
            } else {
                this.a.a.b.remove(this.j);
            }
        }
    }

    private C0973hc(C0998ic c0998ic, Xc xc) {
        this(c0998ic, new C1022jc(c0998ic.a.a), new SystemTimeProvider(), F0.g().c(), F0.g().b(), H2.a(c0998ic.a.a), xc, new H0.c());
    }

    C0973hc(C0998ic c0998ic, C1022jc c1022jc, SystemTimeProvider systemTimeProvider, E e, C1326w c1326w, H2 h2, Xc xc, H0.c cVar) {
        this.j = new a();
        this.a = c0998ic;
        this.b = c1022jc;
        this.c = systemTimeProvider;
        this.d = c0998ic.e;
        this.e = e;
        this.h = c1326w;
        this.f = h2;
        this.g = xc;
        h2.a().a(cVar.a(c0998ic.a.b, xc, h2.a()));
    }

    public void a(C1097mc c1097mc) {
        this.d = c1097mc;
        this.g.a(c1097mc == null ? null : c1097mc.m);
        a();
    }
}
