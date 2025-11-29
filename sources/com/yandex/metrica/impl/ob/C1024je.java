package com.yandex.metrica.impl.ob;

import android.util.Base64;

/* renamed from: com.yandex.metrica.impl.ob.je, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1024je implements Ge {
    private final Dm a;

    public C1024je() {
        this(new Dm());
    }

    @Override // com.yandex.metrica.impl.ob.Ge
    public byte[] a(C1198qe c1198qe, Lg lg) {
        byte[] bArrDecode = new byte[0];
        String str = c1198qe.b;
        if (str != null) {
            try {
                bArrDecode = Base64.decode(str, 0);
            } catch (Throwable unused) {
            }
        }
        return this.a.a(c1198qe.r).a(bArrDecode);
    }

    C1024je(Dm dm) {
        this.a = dm;
    }
}
