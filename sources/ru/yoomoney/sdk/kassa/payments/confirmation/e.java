package ru.yoomoney.sdk.kassa.payments.confirmation;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* loaded from: classes5.dex */
public final class e extends Lambda implements Function0 {
    public final /* synthetic */ ConfirmationActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ConfirmationActivity confirmationActivity) {
        super(0);
        this.a = confirmationActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Serializable serializableExtra = this.a.getIntent().getSerializableExtra("ru.yoomoney.sdk.kassa.payments.extra.PAYMENT_METHOD_TYPE");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType");
        return (PaymentMethodType) serializableExtra;
    }
}
