package ru.yoomoney.sdk.kassa.payments.model.mapper;

import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Fee;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.A;

/* loaded from: classes5.dex */
public abstract class h {
    public static final A a(Fee fee) {
        Amount amount;
        Intrinsics.checkNotNullParameter(fee, "<this>");
        ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount service = fee.getService();
        Amount amount2 = null;
        if (service != null) {
            Intrinsics.checkNotNullParameter(service, "<this>");
            amount = new Amount(new BigDecimal(service.getValue()), service.getCurrency());
        } else {
            amount = null;
        }
        ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.Amount counterparty = fee.getCounterparty();
        if (counterparty != null) {
            Intrinsics.checkNotNullParameter(counterparty, "<this>");
            amount2 = new Amount(new BigDecimal(counterparty.getValue()), counterparty.getCurrency());
        }
        return new A(amount, amount2);
    }
}
