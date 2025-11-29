package com.yandex.metrica.billing.v4.library;

import android.content.Context;
import com.android.billingclient.api.BillingClient;
import com.yandex.metrica.billing_interface.f;
import com.yandex.metrica.impl.ob.C0985i;
import com.yandex.metrica.impl.ob.InterfaceC1009j;
import com.yandex.metrica.impl.ob.InterfaceC1034k;
import com.yandex.metrica.impl.ob.InterfaceC1059l;
import com.yandex.metrica.impl.ob.InterfaceC1084m;
import com.yandex.metrica.impl.ob.InterfaceC1109n;
import com.yandex.metrica.impl.ob.InterfaceC1134o;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class c implements InterfaceC1034k, InterfaceC1009j {
    private C0985i a;
    private final Context b;
    private final Executor c;
    private final Executor d;
    private final InterfaceC1084m e;
    private final InterfaceC1059l f;
    private final InterfaceC1134o g;

    public static final class a extends f {
        final /* synthetic */ C0985i b;

        a(C0985i c0985i) {
            this.b = c0985i;
        }

        @Override // com.yandex.metrica.billing_interface.f
        public void a() {
            BillingClient billingClientBuild = BillingClient.newBuilder(c.this.b).setListener(new PurchasesUpdatedListenerImpl()).enablePendingPurchases().build();
            Intrinsics.checkNotNullExpressionValue(billingClientBuild, "BillingClient\n          …                 .build()");
            billingClientBuild.startConnection(new BillingClientStateListenerImpl(this.b, billingClientBuild, c.this));
        }
    }

    public c(Context context, Executor workerExecutor, Executor uiExecutor, InterfaceC1109n billingInfoStorage, InterfaceC1084m billingInfoSender, InterfaceC1059l billingInfoManager, InterfaceC1134o updatePolicy) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerExecutor, "workerExecutor");
        Intrinsics.checkNotNullParameter(uiExecutor, "uiExecutor");
        Intrinsics.checkNotNullParameter(billingInfoStorage, "billingInfoStorage");
        Intrinsics.checkNotNullParameter(billingInfoSender, "billingInfoSender");
        Intrinsics.checkNotNullParameter(billingInfoManager, "billingInfoManager");
        Intrinsics.checkNotNullParameter(updatePolicy, "updatePolicy");
        this.b = context;
        this.c = workerExecutor;
        this.d = uiExecutor;
        this.e = billingInfoSender;
        this.f = billingInfoManager;
        this.g = updatePolicy;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1034k
    public void b() {
        C0985i c0985i = this.a;
        if (c0985i != null) {
            this.d.execute(new a(c0985i));
        }
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public Executor c() {
        return this.d;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public InterfaceC1084m d() {
        return this.e;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public InterfaceC1059l e() {
        return this.f;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public InterfaceC1134o f() {
        return this.g;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1034k
    public synchronized void a(C0985i c0985i) {
        this.a = c0985i;
    }

    @Override // com.yandex.metrica.impl.ob.InterfaceC1009j
    public Executor a() {
        return this.c;
    }
}
