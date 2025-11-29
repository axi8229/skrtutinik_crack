package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: com.yandex.metrica.impl.ob.xb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1362xb implements Eb {
    private final Object a;
    private C1178pi b;
    private volatile FutureTask<Void> c;
    private final g d;
    private final g e;
    private final g f;
    private final InterfaceC1314vb g;
    private final InterfaceC1314vb h;
    private final InterfaceC1314vb i;
    private Context j;
    private ICommonExecutor k;
    private volatile C1410zb l;

    /* renamed from: com.yandex.metrica.impl.ob.xb$a */
    class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            C1362xb c1362xb = C1362xb.this;
            C1290ub c1290ubA = C1362xb.a(c1362xb, c1362xb.j);
            C1362xb c1362xb2 = C1362xb.this;
            C1290ub c1290ubB = C1362xb.b(c1362xb2, c1362xb2.j);
            C1362xb c1362xb3 = C1362xb.this;
            c1362xb.l = new C1410zb(c1290ubA, c1290ubB, C1362xb.a(c1362xb3, c1362xb3.j, new Fb()));
            return null;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$b */
    class b implements Callable<Void> {
        final /* synthetic */ Context a;
        final /* synthetic */ Gb b;

        b(Context context, Gb gb) {
            this.a = context;
            this.b = gb;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            C1410zb c1410zb = C1362xb.this.l;
            C1362xb c1362xb = C1362xb.this;
            C1290ub c1290ubA = C1362xb.a(c1362xb, C1362xb.a(c1362xb, this.a), c1410zb.a());
            C1362xb c1362xb2 = C1362xb.this;
            C1290ub c1290ubA2 = C1362xb.a(c1362xb2, C1362xb.b(c1362xb2, this.a), c1410zb.b());
            C1362xb c1362xb3 = C1362xb.this;
            c1362xb.l = new C1410zb(c1290ubA, c1290ubA2, C1362xb.a(c1362xb3, C1362xb.a(c1362xb3, this.a, this.b), c1410zb.c()));
            return null;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$c */
    public static class c implements g {
        @Override // com.yandex.metrica.impl.ob.C1362xb.g
        public boolean a(C1178pi c1178pi) {
            return true;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$d */
    public static class d implements g {
        @Override // com.yandex.metrica.impl.ob.C1362xb.g
        public boolean a(C1178pi c1178pi) {
            return c1178pi != null && (c1178pi.f().v || !c1178pi.q());
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$e */
    public static class e implements g {
        @Override // com.yandex.metrica.impl.ob.C1362xb.g
        public boolean a(C1178pi c1178pi) {
            return false;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$f */
    public static class f implements g {
        @Override // com.yandex.metrica.impl.ob.C1362xb.g
        public boolean a(C1178pi c1178pi) {
            return c1178pi != null && c1178pi.f().v;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$g */
    interface g {
        boolean a(C1178pi c1178pi);
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$h */
    public static class h implements g {
        @Override // com.yandex.metrica.impl.ob.C1362xb.g
        public boolean a(C1178pi c1178pi) {
            return c1178pi != null && (c1178pi.f().n || !c1178pi.q());
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.xb$i */
    public static class i implements g {
        @Override // com.yandex.metrica.impl.ob.C1362xb.g
        public boolean a(C1178pi c1178pi) {
            return c1178pi != null && c1178pi.f().n;
        }
    }

    public C1362xb(g gVar, g gVar2, g gVar3, ICommonExecutor iCommonExecutor, String str) {
        this(gVar, gVar2, gVar3, iCommonExecutor, new C1338wb(new Kb("google")), new C1338wb(new Kb("huawei")), new C1338wb(new Kb("yandex")), str);
    }

    static C1290ub a(C1362xb c1362xb, C1290ub c1290ub, C1290ub c1290ub2) {
        c1362xb.getClass();
        U0 u0 = c1290ub.b;
        return u0 != U0.OK ? new C1290ub(c1290ub2.a, u0, c1290ub.c) : c1290ub;
    }

    public void c(Context context) {
        this.j = context.getApplicationContext();
    }

    C1362xb(g gVar, g gVar2, g gVar3, ICommonExecutor iCommonExecutor, InterfaceC1314vb interfaceC1314vb, InterfaceC1314vb interfaceC1314vb2, InterfaceC1314vb interfaceC1314vb3, String str) {
        this.a = new Object();
        this.d = gVar;
        this.e = gVar2;
        this.f = gVar3;
        this.g = interfaceC1314vb;
        this.h = interfaceC1314vb2;
        this.i = interfaceC1314vb3;
        this.k = iCommonExecutor;
        this.l = new C1410zb();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c() throws java.util.concurrent.ExecutionException, java.lang.InterruptedException {
        /*
            r2 = this;
            android.content.Context r0 = r2.j
            if (r0 == 0) goto L2b
            monitor-enter(r2)
            com.yandex.metrica.impl.ob.zb r0 = r2.l     // Catch: java.lang.Throwable -> L1d
            com.yandex.metrica.impl.ob.ub r0 = r0.a()     // Catch: java.lang.Throwable -> L1d
            com.yandex.metrica.impl.ob.U0 r0 = r0.b     // Catch: java.lang.Throwable -> L1d
            com.yandex.metrica.impl.ob.U0 r1 = com.yandex.metrica.impl.ob.U0.UNKNOWN     // Catch: java.lang.Throwable -> L1d
            if (r0 == r1) goto L1f
            com.yandex.metrica.impl.ob.zb r0 = r2.l     // Catch: java.lang.Throwable -> L1d
            com.yandex.metrica.impl.ob.ub r0 = r0.b()     // Catch: java.lang.Throwable -> L1d
            com.yandex.metrica.impl.ob.U0 r0 = r0.b     // Catch: java.lang.Throwable -> L1d
            if (r0 == r1) goto L1f
            r0 = 1
            goto L20
        L1d:
            r0 = move-exception
            goto L29
        L1f:
            r0 = 0
        L20:
            monitor-exit(r2)
            if (r0 != 0) goto L2b
            android.content.Context r0 = r2.j
            r2.a(r0)
            goto L2b
        L29:
            monitor-exit(r2)
            throw r0
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C1362xb.c():void");
    }

    public void b(Context context) {
        this.j = context.getApplicationContext();
        if (this.c == null) {
            synchronized (this.a) {
                try {
                    if (this.c == null) {
                        this.c = new FutureTask<>(new a());
                        this.k.execute(this.c);
                    }
                } finally {
                }
            }
        }
    }

    static C1290ub b(C1362xb c1362xb, Context context) {
        if (c1362xb.e.a(c1362xb.b)) {
            return c1362xb.h.a(context);
        }
        C1178pi c1178pi = c1362xb.b;
        if (c1178pi != null && c1178pi.q()) {
            if (!c1362xb.b.f().v) {
                return new C1290ub(null, U0.FEATURE_DISABLED, "startup forbade ads identifiers collecting");
            }
            return new C1290ub(null, U0.UNKNOWN, "identifiers collecting is forbidden for unknown reason");
        }
        return new C1290ub(null, U0.NO_STARTUP, "startup has not been received yet");
    }

    @Override // com.yandex.metrica.impl.ob.Eb
    @Deprecated
    public Boolean b() throws ExecutionException, InterruptedException {
        c();
        C1266tb c1266tb = this.l.a().a;
        if (c1266tb == null) {
            return null;
        }
        return c1266tb.c;
    }

    public void a(Context context, C1178pi c1178pi) {
        this.b = c1178pi;
        b(context);
    }

    public void a(C1178pi c1178pi) {
        this.b = c1178pi;
    }

    public C1410zb a(Context context) throws ExecutionException, InterruptedException {
        b(context);
        try {
            this.c.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.l;
    }

    public C1410zb a(Context context, Gb gb) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new b(context.getApplicationContext(), gb));
        this.k.execute(futureTask);
        try {
            futureTask.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        return this.l;
    }

    static C1290ub a(C1362xb c1362xb, Context context) {
        if (c1362xb.d.a(c1362xb.b)) {
            return c1362xb.g.a(context);
        }
        C1178pi c1178pi = c1362xb.b;
        if (c1178pi != null && c1178pi.q()) {
            if (!c1362xb.b.f().n) {
                return new C1290ub(null, U0.FEATURE_DISABLED, "startup forbade ads identifiers collecting");
            }
            return new C1290ub(null, U0.UNKNOWN, "identifiers collecting is forbidden for unknown reason");
        }
        return new C1290ub(null, U0.NO_STARTUP, "startup has not been received yet");
    }

    static C1290ub a(C1362xb c1362xb, Context context, Gb gb) {
        if (c1362xb.f.a(c1362xb.b)) {
            return c1362xb.i.a(context, gb);
        }
        return new C1290ub(null, U0.UNKNOWN, "identifiers collecting is forbidden for unknown reason");
    }

    @Override // com.yandex.metrica.impl.ob.Eb
    @Deprecated
    public String a() throws ExecutionException, InterruptedException {
        c();
        C1266tb c1266tb = this.l.a().a;
        if (c1266tb == null) {
            return null;
        }
        return c1266tb.b;
    }
}
