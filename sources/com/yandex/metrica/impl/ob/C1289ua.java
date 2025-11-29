package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.YandexMetricaConfig;

/* renamed from: com.yandex.metrica.impl.ob.ua, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1289ua {

    /* renamed from: com.yandex.metrica.impl.ob.ua$a */
    class a implements InterfaceC1132nm<C1217ra, C1194qa> {
        a(C1289ua c1289ua) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public C1194qa a(C1217ra c1217ra) {
            return c1217ra.a;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.ua$b */
    class b implements InterfaceC1132nm<C1217ra, C1194qa> {
        b(C1289ua c1289ua) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public C1194qa a(C1217ra c1217ra) {
            return c1217ra.c;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.ua$c */
    class c implements InterfaceC1337wa {
        c(C1289ua c1289ua) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1337wa
        public long a(Z8 z8) {
            return z8.c(Long.MAX_VALUE);
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1337wa
        public void a(Z8 z8, long j) {
            z8.e(j);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.ua$d */
    class d implements InterfaceC1132nm<C1217ra, C1194qa> {
        d(C1289ua c1289ua) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1132nm
        public C1194qa a(C1217ra c1217ra) {
            return c1217ra.b;
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.ua$e */
    class e implements InterfaceC1337wa {
        e(C1289ua c1289ua) {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1337wa
        public long a(Z8 z8) {
            return z8.b(Long.MAX_VALUE);
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1337wa
        public void a(Z8 z8, long j) {
            z8.d(j);
        }
    }

    public C1265ta<YandexMetricaConfig> a(Context context, Q0 q0) {
        Xl xl = new Xl();
        return new C1265ta<>(context, q0, "activation", new C1120na(xl, new C1385ya()), new a(this), new C1145oa(xl));
    }

    public C1265ta<C1306v3> b(Context context, Q0 q0) {
        return new C1265ta<>(context, q0, "clids_info", new C1170pa(), new d(this), new e(this));
    }

    public C1265ta<Ud> c(Context context, Q0 q0) {
        return new C1265ta<>(context, q0, "preload_info", new C1361xa(), new b(this), new c(this));
    }
}
