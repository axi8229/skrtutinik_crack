package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Bundle;
import com.yandex.metrica.core.api.executors.ICommonExecutor;
import com.yandex.metrica.impl.ob.C1310v7;
import com.yandex.metrica.impl.ob.D3;
import com.yandex.metrica.impl.ob.J;
import com.yandex.metrica.impl.ob.Mg;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class L1 {
    private final Context a;
    private final ICommonExecutor b;
    private final C1014j4 c;
    private final B0 d;

    class a implements InterfaceC1107mm<Z6> {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(Z6 z6) {
            Z6 z62 = z6;
            L1 l1 = L1.this;
            C0990i4 c0990i4 = new C0990i4(z62.a(), z62.f(), z62.g(), z62.h(), z62.i());
            String strE = z62.e();
            byte[] bArrC = z62.c();
            int iB = z62.b();
            HashMap<J.a, Integer> mapJ = z62.j();
            String strD = z62.d();
            C0858cm c0858cmB = Ul.b(z62.a());
            List<Integer> list = C1399z0.i;
            J jA = new J(bArrC, strE, EnumC0787a1.EVENT_TYPE_EXCEPTION_UNHANDLED_FROM_FILE.b(), c0858cmB).a(mapJ);
            jA.h = iB;
            l1.a(c0990i4, jA.c(strD), new D3(new Mg.b(null, null, null, null, null, null, false, null), new D3.a(), null));
        }
    }

    protected class b implements InterfaceC1107mm<String> {
        private final C0990i4 a;
        private final InterfaceC1132nm<String, C0836c0> b;

        public b(C0990i4 c0990i4, InterfaceC1132nm<String, C0836c0> interfaceC1132nm) {
            this.a = c0990i4;
            this.b = interfaceC1132nm;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1107mm
        public void b(String str) {
            L1.this.a(this.a, this.b.a(str), new D3(new Mg.b(null, null, null, null, null, null, false, null), new D3.a(), null));
        }
    }

    L1(Context context, C1014j4 c1014j4, ICommonExecutor iCommonExecutor, B0 b0) {
        this.a = context;
        this.b = iCommonExecutor;
        this.c = c1014j4;
        this.d = b0;
    }

    public void a(File file) {
        C0793a7 c0793a7 = new C0793a7();
        this.b.execute(new RunnableC1261t6(file, c0793a7, c0793a7, new a()));
    }

    public void a(C0990i4 c0990i4, C0836c0 c0836c0, D3 d3) {
        this.c.a(c0990i4, d3).a(c0836c0, d3);
        this.c.a(c0990i4.b(), c0990i4.c().intValue(), c0990i4.d());
    }

    public void a(C1214r7 c1214r7, InterfaceC1132nm<String, C0836c0> interfaceC1132nm) {
        ICommonExecutor iCommonExecutor = this.b;
        B0 b0 = this.d;
        String str = c1214r7.a.b;
        b0.getClass();
        iCommonExecutor.execute(new RunnableC1261t6(new File(str), new C0993i7(new C0843c7(EnumC0943g7.CRASHPAD, c1214r7.c.b), new C0968h7(new P6())), new C1310v7.c(c1214r7.a.a), new b(c1214r7.b, interfaceC1132nm)));
    }

    public void a(C0836c0 c0836c0, Bundle bundle) {
        if (EnumC0787a1.EVENT_TYPE_UNDEFINED.b() == c0836c0.e) {
            return;
        }
        this.b.execute(new N1(this.a, c0836c0, bundle, this.c));
    }
}
