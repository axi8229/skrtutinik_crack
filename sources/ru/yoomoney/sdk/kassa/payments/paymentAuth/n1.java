package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class n1 extends Lambda implements Function1 {
    public static final n1 a = new n1();

    public n1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Long.valueOf(((Number) obj).longValue());
    }
}
