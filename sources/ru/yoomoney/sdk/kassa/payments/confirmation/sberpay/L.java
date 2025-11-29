package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class L implements I {
    public final M a;

    public L(M sberPayRepository) {
        Intrinsics.checkNotNullParameter(sberPayRepository, "sberPayRepository");
        this.a = sberPayRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Throwable r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.J
            if (r0 == 0) goto L13
            r0 = r11
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.J r0 = (ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.J) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.J r0 = new ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.J
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7d
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            java.lang.String r10 = r0.c
            java.lang.String r9 = r0.b
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.L r8 = r0.a
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6d
        L3e:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r8 instanceof ru.yoomoney.sdk.kassa.payments.model.C2319c
            if (r11 == 0) goto L86
            r11 = r8
            ru.yoomoney.sdk.kassa.payments.model.c r11 = (ru.yoomoney.sdk.kassa.payments.model.C2319c) r11
            ru.yoomoney.sdk.kassa.payments.model.v r2 = r11.a()
            java.lang.Integer r2 = r2.e
            if (r2 == 0) goto L86
            ru.yoomoney.sdk.kassa.payments.model.v r8 = r11.a()
            java.lang.Integer r8 = r8.e
            if (r8 == 0) goto L7e
            int r8 = r8.intValue()
            long r5 = (long) r8
            r0.a = r7
            r0.b = r9
            r0.c = r10
            r0.f = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r8 != r1) goto L6c
            return r1
        L6c:
            r8 = r7
        L6d:
            r11 = 0
            r0.a = r11
            r0.b = r11
            r0.c = r11
            r0.f = r3
            java.lang.Object r11 = r8.a(r9, r10, r0)
            if (r11 != r1) goto L7d
            return r1
        L7d:
            return r11
        L7e:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Required value was null."
            r8.<init>(r9)
            throw r8
        L86:
            ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.m r9 = new ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.m
            r9.<init>(r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.L.a(java.lang.Throwable, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.L.a(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
