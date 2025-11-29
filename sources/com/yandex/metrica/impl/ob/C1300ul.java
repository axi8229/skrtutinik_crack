package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.content.Context;
import com.yandex.metrica.core.api.executors.ICommonExecutor;

/* renamed from: com.yandex.metrica.impl.ob.ul, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1300ul implements InterfaceC0957gl {
    private final Xk a;
    private final Sk b;
    private final C0820b9 c;
    private final C1419zk d;
    private final Lk e;
    private Activity f;
    private C0932fl g;

    /* renamed from: com.yandex.metrica.impl.ob.ul$a */
    class a implements InterfaceC1107mm<Activity> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(Activity activity) {
            C1300ul.this.a.a(activity);
        }
    }

    public C1300ul(Context context, C0820b9 c0820b9, El el, ICommonExecutor iCommonExecutor, C0932fl c0932fl) {
        this(context, c0820b9, el, iCommonExecutor, c0932fl, new C1419zk(c0932fl));
    }

    public synchronized void b(Activity activity) {
        this.f = activity;
        this.a.a(activity);
    }

    private C1300ul(Context context, C0820b9 c0820b9, El el, ICommonExecutor iCommonExecutor, C0932fl c0932fl, C1419zk c1419zk) {
        this(c0820b9, el, c0932fl, c1419zk, new C1055kk(1, c0820b9), new Bl(iCommonExecutor, new C1080lk(c0820b9), c1419zk), new C0981hk(context));
    }

    public synchronized void a(Activity activity) {
        this.e.a(activity);
        this.f = null;
    }

    private C1300ul(C0820b9 c0820b9, El el, C0932fl c0932fl, C1419zk c1419zk, C1055kk c1055kk, Bl bl, C0981hk c0981hk) {
        this(c0820b9, c0932fl, el, bl, c1419zk, new Xk(c0932fl, c1055kk, c0820b9, bl, c0981hk), new Sk(c0932fl, c1055kk, c0820b9, bl, c0981hk), new C1105mk());
    }

    C1300ul(C0820b9 c0820b9, C0932fl c0932fl, El el, Bl bl, C1419zk c1419zk, Xk xk, Sk sk, C1105mk c1105mk) {
        this.c = c0820b9;
        this.g = c0932fl;
        this.d = c1419zk;
        this.a = xk;
        this.b = sk;
        Lk lk = new Lk(new a(), el);
        this.e = lk;
        bl.a(c1105mk, lk);
    }

    public synchronized void a(InterfaceC1081ll interfaceC1081ll, boolean z) {
        this.b.a(this.f, interfaceC1081ll, z);
        this.c.c(true);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0957gl
    public synchronized void a(C0932fl c0932fl) {
        if (!c0932fl.equals(this.g)) {
            this.d.a(c0932fl);
            this.b.a(c0932fl);
            this.a.a(c0932fl);
            this.g = c0932fl;
            Activity activity = this.f;
            if (activity != null) {
                this.a.b(activity);
            }
        }
    }
}
