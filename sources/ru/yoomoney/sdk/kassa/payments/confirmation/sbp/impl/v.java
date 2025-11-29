package ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class v implements s {
    public final n a;

    public v(r paymentDetailsGateway) {
        Intrinsics.checkNotNullParameter(paymentDetailsGateway, "paymentDetailsGateway");
        this.a = paymentDetailsGateway;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.t
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.t r0 = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.t) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.t r0 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.t
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.n r6 = r4.a
            r0.c = r3
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r r6 = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r) r6
            java.lang.Object r6 = r6.a(r5, r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            ru.yoomoney.sdk.kassa.payments.model.d0 r6 = (ru.yoomoney.sdk.kassa.payments.model.d0) r6
            boolean r5 = r6 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r5 == 0) goto L57
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.c r5 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.c
            ru.yoomoney.sdk.kassa.payments.model.c0 r6 = (ru.yoomoney.sdk.kassa.payments.model.c0) r6
            java.lang.Object r6 = r6.a
            ru.yoomoney.sdk.kassa.payments.model.f0 r6 = (ru.yoomoney.sdk.kassa.payments.model.f0) r6
            java.lang.String r0 = r6.a
            java.lang.String r6 = r6.b
            r5.<init>(r0, r6)
            goto L64
        L57:
            boolean r5 = r6 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r5 == 0) goto L65
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.b r5 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.b
            ru.yoomoney.sdk.kassa.payments.model.b0 r6 = (ru.yoomoney.sdk.kassa.payments.model.b0) r6
            java.lang.Throwable r6 = r6.a
            r5.<init>(r6)
        L64:
            return r5
        L65:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.v.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.u
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.u r0 = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.u) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.u r0 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.u
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.String r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.n r7 = r4.a
            r0.a = r6
            r0.d = r3
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r r7 = (ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.r) r7
            java.lang.Object r7 = r7.b(r5, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            ru.yoomoney.sdk.kassa.payments.model.d0 r7 = (ru.yoomoney.sdk.kassa.payments.model.d0) r7
            boolean r5 = r7 instanceof ru.yoomoney.sdk.kassa.payments.model.c0
            if (r5 == 0) goto L5d
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e r5 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.e
            ru.yoomoney.sdk.kassa.payments.model.c0 r7 = (ru.yoomoney.sdk.kassa.payments.model.c0) r7
            java.lang.Object r7 = r7.a
            ru.yoomoney.sdk.kassa.payments.model.N r7 = (ru.yoomoney.sdk.kassa.payments.model.N) r7
            java.lang.String r0 = r7.a
            ru.yoomoney.sdk.kassa.payments.model.W r1 = r7.b
            ru.yoomoney.sdk.kassa.payments.model.t0 r7 = r7.c
            r5.<init>(r6, r0, r1, r7)
            goto L6a
        L5d:
            boolean r5 = r7 instanceof ru.yoomoney.sdk.kassa.payments.model.b0
            if (r5 == 0) goto L6b
            ru.yoomoney.sdk.kassa.payments.confirmation.sbp.d r5 = new ru.yoomoney.sdk.kassa.payments.confirmation.sbp.d
            ru.yoomoney.sdk.kassa.payments.model.b0 r7 = (ru.yoomoney.sdk.kassa.payments.model.b0) r7
            java.lang.Throwable r6 = r7.a
            r5.<init>(r6)
        L6a:
            return r5
        L6b:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sbp.impl.v.a(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
