package com.yandex.metrica.impl.ob;

import android.app.Activity;
import com.yandex.metrica.impl.ob.C1396yl;

/* renamed from: com.yandex.metrica.impl.ob.el, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C0907el {
    private final C1252sl a;
    private final C1396yl.a b;
    private final C1276tl c;

    C0907el() {
        this(new C1252sl(), new C1396yl.a(), new C1276tl());
    }

    C0882dl a(Activity activity, C1348wl c1348wl, Ak ak, Hk hk, boolean z) throws Throwable {
        if (z) {
            return new C0882dl();
        }
        C1276tl c1276tl = this.c;
        this.b.getClass();
        return c1276tl.a(activity, hk, c1348wl, ak, new C1396yl(c1348wl, C1152oh.a()), this.a);
    }

    C0907el(C1252sl c1252sl, C1396yl.a aVar, C1276tl c1276tl) {
        this.a = c1252sl;
        this.b = aVar;
        this.c = c1276tl;
    }
}
