package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2474f implements InterfaceC2468d {
    public final ru.yoomoney.sdk.kassa.payments.config.f a;

    public C2474f(ru.yoomoney.sdk.kassa.payments.config.f configRepository) {
        Intrinsics.checkNotNullParameter(configRepository, "configRepository");
        this.a = configRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2471e
            if (r0 == 0) goto L13
            r0 = r5
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.e r0 = (ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2471e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.e r0 = new ru.yoomoney.sdk.kassa.payments.paymentOptionList.e
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            r5.getValue()
            goto L44
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.yoomoney.sdk.kassa.payments.config.f r5 = r4.a
            r0.c = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.p r5 = ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2503p.a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2474f.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
