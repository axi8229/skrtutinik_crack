package ru.yoomoney.sdk.kassa.payments.extensions;

import java.util.Currency;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class h {
    public static final Currency a;

    static {
        Currency currency = Currency.getInstance("RUB");
        Intrinsics.checkNotNullExpressionValue(currency, "getInstance(...)");
        a = currency;
    }
}
