package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class Q {
    public final String a;
    public final String b;

    public Q(String confirmationData, String shopId) {
        Intrinsics.checkNotNullParameter(confirmationData, "confirmationData");
        Intrinsics.checkNotNullParameter(shopId, "shopId");
        this.a = confirmationData;
        this.b = shopId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q = (Q) obj;
        return Intrinsics.areEqual(this.a, q.a) && Intrinsics.areEqual(this.b, q.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "SberPayAssistedParams(confirmationData=" + this.a + ", shopId=" + this.b + ")";
    }
}
