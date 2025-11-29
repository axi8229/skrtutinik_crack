package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.pe, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1174pe implements Ge {
    private final Dm a;

    public C1174pe() {
        this(new Dm());
    }

    @Override // com.yandex.metrica.impl.ob.Ge
    public byte[] a(C1198qe c1198qe, Lg lg) {
        String str = c1198qe.b;
        return this.a.a(c1198qe.r).a(str != null ? C0810b.b(str) : new byte[0]);
    }

    C1174pe(Dm dm) {
        this.a = dm;
    }
}
