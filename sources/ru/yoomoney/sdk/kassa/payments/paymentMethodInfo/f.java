package ru.yoomoney.sdk.kassa.payments.paymentMethodInfo;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f implements ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a {
    public final ru.yoomoney.sdk.kassa.payments.api.d a;

    public f(ru.yoomoney.sdk.kassa.payments.api.d paymentsApi) {
        Intrinsics.checkNotNullParameter(paymentsApi, "paymentsApi");
        this.a = paymentsApi;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.e
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.e r0 = (ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.e r0 = new ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.e
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
            java.lang.Object r5 = r6.d(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            java.lang.Throwable r6 = kotlin.Result.m2631exceptionOrNullimpl(r5)
            if (r6 != 0) goto L55
            kotlin.Unit r5 = (kotlin.Unit) r5
            ru.yoomoney.sdk.kassa.payments.model.c0 r5 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.r0 r6 = ru.yoomoney.sdk.kassa.payments.model.r0.a
            r5.<init>(r6)
            goto L5a
        L55:
            ru.yoomoney.sdk.kassa.payments.model.b0 r5 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r5.<init>(r6)
        L5a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentMethodInfo.f.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
