package ru.yoomoney.sdk.kassa.payments.paymentAuth;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.AbstractC2330n;

/* loaded from: classes5.dex */
public final class B1 extends C1 {
    public final AbstractC2330n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B1(AbstractC2330n data) {
        super(0);
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    public final AbstractC2330n a() {
        return this.a;
    }
}
