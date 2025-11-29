package ru.yoomoney.sdk.kassa.payments.di;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.model.Q;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function2 {
    public final /* synthetic */ i a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(i iVar) {
        super(2);
        this.a = iVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        T paymentOption = (T) obj;
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        return ru.yoomoney.sdk.kassa.payments.extensions.i.a(paymentOption, this.a.m, (Q) obj2);
    }
}
