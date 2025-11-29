package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class G1 implements E1 {
    public final D1 a;
    public final ru.yoomoney.sdk.kassa.payments.payment.b b;
    public final r1 c;
    public final ru.yoomoney.sdk.kassa.payments.metrics.r d;

    public G1(D1 processPaymentAuthRepository, ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository, r1 paymentAuthTokenRepository, ru.yoomoney.sdk.kassa.payments.metrics.r errorReporter) {
        Intrinsics.checkNotNullParameter(processPaymentAuthRepository, "processPaymentAuthRepository");
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(paymentAuthTokenRepository, "paymentAuthTokenRepository");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        this.a = processPaymentAuthRepository;
        this.b = currentUserRepository;
        this.c = paymentAuthTokenRepository;
        this.d = errorReporter;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0163 A[PHI: r6
  0x0163: PHI (r6v32 ru.yoomoney.sdk.kassa.payments.paymentAuth.r1) = (r6v30 ru.yoomoney.sdk.kassa.payments.paymentAuth.r1), (r6v37 ru.yoomoney.sdk.kassa.payments.paymentAuth.r1) binds: [B:29:0x007b, B:73:0x0161] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r6, boolean r7, kotlin.coroutines.Continuation r8) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.paymentAuth.G1.a(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
