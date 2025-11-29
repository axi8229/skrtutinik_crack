package spay.sdk;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import spay.sdk.api.PaymentResult;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1<PaymentResult, Unit> {
    public final /* synthetic */ Function1<PaymentResult, Unit> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super PaymentResult, Unit> function1) {
        super(1);
        this.a = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(PaymentResult paymentResult) {
        PaymentResult paymentResult2 = paymentResult;
        Intrinsics.checkNotNullParameter(paymentResult2, "paymentResult");
        this.a.invoke(paymentResult2);
        return Unit.INSTANCE;
    }
}
