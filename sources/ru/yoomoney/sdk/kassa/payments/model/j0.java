package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class j0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public j0(String paymentId, String merchantLogin, String orderId, String orderNumber, String apiKey) {
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(merchantLogin, "merchantLogin");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.a = paymentId;
        this.b = merchantLogin;
        this.c = orderId;
        this.d = orderNumber;
        this.e = apiKey;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        return Intrinsics.areEqual(this.a, j0Var.a) && Intrinsics.areEqual(this.b, j0Var.b) && Intrinsics.areEqual(this.c, j0Var.c) && Intrinsics.areEqual(this.d, j0Var.d) && Intrinsics.areEqual(this.e, j0Var.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + AbstractC1553e.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "SberConfirmationDetails(paymentId=" + this.a + ", merchantLogin=" + this.b + ", orderId=" + this.c + ", orderNumber=" + this.d + ", apiKey=" + this.e + ")";
    }
}
