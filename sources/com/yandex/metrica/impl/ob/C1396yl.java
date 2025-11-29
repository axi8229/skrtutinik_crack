package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.yl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1396yl {
    private final M0 a;
    private final C1348wl b;

    /* renamed from: com.yandex.metrica.impl.ob.yl$a */
    static class a {
        a() {
        }
    }

    C1396yl(C1348wl c1348wl, M0 m0) {
        this.b = c1348wl;
        this.a = m0;
    }

    public void a(String str, Throwable th) {
        if (this.b.f) {
            this.a.reportError(str, th);
        }
    }
}
