package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.C1101mg;

/* renamed from: com.yandex.metrica.impl.ob.ng, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1126ng implements C1101mg.a {
    final /* synthetic */ C1101mg.b a;

    /* renamed from: com.yandex.metrica.impl.ob.ng$a */
    public static final class a implements InterfaceC1319vg {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1319vg
        public void a(C0877dg c0877dg) {
            C1101mg c1101mg = C1101mg.this;
            C1101mg.a(c1101mg, c0877dg, C1101mg.c(c1101mg));
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1319vg
        public void a(Throwable th) {
            C1101mg c1101mg = C1101mg.this;
            C1101mg.a(c1101mg, null, C1101mg.c(c1101mg));
        }
    }

    C1126ng(C1101mg.b bVar) {
        this.a = bVar;
    }

    @Override // com.yandex.metrica.impl.ob.C1101mg.a
    public void a() {
        C1101mg.this.g.a(new a());
    }
}
