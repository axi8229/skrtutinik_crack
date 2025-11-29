package ru.yoomoney.sdk.kassa.payments.paymentAuth;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2445t implements D1 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.D1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u r5, java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.r
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.kassa.payments.paymentAuth.r r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.r) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.r r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.r
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.String r6 = r0.b
            ru.yoomoney.sdk.kassa.payments.model.u r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.a = r5
            r0.b = r6
            r0.e = r3
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            java.lang.String r7 = "fail"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r7 == 0) goto L6b
            ru.yoomoney.sdk.kassa.payments.model.c0 r5 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.paymentAuth.B1 r6 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.B1
            ru.yoomoney.sdk.kassa.payments.model.j r7 = new ru.yoomoney.sdk.kassa.payments.model.j
            r0 = 3
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            r2 = 60
            r3 = 4
            r7.<init>(r2, r3, r1, r0)
            r6.<init>(r7)
            r5.<init>(r6)
            goto L9a
        L6b:
            java.lang.String r7 = "tech"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r7 == 0) goto L80
            ru.yoomoney.sdk.kassa.payments.model.b0 r5 = new ru.yoomoney.sdk.kassa.payments.model.b0
            ru.yoomoney.sdk.kassa.payments.model.c r6 = new ru.yoomoney.sdk.kassa.payments.model.c
            ru.yoomoney.sdk.kassa.payments.model.w r7 = ru.yoomoney.sdk.kassa.payments.model.EnumC2338w.a
            r6.<init>()
            r5.<init>(r6)
            goto L9a
        L80:
            ru.yoomoney.sdk.kassa.payments.model.c0 r7 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.paymentAuth.q1 r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.q1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r6)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            r7.<init>(r0)
            r5 = r7
        L9a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2445t.a(ru.yoomoney.sdk.kassa.payments.model.u, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.D1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.yoomoney.sdk.kassa.payments.paymentAuth.C2443s
            if (r0 == 0) goto L13
            r0 = r6
            ru.yoomoney.sdk.kassa.payments.paymentAuth.s r0 = (ru.yoomoney.sdk.kassa.payments.paymentAuth.C2443s) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentAuth.s r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.s
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            ru.yoomoney.sdk.kassa.payments.model.u r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.a = r5
            r0.d = r3
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            ru.yoomoney.sdk.kassa.payments.model.c0 r6 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.paymentAuth.q1 r0 = new ru.yoomoney.sdk.kassa.payments.paymentAuth.q1
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            r6.<init>(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.C2445t.a(ru.yoomoney.sdk.kassa.payments.model.u, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
