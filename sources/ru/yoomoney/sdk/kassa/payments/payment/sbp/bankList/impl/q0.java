package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.impl;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q0 {
    public final String a;
    public final String b;

    public q0(String confirmationUrl, String paymentId) {
        Intrinsics.checkNotNullParameter(confirmationUrl, "confirmationUrl");
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        this.a = confirmationUrl;
        this.b = paymentId;
    }
}
