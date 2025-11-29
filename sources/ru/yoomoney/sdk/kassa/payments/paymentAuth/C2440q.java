package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;
import ru.yoomoney.sdk.kassa.payments.model.C2326j;

/* renamed from: ru.yoomoney.sdk.kassa.payments.paymentAuth.q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2440q implements s1 {
    @Override // ru.yoomoney.sdk.kassa.payments.paymentAuth.s1
    public final Object a(Continuation continuation, Amount amount, boolean z) {
        return new ru.yoomoney.sdk.kassa.payments.model.c0(new C2326j(15, 4, Boxing.boxInt(3), Boxing.boxInt(3)));
    }
}
