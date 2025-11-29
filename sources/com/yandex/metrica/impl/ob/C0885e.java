package com.yandex.metrica.impl.ob;

import com.android.billingclient.api.SkuDetails;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.yandex.metrica.impl.ob.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0885e {
    public static final C0885e a = new C0885e();

    private C0885e() {
    }

    private final int b(SkuDetails skuDetails) {
        String freeTrialPeriod = skuDetails.getFreeTrialPeriod();
        Intrinsics.checkNotNullExpressionValue(freeTrialPeriod, "skuDetails.freeTrialPeriod");
        if (freeTrialPeriod.length() == 0) {
            return skuDetails.getIntroductoryPriceCycles();
        }
        return 1;
    }

    private final com.yandex.metrica.billing_interface.c c(SkuDetails skuDetails) {
        String freeTrialPeriod = skuDetails.getFreeTrialPeriod();
        Intrinsics.checkNotNullExpressionValue(freeTrialPeriod, "skuDetails.freeTrialPeriod");
        return freeTrialPeriod.length() == 0 ? com.yandex.metrica.billing_interface.c.a(skuDetails.getIntroductoryPricePeriod()) : com.yandex.metrica.billing_interface.c.a(skuDetails.getFreeTrialPeriod());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.yandex.metrica.billing_interface.d a(com.android.billingclient.api.PurchaseHistoryRecord r22, com.android.billingclient.api.SkuDetails r23, com.android.billingclient.api.Purchase r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            java.lang.String r2 = "purchasesHistoryRecord"
            r3 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "skuDetails"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.yandex.metrica.billing_interface.d r2 = new com.yandex.metrica.billing_interface.d
            java.lang.String r4 = r23.getType()
            java.lang.String r5 = "skuDetails.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r5 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            int r5 = r4.hashCode()
            r6 = 3541555(0x360a33, float:4.962776E-39)
            if (r5 == r6) goto L3a
            r6 = 100343516(0x5fb1edc, float:2.3615263E-35)
            if (r5 == r6) goto L2f
            goto L45
        L2f:
            java.lang.String r5 = "inapp"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L45
            com.yandex.metrica.billing_interface.e r4 = com.yandex.metrica.billing_interface.e.INAPP
            goto L47
        L3a:
            java.lang.String r5 = "subs"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L45
            com.yandex.metrica.billing_interface.e r4 = com.yandex.metrica.billing_interface.e.SUBS
            goto L47
        L45:
            com.yandex.metrica.billing_interface.e r4 = com.yandex.metrica.billing_interface.e.UNKNOWN
        L47:
            java.lang.String r5 = r23.getSku()
            int r6 = r22.getQuantity()
            long r7 = r23.getPriceAmountMicros()
            java.lang.String r9 = r23.getPriceCurrencyCode()
            long r10 = r0.a(r1)
            com.yandex.metrica.billing_interface.c r12 = r0.c(r1)
            int r13 = r0.b(r1)
            java.lang.String r1 = r23.getSubscriptionPeriod()
            com.yandex.metrica.billing_interface.c r14 = com.yandex.metrica.billing_interface.c.a(r1)
            java.lang.String r15 = r22.getSignature()
            java.lang.String r16 = r22.getPurchaseToken()
            long r17 = r22.getPurchaseTime()
            if (r24 == 0) goto L80
            boolean r1 = r24.isAutoRenewing()
        L7d:
            r19 = r1
            goto L82
        L80:
            r1 = 0
            goto L7d
        L82:
            if (r24 == 0) goto L8d
            java.lang.String r1 = r24.getOriginalJson()
            if (r1 == 0) goto L8d
        L8a:
            r20 = r1
            goto L90
        L8d:
            java.lang.String r1 = "{}"
            goto L8a
        L90:
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r9, r10, r12, r13, r14, r15, r16, r17, r19, r20)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.C0885e.a(com.android.billingclient.api.PurchaseHistoryRecord, com.android.billingclient.api.SkuDetails, com.android.billingclient.api.Purchase):com.yandex.metrica.billing_interface.d");
    }

    private final long a(SkuDetails skuDetails) {
        String freeTrialPeriod = skuDetails.getFreeTrialPeriod();
        Intrinsics.checkNotNullExpressionValue(freeTrialPeriod, "skuDetails.freeTrialPeriod");
        if (freeTrialPeriod.length() == 0) {
            return skuDetails.getIntroductoryPriceAmountMicros();
        }
        return 0L;
    }
}
