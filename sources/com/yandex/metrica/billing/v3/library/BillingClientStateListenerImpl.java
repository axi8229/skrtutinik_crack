package com.yandex.metrica.billing.v3.library;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.yandex.metrica.impl.ob.C0985i;
import com.yandex.metrica.impl.ob.InterfaceC1009j;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
class BillingClientStateListenerImpl implements BillingClientStateListener {
    private final C0985i a;
    private final Executor b;
    private final Executor c;
    private final BillingClient d;
    private final InterfaceC1009j e;
    private final b f;

    BillingClientStateListenerImpl(C0985i c0985i, Executor executor, Executor executor2, BillingClient billingClient, InterfaceC1009j interfaceC1009j, b bVar) {
        this.a = c0985i;
        this.b = executor;
        this.c = executor2;
        this.d = billingClient;
        this.e = interfaceC1009j;
        this.f = bVar;
    }
}
