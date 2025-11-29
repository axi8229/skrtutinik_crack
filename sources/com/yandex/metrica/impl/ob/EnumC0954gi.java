package com.yandex.metrica.impl.ob;

import android.os.Bundle;

/* renamed from: com.yandex.metrica.impl.ob.gi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC0954gi {
    UNKNOWN(0),
    NETWORK(1),
    PARSE(2);

    private int a;

    EnumC0954gi(int i) {
        this.a = i;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt("startup_error_key_code", this.a);
        return bundle;
    }
}
