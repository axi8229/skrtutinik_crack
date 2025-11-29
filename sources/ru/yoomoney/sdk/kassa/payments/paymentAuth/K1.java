package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n;

/* loaded from: classes5.dex */
public final class K1 extends Lambda implements Function1 {
    public final /* synthetic */ M1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K1(M1 m1) {
        super(1);
        this.a = m1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AbstractC2330n it = (AbstractC2330n) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C2395a c2395a = this.a.a;
        return Boolean.valueOf(ArraysKt.contains(c2395a.a, it.a()));
    }
}
