package ru.yoomoney.sdk.kassa.payments.model.mapper;

import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.BankCardType;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class d {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[BankCardType.values().length];
        try {
            iArr[BankCardType.MASTER_CARD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[BankCardType.VISA.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[BankCardType.MIR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[BankCardType.AMERICAN_EXPRESS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[BankCardType.JCB.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr[BankCardType.CUP.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr[BankCardType.DINERS_CLUB.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr[BankCardType.BANK_CARD.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr[BankCardType.DISCOVER_CARD.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr[BankCardType.INSTA_PAYMENT.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr[BankCardType.INSTA_PAYMENT_TM.ordinal()] = 11;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr[BankCardType.LASER.ordinal()] = 12;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr[BankCardType.DANKORT.ordinal()] = 13;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr[BankCardType.SOLO.ordinal()] = 14;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr[BankCardType.SWITCH.ordinal()] = 15;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr[BankCardType.UNKNOWN.ordinal()] = 16;
        } catch (NoSuchFieldError unused16) {
        }
        a = iArr;
    }
}
