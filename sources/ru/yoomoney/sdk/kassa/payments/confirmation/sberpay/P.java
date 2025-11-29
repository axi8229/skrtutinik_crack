package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class P implements M {
    public final ru.yoomoney.sdk.kassa.payments.api.d a;

    public P(ru.yoomoney.sdk.kassa.payments.api.d paymentsApi) {
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        this.a = paymentsApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.N
            if (r0 == 0) goto L13
            r0 = r9
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.N r0 = (ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.N) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.N r0 = new ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.N
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r8 = r9.getValue()
            goto L45
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            ru.yoomoney.sdk.kassa.payments.api.d r9 = r7.a
            r0.c = r3
            java.lang.Object r8 = r9.c(r8, r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r9 = kotlin.Result.m2631exceptionOrNullimpl(r8)
            if (r9 != 0) goto Lb7
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDetailsResponse r8 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDetailsResponse) r8
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r9 = r8.getConfirmationData()
            boolean r9 = r9 instanceof ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SberPayConfirmationDataResponse
            if (r9 != 0) goto L60
            ru.yoomoney.sdk.kassa.payments.model.b0 r8 = new ru.yoomoney.sdk.kassa.payments.model.b0
            java.lang.ClassCastException r9 = new java.lang.ClassCastException
            r9.<init>()
            r8.<init>(r9)
            goto Lbc
        L60:
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r9 = r8.getConfirmationData()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse$SberPayConfirmationDataResponse r9 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SberPayConfirmationDataResponse) r9
            java.lang.String r9 = r9.getApiKey()
            if (r9 == 0) goto Lac
            int r9 = r9.length()
            if (r9 != 0) goto L73
            goto Lac
        L73:
            ru.yoomoney.sdk.kassa.payments.model.c0 r9 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.j0 r6 = new ru.yoomoney.sdk.kassa.payments.model.j0
            java.lang.String r1 = r8.getPaymentId()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r0 = r8.getConfirmationData()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse$SberPayConfirmationDataResponse r0 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SberPayConfirmationDataResponse) r0
            java.lang.String r2 = r0.getMerchantLogin()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r0 = r8.getConfirmationData()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse$SberPayConfirmationDataResponse r0 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SberPayConfirmationDataResponse) r0
            java.lang.String r3 = r0.getOrderId()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r0 = r8.getConfirmationData()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse$SberPayConfirmationDataResponse r0 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SberPayConfirmationDataResponse) r0
            java.lang.String r4 = r0.getOrderNumber()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse r8 = r8.getConfirmationData()
            ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse$SberPayConfirmationDataResponse r8 = (ru.yoomoney.sdk.kassa.payments.api.model.confirmationdata.ConfirmationDataResponse.SberPayConfirmationDataResponse) r8
            java.lang.String r5 = r8.getApiKey()
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r9.<init>(r6)
            r8 = r9
            goto Lbc
        Lac:
            ru.yoomoney.sdk.kassa.payments.model.b0 r8 = new ru.yoomoney.sdk.kassa.payments.model.b0
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>()
            r8.<init>(r9)
            goto Lbc
        Lb7:
            ru.yoomoney.sdk.kassa.payments.model.b0 r8 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r8.<init>(r9)
        Lbc:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.P.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.O
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.O r0 = (ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.O) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.O r0 = new ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.O
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
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.P.b(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
