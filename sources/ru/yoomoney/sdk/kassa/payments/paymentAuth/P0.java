package ru.yoomoney.sdk.kassa.payments.paymentAuth;

/* loaded from: classes5.dex */
public abstract class P0 {
    public static final String a(long j) {
        if (j >= 10) {
            return String.valueOf(j);
        }
        return "0" + j;
    }
}
