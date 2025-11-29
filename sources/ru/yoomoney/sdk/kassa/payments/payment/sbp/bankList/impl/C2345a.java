package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2345a implements Function2 {
    public final ru.yoomoney.sdk.kassa.payments.metrics.F a;
    public final Function2 b;

    public C2345a(ru.yoomoney.sdk.kassa.payments.metrics.F reporter, c0 businessLogic) {
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(businessLogic, "businessLogic");
        this.a = reporter;
        this.b = businessLogic;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(java.lang.Object r5, java.lang.Object r6) {
        /*
            r4 = this;
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C r5 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.C) r5
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.o r6 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.o) r6
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.n
            r1 = 0
            if (r0 == 0) goto L22
            boolean r2 = r5 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.A
            if (r2 == 0) goto L22
            java.lang.String r0 = "actionSelectPriorityBank"
        L19:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
        L1d:
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            goto L46
        L22:
            if (r0 == 0) goto L2b
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.v
            if (r0 == 0) goto L2b
            java.lang.String r0 = "actionSelectOrdinaryBank"
            goto L19
        L2b:
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.g
            if (r0 == 0) goto L32
            java.lang.String r0 = "actionShowFullList"
            goto L19
        L32:
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.j
            if (r0 == 0) goto L41
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.B
            if (r0 != 0) goto L3e
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.w
            if (r0 == 0) goto L41
        L3e:
            java.lang.String r0 = "actionSBPConfirmation"
            goto L19
        L41:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r1, r1)
            goto L1d
        L46:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L4c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L6c
            java.lang.Object r1 = r0.next()
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r2 = r1.getFirst()
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L4c
            ru.yoomoney.sdk.kassa.payments.metrics.F r3 = r4.a
            java.lang.Object r1 = r1.getSecond()
            java.util.List r1 = (java.util.List) r1
            r3.a(r2, r1)
            goto L4c
        L6c:
            kotlin.jvm.functions.Function2 r0 = r4.b
            java.lang.Object r5 = r0.invoke(r5, r6)
            ru.yoomoney.sdk.march.Out r5 = (ru.yoomoney.sdk.march.Out) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.C2345a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
