package com.yandex.metrica.impl.ob;

/* loaded from: classes3.dex */
public class Fe implements Ge {
    private final Dm a;

    public Fe() {
        this(new Dm());
    }

    @Override // com.yandex.metrica.impl.ob.Ge
    public byte[] a(C1198qe c1198qe, Lg lg) {
        byte[] bArrA = new byte[0];
        try {
            bArrA = L0.a(c1198qe.b);
        } catch (Throwable unused) {
        }
        byte[] bArrA2 = this.a.a(c1198qe.r).a(bArrA);
        return bArrA2 == null ? new byte[0] : bArrA2;
    }

    Fe(Dm dm) {
        this.a = dm;
    }
}
