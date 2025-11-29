package com.yandex.metrica.billing.v3.library;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import com.yandex.metrica.billing_interface.f;
import com.yandex.metrica.impl.ob.C0985i;
import com.yandex.metrica.impl.ob.InterfaceC1009j;
import com.yandex.metrica.impl.ob.InterfaceC1034k;
import com.yandex.metrica.impl.ob.InterfaceC1059l;
import com.yandex.metrica.impl.ob.InterfaceC1084m;
import com.yandex.metrica.impl.ob.InterfaceC1134o;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class c implements InterfaceC1034k, InterfaceC1009j {
    private final Context a;
    private final Executor b;
    private final Executor c;
    private final InterfaceC1059l d;
    private final InterfaceC1134o e;
    private final InterfaceC1084m f;
    private C0985i g;

    class a extends f {
        final /* synthetic */ C0985i a;

        a(C0985i c0985i) {
            this.a = c0985i;
        }

        @Override // com.yandex.metrica.billing_interface.f
        public void a() {
            BillingClient billingClientBuild = BillingClient.newBuilder(c.this.a).setListener(new PurchasesUpdatedListenerImpl()).enablePendingPurchases().build();
            billingClientBuild.startConnection(new BillingClientStateListenerImpl(this.a, c.this.b, c.this.c, billingClientBuild, c.this, new b(billingClientBuild)));
        }
    }

    public c(Context context, Executor executor, Executor executor2, InterfaceC1059l interfaceC1059l, InterfaceC1134o interfaceC1134o, InterfaceC1084m interfaceC1084m) {
        this.a = context;
        this.b = executor;
        this.c = executor2;
        this.d = interfaceC1059l;
        this.e = interfaceC1134o;
        this.f = interfaceC1084m;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public InterfaceC1084m d() {
        return this.f;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public InterfaceC1059l e() {
        return this.d;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public InterfaceC1134o f() {
        return this.e;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1034k
    public synchronized void a(C0985i c0985i) {
        this.g = c0985i;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1034k
    public void b() throws Throwable {
        C0985i c0985i = this.g;
        if (c0985i != null) {
            this.c.execute(new a(c0985i));
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public Executor c() {
        return this.c;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public Executor a() {
        return this.b;
    }
}
