package ru.yoomoney.sdk.kassa.payments.model.mapper;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.PaymentDetailsResponse;
import ru.yoomoney.sdk.kassa.payments.model.N;
import ru.yoomoney.sdk.kassa.payments.model.W;
import ru.yoomoney.sdk.kassa.payments.model.t0;

/* loaded from: classes5.dex */
public abstract class j {
    public static final N a(PaymentDetailsResponse paymentDetailsResponse) {
        Intrinsics.checkNotNullParameter(paymentDetailsResponse, "<this>");
        String paymentId = paymentDetailsResponse.getPaymentId();
        int i = i.a[paymentDetailsResponse.getStatus().ordinal()];
        W w = i != 1 ? i != 2 ? i != 3 ? i != 4 ? W.e : W.c : W.b : W.a : W.d;
        int i2 = i.b[paymentDetailsResponse.getUserPaymentProcess().ordinal()];
        return new N(paymentId, w, i2 != 1 ? i2 != 2 ? t0.c : t0.b : t0.a);
    }
}
