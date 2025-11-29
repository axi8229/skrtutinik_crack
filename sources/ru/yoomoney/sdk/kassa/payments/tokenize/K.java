package ru.yoomoney.sdk.kassa.payments.tokenize;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.paymentAuth.r1;

/* loaded from: classes5.dex */
public final class K implements I {
    public final ru.yoomoney.sdk.kassa.payments.payment.c a;
    public final ru.yoomoney.sdk.kassa.payments.payment.tokenize.o b;
    public final ru.yoomoney.sdk.kassa.payments.payment.a c;
    public final r1 d;

    public K(ru.yoomoney.sdk.kassa.payments.payment.c getLoadedPaymentOptionListRepository, ru.yoomoney.sdk.kassa.payments.payment.tokenize.o tokenizeRepository, ru.yoomoney.sdk.kassa.payments.payment.a checkPaymentAuthRequiredGateway, r1 paymenPaymentAuthTokenRepository) {
        Intrinsics.checkNotNullParameter(getLoadedPaymentOptionListRepository, "getLoadedPaymentOptionListRepository");
        Intrinsics.checkNotNullParameter(tokenizeRepository, "tokenizeRepository");
        Intrinsics.checkNotNullParameter(checkPaymentAuthRequiredGateway, "checkPaymentAuthRequiredGateway");
        Intrinsics.checkNotNullParameter(paymenPaymentAuthTokenRepository, "paymenPaymentAuthTokenRepository");
        this.a = getLoadedPaymentOptionListRepository;
        this.b = tokenizeRepository;
        this.c = checkPaymentAuthRequiredGateway;
        this.d = paymenPaymentAuthTokenRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(ru.yoomoney.sdk.kassa.payments.payment.tokenize.i r12, kotlin.coroutines.Continuation r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.yoomoney.sdk.kassa.payments.tokenize.K.a(ru.yoomoney.sdk.kassa.payments.payment.tokenize.i, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
