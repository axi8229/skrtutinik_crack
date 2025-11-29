package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.impl.ob.Bl;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class Al implements Runnable {
    final /* synthetic */ WeakReference a;
    final /* synthetic */ List b;
    final /* synthetic */ C0932fl c;
    final /* synthetic */ C1348wl d;
    final /* synthetic */ Bk e;
    final /* synthetic */ boolean f;
    final /* synthetic */ Bl g;

    Al(Bl bl, WeakReference weakReference, List list, C0932fl c0932fl, C1348wl c1348wl, Bk bk, boolean z) {
        this.g = bl;
        this.a = weakReference;
        this.b = list;
        this.c = c0932fl;
        this.d = c1348wl;
        this.e = bk;
        this.f = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Hk c1180pk;
        C0882dl c0882dlA;
        Activity activity = (Activity) this.a.get();
        if (activity == null) {
            return;
        }
        Bl.a aVar = this.g.f;
        List list = this.b;
        List list2 = this.g.g;
        C0932fl c0932fl = this.c;
        aVar.getClass();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (((InterfaceC1324vl) it2.next()).a(c0932fl)) {
                    }
                }
                c1180pk = new C1180pk();
            } else if (((InterfaceC1324vl) it.next()).a(c0932fl)) {
                break;
            }
        }
        c1180pk = new Uk();
        Hk hk = c1180pk;
        long jA = this.g.c.a();
        Bl.a(this.g, activity, jA);
        try {
            c0882dlA = this.g.d.a(activity, this.d, this.e.c(), hk, this.f);
        } catch (Throwable th) {
            Bl.a(this.g, this.b, th, this.d);
            c0882dlA = null;
        }
        C0882dl c0882dl = c0882dlA;
        if (c0882dl != null) {
            Bl.a(this.g, this.b, c0882dl, hk.a(), activity, this.c, this.e, jA);
        }
    }
}
