package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.Bk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class Bl {
    private Runnable a;
    private final ICommonExecutor b;
    private final C1080lk c;
    private final C0907el d;
    private final C1419zk e;
    private final a f;
    private final List<InterfaceC1372xl> g;
    private final List<Vk> h;
    private final Bk.a i;

    static class a {
        a() {
        }
    }

    Bl(ICommonExecutor iCommonExecutor, C1080lk c1080lk, C1419zk c1419zk) {
        this(iCommonExecutor, c1080lk, c1419zk, new C0907el(), new a(), Collections.emptyList(), new Bk.a());
    }

    static void a(Bl bl, List list, Throwable th, C1348wl c1348wl) {
        bl.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((InterfaceC1324vl) it.next()).a(th, c1348wl);
        }
        Iterator<InterfaceC1372xl> it2 = bl.g.iterator();
        while (it2.hasNext()) {
            it2.next().a(th, c1348wl);
        }
    }

    Bl(ICommonExecutor iCommonExecutor, C1080lk c1080lk, C1419zk c1419zk, C0907el c0907el, a aVar, List<Vk> list, Bk.a aVar2) {
        this.g = new ArrayList();
        this.b = iCommonExecutor;
        this.c = c1080lk;
        this.e = c1419zk;
        this.d = c0907el;
        this.f = aVar;
        this.h = list;
        this.i = aVar2;
    }

    static void a(Bl bl, List list, C0882dl c0882dl, List list2, Activity activity, C0932fl c0932fl, Bk bk, long j) {
        bl.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((InterfaceC1324vl) it.next()).a(j, activity, c0882dl, list2, c0932fl, bk);
        }
        Iterator<InterfaceC1372xl> it2 = bl.g.iterator();
        while (it2.hasNext()) {
            it2.next().a(j, activity, c0882dl, list2, c0932fl, bk);
        }
    }

    void a(InterfaceC1372xl... interfaceC1372xlArr) {
        this.g.addAll(Arrays.asList(interfaceC1372xlArr));
    }

    static void a(Bl bl, Activity activity, long j) {
        Iterator<InterfaceC1372xl> it = bl.g.iterator();
        while (it.hasNext()) {
            it.next().a(activity, j);
        }
    }

    void a(Activity activity, long j, C0932fl c0932fl, C1348wl c1348wl, List<InterfaceC1324vl> list) {
        boolean z;
        Iterator<Vk> it = this.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().a(activity, c1348wl)) {
                z = true;
                break;
            }
        }
        boolean z2 = z;
        WeakReference weakReference = new WeakReference(activity);
        Bk.a aVar = this.i;
        C1419zk c1419zk = this.e;
        aVar.getClass();
        Al al = new Al(this, weakReference, list, c0932fl, c1348wl, new Bk(c1419zk, c0932fl), z2);
        Runnable runnable = this.a;
        if (runnable != null) {
            this.b.remove(runnable);
        }
        this.a = al;
        Iterator<InterfaceC1372xl> it2 = this.g.iterator();
        while (it2.hasNext()) {
            it2.next().a(activity, z2);
        }
        this.b.executeDelayed(al, j);
    }
}
