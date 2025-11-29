package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class I0 extends Lambda implements Function0 {
    public final /* synthetic */ O0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I0(O0 o0) {
        super(0);
        this.a = o0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle arguments = this.a.getArguments();
        Amount amount = arguments != null ? (Amount) arguments.getParcelable("ru.yoomoney.sdk.kassa.payments.impl.paymentAuth.AMOUNT_KEY") : null;
        Amount amount2 = amount != null ? amount : null;
        if (amount2 != null) {
            return amount2;
        }
        throw new IllegalStateException("AMOUNT_KEY should be passed");
    }
}
