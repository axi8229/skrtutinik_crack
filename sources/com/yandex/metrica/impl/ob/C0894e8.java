package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.e8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0894e8 {
    private final Map<String, C0819b8> a = new LinkedHashMap();
    private final B0 b;
    private final Q7 c;
    private final C0794a8 d;
    private final C0794a8 e;
    private final Context f;

    public C0894e8(Context context) {
        this.f = context;
        B0 b0 = new B0();
        this.b = b0;
        Q7 q7 = new Q7(context, "appmetrica_vital.dat", b0);
        this.c = q7;
        F0 f0G = F0.g();
        Intrinsics.checkNotNullExpressionValue(f0G, "GlobalServiceLocator.getInstance()");
        C0895e9 c0895e9S = f0G.s();
        Intrinsics.checkNotNullExpressionValue(c0895e9S, "GlobalServiceLocator.get…ance().servicePreferences");
        this.d = new C0794a8(c0895e9S, q7);
        C1020ja c1020jaA = C1020ja.a(context);
        Intrinsics.checkNotNullExpressionValue(c1020jaA, "DatabaseStorageFactory.getInstance(context)");
        this.e = new C0794a8(new C0895e9(c1020jaA.j()), q7);
    }

    public final C0794a8 a() {
        return this.d;
    }

    public final C0794a8 b() {
        return this.e;
    }

    public final synchronized C0819b8 a(I3 i3) {
        C0819b8 c0819b8;
        try {
            String strValueOf = String.valueOf(i3.a());
            Map<String, C0819b8> map = this.a;
            c0819b8 = map.get(strValueOf);
            if (c0819b8 == null) {
                c0819b8 = new C0819b8(new C0845c9(C1020ja.a(this.f).b(i3)), new Q7(this.f, "appmetrica_vital_" + i3.a() + ".dat", this.b), strValueOf);
                map.put(strValueOf, c0819b8);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0819b8;
    }
}
