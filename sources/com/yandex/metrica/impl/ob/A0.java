package com.yandex.metrica.impl.ob;

import android.content.Context;

/* loaded from: classes3.dex */
public class A0 {
    private final C1281u2 a;
    private final F b;

    public A0(Context context) {
        this(new C1281u2(context, "com.yandex.android.appmetrica.build_id"), new F(context, "com.yandex.android.appmetrica.is_offline"));
    }

    public String a() {
        return this.a.a();
    }

    public Boolean b() {
        return this.b.a();
    }

    A0(C1281u2 c1281u2, F f) {
        this.a = c1281u2;
        this.b = f;
    }
}
