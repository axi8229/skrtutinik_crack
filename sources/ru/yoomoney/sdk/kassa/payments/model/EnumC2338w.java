package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ru.yoomoney.sdk.kassa.payments.model.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC2338w {
    public static final EnumC2338w a;
    public static final EnumC2338w b;
    public static final EnumC2338w c;
    public static final EnumC2338w d;
    public static final EnumC2338w e;
    public static final EnumC2338w f;
    public static final EnumC2338w g;
    public static final EnumC2338w h;
    public static final /* synthetic */ EnumC2338w[] i;

    static {
        EnumC2338w enumC2338w = new EnumC2338w("INVALID_REQUEST", 0);
        EnumC2338w enumC2338w2 = new EnumC2338w("NOT_SUPPORTED", 1);
        EnumC2338w enumC2338w3 = new EnumC2338w("INVALID_CREDENTIALS", 2);
        EnumC2338w enumC2338w4 = new EnumC2338w("FORBIDDEN", 3);
        EnumC2338w enumC2338w5 = new EnumC2338w("INTERNAL_SERVER_ERROR", 4);
        EnumC2338w enumC2338w6 = new EnumC2338w("TECHNICAL_ERROR", 5);
        a = enumC2338w6;
        EnumC2338w enumC2338w7 = new EnumC2338w("INVALID_SCOPE", 6);
        EnumC2338w enumC2338w8 = new EnumC2338w("INVALID_LOGIN", 7);
        EnumC2338w enumC2338w9 = new EnumC2338w("INVALID_TOKEN", 8);
        EnumC2338w enumC2338w10 = new EnumC2338w("INVALID_SIGNATURE", 9);
        EnumC2338w enumC2338w11 = new EnumC2338w("SYNTAX_ERROR", 10);
        EnumC2338w enumC2338w12 = new EnumC2338w("ILLEGAL_PARAMETERS", 11);
        EnumC2338w enumC2338w13 = new EnumC2338w("ILLEGAL_HEADERS", 12);
        EnumC2338w enumC2338w14 = new EnumC2338w("INVALID_CONTEXT", 13);
        b = enumC2338w14;
        EnumC2338w enumC2338w15 = new EnumC2338w("CREATE_TIMEOUT_NOT_EXPIRED", 14);
        EnumC2338w enumC2338w16 = new EnumC2338w("SESSIONS_EXCEEDED", 15);
        EnumC2338w enumC2338w17 = new EnumC2338w("UNSUPPORTED_AUTH_TYPE", 16);
        c = enumC2338w17;
        EnumC2338w enumC2338w18 = new EnumC2338w("VERIFY_ATTEMPTS_EXCEEDED", 17);
        d = enumC2338w18;
        EnumC2338w enumC2338w19 = new EnumC2338w("INVALID_ANSWER", 18);
        e = enumC2338w19;
        EnumC2338w enumC2338w20 = new EnumC2338w("SESSION_DOES_NOT_EXIST", 19);
        f = enumC2338w20;
        EnumC2338w enumC2338w21 = new EnumC2338w("SESSION_EXPIRED", 20);
        g = enumC2338w21;
        EnumC2338w enumC2338w22 = new EnumC2338w("ACCOUNT_NOT_FOUND", 21);
        EnumC2338w enumC2338w23 = new EnumC2338w("AUTH_REQUIRED", 22);
        EnumC2338w enumC2338w24 = new EnumC2338w("AUTH_EXPIRED", 23);
        EnumC2338w enumC2338w25 = new EnumC2338w("UNKNOWN", 24);
        h = enumC2338w25;
        EnumC2338w[] enumC2338wArr = {enumC2338w, enumC2338w2, enumC2338w3, enumC2338w4, enumC2338w5, enumC2338w6, enumC2338w7, enumC2338w8, enumC2338w9, enumC2338w10, enumC2338w11, enumC2338w12, enumC2338w13, enumC2338w14, enumC2338w15, enumC2338w16, enumC2338w17, enumC2338w18, enumC2338w19, enumC2338w20, enumC2338w21, enumC2338w22, enumC2338w23, enumC2338w24, enumC2338w25};
        i = enumC2338wArr;
        EnumEntriesKt.enumEntries(enumC2338wArr);
    }

    public EnumC2338w(String str, int i2) {
    }

    public static EnumC2338w valueOf(String str) {
        return (EnumC2338w) Enum.valueOf(EnumC2338w.class, str);
    }

    public static EnumC2338w[] values() {
        return (EnumC2338w[]) i.clone();
    }
}
