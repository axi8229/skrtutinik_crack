package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ru.yoomoney.sdk.kassa.payments.model.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC2321e {
    public static final EnumC2321e a;
    public static final EnumC2321e b;
    public static final EnumC2321e c;
    public static final EnumC2321e d;
    public static final EnumC2321e e;
    public static final EnumC2321e f;
    public static final EnumC2321e g;
    public static final EnumC2321e h;
    public static final /* synthetic */ EnumC2321e[] i;

    static {
        EnumC2321e enumC2321e = new EnumC2321e("SMS", 0);
        a = enumC2321e;
        EnumC2321e enumC2321e2 = new EnumC2321e("TOTP", 1);
        b = enumC2321e2;
        EnumC2321e enumC2321e3 = new EnumC2321e("SECURE_PASSWORD", 2);
        c = enumC2321e3;
        EnumC2321e enumC2321e4 = new EnumC2321e("EMERGENCY", 3);
        d = enumC2321e4;
        EnumC2321e enumC2321e5 = new EnumC2321e("PUSH", 4);
        e = enumC2321e5;
        EnumC2321e enumC2321e6 = new EnumC2321e("OAUTH_TOKEN", 5);
        f = enumC2321e6;
        EnumC2321e enumC2321e7 = new EnumC2321e("PUSH_CODE", 6);
        g = enumC2321e7;
        EnumC2321e enumC2321e8 = new EnumC2321e("UNKNOWN", 7);
        h = enumC2321e8;
        EnumC2321e[] enumC2321eArr = {enumC2321e, enumC2321e2, enumC2321e3, enumC2321e4, enumC2321e5, enumC2321e6, enumC2321e7, enumC2321e8};
        i = enumC2321eArr;
        EnumEntriesKt.enumEntries(enumC2321eArr);
    }

    public EnumC2321e(String str, int i2) {
    }

    public static EnumC2321e valueOf(String str) {
        return (EnumC2321e) Enum.valueOf(EnumC2321e.class, str);
    }

    public static EnumC2321e[] values() {
        return (EnumC2321e[]) i.clone();
    }
}
