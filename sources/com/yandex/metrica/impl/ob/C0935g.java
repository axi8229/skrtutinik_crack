package com.yandex.metrica.impl.ob;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0935g {
    public static final C0935g a = new C0935g();

    private C0935g() {
    }

    public static void a(C0935g c0935g, Map history, Map newBillingInfo, String type, InterfaceC1059l billingInfoManager, com.yandex.metrica.billing_interface.g gVar, int i) {
        com.yandex.metrica.billing_interface.g systemTimeProvider = (i & 16) != 0 ? new com.yandex.metrica.billing_interface.g() : null;
        Intrinsics.checkNotNullParameter(history, "history");
        Intrinsics.checkNotNullParameter(newBillingInfo, "newBillingInfo");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(billingInfoManager, "billingInfoManager");
        Intrinsics.checkNotNullParameter(systemTimeProvider, "systemTimeProvider");
        systemTimeProvider.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.yandex.metrica.billing_interface.a aVar : history.values()) {
            if (newBillingInfo.containsKey(aVar.b)) {
                aVar.e = jCurrentTimeMillis;
            } else {
                com.yandex.metrica.billing_interface.a aVarA = billingInfoManager.a(aVar.b);
                if (aVarA != null) {
                    aVar.e = aVarA.e;
                }
            }
        }
        billingInfoManager.a((Map<String, com.yandex.metrica.billing_interface.a>) history);
        if (billingInfoManager.a() || !Intrinsics.areEqual("inapp", type)) {
            return;
        }
        billingInfoManager.b();
    }
}
