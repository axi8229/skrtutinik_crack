package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.yandex.metrica.impl.ob.D3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class F3 implements P3, InterfaceC1053ki, R3 {
    private final Context a;
    private final I3 b;
    private final C0904ei c;
    private final C1225ri d;
    private final C0840c4 e;
    private final C1362xb f;
    private final N4<M4, F3> g;
    private final C1329w2<F3> h;
    private final J3 j;
    private Jf k;
    private final M l;
    private final C1295ug m;
    private List<V0> i = new ArrayList();
    private final Object n = new Object();

    class a implements InterfaceC0852cg {
        final /* synthetic */ ResultReceiver a;

        a(F3 f3, ResultReceiver resultReceiver) {
            this.a = resultReceiver;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0852cg
        public void a(C0877dg c0877dg) {
            ResultReceiver resultReceiver = this.a;
            int i = ResultReceiverC0902eg.b;
            if (resultReceiver != null) {
                Bundle bundle = new Bundle();
                bundle.putByteArray("referrer", c0877dg == null ? null : c0877dg.a());
                resultReceiver.send(1, bundle);
            }
        }
    }

    F3(Context context, C0904ei c0904ei, I3 i3, D3 d3, C0840c4 c0840c4, C1247sg c1247sg, J3 j3, H3 h3, N n, C1362xb c1362xb, C1295ug c1295ug) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = i3;
        this.c = c0904ei;
        this.e = c0840c4;
        this.j = j3;
        this.g = h3.a(this);
        C1225ri c1225riA = c0904ei.a(applicationContext, i3, d3.a);
        this.d = c1225riA;
        this.f = c1362xb;
        c1362xb.a(applicationContext, c1225riA.d());
        this.l = n.a(c1225riA, c1362xb, applicationContext);
        this.h = h3.a(this, c1225riA);
        this.m = c1295ug;
        c0904ei.a(i3, this);
    }

    public void a(D3.a aVar) {
        this.e.a(aVar);
    }

    public synchronized void b(C1114n4 c1114n4) {
        this.j.b(c1114n4);
    }

    public synchronized void a(C1114n4 c1114n4) {
        this.j.a(c1114n4);
        c1114n4.a(this.l.a(Tl.a(this.d.d().v())));
    }

    public Context b() {
        return this.a;
    }

    public void a(C0836c0 c0836c0, C1114n4 c1114n4) {
        this.g.a(c0836c0, c1114n4);
    }

    public D3.a a() {
        return this.e.a();
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public void a(C1178pi c1178pi) {
        this.f.a(c1178pi);
        synchronized (this.n) {
            try {
                Iterator<InterfaceC1039k4> it = this.j.a().iterator();
                while (it.hasNext()) {
                    ((K) it.next()).a(this.l.a(Tl.a(c1178pi.v())));
                }
                ArrayList arrayList = new ArrayList();
                for (V0 v0 : this.i) {
                    if (v0.a(c1178pi)) {
                        a(v0.c(), v0.a());
                    } else {
                        arrayList.add(v0);
                    }
                }
                this.i = new ArrayList(arrayList);
                if (!arrayList.isEmpty()) {
                    this.h.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.k == null) {
            this.k = F0.g().l();
        }
        this.k.a(c1178pi);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public void a(EnumC0954gi enumC0954gi, C1178pi c1178pi) {
        synchronized (this.n) {
            try {
                for (V0 v0 : this.i) {
                    ResultReceiver resultReceiverC = v0.c();
                    L lA = this.l.a(v0.a());
                    int i = ResultReceiverC0911f0.b;
                    if (resultReceiverC != null) {
                        Bundle bundle = new Bundle();
                        enumC0954gi.a(bundle);
                        lA.c(bundle);
                        resultReceiverC.send(2, bundle);
                    }
                }
                this.i.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(V0 v0) {
        ResultReceiver resultReceiverC;
        Map<String, String> mapA;
        List<String> listB;
        HashMap map = new HashMap();
        if (v0 != null) {
            listB = v0.b();
            resultReceiverC = v0.c();
            mapA = v0.a();
        } else {
            resultReceiverC = null;
            mapA = map;
            listB = null;
        }
        boolean zA = this.d.a(listB, mapA);
        if (!zA) {
            a(resultReceiverC, mapA);
        }
        if (!this.d.e()) {
            if (zA) {
                a(resultReceiverC, mapA);
                return;
            }
            return;
        }
        synchronized (this.n) {
            if (zA && v0 != null) {
                try {
                    this.i.add(v0);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.h.d();
    }

    public void a(ResultReceiver resultReceiver) {
        this.m.a(new a(this, resultReceiver));
    }

    @Override // com.yandex.metrica.impl.ob.R3
    public void a(D3 d3) {
        this.d.a(d3.a);
        this.e.a(d3.b);
    }

    private void a(ResultReceiver resultReceiver, Map<String, String> map) {
        L lA = this.l.a(map);
        int i = ResultReceiverC0911f0.b;
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            lA.c(bundle);
            resultReceiver.send(1, bundle);
        }
    }
}
