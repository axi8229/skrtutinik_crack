package ru.yoomoney.sdk.kassa.payments.model.mapper;

import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public abstract class a {
    public static final Amount a(ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount amount) {
        Intrinsics.checkNotNullParameter(amount, "<this>");
        return new Amount(new BigDecimal(amount.getValue()), amount.getCurrency());
    }
}
