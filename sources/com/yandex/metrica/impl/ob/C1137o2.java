package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C1183q;
import com.yandex.metrica.impl.ob.r;

/* renamed from: com.yandex.metrica.impl.ob.o2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1137o2 {
    private final C1183q a;
    private final Ll<C1011j1> b;
    private final C1183q.b c;
    private final C1183q.b d;
    private final r e;
    private final C1159p f;

    /* renamed from: com.yandex.metrica.impl.ob.o2$a */
    class a implements C1183q.b {

        /* renamed from: com.yandex.metrica.impl.ob.o2$a$a, reason: collision with other inner class name */
        class C0292a implements E1<C1011j1> {
            final /* synthetic */ Activity a;

            C0292a(Activity activity) {
                this.a = activity;
            }

            @Override // com.yandex.metrica.impl.ob.E1
            public void b(C1011j1 c1011j1) {
                C1137o2.a(C1137o2.this, this.a, c1011j1);
            }
        }

        a() {
        }

        @Override // com.yandex.metrica.impl.ob.C1183q.b
        public void a(Activity activity, C1183q.a aVar) {
            C1137o2.this.b.a((E1) new C0292a(activity));
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.o2$b */
    class b implements C1183q.b {

        /* renamed from: com.yandex.metrica.impl.ob.o2$b$a */
        class a implements E1<C1011j1> {
            final /* synthetic */ Activity a;

            a(Activity activity) {
                this.a = activity;
            }

            @Override // com.yandex.metrica.impl.ob.E1
            public void b(C1011j1 c1011j1) {
                C1137o2.b(C1137o2.this, this.a, c1011j1);
            }
        }

        b() {
        }

        @Override // com.yandex.metrica.impl.ob.C1183q.b
        public void a(Activity activity, C1183q.a aVar) {
            C1137o2.this.b.a((E1) new a(activity));
        }
    }

    public C1137o2(C1183q c1183q, ICommonExecutor iCommonExecutor, C1159p c1159p) {
        this(c1183q, c1159p, new Ll(iCommonExecutor), new r());
    }

    public void b(Activity activity, K0 k0) {
        if (activity != null) {
            this.f.a(activity);
        }
        if (this.e.a(activity, r.a.RESUMED)) {
            k0.a(activity);
        }
    }

    C1137o2(C1183q c1183q, C1159p c1159p, Ll<C1011j1> ll, r rVar) {
        this.a = c1183q;
        this.f = c1159p;
        this.b = ll;
        this.e = rVar;
        this.c = new a();
        this.d = new b();
    }

    public C1183q.c a() {
        this.a.a(this.c, C1183q.a.RESUMED);
        this.a.a(this.d, C1183q.a.PAUSED);
        return this.a.a();
    }

    static void b(C1137o2 c1137o2, Activity activity, K0 k0) {
        if (c1137o2.e.a(activity, r.a.PAUSED)) {
            ((C1011j1) k0).b(activity);
        }
    }

    public void a(Activity activity, K0 k0) {
        if (activity != null) {
            this.f.a(activity);
        }
        if (this.e.a(activity, r.a.PAUSED)) {
            k0.b(activity);
        }
    }

    public void a(C1011j1 c1011j1) {
        this.b.a((Ll<C1011j1>) c1011j1);
    }

    static void a(C1137o2 c1137o2, Activity activity, K0 k0) {
        if (c1137o2.e.a(activity, r.a.RESUMED)) {
            ((C1011j1) k0).a(activity);
        }
    }
}
