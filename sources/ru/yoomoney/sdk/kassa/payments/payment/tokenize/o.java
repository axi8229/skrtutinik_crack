package ru.yoomoney.sdk.kassa.payments.payment.tokenize;

import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2335t;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.T;
import ru.yoomoney.sdk.kassa.payments.model.U;

/* loaded from: classes5.dex */
public interface o {
    Object a(Amount amount, T t, U u, boolean z, boolean z2, AbstractC2335t abstractC2335t, Continuation continuation);

    Object a(Amount amount, T t, boolean z, AbstractC2335t abstractC2335t, String str, String str2, Continuation continuation);

    Object a(T t, Q q, Amount amount, boolean z, String str, AbstractC2335t abstractC2335t, Continuation continuation);
}
