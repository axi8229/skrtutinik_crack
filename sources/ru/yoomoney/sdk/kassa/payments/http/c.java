package ru.yoomoney.sdk.kassa.payments.http;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class c {
    public static final String a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return "Bearer " + str;
    }
}
