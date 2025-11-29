package com.yandex.metrica.billing.v4.library;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.yandex.metrica.impl.ob.C0985i;
import com.yandex.metrica.impl.ob.InterfaceC1009j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/yandex/metrica/billing/v4/library/BillingClientStateListenerImpl;", "Lcom/android/billingclient/api/BillingClientStateListener;", "Lcom/yandex/metrica/impl/ob/i;", "config", "Lcom/android/billingclient/api/BillingClient;", "billingClient", "Lcom/yandex/metrica/impl/ob/j;", "utilsProvider", "Lcom/yandex/metrica/billing/v4/library/b;", "billingLibraryConnectionHolder", "<init>", "(Lcom/yandex/metrica/impl/ob/i;Lcom/android/billingclient/api/BillingClient;Lcom/yandex/metrica/impl/ob/j;Lcom/yandex/metrica/billing/v4/library/b;)V", "(Lcom/yandex/metrica/impl/ob/i;Lcom/android/billingclient/api/BillingClient;Lcom/yandex/metrica/impl/ob/j;)V", "a", "Lcom/yandex/metrica/impl/ob/i;", "b", "Lcom/android/billingclient/api/BillingClient;", "c", "Lcom/yandex/metrica/impl/ob/j;", "d", "Lcom/yandex/metrica/billing/v4/library/b;", "billing-v4_publicBinaryProdRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class BillingClientStateListenerImpl implements BillingClientStateListener {

    /* renamed from: a, reason: from kotlin metadata */
    private final C0985i config;

    /* renamed from: b, reason: from kotlin metadata */
    private final BillingClient billingClient;

    /* renamed from: c, reason: from kotlin metadata */
    private final InterfaceC1009j utilsProvider;

    /* renamed from: d, reason: from kotlin metadata */
    private final b billingLibraryConnectionHolder;

    public BillingClientStateListenerImpl(C0985i config, BillingClient billingClient, InterfaceC1009j utilsProvider, b billingLibraryConnectionHolder) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(billingClient, "billingClient");
        Intrinsics.checkNotNullParameter(utilsProvider, "utilsProvider");
        Intrinsics.checkNotNullParameter(billingLibraryConnectionHolder, "billingLibraryConnectionHolder");
        this.config = config;
        this.billingClient = billingClient;
        this.utilsProvider = utilsProvider;
        this.billingLibraryConnectionHolder = billingLibraryConnectionHolder;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BillingClientStateListenerImpl(C0985i config, BillingClient billingClient, InterfaceC1009j utilsProvider) {
        this(config, billingClient, utilsProvider, new b(billingClient, null, 2));
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(billingClient, "billingClient");
        Intrinsics.checkNotNullParameter(utilsProvider, "utilsProvider");
    }
}
