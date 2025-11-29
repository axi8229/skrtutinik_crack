package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n;

/* loaded from: classes5.dex */
public final class L1 extends Lambda implements Function2 {
    public final /* synthetic */ M1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L1(M1 m1) {
        super(2);
        this.a = m1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(this.a.a.compare(((AbstractC2330n) obj).a(), ((AbstractC2330n) obj2).a()));
    }
}
