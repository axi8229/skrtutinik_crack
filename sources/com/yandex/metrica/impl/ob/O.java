package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.D1;

/* loaded from: classes3.dex */
public class O extends D1 {
    private final C0820b9 a;

    class a extends SparseArray<D1.a> {
        a() {
            put(47, new c(O.this.a));
            put(66, new d(O.this, O.this.a));
            put(89, new b(O.this.a));
            put(99, new e(O.this.a));
            put(105, new f(O.this.a));
        }
    }

    private class d implements D1.a {
        private final C0820b9 a;

        public d(O o, C0820b9 c0820b9) {
            this.a = c0820b9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.a.f(new Rd("COOKIE_BROWSERS", null).a());
            this.a.f(new Rd("BIND_ID_URL", null).a());
            L0.a(context, "b_meta.dat");
            L0.a(context, "browsers.dat");
        }
    }

    static class e implements D1.a {
        private final C0820b9 a;

        e(C0820b9 c0820b9) {
            this.a = c0820b9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.a.f(new Rd("DEVICE_ID_POSSIBLE", null).a()).d();
        }
    }

    static class f implements D1.a {
        private final C0820b9 a;

        f(C0820b9 c0820b9) {
            this.a = c0820b9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            this.a.f(new Rd("STARTUP_REQUEST_TIME", null).a()).d();
        }
    }

    public O(Context context) {
        this(new C0820b9(C1020ja.a(context).d()));
    }

    @Override // com.yandex.metrica.impl.ob.D1
    SparseArray<D1.a> a() {
        return new a();
    }

    @Override // com.yandex.metrica.impl.ob.D1
    protected int a(Nd nd) {
        return (int) this.a.b(-1L);
    }

    O(C0820b9 c0820b9) {
        this.a = c0820b9;
    }

    @Override // com.yandex.metrica.impl.ob.D1
    protected void a(Nd nd, int i) {
        this.a.e(i);
        nd.g().b();
    }

    static class b implements D1.a {
        private final C0820b9 a;

        b(C0820b9 c0820b9) {
            this.a = c0820b9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            String strL = this.a.l(null);
            String strN = this.a.n(null);
            String strM = this.a.m(null);
            String strG = this.a.g((String) null);
            String strH = this.a.h((String) null);
            String strJ = this.a.j((String) null);
            this.a.e(a(strL));
            this.a.i(a(strN));
            this.a.d(a(strM));
            this.a.a(a(strG));
            this.a.b(a(strH));
            this.a.h(a(strJ));
        }

        private W0 a(String str) {
            boolean zIsEmpty = TextUtils.isEmpty(str);
            return new W0(str, zIsEmpty ? U0.UNKNOWN : U0.OK, zIsEmpty ? "no identifier saved in previous version" : null);
        }
    }

    static class c implements D1.a {
        private C0820b9 a;

        public c(C0820b9 c0820b9) {
            this.a = c0820b9;
        }

        @Override // com.yandex.metrica.impl.ob.D1.a
        public void a(Context context) {
            Ld ld = new Ld(context);
            if (A2.b(ld.g())) {
                return;
            }
            if (this.a.n(null) == null || this.a.l(null) == null) {
                String strE = ld.e(null);
                if (a(strE, this.a.l(null))) {
                    this.a.s(strE);
                }
                String strF = ld.f(null);
                if (a(strF, this.a.n(null))) {
                    this.a.t(strF);
                }
                String strB = ld.b(null);
                if (a(strB, this.a.g((String) null))) {
                    this.a.o(strB);
                }
                String strC = ld.c(null);
                if (a(strC, this.a.h((String) null))) {
                    this.a.p(strC);
                }
                String strD = ld.d(null);
                if (a(strD, this.a.j((String) null))) {
                    this.a.q(strD);
                }
                long jA = ld.a(-1L);
                long jD = this.a.d(-1L);
                if (jA != -1 && jD == -1) {
                    this.a.h(jA);
                }
                this.a.d();
                ld.f().b();
            }
        }

        private boolean a(String str, String str2) {
            return !TextUtils.isEmpty(str) && TextUtils.isEmpty(str2);
        }
    }
}
