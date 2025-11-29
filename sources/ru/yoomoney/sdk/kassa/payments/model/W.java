package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class W {
    public static final W a;
    public static final W b;
    public static final W c;
    public static final W d;
    public static final W e;
    public static final /* synthetic */ W[] f;

    static {
        W w = new W("PENDING", 0);
        a = w;
        W w2 = new W("WAITING_FOR_CAPTURE", 1);
        b = w2;
        W w3 = new W("SUCCEEDED", 2);
        c = w3;
        W w4 = new W("CANCELED", 3);
        d = w4;
        W w5 = new W("UNKNOWN", 4);
        e = w5;
        W[] wArr = {w, w2, w3, w4, w5};
        f = wArr;
        EnumEntriesKt.enumEntries(wArr);
    }

    public W(String str, int i) {
    }

    public static W valueOf(String str) {
        return (W) Enum.valueOf(W.class, str);
    }

    public static W[] values() {
        return (W[]) f.clone();
    }
}
