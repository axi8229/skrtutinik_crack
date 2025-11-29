package com.yandex.metrica.impl.ob;

import android.app.Activity;
import android.os.Bundle;

/* loaded from: classes3.dex */
class Vk {
    private final Ok a;
    private final Yk b;

    Vk(Ok ok, Yk yk) {
        this.a = ok;
        this.b = yk;
    }

    boolean a(Activity activity, C1348wl c1348wl) {
        Bundle bundleA = this.a.a(activity);
        return this.b.a(bundleA == null ? null : bundleA.getString("yandex:ads:context"), c1348wl);
    }
}
