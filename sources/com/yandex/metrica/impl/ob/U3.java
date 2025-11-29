package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.C1247sg;
import com.yandex.metrica.impl.ob.D3;
import java.io.File;

/* loaded from: classes3.dex */
public class U3 extends L3 implements InterfaceC1001ig, InterfaceC0977hg {
    private final C1247sg A;
    private final C1271tg B;
    private final C1233s2 C;
    private final InterfaceC0893e7<File> D;
    private final C0889e3 E;

    class a implements InterfaceC1107mm<File> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(File file) {
            U3.a(U3.this, file);
        }
    }

    public class b implements C1247sg.a {
        public b() {
        }

        @Override // com.yandex.metrica.impl.ob.C1247sg.a
        public void a(C0877dg c0877dg) {
            if (c0877dg == null) {
                return;
            }
            U3.this.a(new C0836c0().a(c0877dg.a()).a(EnumC0787a1.EVENT_TYPE_SEND_REFERRER.b()));
        }
    }

    public U3(Context context, C1178pi c1178pi, I3 i3, D3.a aVar, C1247sg c1247sg, C1233s2 c1233s2, AbstractC1321vi abstractC1321vi) {
        this(context, i3, c1178pi, aVar, new B3(), new C1353x2(), new B0(), new V3(context, i3, aVar, abstractC1321vi, c1178pi, new T3(c1233s2), F0.g().q().d(), A2.b(context, i3.b()), F0.g().q(), F0.g().h()), c1247sg, c1233s2);
    }

    private void a(Context context, B0 b0) {
        File fileA = b0.a(context, "YandexMetricaNativeCrashes");
        if (fileA != null) {
            new Y6(fileA, new a()).a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.L3
    public void G() {
        this.A.a(this.B);
    }

    @Override // com.yandex.metrica.impl.ob.L3
    public CounterConfiguration.b s() {
        return CounterConfiguration.b.MAIN;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC0977hg
    public void a() {
        x().c(true);
    }

    @Override // com.yandex.metrica.impl.ob.L3, com.yandex.metrica.impl.ob.S3
    public synchronized void a(D3.a aVar) {
        super.a(aVar);
        this.C.a(aVar.l);
    }

    @Override // com.yandex.metrica.impl.ob.L3, com.yandex.metrica.impl.ob.InterfaceC1053ki
    public void a(C1178pi c1178pi) {
        super.a(c1178pi);
        this.E.a(c1178pi);
    }

    static void a(U3 u3, File file) {
        u3.D.a(file);
    }

    U3(Context context, I3 i3, C1178pi c1178pi, D3.a aVar, B3 b3, C1353x2 c1353x2, B0 b0, V3 v3, C1247sg c1247sg, C1233s2 c1233s2) {
        super(context, i3, b3, c1353x2, v3);
        this.A = c1247sg;
        I4 i4K = k();
        i4K.a(EnumC0787a1.EVENT_TYPE_REGULAR, new C5(i4K.b()));
        this.B = v3.c(this);
        this.C = c1233s2;
        C1117n7 c1117n7A = v3.a(v3.f(), v3.b(this), f());
        this.D = c1117n7A;
        c1117n7A.a();
        a(context, b0);
        C0889e3 c0889e3A = v3.a(this);
        this.E = c0889e3A;
        c0889e3A.a(c1178pi, aVar.q);
    }
}
