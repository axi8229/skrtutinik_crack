package ru.yoomoney.sdk.kassa.payments.contract.savePayment;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function0 {
    public final /* synthetic */ SavePaymentMethodInfoActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SavePaymentMethodInfoActivity savePaymentMethodInfoActivity) {
        super(0);
        this.a = savePaymentMethodInfoActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.a.finish();
        return Unit.INSTANCE;
    }
}
