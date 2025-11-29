package ru.yoomoney.sdk.kassa.payments.api;

import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.InstrumentType;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.PaymentMethodTypeNetwork;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class b {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[PaymentMethodTypeNetwork.values().length];
        try {
            iArr[PaymentMethodTypeNetwork.YOO_MONEY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.BANK_CARD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.SBERBANK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.GOOGLE_PAY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.SBP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[PaymentMethodTypeNetwork.UNKNOWN.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        a = iArr;
        int[] iArr2 = new int[InstrumentType.values().length];
        try {
            iArr2[InstrumentType.WALLET.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[InstrumentType.LINKED_BANK_CARD.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        b = iArr2;
    }
}
