package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

/* loaded from: classes5.dex */
public final class h implements o {
    public final boolean a;

    public h(boolean z) {
        this.a = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r4, ru.yoomoney.sdk.kassa.payments.model.T r5, ru.yoomoney.sdk.kassa.payments.model.U r6, boolean r7, boolean r8, ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t r9, kotlin.coroutines.Continuation r10) {
        /*
            r3 = this;
            boolean r4 = r10 instanceof ru.yoomoney.sdk.kassa.payments.payment.tokenize.e
            if (r4 == 0) goto L13
            r4 = r10
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.e r4 = (ru.yoomoney.sdk.kassa.payments.payment.tokenize.e) r4
            int r0 = r4.i
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.i = r0
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.e r4 = new ru.yoomoney.sdk.kassa.payments.payment.tokenize.e
            r4.<init>(r3, r10)
        L18:
            java.lang.Object r10 = r4.g
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.i
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            boolean r8 = r4.f
            boolean r7 = r4.e
            ru.yoomoney.sdk.kassa.payments.model.t r9 = r4.d
            ru.yoomoney.sdk.kassa.payments.model.U r6 = r4.c
            ru.yoomoney.sdk.kassa.payments.model.T r5 = r4.b
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.h r4 = r4.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L58
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.ResultKt.throwOnFailure(r10)
            r4.a = r3
            r4.b = r5
            r4.c = r6
            r4.d = r9
            r4.e = r7
            r4.f = r8
            r4.i = r2
            r1 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r1, r4)
            if (r4 != r0) goto L57
            return r0
        L57:
            r4 = r3
        L58:
            boolean r4 = r4.a
            if (r4 == 0) goto L68
            ru.yoomoney.sdk.kassa.payments.model.b0 r4 = new ru.yoomoney.sdk.kassa.payments.model.b0
            ru.yoomoney.sdk.kassa.payments.model.o0 r5 = new ru.yoomoney.sdk.kassa.payments.model.o0
            r6 = 0
            r5.<init>(r6)
            r4.<init>(r5)
            goto L9e
        L68:
            ru.yoomoney.sdk.kassa.payments.model.c0 r4 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.X r10 = new ru.yoomoney.sdk.kassa.payments.model.X
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "THIS IS A TEST TOKEN. \nTo get production token, remove mockConfiguration from your TestParameters object, that is used in Checkout.createTokenizeIntent()). \n\nParameters: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = ", "
            r0.append(r5)
            r0.append(r6)
            r0.append(r5)
            r0.append(r7)
            r0.append(r5)
            r0.append(r8)
            r0.append(r5)
            r0.append(r9)
            java.lang.String r5 = r0.toString()
            r6 = 0
            r10.<init>(r5, r6)
            r4.<init>(r10)
        L9e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.tokenize.h.a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, ru.yoomoney.sdk.kassa.payments.model.T, ru.yoomoney.sdk.kassa.payments.model.U, boolean, boolean, ru.yoomoney.sdk.kassa.payments.model.t, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r3, ru.yoomoney.sdk.kassa.payments.model.T r4, boolean r5, ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r2 = this;
            boolean r4 = r9 instanceof ru.yoomoney.sdk.kassa.payments.payment.tokenize.g
            if (r4 == 0) goto L13
            r4 = r9
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.g r4 = (ru.yoomoney.sdk.kassa.payments.payment.tokenize.g) r4
            int r7 = r4.h
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r7 & r0
            if (r1 == 0) goto L13
            int r7 = r7 - r0
            r4.h = r7
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.g r4 = new ru.yoomoney.sdk.kassa.payments.payment.tokenize.g
            r4.<init>(r2, r9)
        L18:
            java.lang.Object r7 = r4.f
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.h
            r1 = 1
            if (r0 == 0) goto L3b
            if (r0 != r1) goto L33
            boolean r5 = r4.e
            java.lang.String r8 = r4.d
            ru.yoomoney.sdk.kassa.payments.model.t r6 = r4.c
            ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r3 = r4.b
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.h r4 = r4.a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L54
        L33:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L3b:
            kotlin.ResultKt.throwOnFailure(r7)
            r4.a = r2
            r4.b = r3
            r4.c = r6
            r4.d = r8
            r4.e = r5
            r4.h = r1
            r0 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r0, r4)
            if (r4 != r9) goto L53
            return r9
        L53:
            r4 = r2
        L54:
            boolean r4 = r4.a
            if (r4 == 0) goto L64
            ru.yoomoney.sdk.kassa.payments.model.b0 r3 = new ru.yoomoney.sdk.kassa.payments.model.b0
            ru.yoomoney.sdk.kassa.payments.model.o0 r4 = new ru.yoomoney.sdk.kassa.payments.model.o0
            r5 = 0
            r4.<init>(r5)
            r3.<init>(r4)
            goto L95
        L64:
            ru.yoomoney.sdk.kassa.payments.model.c0 r4 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.X r7 = new ru.yoomoney.sdk.kassa.payments.model.X
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "THIS IS A TEST TOKEN. \nTo get production token, remove mockConfiguration from your TestParameters object, that is used in Checkout.createTokenizeIntent()). \n\nParameters: "
            r9.append(r0)
            r9.append(r3)
            java.lang.String r3 = ", "
            r9.append(r3)
            r9.append(r5)
            r9.append(r3)
            r9.append(r8)
            r9.append(r3)
            r9.append(r6)
            java.lang.String r3 = r9.toString()
            r5 = 0
            r7.<init>(r3, r5)
            r4.<init>(r7)
            r3 = r4
        L95:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.tokenize.h.a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, ru.yoomoney.sdk.kassa.payments.model.T, boolean, ru.yoomoney.sdk.kassa.payments.model.t, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.tokenize.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.model.T r4, ru.yoomoney.sdk.kassa.payments.model.Q r5, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r6, boolean r7, java.lang.String r8, ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t r9, kotlin.coroutines.Continuation r10) {
        /*
            r3 = this;
            boolean r4 = r10 instanceof ru.yoomoney.sdk.kassa.payments.payment.tokenize.f
            if (r4 == 0) goto L13
            r4 = r10
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.f r4 = (ru.yoomoney.sdk.kassa.payments.payment.tokenize.f) r4
            int r0 = r4.i
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.i = r0
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.f r4 = new ru.yoomoney.sdk.kassa.payments.payment.tokenize.f
            r4.<init>(r3, r10)
        L18:
            java.lang.Object r10 = r4.g
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.i
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            boolean r7 = r4.f
            ru.yoomoney.sdk.kassa.payments.model.t r9 = r4.e
            java.lang.String r8 = r4.d
            ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r6 = r4.c
            ru.yoomoney.sdk.kassa.payments.model.Q r5 = r4.b
            ru.yoomoney.sdk.kassa.payments.payment.tokenize.h r4 = r4.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L58
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.ResultKt.throwOnFailure(r10)
            r4.a = r3
            r4.b = r5
            r4.c = r6
            r4.d = r8
            r4.e = r9
            r4.f = r7
            r4.i = r2
            r1 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r1, r4)
            if (r4 != r0) goto L57
            return r0
        L57:
            r4 = r3
        L58:
            boolean r4 = r4.a
            if (r4 == 0) goto L68
            ru.yoomoney.sdk.kassa.payments.model.b0 r4 = new ru.yoomoney.sdk.kassa.payments.model.b0
            ru.yoomoney.sdk.kassa.payments.model.o0 r5 = new ru.yoomoney.sdk.kassa.payments.model.o0
            r6 = 0
            r5.<init>(r6)
            r4.<init>(r5)
            goto L9e
        L68:
            ru.yoomoney.sdk.kassa.payments.model.c0 r4 = new ru.yoomoney.sdk.kassa.payments.model.c0
            ru.yoomoney.sdk.kassa.payments.model.X r10 = new ru.yoomoney.sdk.kassa.payments.model.X
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "THIS IS A TEST TOKEN. \nTo get production token, remove mockConfiguration from your TestParameters object, that is used in Checkout.createTokenizeIntent()). \n\nParameters: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = ", "
            r0.append(r5)
            r0.append(r6)
            r0.append(r5)
            r0.append(r7)
            r0.append(r5)
            r0.append(r8)
            r0.append(r5)
            r0.append(r9)
            java.lang.String r5 = r0.toString()
            r6 = 0
            r10.<init>(r5, r6)
            r4.<init>(r10)
        L9e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.payment.tokenize.h.a(ru.yoomoney.sdk.kassa.payments.model.T, ru.yoomoney.sdk.kassa.payments.model.Q, ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, boolean, java.lang.String, ru.yoomoney.sdk.kassa.payments.model.t, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
