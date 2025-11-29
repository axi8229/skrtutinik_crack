package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;
import com.yandex.metrica.impl.ob.C0904ei;
import com.yandex.metrica.impl.ob.C1178pi;
import com.yandex.metrica.impl.ob.C1202qi;
import com.yandex.metrica.impl.ob.Mg;
import com.yandex.metrica.networktasks.api.NetworkTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* renamed from: com.yandex.metrica.impl.ob.ri, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1225ri {
    private final Context a;
    private final I3 b;
    private final InterfaceC1153oi c;
    private final C1178pi.b d;
    private volatile NetworkTask e;
    private C0929fi f;
    private final TimeProvider g;
    private final I h;
    private final Rh i;
    private final C1063l3 j;

    /* renamed from: com.yandex.metrica.impl.ob.ri$a */
    class a implements Function0<I> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function0
        public I invoke() {
            return C1225ri.this.h;
        }
    }

    public C1225ri(Context context, String str, Mg.b bVar, InterfaceC1153oi interfaceC1153oi) {
        this(context, new E3(str), bVar, interfaceC1153oi, new C1178pi.b(context), new Pl(context), new SystemTimeProvider(), F0.g().d(), new Rh(), C1063l3.a());
    }

    public Context b() {
        return this.a;
    }

    public synchronized NetworkTask c() {
        try {
            if (!e()) {
                return null;
            }
            if (this.e == null) {
                this.e = C1220rd.a(this, this.f.b());
            }
            return this.e;
        } catch (Throwable th) {
            throw th;
        }
    }

    public C1178pi d() {
        return this.f.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean e() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.yandex.metrica.impl.ob.fi r0 = r5.f     // Catch: java.lang.Throwable -> L2d
            com.yandex.metrica.impl.ob.pi r0 = r0.d()     // Catch: java.lang.Throwable -> L2d
            boolean r1 = com.yandex.metrica.impl.ob.C1128ni.b(r0)     // Catch: java.lang.Throwable -> L2d
            if (r1 != 0) goto L30
            boolean r1 = com.yandex.metrica.impl.ob.C1128ni.a(r0)     // Catch: java.lang.Throwable -> L2d
            r2 = r1 ^ 1
            if (r1 == 0) goto L2f
            com.yandex.metrica.impl.ob.Rh r1 = r5.i     // Catch: java.lang.Throwable -> L2d
            com.yandex.metrica.impl.ob.fi r3 = r5.f     // Catch: java.lang.Throwable -> L2d
            com.yandex.metrica.impl.ob.Eg r3 = r3.b()     // Catch: java.lang.Throwable -> L2d
            com.yandex.metrica.impl.ob.Mg r3 = (com.yandex.metrica.impl.ob.Mg) r3     // Catch: java.lang.Throwable -> L2d
            java.util.Map r3 = r3.C()     // Catch: java.lang.Throwable -> L2d
            com.yandex.metrica.impl.ob.I r4 = r5.h     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r1.a(r3, r0, r4)     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto L2f
            r1 = 1
            goto L30
        L2d:
            r0 = move-exception
            goto L32
        L2f:
            r1 = r2
        L30:
            monitor-exit(r5)
            return r1
        L32:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2d
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1225ri.e():boolean");
    }

    private void a(Pl pl, C0880dj c0880dj, C1178pi c1178pi) {
        C1178pi.a aVarA = c1178pi.a();
        if (!C1128ni.a(c1178pi.V())) {
            aVarA = aVarA.k(c0880dj.a().a);
        }
        String strA = pl.a();
        if (!C1128ni.a(c1178pi.i())) {
            aVarA = aVarA.c(strA).d("");
        }
        C1178pi c1178piA = aVarA.a();
        b(c1178piA);
        a(c1178piA);
    }

    private synchronized void b(C1178pi c1178pi) {
        this.f.a(c1178pi);
        this.d.a(c1178pi);
        F0.g().a(c1178pi);
        this.j.a((C1113n3) new C1187q3(this.b.b(), c1178pi));
    }

    private C1225ri(Context context, I3 i3, Mg.b bVar, InterfaceC1153oi interfaceC1153oi, C1178pi.b bVar2, Pl pl, TimeProvider timeProvider, I i, Rh rh, C1063l3 c1063l3) {
        this(context, i3, bVar, interfaceC1153oi, bVar2, bVar2.a(), pl, timeProvider, i, rh, c1063l3);
    }

    public I3 a() {
        return this.b;
    }

    public void a(EnumC0954gi enumC0954gi) {
        ArrayList arrayList;
        synchronized (this) {
            this.e = null;
        }
        InterfaceC1153oi interfaceC1153oi = this.c;
        String strB = this.b.b();
        C1178pi c1178piD = this.f.d();
        C0904ei.a aVar = (C0904ei.a) interfaceC1153oi;
        synchronized (C0904ei.this.b) {
            try {
                Collection collectionA = C0904ei.this.a.a(strB);
                if (collectionA == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = new ArrayList(collectionA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC1053ki) it.next()).a(enumC0954gi, c1178piD);
        }
    }

    private C1225ri(Context context, I3 i3, Mg.b bVar, InterfaceC1153oi interfaceC1153oi, C1178pi.b bVar2, C1178pi c1178pi, Pl pl, TimeProvider timeProvider, I i, Rh rh, C1063l3 c1063l3) {
        this(context, i3, interfaceC1153oi, bVar2, c1178pi, pl, new C0929fi(new Mg.c(context, i3.b()), c1178pi, bVar), timeProvider, i, rh, C0905ej.a(context).a(context, new C1004ij(bVar2)), c1063l3);
    }

    C1225ri(Context context, I3 i3, InterfaceC1153oi interfaceC1153oi, C1178pi.b bVar, C1178pi c1178pi, Pl pl, C0929fi c0929fi, TimeProvider timeProvider, I i, Rh rh, C0880dj c0880dj, C1063l3 c1063l3) {
        this.a = context;
        this.b = i3;
        this.c = interfaceC1153oi;
        this.d = bVar;
        this.f = c0929fi;
        this.g = timeProvider;
        this.h = i;
        this.i = rh;
        this.j = c1063l3;
        a(pl, c0880dj, c1178pi);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.yandex.metrica.impl.ob.Ui r6, com.yandex.metrica.impl.ob.Mg r7, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = com.yandex.metrica.impl.ob.A2.b(r8)     // Catch: java.lang.Throwable -> L33
            r1 = 0
            if (r0 != 0) goto L35
            java.lang.String r0 = "Date"
            java.lang.Object r8 = r8.get(r0)     // Catch: java.lang.Throwable -> L33
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L33
            boolean r0 = com.yandex.metrica.impl.ob.A2.b(r8)     // Catch: java.lang.Throwable -> L33
            if (r0 != 0) goto L35
            r0 = 0
            java.lang.Object r8 = r8.get(r0)     // Catch: java.lang.Throwable -> L35
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L35
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = "E, d MMM yyyy HH:mm:ss z"
            java.util.Locale r3 = java.util.Locale.US     // Catch: java.lang.Throwable -> L35
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L35
            java.util.Date r8 = r0.parse(r8)     // Catch: java.lang.Throwable -> L35
            long r2 = r8.getTime()     // Catch: java.lang.Throwable -> L35
            java.lang.Long r8 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L35
            goto L36
        L33:
            r6 = move-exception
            goto L61
        L35:
            r8 = r1
        L36:
            r2 = 0
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L33
            if (r8 != 0) goto L3f
            r8 = r0
        L3f:
            java.lang.Long r0 = r6.N()     // Catch: java.lang.Throwable -> L33
            com.yandex.metrica.impl.ob.fm r2 = com.yandex.metrica.impl.ob.C0933fm.c()     // Catch: java.lang.Throwable -> L33
            long r3 = r8.longValue()     // Catch: java.lang.Throwable -> L33
            r2.a(r3, r0)     // Catch: java.lang.Throwable -> L33
            com.yandex.metrica.impl.ob.pi r6 = r5.a(r6, r7, r8)     // Catch: java.lang.Throwable -> L33
            monitor-enter(r5)     // Catch: java.lang.Throwable -> L33
            r5.e = r1     // Catch: java.lang.Throwable -> L5e
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L33
            r5.b(r6)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L33
            r5.a(r6)
            return
        L5e:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L33
            throw r6     // Catch: java.lang.Throwable -> L33
        L61:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L33
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1225ri.a(com.yandex.metrica.impl.ob.Ui, com.yandex.metrica.impl.ob.Mg, java.util.Map):void");
    }

    protected C1178pi a(Ui ui, Mg mg, Long l) {
        boolean zEquals;
        String strC = Tl.c(mg.C());
        Map<String, String> mapB = mg.B().b();
        String strN = ui.n();
        String strN2 = this.f.d().n();
        if (!Tl.d(Tl.a(strN))) {
            strN = Tl.d(Tl.a(strN2)) ? strN2 : null;
        }
        String strI = this.f.d().i();
        if (TextUtils.isEmpty(strI)) {
            strI = ui.i();
        }
        C1178pi.a aVarH = new C1178pi.a(new C1202qi.b(ui.e())).c(strI).d(ui.h()).c(this.g.currentTimeSeconds()).k(this.f.d().V()).f(ui.o()).c(ui.G()).b(mg.J()).i(ui.y()).e(ui.r()).i(ui.x()).j(ui.D()).a(ui.d()).a(ui.j()).g(ui.t()).a(ui.g()).e(strN).h(strC);
        this.i.getClass();
        Map<String, String> mapA = Tl.a(strN);
        if (A2.b(mapB)) {
            zEquals = A2.b(mapA);
        } else {
            zEquals = mapA.equals(mapB);
        }
        C1178pi.a aVarA = aVarH.c(zEquals).g(Tl.c(mapB)).a(ui.E()).d(ui.q()).j(ui.z()).b(ui.f()).a(ui.w()).h(ui.v()).a(ui.C()).a(ui.H()).a(true);
        Long lValueOf = Long.valueOf((System.currentTimeMillis() / 1000) * 1000);
        if (l != null) {
            lValueOf = l;
        }
        return aVarA.b(lValueOf.longValue()).a(this.f.b().a(l.longValue())).b(false).a(ui.p()).a(ui.B()).a(ui.L()).b(ui.K()).c(ui.M()).a(ui.J()).a(ui.I()).a(ui.c()).a(ui.k()).f(ui.s()).a(ui.b()).a(ui.a()).a(ui.l()).a(ui.m()).a(ui.F()).b(ui.u()).a();
    }

    private void a(C1178pi c1178pi) {
        ArrayList arrayList;
        InterfaceC1153oi interfaceC1153oi = this.c;
        String strB = this.b.b();
        C0904ei.a aVar = (C0904ei.a) interfaceC1153oi;
        synchronized (C0904ei.this.b) {
            try {
                C0904ei.this.c = c1178pi;
                Collection collectionA = C0904ei.this.a.a(strB);
                if (collectionA == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = new ArrayList(collectionA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC1053ki) it.next()).a(c1178pi);
        }
    }

    public synchronized boolean a(List<String> list, Map<String, String> map) {
        return !C1128ni.a(this.f.d(), list, map, new a());
    }

    public synchronized void a(Mg.b bVar) {
        boolean z;
        try {
            this.f.a(bVar);
            Mg mgB = this.f.b();
            if (mgB.K()) {
                List<String> listG = mgB.G();
                boolean z2 = true;
                C1178pi.a aVarB = null;
                if (!A2.b(listG) || A2.b(mgB.J())) {
                    z = false;
                } else {
                    aVarB = this.f.d().a().b((List<String>) null);
                    z = true;
                }
                if (A2.b(listG) || A2.a(listG, mgB.J())) {
                    z2 = z;
                } else {
                    aVarB = this.f.d().a().b(listG);
                }
                if (z2) {
                    C1178pi c1178piA = aVarB.a();
                    b(c1178piA);
                    a(c1178piA);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
