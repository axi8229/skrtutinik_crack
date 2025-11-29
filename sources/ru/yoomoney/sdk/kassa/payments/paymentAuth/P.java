package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class P implements Function2 {
    public final ru.yoomoney.sdk.kassa.payments.metrics.F a;
    public final Function2 b;

    public P(ru.yoomoney.sdk.kassa.payments.metrics.F reporter, H0 businessLogic) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        this.a = reporter;
        this.b = businessLogic;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            ru.yoomoney.sdk.kassa.payments.paymentAuth.O r4 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.O) r4
            ru.yoomoney.sdk.kassa.payments.paymentAuth.E r5 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.E) r5
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            ru.yoomoney.sdk.kassa.payments.paymentAuth.y r0 = ru.yoomoney.sdk.kassa.payments.paymentAuth.C2455y.a
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r0)
            java.lang.String r1 = "actionPaymentAuthorization"
            if (r0 == 0) goto L26
            ru.yoomoney.sdk.kassa.payments.metrics.j r0 = new ru.yoomoney.sdk.kassa.payments.metrics.j
            r0.<init>()
        L1d:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r0)
            goto L3f
        L26:
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.A
            if (r0 == 0) goto L30
            ru.yoomoney.sdk.kassa.payments.metrics.i r0 = new ru.yoomoney.sdk.kassa.payments.metrics.i
            r0.<init>()
            goto L1d
        L30:
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2447u
            if (r0 == 0) goto L3a
            ru.yoomoney.sdk.kassa.payments.metrics.i r0 = new ru.yoomoney.sdk.kassa.payments.metrics.i
            r0.<init>()
            goto L1d
        L3a:
            r0 = 0
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r0)
        L3f:
            java.lang.Object r1 = r0.component1()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.component2()
            java.util.List r0 = (java.util.List) r0
            if (r1 == 0) goto L52
            ru.yoomoney.sdk.kassa.payments.metrics.F r2 = r3.a
            r2.a(r1, r0)
        L52:
            kotlin.jvm.functions.Function2 r0 = r3.b
            java.lang.Object r4 = r0.invoke(r4, r5)
            ru.yoomoney.sdk.march.Out r4 = (ru.yoomoney.sdk.march.Out) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.P.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
