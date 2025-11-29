package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentOptionList.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2480h implements ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b {
    public final Context a;
    public final ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b b;
    public final ru.yoomoney.sdk.kassa.payments.metrics.r c;

    public C2480h(Context context, C2465c paymentOptionListRepository, ru.yoomoney.sdk.kassa.payments.metrics.r errorReporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paymentOptionListRepository, "paymentOptionListRepository");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        this.a = context;
        this.b = paymentOptionListRepository;
        this.c = errorReporter;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount r5, ru.yoomoney.sdk.kassa.payments.model.AbstractC2336u r6, kotlin.coroutines.Continuation r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2477g
            if (r0 == 0) goto L13
            r0 = r7
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.g r0 = (ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2477g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.g r0 = new ru.yoomoney.sdk.kassa.payments.paymentOptionList.g
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            ru.yoomoney.sdk.kassa.payments.paymentOptionList.h r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2b
            goto L72
        L2b:
            r6 = move-exception
            goto L7b
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            android.content.Context r7 = r4.a     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "connectivity"
            java.lang.Object r7 = r7.getSystemService(r2)     // Catch: java.lang.Throwable -> L58
            android.net.ConnectivityManager r7 = (android.net.ConnectivityManager) r7     // Catch: java.lang.Throwable -> L58
            if (r7 == 0) goto L5b
            android.net.NetworkInfo r7 = r7.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L58
            if (r7 == 0) goto L5b
            boolean r7 = r7.isConnectedOrConnecting()     // Catch: java.lang.Throwable -> L58
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Throwable -> L58
            goto L5c
        L58:
            r6 = move-exception
            r5 = r4
            goto L7b
        L5b:
            r7 = 0
        L5c:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L58
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)     // Catch: java.lang.Throwable -> L58
            if (r7 == 0) goto L75
            ru.yoomoney.sdk.kassa.payments.payment.loadOptionList.b r7 = r4.b     // Catch: java.lang.Throwable -> L58
            r0.a = r4     // Catch: java.lang.Throwable -> L58
            r0.d = r3     // Catch: java.lang.Throwable -> L58
            java.lang.Object r7 = r7.a(r5, r6, r0)     // Catch: java.lang.Throwable -> L58
            if (r7 != r1) goto L71
            return r1
        L71:
            r5 = r4
        L72:
            ru.yoomoney.sdk.kassa.payments.model.d0 r7 = (ru.yoomoney.sdk.kassa.payments.model.d0) r7     // Catch: java.lang.Throwable -> L2b
            goto L8c
        L75:
            ru.yoomoney.sdk.kassa.payments.model.L r5 = new ru.yoomoney.sdk.kassa.payments.model.L     // Catch: java.lang.Throwable -> L58
            r5.<init>()     // Catch: java.lang.Throwable -> L58
            throw r5     // Catch: java.lang.Throwable -> L58
        L7b:
            ru.yoomoney.sdk.kassa.payments.metrics.r r5 = r5.c
            ru.yoomoney.sdk.kassa.payments.model.o0 r7 = new ru.yoomoney.sdk.kassa.payments.model.o0
            r7.<init>(r6)
            ru.yoomoney.sdk.kassa.payments.metrics.f0 r5 = (ru.yoomoney.sdk.kassa.payments.metrics.f0) r5
            r5.a(r7)
            ru.yoomoney.sdk.kassa.payments.model.b0 r7 = new ru.yoomoney.sdk.kassa.payments.model.b0
            r7.<init>(r6)
        L8c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentOptionList.C2480h.a(ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount, ru.yoomoney.sdk.kassa.payments.model.u, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
