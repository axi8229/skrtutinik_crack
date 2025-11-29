package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.D3;
import com.yandex.metrica.impl.ob.D4;
import com.yandex.metrica.networktasks.api.ConfigProvider;

/* renamed from: com.yandex.metrica.impl.ob.z4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1403z4 implements P3, ConfigProvider, Q3 {
    private final Context a;
    private final I3 b;
    private final C1160p0 c;
    private A4 d;
    private C0915f4 e;

    /* renamed from: com.yandex.metrica.impl.ob.z4$a */
    static class a {
        a() {
        }

        public A4 a(Context context, I3 i3, C1178pi c1178pi, D4.a aVar) {
            return new A4(new D4.b(context, i3.b()), c1178pi, aVar);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.z4$b */
    static class b {
        private final C0912f1 a;

        b() {
            this(F0.g().h());
        }

        public C1160p0<C1403z4> a(C1403z4 c1403z4, AbstractC1321vi abstractC1321vi, E4 e4, C0819b8 c0819b8) {
            C1160p0<C1403z4> c1160p0 = new C1160p0<>(c1403z4, abstractC1321vi.a(), e4, c0819b8);
            this.a.a(c1160p0);
            return c1160p0;
        }

        b(C0912f1 c0912f1) {
            this.a = c0912f1;
        }
    }

    public C1403z4(Context context, I3 i3, D3.a aVar, C1178pi c1178pi, AbstractC1321vi abstractC1321vi, CounterConfiguration.b bVar) {
        this(context, i3, aVar, c1178pi, abstractC1321vi, bVar, new E4(), new b(), new a(), new C0915f4(context, i3), F0.g().w().a(i3));
    }

    @Override // com.yandex.metrica.impl.ob.S3
    public void a(D3.a aVar) {
        this.d.a((A4) aVar);
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public void a(EnumC0954gi enumC0954gi, C1178pi c1178pi) {
    }

    public Context b() {
        return this.a;
    }

    @Override // com.yandex.metrica.networktasks.api.ConfigProvider
    public Object getConfig() {
        return this.d.b();
    }

    @Override // com.yandex.metrica.impl.ob.S3
    public void a(C0836c0 c0836c0) {
        this.c.a(c0836c0);
    }

    public void a() {
        if (this.e.a(this.d.b().D())) {
            this.c.a(C1399z0.a());
            this.e.a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1053ki
    public synchronized void a(C1178pi c1178pi) {
        this.d.a(c1178pi);
        this.e.a(c1178pi.P());
    }

    public C1403z4(Context context, I3 i3, D3.a aVar, C1178pi c1178pi, AbstractC1321vi abstractC1321vi, CounterConfiguration.b bVar, E4 e4, b bVar2, a aVar2, C0915f4 c0915f4, C0819b8 c0819b8) {
        this.a = context;
        this.b = i3;
        this.e = c0915f4;
        this.c = bVar2.a(this, abstractC1321vi, e4, c0819b8);
        synchronized (this) {
            this.e.a(c1178pi.P());
            this.d = aVar2.a(context, i3, c1178pi, new D4.a(aVar));
        }
    }
}
