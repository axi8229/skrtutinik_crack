package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.If;
import java.util.Collection;

/* loaded from: classes3.dex */
class Ij extends AbstractC1203qj {
    private final TelephonyManager a;
    private PhoneStateListener b;
    private boolean c;
    private C1178pi d;
    private C1097mc e;
    private final G<Zj> f;
    private final G<Collection<C1298uj>> g;
    private final ICommonExecutor h;
    private final Context i;
    private final C1346wj j;
    private final Uj k;
    private final C1226rj l;
    private final Ed m;
    private C1388yd n;
    private Lj o;
    private final InterfaceC1412zd p;
    private final C1063l3 q;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Ij.this.b = new d(Ij.this, null);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Ij.this.c) {
                return;
            }
            Ij.this.c = true;
            if (Ij.this.b == null || Ij.this.a == null) {
                return;
            }
            try {
                Ij.this.a.listen(Ij.this.b, 256);
            } catch (Throwable unused) {
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Ij.this.c) {
                Ij.this.c = false;
                Ij.this.q.a(Ij.this);
                if (Ij.this.b == null || Ij.this.a == null) {
                    return;
                }
                try {
                    Ij.this.a.listen(Ij.this.b, 0);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private class d extends PhoneStateListener {
        private d() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            Ij.a(Ij.this, signalStrength);
        }

        /* synthetic */ d(Ij ij, a aVar) {
            this();
        }
    }

    protected Ij(Context context, ICommonExecutor iCommonExecutor) {
        this(context, new Ed(), iCommonExecutor);
    }

    public Context e() {
        return this.i;
    }

    public TelephonyManager f() {
        return this.a;
    }

    synchronized Zj g() {
        C1298uj c1298ujB;
        try {
            if (this.f.b() || this.f.d()) {
                Zj zj = new Zj(this.j, this.k, this.l);
                C1298uj c1298ujB2 = zj.b();
                if (c1298ujB2 != null && c1298ujB2.p() == null && !this.f.b() && (c1298ujB = this.f.a().b()) != null) {
                    zj.b().a(c1298ujB.p());
                }
                this.f.a(zj);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f.a();
    }

    protected Ij(Context context, Ed ed, ICommonExecutor iCommonExecutor) {
        this(context, ed, new C1388yd(ed.a()), iCommonExecutor, A2.a(17) ? new C1250sj() : new C1274tj(), new G1(), C1063l3.a());
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public synchronized void b() {
        this.h.execute(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    synchronized boolean c() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.yandex.metrica.impl.ob.mc r0 = r1.e     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto Ld
            boolean r0 = r0.l     // Catch: java.lang.Throwable -> Lb
            if (r0 == 0) goto Ld
            r0 = 1
            goto Le
        Lb:
            r0 = move-exception
            goto L10
        Ld:
            r0 = 0
        Le:
            monitor-exit(r1)
            return r0
        L10:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Ij.c():boolean");
    }

    synchronized boolean d() {
        C1178pi c1178pi;
        boolean z;
        synchronized (this) {
            c1178pi = this.d;
            z = false;
        }
        return z;
        if ((c1178pi != null) && c1178pi.f().s) {
            z = true;
        }
        return z;
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public synchronized void a() {
        this.h.execute(new b());
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public synchronized void a(InterfaceC0806ak interfaceC0806ak) {
        if (interfaceC0806ak != null) {
            interfaceC0806ak.a(g());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0055 A[Catch: all -> 0x0015, LOOP:0: B:34:0x0055->B:39:0x006c, LOOP_START, PHI: r5
  0x0055: PHI (r5v2 int) = (r5v1 int), (r5v3 int) binds: [B:33:0x0053, B:39:0x006c] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0015, blocks: (B:5:0x0004, B:7:0x000c, B:51:0x0090, B:12:0x0018, B:14:0x0029, B:16:0x0033, B:25:0x0042, B:27:0x0045, B:32:0x004f, B:34:0x0055, B:36:0x005b, B:38:0x0069, B:39:0x006c, B:40:0x006f, B:41:0x0070, B:42:0x0071, B:44:0x0077, B:50:0x008d, B:47:0x0082, B:49:0x0088, B:17:0x0034, B:19:0x0039), top: B:63:0x0004, outer: #1, inners: #3 }] */
    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(com.yandex.metrica.impl.ob.InterfaceC1322vj r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r9 == 0) goto La3
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L9d
            com.yandex.metrica.impl.ob.G<java.util.Collection<com.yandex.metrica.impl.ob.uj>> r0 = r8.g     // Catch: java.lang.Throwable -> L15
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L18
            com.yandex.metrica.impl.ob.G<java.util.Collection<com.yandex.metrica.impl.ob.uj>> r0 = r8.g     // Catch: java.lang.Throwable -> L15
            boolean r0 = r0.d()     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L90
            goto L18
        L15:
            r9 = move-exception
            goto L9f
        L18:
            com.yandex.metrica.impl.ob.G<java.util.Collection<com.yandex.metrica.impl.ob.uj>> r0 = r8.g     // Catch: java.lang.Throwable -> L15
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L15
            r1.<init>()     // Catch: java.lang.Throwable -> L15
            r2 = 17
            boolean r2 = com.yandex.metrica.impl.ob.A2.a(r2)     // Catch: java.lang.Throwable -> L15
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L71
            com.yandex.metrica.impl.ob.zd r2 = r8.p     // Catch: java.lang.Throwable -> L15
            android.content.Context r5 = r8.i     // Catch: java.lang.Throwable -> L15
            boolean r2 = r2.a(r5)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L71
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L15
            com.yandex.metrica.impl.ob.mc r2 = r8.e     // Catch: java.lang.Throwable -> L3f
            r5 = 0
            if (r2 == 0) goto L41
            boolean r2 = r2.k     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L41
            r2 = r4
            goto L42
        L3f:
            r9 = move-exception
            goto L6f
        L41:
            r2 = r5
        L42:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L71
            android.telephony.TelephonyManager r2 = r8.a     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L4e
            java.util.List r2 = r2.getAllCellInfo()     // Catch: java.lang.Throwable -> L4e
            goto L4f
        L4e:
            r2 = r3
        L4f:
            boolean r6 = com.yandex.metrica.impl.ob.A2.b(r2)     // Catch: java.lang.Throwable -> L15
            if (r6 != 0) goto L71
        L55:
            int r6 = r2.size()     // Catch: java.lang.Throwable -> L15
            if (r5 >= r6) goto L71
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Throwable -> L15
            android.telephony.CellInfo r6 = (android.telephony.CellInfo) r6     // Catch: java.lang.Throwable -> L15
            com.yandex.metrica.impl.ob.Lj r7 = r8.o     // Catch: java.lang.Throwable -> L15
            com.yandex.metrica.impl.ob.uj r6 = r7.a(r6)     // Catch: java.lang.Throwable -> L15
            if (r6 == 0) goto L6c
            r1.add(r6)     // Catch: java.lang.Throwable -> L15
        L6c:
            int r5 = r5 + 1
            goto L55
        L6f:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L15
            throw r9     // Catch: java.lang.Throwable -> L15
        L71:
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L15
            if (r2 >= r4) goto L88
            com.yandex.metrica.impl.ob.Zj r1 = r8.g()     // Catch: java.lang.Throwable -> L15
            com.yandex.metrica.impl.ob.uj r1 = r1.b()     // Catch: java.lang.Throwable -> L15
            if (r1 != 0) goto L82
            goto L8d
        L82:
            java.util.List r1 = java.util.Collections.singletonList(r1)     // Catch: java.lang.Throwable -> L15
        L86:
            r3 = r1
            goto L8d
        L88:
            java.util.List r1 = com.yandex.metrica.impl.ob.A2.c(r1)     // Catch: java.lang.Throwable -> L15
            goto L86
        L8d:
            r0.a(r3)     // Catch: java.lang.Throwable -> L15
        L90:
            com.yandex.metrica.impl.ob.G<java.util.Collection<com.yandex.metrica.impl.ob.uj>> r0 = r8.g     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.a()     // Catch: java.lang.Throwable -> L15
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L15
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L9d
            r9.a(r0)     // Catch: java.lang.Throwable -> L9d
            goto La3
        L9d:
            r9 = move-exception
            goto La1
        L9f:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L9d
            throw r9     // Catch: java.lang.Throwable -> L9d
        La1:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L9d
            throw r9
        La3:
            monitor-exit(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.Ij.a(com.yandex.metrica.impl.ob.vj):void");
    }

    protected Ij(Context context, Ed ed, C1388yd c1388yd, ICommonExecutor iCommonExecutor, Lj lj, G1 g1, C1063l3 c1063l3) {
        TelephonyManager telephonyManager;
        this.c = false;
        If.c cVar = G.e;
        long j = cVar.a;
        this.f = new G<>(j, j * 2);
        long j2 = cVar.a;
        this.g = new G<>(j2, 2 * j2);
        this.i = context;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
            telephonyManager = null;
        }
        this.a = telephonyManager;
        this.p = a(c1388yd, g1);
        this.h = iCommonExecutor;
        iCommonExecutor.execute(new a());
        this.j = new C1346wj(this, c1388yd);
        this.k = new Uj(this, c1388yd);
        this.l = new C1226rj(this);
        this.m = ed;
        this.n = c1388yd;
        this.o = lj;
        this.q = c1063l3;
    }

    static void a(Ij ij, SignalStrength signalStrength) {
        C1298uj c1298ujB;
        int evdoDbm;
        synchronized (ij) {
            try {
                if (!ij.f.b() && !ij.f.d() && (c1298ujB = ij.f.a().b()) != null) {
                    if (signalStrength.isGsm()) {
                        evdoDbm = 99 == signalStrength.getGsmSignalStrength() ? -1 : (r4 * 2) - 113;
                    } else {
                        int cdmaDbm = signalStrength.getCdmaDbm();
                        evdoDbm = signalStrength.getEvdoDbm();
                        if (-120 == evdoDbm) {
                            evdoDbm = cdmaDbm;
                        } else if (-120 != cdmaDbm) {
                            evdoDbm = Math.min(cdmaDbm, evdoDbm);
                        }
                    }
                    c1298ujB.a(Integer.valueOf(evdoDbm));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public void a(C1178pi c1178pi) {
        this.d = c1178pi;
        this.m.a(c1178pi);
        this.n.a(this.m.a());
        this.o.a(c1178pi.f());
        if (c1178pi.d() != null) {
            this.f.a(c1178pi.d().a, c1178pi.d().a * 2);
            this.g.a(c1178pi.d().a, c1178pi.d().a * 2);
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1122nc
    public synchronized void a(C1097mc c1097mc) {
        this.e = c1097mc;
    }

    @Override // com.yandex.metrica.impl.ob.AbstractC1203qj
    public void a(boolean z) {
        this.m.a(z);
        this.n.a(this.m.a());
    }

    private static InterfaceC1412zd a(C1388yd c1388yd, G1 g1) {
        if (A2.a(29)) {
            return g1.c(c1388yd);
        }
        return g1.b(c1388yd);
    }
}
