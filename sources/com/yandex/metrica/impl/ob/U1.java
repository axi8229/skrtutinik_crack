package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.IMetricaService;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C1136o1;
import com.yandex.metrica.impl.ob.J;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class U1 implements C1136o1.c, com.yandex.metrica.rtm.wrapper.k {
    private final P0 a;
    private final C1136o1 b;
    private final Object c;
    private final ICommonExecutor d;
    private final C1116n6 e;

    class a extends g {
        final /* synthetic */ A3 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(A3 a3) {
            super(U1.this, null);
            this.b = a3;
        }

        @Override // com.yandex.metrica.impl.ob.U1.g
        void a(IMetricaService iMetricaService) throws RemoteException {
            P0 p0 = U1.this.a;
            A3 a3 = this.b;
            ((T1) p0).getClass();
            Bundle bundle = new Bundle();
            synchronized (a3) {
                bundle.putParcelable("PROCESS_CFG_OBJ", a3);
            }
            iMetricaService.b(bundle);
        }
    }

    class b extends g {
        final /* synthetic */ A3 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(A3 a3) {
            super(U1.this, null);
            this.b = a3;
        }

        @Override // com.yandex.metrica.impl.ob.U1.g
        void a(IMetricaService iMetricaService) throws RemoteException {
            P0 p0 = U1.this.a;
            A3 a3 = this.b;
            ((T1) p0).getClass();
            Bundle bundle = new Bundle();
            synchronized (a3) {
                bundle.putParcelable("PROCESS_CFG_OBJ", a3);
            }
            iMetricaService.a(bundle);
        }
    }

    class c extends d {
        private boolean d;
        private final Xl e;

        c(f fVar, Xl xl) {
            super(fVar);
            this.d = false;
            this.e = xl;
        }

        @Override // com.yandex.metrica.impl.ob.U1.g
        boolean b() {
            f fVar = this.b;
            if (fVar.b().h != 0) {
                U1.this.e.a(fVar);
                return false;
            }
            Context contextA = ((T1) U1.this.a).a();
            Intent intentA = C1112n2.a(contextA);
            fVar.b().e = EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_INTENT.b();
            intentA.putExtras(fVar.b().b(fVar.a().c()));
            try {
                contextA.startService(intentA);
                return false;
            } catch (Throwable unused) {
                U1.this.e.a(fVar);
                return false;
            }
        }

        @Override // com.yandex.metrica.impl.ob.U1.g
        /* renamed from: a */
        public synchronized Void call() {
            if (this.d) {
                return null;
            }
            this.d = true;
            Xl xl = this.e;
            xl.getClass();
            try {
                if (!TextUtils.isEmpty(xl.b())) {
                    if (xl.b().endsWith(":Metrica")) {
                        a(this.b);
                        return null;
                    }
                }
            } catch (Throwable unused) {
            }
            U1.this.b.g();
            return super.call();
        }

        void a(f fVar) {
            U1.this.e.a(fVar);
        }
    }

    class d extends g {
        final f b;

        d(f fVar) {
            super(U1.this, null);
            this.b = fVar;
        }

        @Override // com.yandex.metrica.impl.ob.U1.g
        void a(IMetricaService iMetricaService) throws RemoteException {
            f fVar = this.b;
            ((T1) U1.this.a).a(iMetricaService, fVar.e(), fVar.b);
        }

        @Override // com.yandex.metrica.impl.ob.U1.g
        void a(Throwable th) {
        }

        @Override // com.yandex.metrica.impl.ob.U1.g, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call();
        }
    }

    public interface e {
        C0836c0 a(C0836c0 c0836c0);
    }

    public static class f {
        private C0836c0 a;
        private Q1 b;
        private boolean c = false;
        private e d;
        private HashMap<J.a, Integer> e;

        public f(C0836c0 c0836c0, Q1 q1) {
            this.a = c0836c0;
            this.b = new Q1(new A3(q1.a()), new CounterConfiguration(q1.b()), q1.e());
        }

        public C0836c0 b() {
            return this.a;
        }

        public HashMap<J.a, Integer> c() {
            return this.e;
        }

        public boolean d() {
            return this.c;
        }

        C0836c0 e() {
            e eVar = this.d;
            return eVar != null ? eVar.a(this.a) : this.a;
        }

        public String toString() {
            return "ReportToSend{mReport=" + this.a + ", mEnvironment=" + this.b + ", mCrash=" + this.c + ", mAction=" + this.d + ", mTrimmedFields=" + this.e + '}';
        }

        public f a(e eVar) {
            this.d = eVar;
            return this;
        }

        public f a(HashMap<J.a, Integer> map) {
            this.e = map;
            return this;
        }

        public f a(boolean z) {
            this.c = z;
            return this;
        }

        public Q1 a() {
            return this.b;
        }
    }

    private abstract class g implements Callable<Void> {
        private g() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            int i = 0;
            do {
                try {
                    IMetricaService iMetricaServiceD = U1.this.b.d();
                    if (iMetricaServiceD != null) {
                        try {
                            a(iMetricaServiceD);
                            return null;
                        } catch (RemoteException unused) {
                        }
                    }
                    i++;
                    if (!b() || C1.a()) {
                        break;
                    }
                } catch (Throwable th) {
                    a(th);
                    return null;
                }
            } while (i < 2);
            return null;
        }

        abstract void a(IMetricaService iMetricaService) throws RemoteException;

        void a(Throwable th) {
        }

        boolean b() {
            U1.this.b.b();
            synchronized (U1.this.c) {
                if (!U1.this.b.e()) {
                    try {
                        U1.this.c.wait(DeviceOrientationRequest.OUTPUT_PERIOD_FAST, 0);
                    } catch (InterruptedException unused) {
                        U1.this.c.notifyAll();
                    }
                }
            }
            return true;
        }

        /* synthetic */ g(U1 u1, a aVar) {
            this();
        }
    }

    class h extends g {
        private final int b;
        private final Bundle c;

        h(U1 u1, int i, Bundle bundle) {
            super(u1, null);
            this.b = i;
            this.c = bundle;
        }

        @Override // com.yandex.metrica.impl.ob.U1.g
        void a(IMetricaService iMetricaService) throws RemoteException {
            iMetricaService.a(this.b, this.c);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public U1(P0 p0) {
        T1 t1 = (T1) p0;
        this(t1, P.g().d().d(), new C1116n6(t1.a()));
    }

    @Override // com.yandex.metrica.impl.ob.C1136o1.c
    public void onServiceConnected() {
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    @Override // com.yandex.metrica.impl.ob.C1136o1.c
    public void onServiceDisconnected() {
    }

    public Future<Void> queuePauseUserSession(A3 a3) {
        return this.d.submit(new b(a3));
    }

    public Future<Void> queueReport(f fVar) {
        return this.d.submit(fVar.d() ? new c(fVar, P.g().h()) : new d(fVar));
    }

    public Future<Void> queueResumeUserSession(A3 a3) {
        return this.d.submit(new a(a3));
    }

    public void reportData(int i, Bundle bundle) {
        this.d.submit(new h(this, i, bundle));
    }

    public void sendCrash(f fVar) {
        c cVar = new c(fVar, P.g().h());
        if (this.b.e()) {
            try {
                this.d.submit(cVar).get(4L, TimeUnit.SECONDS);
            } catch (Throwable unused) {
            }
        }
        if (cVar.d) {
            return;
        }
        try {
            cVar.call();
        } catch (Throwable unused2) {
        }
    }

    public U1(P0 p0, ICommonExecutor iCommonExecutor, C1116n6 c1116n6) {
        this.c = new Object();
        this.a = p0;
        this.d = iCommonExecutor;
        this.e = c1116n6;
        C1136o1 c1136o1C = ((T1) p0).c();
        this.b = c1136o1C;
        c1136o1C.a(this);
    }
}
