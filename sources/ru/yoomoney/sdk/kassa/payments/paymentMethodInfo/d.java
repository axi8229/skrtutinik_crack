package ru.yoomoney.sdk.kassa.payments.paymentMethodInfo;

/* loaded from: classes5.dex */
public final class d implements ru.yoomoney.sdk.kassa.payments.payment.loadPaymentInfo.a {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.loadPaymentInfo.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r11, kotlin.coroutines.Continuation r12) {
        /*
            r10 = this;
            boolean r11 = r12 instanceof ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.c
            if (r11 == 0) goto L13
            r11 = r12
            ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.c r11 = (ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.c) r11
            int r0 = r11.c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r11.c = r0
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.c r11 = new ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.c
            r11.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r11.a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.ResultKt.throwOnFailure(r12)
            goto L3f
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.throwOnFailure(r12)
            r11.c = r2
            r1 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r1, r11)
            if (r11 != r0) goto L3f
            return r0
        L3f:
            ru.yoomoney.sdk.kassa.payments.model.c0 r11 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.S r12 = new ru.yoomoney.sdk.kassa.payments.model.S
            ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType r1 = ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType.BANK_CARD
            ru.yoomoney.sdk.kassa.payments.model.r r9 = new ru.yoomoney.sdk.kassa.payments.model.r
            ru.yoomoney.sdk.kassa.payments.model.q r7 = ru.yoomoney.sdk.kassa.payments.model.EnumC2333q.a
            ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType r8 = ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType.GOOGLE_PAY
            java.lang.String r5 = "2020"
            java.lang.String r6 = "12"
            java.lang.String r3 = "123456"
            java.lang.String r4 = "1234"
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r4 = 1
            java.lang.String r5 = "11234567887654321"
            java.lang.String r2 = "11234567887654321"
            r3 = 1
            r0 = r12
            r6 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r11.<init>(r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.d.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
