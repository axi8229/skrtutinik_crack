package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.coreutils.services.SystemTimeProvider;
import com.yandex.metrica.coreutils.services.TimeProvider;

/* renamed from: com.yandex.metrica.impl.ob.ta, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1265ta<T> {
    private final Context a;
    private final String b;
    private final InterfaceC1241sa<T> c;
    private final InterfaceC1132nm<C1217ra, C1194qa> d;
    private final InterfaceC1337wa e;
    private final C1313va f;
    private final M0 g;
    private final TimeProvider h;

    public C1265ta(Context context, Q0 q0, String str, InterfaceC1241sa<T> interfaceC1241sa, InterfaceC1132nm<C1217ra, C1194qa> interfaceC1132nm, InterfaceC1337wa interfaceC1337wa) {
        this(context, str, interfaceC1241sa, interfaceC1132nm, interfaceC1337wa, new C1313va(context, str, interfaceC1337wa, q0), C1152oh.a(), new SystemTimeProvider());
    }

    public synchronized void a(T t, C1217ra c1217ra) {
        if (this.f.a(this.d.a(c1217ra))) {
            this.g.a(this.b, this.c.a(t));
            this.e.a(new Z8(C1020ja.a(this.a).g()), this.h.currentTimeSeconds());
        }
    }

    public C1265ta(Context context, String str, InterfaceC1241sa<T> interfaceC1241sa, InterfaceC1132nm<C1217ra, C1194qa> interfaceC1132nm, InterfaceC1337wa interfaceC1337wa, C1313va c1313va, M0 m0, TimeProvider timeProvider) {
        this.a = context;
        this.b = str;
        this.c = interfaceC1241sa;
        this.d = interfaceC1132nm;
        this.e = interfaceC1337wa;
        this.f = c1313va;
        this.g = m0;
        this.h = timeProvider;
    }
}
