package ru.yoomoney.sdk.kassa.payments.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class V {
    public final List a;
    public final q0 b;

    public V(List paymentOptions, q0 shopProperties) {
        Intrinsics.checkNotNullParameter(paymentOptions, "paymentOptions");
        Intrinsics.checkNotNullParameter(shopProperties, "shopProperties");
        this.a = paymentOptions;
        this.b = shopProperties;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V)) {
            return false;
        }
        V v = (V) obj;
        return Intrinsics.areEqual(this.a, v.a) && Intrinsics.areEqual(this.b, v.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "PaymentOptionsResponse(paymentOptions=" + this.a + ", shopProperties=" + this.b + ")";
    }
}
