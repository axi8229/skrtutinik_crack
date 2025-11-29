package com.yandex.metrica.impl.ob;

/* renamed from: com.yandex.metrica.impl.ob.xd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C1364xd implements InterfaceC1340wd {
    private final boolean a;

    C1364xd(boolean z) {
        this.a = z;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1340wd
    public boolean a(String str) {
        if ("android.permission.ACCESS_FINE_LOCATION".equals(str) || "android.permission.ACCESS_COARSE_LOCATION".equals(str)) {
            return this.a;
        }
        return true;
    }

    public String toString() {
        return "LocationFlagStrategy{mEnabled=" + this.a + '}';
    }
}
