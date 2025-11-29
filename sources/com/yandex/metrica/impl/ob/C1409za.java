package com.yandex.metrica.impl.ob;

import android.content.Context;

/* renamed from: com.yandex.metrica.impl.ob.za, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1409za {
    private final C1265ta<Ud> a;
    private final C1265ta<C1306v3> b;

    public C1409za(Context context) {
        this(context, new C1289ua());
    }

    public void a(C1178pi c1178pi) {
        this.a.a(F0.g().k().a(), c1178pi.l());
        this.b.a(F0.g().d().a(), c1178pi.l());
    }

    C1409za(Context context, C1289ua c1289ua) {
        this.a = c1289ua.c(context, C0933fm.c());
        this.b = c1289ua.b(context, C0933fm.c());
    }
}
