package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;

/* renamed from: com.yandex.metrica.impl.ob.va, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1313va {
    private final Context a;
    private final String b;
    private final InterfaceC1337wa c;
    private final Q0 d;
    private final TimeProvider e;
    private final C1353x2 f;

    public C1313va(Context context, String str, InterfaceC1337wa interfaceC1337wa, Q0 q0) {
        this(context, str, interfaceC1337wa, q0, new SystemTimeProvider(), new C1353x2());
    }

    public boolean a(C1194qa c1194qa) {
        long jCurrentTimeSeconds = this.e.currentTimeSeconds();
        if (c1194qa == null) {
            return false;
        }
        boolean z = true;
        boolean z2 = jCurrentTimeSeconds <= c1194qa.a;
        if (!z2) {
            z = z2;
        } else if (jCurrentTimeSeconds + this.d.a() > c1194qa.a) {
            z = false;
        }
        if (!z) {
            return false;
        }
        Z8 z8 = new Z8(C1020ja.a(this.a).g());
        return this.f.b(this.c.a(z8), c1194qa.b, this.b + " diagnostics event");
    }

    C1313va(Context context, String str, InterfaceC1337wa interfaceC1337wa, Q0 q0, TimeProvider timeProvider, C1353x2 c1353x2) {
        this.a = context;
        this.b = str;
        this.c = interfaceC1337wa;
        this.d = q0;
        this.e = timeProvider;
        this.f = c1353x2;
    }
}
