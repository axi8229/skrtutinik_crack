package ru.yoomoney.sdk.kassa.payments.model.mapper;

import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.AuthTypes;
import ru.yoomoney.sdk.kassa.payments.api.model.authpayments.ErrorCodeNetwork;
import ru.yoomoney.sdk.kassa.payments.model.EnumC2321e;

/* loaded from: classes5.dex */
public abstract /* synthetic */ class b {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[EnumC2321e.values().length];
        try {
            iArr[0] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            EnumC2321e enumC2321e = EnumC2321e.a;
            iArr[3] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            EnumC2321e enumC2321e2 = EnumC2321e.a;
            iArr[1] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            EnumC2321e enumC2321e3 = EnumC2321e.a;
            iArr[2] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            EnumC2321e enumC2321e4 = EnumC2321e.a;
            iArr[4] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            EnumC2321e enumC2321e5 = EnumC2321e.a;
            iArr[5] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            EnumC2321e enumC2321e6 = EnumC2321e.a;
            iArr[6] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            EnumC2321e enumC2321e7 = EnumC2321e.a;
            iArr[7] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        int[] iArr2 = new int[AuthTypes.values().length];
        try {
            iArr2[AuthTypes.SMS.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[AuthTypes.EMERGENCY.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[AuthTypes.TOTP.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[AuthTypes.SECURE_PASSWORD.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[AuthTypes.PUSH.ordinal()] = 5;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[AuthTypes.OAUTH_TOKEN.ordinal()] = 6;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[AuthTypes.PUSH_CODE.ordinal()] = 7;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[AuthTypes.UNKNOWN.ordinal()] = 8;
        } catch (NoSuchFieldError unused16) {
        }
        a = iArr2;
        int[] iArr3 = new int[ErrorCodeNetwork.values().length];
        try {
            iArr3[ErrorCodeNetwork.INVALID_CONTEXT.ordinal()] = 1;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            iArr3[ErrorCodeNetwork.UNSUPPORTED_AUTH_TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            iArr3[ErrorCodeNetwork.INVALID_ANSWER.ordinal()] = 3;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            iArr3[ErrorCodeNetwork.VERIFY_ATTEMPTS_EXCEEDED.ordinal()] = 4;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            iArr3[ErrorCodeNetwork.SESSION_DOES_NOT_EXIST.ordinal()] = 5;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            iArr3[ErrorCodeNetwork.SESSION_EXPIRED.ordinal()] = 6;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            iArr3[ErrorCodeNetwork.UNKNOWN.ordinal()] = 7;
        } catch (NoSuchFieldError unused23) {
        }
        b = iArr3;
    }
}
