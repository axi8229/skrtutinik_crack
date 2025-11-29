package ru.yoomoney.sdk.kassa.payments.utils;

import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public abstract class d {
    public static final boolean a() {
        return StringsKt.contains$default((CharSequence) "release", (CharSequence) "debug", false, 2, (Object) null);
    }

    public static final boolean b() {
        return a() || StringsKt.contains$default((CharSequence) "release", (CharSequence) "extended", false, 2, (Object) null);
    }
}
