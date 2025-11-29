package ru.yoomoney.sdk.kassa.payments.model.mapper;

import ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.PaymentStatusResponse;
import ru.yoomoney.sdk.kassa.payments.api.model.paymentdetails.UserPaymentProcessResponse;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class i {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[PaymentStatusResponse.values().length];
        try {
            iArr[PaymentStatusResponse.CANCELED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[PaymentStatusResponse.PENDING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[PaymentStatusResponse.WAITING_FOR_CAPTURE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[PaymentStatusResponse.SUCCEEDED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        a = iArr;
        int[] iArr2 = new int[UserPaymentProcessResponse.values().length];
        try {
            iArr2[UserPaymentProcessResponse.IN_PROGRESS.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[UserPaymentProcessResponse.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        b = iArr2;
    }
}
