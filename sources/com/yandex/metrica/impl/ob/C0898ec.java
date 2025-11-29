package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;

/* renamed from: com.yandex.metrica.impl.ob.ec, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0898ec {
    private final C0895e9 a;
    private final Cc b;
    private final InterfaceC0948gc c;
    private final C0823bc d;
    private final Zb e;
    private final C0873dc f;

    /* renamed from: com.yandex.metrica.impl.ob.ec$a */
    class a implements InterfaceC0948gc {
        a() {
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0948gc
        public void a(long j) {
            C0898ec.this.a.g(j);
        }

        @Override // com.yandex.metrica.impl.ob.InterfaceC0948gc
        public long getLastAttemptTimeSeconds() {
            return C0898ec.this.a.b(0L);
        }
    }

    public C0898ec(Cc cc, C0895e9 c0895e9, Pc pc) {
        this.b = cc;
        this.a = c0895e9;
        InterfaceC0948gc interfaceC0948gcB = b();
        this.c = interfaceC0948gcB;
        this.e = a(interfaceC0948gcB);
        this.d = a();
        this.f = a(pc);
    }

    private InterfaceC0948gc b() {
        return new a();
    }

    private C0823bc a() {
        return new C0823bc(this.b.a.b);
    }

    private Zb a(InterfaceC0948gc interfaceC0948gc) {
        return new Zb(interfaceC0948gc, new C1353x2());
    }

    private C0873dc a(Pc pc) {
        Sb sb = this.b.a;
        return new C0873dc(sb.a, pc, sb.b, sb.c);
    }

    public Ec<C0848cc> a(C0848cc c0848cc) {
        return new Ec<>(this.f, this.e, new Ob(this.c, new SystemTimeProvider()), this.d, c0848cc);
    }
}
