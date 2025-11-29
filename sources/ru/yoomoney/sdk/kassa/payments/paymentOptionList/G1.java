package ru.yoomoney.sdk.kassa.payments.paymentOptionList;

import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class G1 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[PaymentMethodType.values().length];
        try {
            iArr[PaymentMethodType.BANK_CARD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        a = iArr;
    }
}
