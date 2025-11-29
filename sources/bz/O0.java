package bz;

import dagger.internal.Preconditions;

/* loaded from: classes.dex */
public final class O0 implements L1 {
    public final Q a;
    public C0515g0 b;
    public final zone.bi.mobile.sdk.c c;
    public final zone.bi.mobile.sdk.b d;

    public O0(Q q, zone.bi.mobile.sdk.c cVar, zone.bi.mobile.sdk.b bVar) {
        this.a = q;
        this.c = cVar;
        this.d = bVar;
    }

    @Override // bz.L1
    public final Object a() {
        Object objA;
        if (this.b == null) {
            if (((L1) ((C0505d) this.a).b.a.get(InterfaceC0523j.class)) == null) {
                throw new IllegalStateException("Failed to get feature with key = " + InterfaceC0523j.class);
            }
            B b = ((C0505d) this.a).b;
            N n = b.b;
            if (n == null) {
                objA = b.a(InterfaceC0523j.class);
            } else {
                if (!n.d.add(InterfaceC0523j.class)) {
                    n.c = InterfaceC0523j.class;
                    throw new C0525j1(n);
                }
                L1 l1 = (L1) b.a.get(InterfaceC0523j.class);
                if (l1 == null) {
                    throw new IllegalStateException("Failed to get feature with key = " + InterfaceC0523j.class);
                }
                Object objA2 = l1.a();
                b.b.d.remove(InterfaceC0523j.class);
                objA = objA2;
            }
            InterfaceC0523j interfaceC0523j = (InterfaceC0523j) Preconditions.checkNotNull((InterfaceC0523j) objA);
            zone.bi.mobile.sdk.c cVar = (zone.bi.mobile.sdk.c) Preconditions.checkNotNull(this.c);
            zone.bi.mobile.sdk.b bVar = (zone.bi.mobile.sdk.b) Preconditions.checkNotNull(this.d);
            Preconditions.checkBuilderRequirement(interfaceC0523j, InterfaceC0523j.class);
            Preconditions.checkBuilderRequirement(cVar, zone.bi.mobile.sdk.c.class);
            Preconditions.checkBuilderRequirement(bVar, zone.bi.mobile.sdk.b.class);
            this.b = new C0515g0(interfaceC0523j);
        }
        return this.b;
    }
}
