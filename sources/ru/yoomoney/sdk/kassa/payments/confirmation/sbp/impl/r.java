package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class r implements n {
    public final ru.yoomoney.sdk.kassa.payments.api.d a;

    public r(ru.yoomoney.sdk.kassa.payments.api.d paymentsApi) {
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        this.a = paymentsApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r7, kotlin.coroutines.Continuation r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.o
            if (r0 == 0) goto L13
            r0 = r8
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.o r0 = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.o) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.o r0 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.o
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result r8 = (kotlin.Result) r8
            java.lang.Object r7 = r8.getValue()
            goto L6b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L59
        L41:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getIO()
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.p r2 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.p
            r2.<init>(r7, r3)
            r0.a = r6
            r0.d = r5
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)
            if (r8 != r1) goto L58
            return r1
        L58:
            r7 = r6
        L59:
            java.lang.String r8 = (java.lang.String) r8
            ru.yoomoney.sdk.kassa.payments.api.d r7 = r7.a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r0.a = r3
            r0.d = r4
            java.lang.Object r7 = r7.c(r8, r0)
            if (r7 != r1) goto L6b
            return r1
        L6b:
            java.lang.Throwable r8 = kotlin.Result.m2631exceptionOrNullimpl(r7)
            if (r8 != 0) goto La0
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDetailsResponse r7 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDetailsResponse) r7
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r8 = r7.getConfirmationData()
            boolean r8 = r8 instanceof ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SbpConfirmationDataResponse
            if (r8 != 0) goto L86
            ru.yoomoney.sdk.kassa.payments.model.b0 r7 = new ru.yoomoney.sdk.kassa.payments.model.b0
            java.lang.ClassCastException r8 = new java.lang.ClassCastException
            r8.<init>()
            r7.<init>(r8)
            goto La5
        L86:
            ru.yoomoney.sdk.kassa.payments.model.c0 r8 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.f0 r0 = new ru.yoomoney.sdk.kassa.payments.model.f0
            java.lang.String r1 = r7.getPaymentId()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r7 = r7.getConfirmationData()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse$SbpConfirmationDataResponse r7 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SbpConfirmationDataResponse) r7
            java.lang.String r7 = r7.getUrl()
            r0.<init>(r1, r7)
            r8.<init>(r0)
            r7 = r8
            goto La5
        La0:
            ru.yoomoney.sdk.kassa.payments.model.b0 r7 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r7.<init>(r8)
        La5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.q
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.q r0 = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.q) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.q r0 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.q
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
            ru.yoomoney.sdk.kassa.payments.api.d r6 = r4.a
            r0.c = r3
            java.lang.Object r5 = r6.a(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L57
            ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.PaymentDetailsResponse r5 = (ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.PaymentDetailsResponse) r5
            ru.yoomoney.sdk.kassa.payments.model.c0 r6 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.N r5 = ru.yoomoney.sdk.kassa.payments.model.mapper.j.a(r5)
            r6.<init>(r5)
            goto L5d
        L57:
            ru.yoomoney.sdk.kassa.payments.model.b0 r5 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r5.<init>(r6)
            r6 = r5
        L5d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
