package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.core.api.ProtobufStateStorage;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.coreutils.services.ActivationBarrier;
import com.yandex.metrica.coreutils.services.UtilityServiceLocator;
import com.yandex.metrica.impl.ob.C0803ah;
import com.yandex.metrica.impl.ob.InterfaceC0921fa;

/* renamed from: com.yandex.metrica.impl.ob.dh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0878dh {
    private final C0828bh a;
    private final ProtobufStateStorage b;
    private final C1353x2 c;
    private final ICommonExecutor d;
    private final ActivationBarrier.IActivationBarrierCallback e;
    private final ActivationBarrier f;
    private final C0803ah g;
    private boolean h;
    private C0854ci i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private boolean o;
    private boolean p;
    private final Object q;

    /* renamed from: com.yandex.metrica.impl.ob.dh$a */
    class a implements C0803ah.a {
        a() {
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.dh$b */
    class b implements ActivationBarrier.IActivationBarrierCallback {
        b() {
        }

        @Override // com.yandex.metrica.coreutils.services.ActivationBarrier.IActivationBarrierCallback
        public void onWaitFinished() {
            C0878dh.this.p = true;
            C0878dh.this.a.a(C0878dh.this.g);
        }
    }

    public C0878dh(Context context, ICommonExecutor iCommonExecutor) {
        this(new C0828bh(context, null, iCommonExecutor), InterfaceC0921fa.b.a(C0903eh.class).a(context), new C1353x2(), iCommonExecutor, UtilityServiceLocator.getInstance().getActivationBarrier());
    }

    void a() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (!this.p) {
            this.f.subscribe(this.i.c, this.d, this.e);
        } else {
            this.a.a(this.g);
        }
    }

    void b() {
        C0903eh c0903eh = (C0903eh) this.b.read();
        this.m = c0903eh.c;
        this.n = c0903eh.d;
        this.o = c0903eh.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(com.yandex.metrica.impl.ob.C1178pi r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L3
            goto L3b
        L3:
            boolean r0 = r8.j
            r1 = 1
            if (r0 != 0) goto L10
            com.yandex.metrica.impl.ob.Sh r0 = r9.f()
            boolean r0 = r0.e
            if (r0 == r1) goto L3c
        L10:
            com.yandex.metrica.impl.ob.ci r0 = r8.i
            if (r0 == 0) goto L3c
            com.yandex.metrica.impl.ob.ci r2 = r9.K()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L3c
            long r2 = r8.k
            long r4 = r9.B()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L3c
            long r2 = r8.l
            long r4 = r9.o()
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L3c
            com.yandex.metrica.impl.ob.bh r0 = r8.a
            boolean r0 = r0.b(r9)
            if (r0 == 0) goto L3b
            goto L3c
        L3b:
            r1 = 0
        L3c:
            java.lang.Object r0 = r8.q
            monitor-enter(r0)
            if (r9 == 0) goto L5e
            com.yandex.metrica.impl.ob.Sh r2 = r9.f()     // Catch: java.lang.Throwable -> L5c
            boolean r2 = r2.e     // Catch: java.lang.Throwable -> L5c
            r8.j = r2     // Catch: java.lang.Throwable -> L5c
            com.yandex.metrica.impl.ob.ci r2 = r9.K()     // Catch: java.lang.Throwable -> L5c
            r8.i = r2     // Catch: java.lang.Throwable -> L5c
            long r2 = r9.B()     // Catch: java.lang.Throwable -> L5c
            r8.k = r2     // Catch: java.lang.Throwable -> L5c
            long r2 = r9.o()     // Catch: java.lang.Throwable -> L5c
            r8.l = r2     // Catch: java.lang.Throwable -> L5c
            goto L5e
        L5c:
            r9 = move-exception
            goto Lb2
        L5e:
            com.yandex.metrica.impl.ob.bh r2 = r8.a     // Catch: java.lang.Throwable -> L5c
            r2.a(r9)     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            if (r1 == 0) goto Lb1
            java.lang.Object r9 = r8.q
            monitor-enter(r9)
            boolean r0 = r8.j     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto Lad
            com.yandex.metrica.impl.ob.ci r0 = r8.i     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto Lad
            boolean r1 = r8.n     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L9f
            boolean r1 = r8.o     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L8d
            com.yandex.metrica.impl.ob.x2 r2 = r8.c     // Catch: java.lang.Throwable -> L8b
            long r3 = r8.m     // Catch: java.lang.Throwable -> L8b
            long r5 = r0.d     // Catch: java.lang.Throwable -> L8b
            java.lang.String r7 = "should retry sdk collecting"
            boolean r0 = r2.a(r3, r5, r7)     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto Lad
            r8.a()     // Catch: java.lang.Throwable -> L8b
            goto Lad
        L8b:
            r0 = move-exception
            goto Laf
        L8d:
            com.yandex.metrica.impl.ob.x2 r1 = r8.c     // Catch: java.lang.Throwable -> L8b
            long r2 = r8.m     // Catch: java.lang.Throwable -> L8b
            long r4 = r0.a     // Catch: java.lang.Throwable -> L8b
            java.lang.String r6 = "should collect sdk as usual"
            boolean r0 = r1.a(r2, r4, r6)     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto Lad
            r8.a()     // Catch: java.lang.Throwable -> L8b
            goto Lad
        L9f:
            long r1 = r8.k     // Catch: java.lang.Throwable -> L8b
            long r3 = r8.l     // Catch: java.lang.Throwable -> L8b
            long r1 = r1 - r3
            long r3 = r0.b     // Catch: java.lang.Throwable -> L8b
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 < 0) goto Lad
            r8.a()     // Catch: java.lang.Throwable -> L8b
        Lad:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L8b
            goto Lb1
        Laf:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L8b
            throw r0
        Lb1:
            return
        Lb2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5c
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C0878dh.b(com.yandex.metrica.impl.ob.pi):void");
    }

    C0878dh(C0828bh c0828bh, ProtobufStateStorage protobufStateStorage, C1353x2 c1353x2, ICommonExecutor iCommonExecutor, ActivationBarrier activationBarrier) {
        this.p = false;
        this.q = new Object();
        this.a = c0828bh;
        this.b = protobufStateStorage;
        this.g = new C0803ah(protobufStateStorage, new a());
        this.c = c1353x2;
        this.d = iCommonExecutor;
        this.e = new b();
        this.f = activationBarrier;
    }

    public void a(C1178pi c1178pi) {
        C0903eh c0903eh = (C0903eh) this.b.read();
        this.m = c0903eh.c;
        this.n = c0903eh.d;
        this.o = c0903eh.e;
        b(c1178pi);
    }
}
