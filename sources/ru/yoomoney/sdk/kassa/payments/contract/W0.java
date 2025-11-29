package ru.yoomoney.sdk.kassa.payments.contract;

import ru.yoomoney.sdk.kassa.payments.checkoutParameters.SavePaymentMethod;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class W0 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[SavePaymentMethod.values().length];
        try {
            iArr[SavePaymentMethod.ON.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[SavePaymentMethod.OFF.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[SavePaymentMethod.USER_SELECTS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        a = iArr;
    }
}
