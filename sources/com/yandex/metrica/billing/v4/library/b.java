package com.yandex.metrica.billing.v4.library;

import android.os.Handler;
import android.os.Looper;
import com.android.billingclient.api.BillingClient;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class b {
    private final Set<Object> a;
    private final BillingClient b;
    private final Handler c;

    public b(BillingClient billingClient, Handler mainHandler) {
        Intrinsics.checkNotNullParameter(billingClient, "billingClient");
        Intrinsics.checkNotNullParameter(mainHandler, "mainHandler");
        this.b = billingClient;
        this.c = mainHandler;
        this.a = new LinkedHashSet();
    }

    public /* synthetic */ b(BillingClient billingClient, Handler handler, int i) {
        this(billingClient, (i & 2) != 0 ? new Handler(Looper.getMainLooper()) : null);
    }
}
