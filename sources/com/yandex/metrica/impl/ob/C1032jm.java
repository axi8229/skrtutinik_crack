package com.yandex.metrica.impl.ob;

import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.yandex.metrica.impl.ob.jm, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1032jm {
    public final String a() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        String strReplace$default = StringsKt.replace$default(string, "-", "", false, 4, (Object) null);
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
        if (strReplace$default == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strReplace$default.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
