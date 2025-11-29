package com.yandex.metrica.impl.ob;

import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;

/* renamed from: com.yandex.metrica.impl.ob.zh, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1416zh {
    private final String a;
    private final C1353x2 b;
    private final TimeProvider c;
    private final C1368xh d;

    C1416zh(String str, C1344wh c1344wh) {
        this(str, new C1353x2(), new SystemTimeProvider(), new C1368xh(c1344wh));
    }

    void a(Gh gh, int i, C0879di c0879di) {
        this.d.a(c0879di.g);
        if (this.b.b(this.d.a(i), c0879di.g, "report " + this.a)) {
            ((Jh) gh).a(this.a, Integer.valueOf(i));
            this.d.a(i, this.c.currentTimeSeconds());
        }
    }

    C1416zh(String str, C1353x2 c1353x2, TimeProvider timeProvider, C1368xh c1368xh) {
        this.a = str;
        this.b = c1353x2;
        this.c = timeProvider;
        this.d = c1368xh;
    }
}
