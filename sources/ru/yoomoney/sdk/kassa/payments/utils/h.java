package ru.yoomoney.sdk.kassa.payments.utils;

import android.util.Log;
import java.util.Arrays;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* loaded from: classes5.dex */
public abstract class h {
    public static final Set a() {
        PaymentMethodType[] paymentMethodTypeArrValues = PaymentMethodType.values();
        return SetsKt.setOf(Arrays.copyOf(paymentMethodTypeArrValues, paymentMethodTypeArrValues.length));
    }

    public static final void a(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.i("YoomoneySberPaySdk", msg);
    }
}
