package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.wb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1338wb implements InterfaceC1314vb {
    private final InterfaceC1314vb a;

    /* renamed from: com.yandex.metrica.impl.ob.wb$a */
    class a implements InterfaceC1206qm<C1290ub> {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1206qm
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1290ub a() {
            return C1338wb.this.a.a(this.a);
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.wb$b */
    class b implements InterfaceC1206qm<C1290ub> {
        final /* synthetic */ Context a;
        final /* synthetic */ Gb b;

        b(Context context, Gb gb) {
            this.a = context;
            this.b = gb;
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC1206qm
        public C1290ub a() {
            return C1338wb.this.a.a(this.a, this.b);
        }
    }

    public C1338wb(InterfaceC1314vb interfaceC1314vb) {
        this.a = interfaceC1314vb;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1314vb
    public C1290ub a(Context context) {
        return a(new a(context));
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1314vb
    public C1290ub a(Context context, Gb gb) {
        return a(new b(context, gb));
    }

    private C1290ub a(InterfaceC1206qm<C1290ub> interfaceC1206qm) {
        C1290ub c1290ubA = interfaceC1206qm.a();
        C1266tb c1266tb = c1290ubA.a;
        return (c1266tb == null || !"00000000-0000-0000-0000-000000000000".equals(c1266tb.b)) ? c1290ubA : new C1290ub(null, U0.INVALID_ADV_ID, "AdvId is invalid: 00000000-0000-0000-0000-000000000000");
    }
}
