package com.yandex.metrica.billing.v3.library;

import android.os.Handler;
import android.os.Looper;
import com.android.billingclient.api.BillingClient;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
class b {
    private final Handler a;
    private final BillingClient b;
    private final Set<Object> c;

    b(BillingClient billingClient) {
        this(billingClient, new Handler(Looper.getMainLooper()));
    }

    b(BillingClient billingClient, Handler handler) {
        this.b = billingClient;
        this.c = new HashSet();
        this.a = handler;
    }
}
