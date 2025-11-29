package com.yandex.metrica.impl.ob;

import java.util.Map;

/* renamed from: com.yandex.metrica.impl.ob.h1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0962h1 {
    private final M0 a;

    public C0962h1() {
        this(C1152oh.a());
    }

    public void a(Map<String, Object> map) {
        this.a.reportEvent("login_sdk", map);
    }

    C0962h1(M0 m0) {
        this.a = m0;
    }
}
