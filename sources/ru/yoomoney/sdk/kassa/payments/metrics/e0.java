package ru.yoomoney.sdk.kassa.payments.metrics;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.C2318b;

/* loaded from: classes5.dex */
public final class e0 implements Function0 {
    public final ru.yoomoney.sdk.kassa.payments.payment.b a;
    public final ru.yoomoney.sdk.kassa.payments.payment.a b;

    public e0(ru.yoomoney.sdk.kassa.payments.payment.b currentUserRepository, ru.yoomoney.sdk.kassa.payments.payment.a paymentAuthRequiredGateway) {
        Intrinsics.checkNotNullParameter(currentUserRepository, "currentUserRepository");
        Intrinsics.checkNotNullParameter(paymentAuthRequiredGateway, "paymentAuthRequiredGateway");
        this.a = currentUserRepository;
        this.b = paymentAuthRequiredGateway;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Intrinsics.areEqual(this.a.a(), C2318b.a) ? new C2304m() : (this.b.b() && this.b.c()) ? new C2305n() : new C2303l();
    }
}
