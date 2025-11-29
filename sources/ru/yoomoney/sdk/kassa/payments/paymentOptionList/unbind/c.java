package ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c implements a {
    public final ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a a;
    public final ru.yoomoney.sdk.kassa.payments.payment.c b;

    public c(ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a unbindCardGateway, ru.yoomoney.sdk.kassa.payments.payment.c getLoadedPaymentOptionListRepository) {
        Intrinsics.checkNotNullParameter(unbindCardGateway, "unbindCardGateway");
        Intrinsics.checkNotNullParameter(getLoadedPaymentOptionListRepository, "getLoadedPaymentOptionListRepository");
        this.a = unbindCardGateway;
        this.b = getLoadedPaymentOptionListRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.b
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.b r0 = (ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.b r0 = new ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.b
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.c r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.kassa.payments.payment.unbindCard.a r6 = r4.a
            r0.a = r4
            r0.d = r3
            java.lang.Object r6 = r6.a(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            ru.yoomoney.sdk.kassa.payments.model.d0 r6 = (ru.yoomoney.sdk.kassa.payments.model.d0) r6
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r0 == 0) goto L54
            ru.yoomoney.sdk.kassa.payments.payment.c r5 = r5.b
            r6 = 0
            ru.yoomoney.sdk.kassa.payments.payment.d r5 = (ru.yoomoney.sdk.kassa.payments.payment.d) r5
            r5.a = r6
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.B r5 = ru.yoomoney.sdk.kassa.payments.paymentOptionList.B.a
            goto L5a
        L54:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r5 == 0) goto L5b
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.A r5 = ru.yoomoney.sdk.kassa.payments.paymentOptionList.A.a
        L5a:
            return r5
        L5b:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentOptionList.unbind.c.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
