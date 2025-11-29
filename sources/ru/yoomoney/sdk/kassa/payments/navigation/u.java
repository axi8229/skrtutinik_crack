package ru.yoomoney.sdk.kassa.payments.navigation;

import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.model.T;

/* loaded from: classes5.dex */
public final class u extends v {
    public final T a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(T paymentOption) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentOption, "paymentOption");
        this.a = paymentOption;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u) && Intrinsics.areEqual(this.a, ((u) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "UnbindLinkedCard(paymentOption=" + this.a + ")";
    }
}
