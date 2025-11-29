package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class p0 implements k0 {
    public final ru.yoomoney.sdk.kassa.payments.api.f a;
    public final ru.yoomoney.sdk.kassa.payments.api.d b;

    public p0(ru.yoomoney.sdk.kassa.payments.api.f sbpApi, ru.yoomoney.sdk.kassa.payments.api.d paymentsApi) {
        Intrinsics.checkNotNullParameter(sbpApi, "sbpApi");
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        this.a = sbpApi;
        this.b = paymentsApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.l0
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.l0 r0 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.l0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.l0 r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.l0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.kassa.payments.api.d r6 = r4.b
            r0.c = r3
            java.lang.Object r5 = r6.a(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L56
            ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.PaymentDetailsResponse r5 = (ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.PaymentDetailsResponse) r5
            ru.yoomoney.sdk.kassa.payments.model.N r5 = ru.yoomoney.sdk.kassa.payments.model.mapper.j.a(r5)
        L51:
            java.lang.Object r5 = kotlin.Result.m2628constructorimpl(r5)
            goto L5b
        L56:
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r6)
            goto L51
        L5b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.o0
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.o0 r0 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.o0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.o0 r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.o0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r6 = r7.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.kassa.payments.api.f r7 = r5.a
            r0.c = r3
            java.lang.Object r6 = r7.a(r6, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r7 = kotlin.Result.m2631exceptionOrNullimpl(r6)
            if (r7 != 0) goto L91
            ru.yoomoney.sdk.kassa.payments.api.model.sbp.SbpBanksResponse r6 = (ru.yoomoney.sdk.kassa.payments.api.model.sbp.SbpBanksResponse) r6
            java.util.List r6 = r6.getBanks()
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r0)
            r7.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
        L67:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L8c
            java.lang.Object r0 = r6.next()
            ru.yoomoney.sdk.kassa.payments.api.model.sbp.SbpBankInfo r0 = (ru.yoomoney.sdk.kassa.payments.api.model.sbp.SbpBankInfo) r0
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a r1 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model.a
            java.lang.String r2 = r0.getMemberId()
            java.lang.String r3 = r0.getNameRus()
            java.lang.String r4 = r0.getNameEng()
            java.lang.String r0 = r0.getDeeplink()
            r1.<init>(r2, r3, r4, r0)
            r7.add(r1)
            goto L67
        L8c:
            java.lang.Object r6 = kotlin.Result.m2628constructorimpl(r7)
            goto L99
        L91:
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r6 = kotlin.Result.m2628constructorimpl(r6)
        L99:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(android.content.Context r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.m0
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.m0 r0 = (ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.m0) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.m0 r0 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.m0
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.n0 r2 = new ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.n0
            r4 = 0
            r2.<init>(r6, r4)
            r0.c = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r6 = r7.getValue()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl.p0.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
