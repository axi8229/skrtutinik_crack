package ru.yoomoney.sdk.kassa.payments.utils;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class f {
    public static final String a() {
        String language = Locale.getDefault().getLanguage();
        if (!Intrinsics.areEqual(language, "ru")) {
            return "en";
        }
        Intrinsics.checkNotNull(language);
        return language;
    }
}
