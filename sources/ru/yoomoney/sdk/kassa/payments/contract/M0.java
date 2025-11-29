package ru.yoomoney.sdk.kassa.payments.contract;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class M0 extends Lambda implements Function2 {
    public final /* synthetic */ O0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M0(O0 o0) {
        super(2);
        this.a = o0;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ru.yoomoney.sdk.kassa.payments.model.T paymentOption = (ru.yoomoney.sdk.kassa.payments.model.T) obj;
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        return ru.yoomoney.sdk.kassa.payments.extensions.i.a(paymentOption, this.a.a, (ru.yoomoney.sdk.kassa.payments.model.Q) obj2);
    }
}
