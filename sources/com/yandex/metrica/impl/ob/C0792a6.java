package com.yandex.metrica.impl.ob;

import okhttp3.internal.connection.RealConnection;

/* renamed from: com.yandex.metrica.impl.ob.a6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0792a6 {
    private final C0819b8 a;

    public C0792a6(C0819b8 c0819b8) {
        this.a = c0819b8;
    }

    public long a() {
        long jH = this.a.h();
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (jH >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + jH;
        }
        this.a.a(j);
        return j;
    }
}
