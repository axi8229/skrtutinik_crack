package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.kc, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1047kc extends Pb {

    /* renamed from: com.yandex.metrica.impl.ob.kc$a */
    class a implements InterfaceC0948gc {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0948gc
        public void a(long j) {
            C1047kc.this.a.j(j);
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0948gc
        public long getLastAttemptTimeSeconds() {
            return C1047kc.this.a.e(0L);
        }
    }

    public C1047kc(Cc cc, C0895e9 c0895e9) {
        this(cc, c0895e9, new G1());
    }

    @Override // com.yandex.metrica.impl.ob.Pb
    public InterfaceC0948gc a() {
        return new a();
    }

    @Override // com.yandex.metrica.impl.ob.Pb
    protected String b() {
        return "network";
    }

    @Override // com.yandex.metrica.impl.ob.Pb
    protected String c() {
        return "lbs";
    }

    C1047kc(Cc cc, C0895e9 c0895e9, G1 g1) {
        super(cc, c0895e9, g1);
    }

    @Override // com.yandex.metrica.impl.ob.Pb
    protected InterfaceC1412zd a(C1388yd c1388yd) {
        return this.c.a(c1388yd);
    }
}
