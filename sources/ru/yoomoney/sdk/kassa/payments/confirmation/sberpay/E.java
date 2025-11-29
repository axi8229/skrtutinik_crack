package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.api.PaymentResult;

/* loaded from: classes5.dex */
public final class E extends Lambda implements Function1 {
    public final /* synthetic */ H a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(H h) {
        super(1);
        this.a = h;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        PaymentResult it = (PaymentResult) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        H h = this.a;
        int i = H.$r8$clinit;
        h.a(it);
        return Unit.INSTANCE;
    }
}
