package ru.yoomoney.sdk.kassa.payments.paymentOptionInfo;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function2 {
    public static final a a = new a();

    public a() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int iIntValue = ((Number) obj).intValue();
        int iIntValue2 = ((Number) obj2).intValue();
        if (iIntValue % 2 != 0) {
            iIntValue2 = iIntValue2 < 5 ? iIntValue2 * 2 : (iIntValue2 * 2) - 9;
        }
        return Integer.valueOf(iIntValue2);
    }
}
