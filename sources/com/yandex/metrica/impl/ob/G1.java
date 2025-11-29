package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes3.dex */
public class G1 {

    class a implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        a(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            this.a.getClass();
            return false;
        }
    }

    class b implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        b(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            return this.a.a(context) && this.a.c(context);
        }
    }

    class c implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        c(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            return this.a.c(context);
        }
    }

    class d implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        d(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            this.a.getClass();
            return false;
        }
    }

    class e implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        e(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            if (!this.a.a(context)) {
                return false;
            }
            this.a.getClass();
            return false;
        }
    }

    class f implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        f(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            this.a.getClass();
            return false;
        }
    }

    class g implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        g(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            this.a.getClass();
            return false;
        }
    }

    class h implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        h(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            return this.a.a(context);
        }
    }

    class i implements InterfaceC1412zd {
        final /* synthetic */ C1388yd a;

        i(G1 g1, C1388yd c1388yd) {
            this.a = c1388yd;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1412zd
        public boolean a(Context context) {
            return this.a.a(context);
        }
    }

    public InterfaceC1412zd a(C1388yd c1388yd) {
        return new i(this, c1388yd);
    }

    public InterfaceC1412zd b(C1388yd c1388yd) {
        return new h(this, c1388yd);
    }

    public InterfaceC1412zd c(C1388yd c1388yd) {
        return new g(this, c1388yd);
    }

    public InterfaceC1412zd d(C1388yd c1388yd) {
        return A2.a(29) ? new a(this, c1388yd) : A2.a(23) ? new b(this, c1388yd) : new c(this, c1388yd);
    }

    public InterfaceC1412zd e(C1388yd c1388yd) {
        return A2.a(29) ? new d(this, c1388yd) : A2.a(23) ? new e(this, c1388yd) : new f(this, c1388yd);
    }
}
