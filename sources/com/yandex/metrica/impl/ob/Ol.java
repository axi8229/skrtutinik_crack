package com.yandex.metrica.impl.ob;

import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Ol {
    private static final BigInteger a = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger b = BigInteger.valueOf(Long.MIN_VALUE);

    public static final Pair a(BigDecimal bigDecimal) {
        int i = -bigDecimal.scale();
        BigInteger bigIntegerUnscaledValue = bigDecimal.unscaledValue();
        Intrinsics.checkNotNullExpressionValue(bigIntegerUnscaledValue, "value.unscaledValue()");
        while (true) {
            if (bigIntegerUnscaledValue.compareTo(a) <= 0 && bigIntegerUnscaledValue.compareTo(b) >= 0) {
                return TuplesKt.to(Long.valueOf(bigIntegerUnscaledValue.longValue()), Integer.valueOf(i));
            }
            bigIntegerUnscaledValue = bigIntegerUnscaledValue.divide(BigInteger.TEN);
            Intrinsics.checkNotNullExpressionValue(bigIntegerUnscaledValue, "bigIntMantissa.divide(BigInteger.TEN)");
            i++;
        }
    }
}
