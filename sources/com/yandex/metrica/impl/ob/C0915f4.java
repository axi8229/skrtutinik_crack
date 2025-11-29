package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;

/* renamed from: com.yandex.metrica.impl.ob.f4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0915f4 {
    private final C0845c9 a;
    private final TimeProvider b;
    private final C1353x2 c;
    private C1273ti d;
    private long e;

    public C0915f4(Context context, I3 i3) {
        this(new C0845c9(C1020ja.a(context).b(i3)), new SystemTimeProvider(), new C1353x2());
    }

    public boolean a(Boolean bool) {
        C1273ti c1273ti;
        return Boolean.FALSE.equals(bool) && (c1273ti = this.d) != null && this.c.a(this.e, c1273ti.a, "should report diagnostic");
    }

    public C0915f4(C0845c9 c0845c9, TimeProvider timeProvider, C1353x2 c1353x2) {
        this.a = c0845c9;
        this.b = timeProvider;
        this.c = c1353x2;
        this.e = c0845c9.k();
    }

    public void a() {
        long jCurrentTimeMillis = this.b.currentTimeMillis();
        this.e = jCurrentTimeMillis;
        this.a.d(jCurrentTimeMillis).d();
    }

    public void a(C1273ti c1273ti) {
        this.d = c1273ti;
    }
}
