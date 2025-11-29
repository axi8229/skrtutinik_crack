package ru.yoomoney.sdk.kassa.payments.model.mapper;

import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class k {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[PaymentMethodTypeNetwork.values().length];
        try {
            iArr[PaymentMethodTypeNetwork.BANK_CARD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.GOOGLE_PAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.SBERBANK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.YOO_MONEY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.SBP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        a = iArr;
    }
}
