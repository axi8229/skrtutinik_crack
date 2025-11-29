package ru.yoomoney.sdk.kassa.payments.confirmation.sberpay;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* renamed from: ru.yoomoney.sdk.kassa.payments.confirmation.sberpay.n, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C2204n extends AbstractC2205o {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2204n(String sberPayApikey, String merchantLogin, String orderId, String orderNumber) {
        super(0);
        Intrinsics.checkNotNullParameter(sberPayApikey, "sberPayApikey");
        Intrinsics.checkNotNullParameter(merchantLogin, "merchantLogin");
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        this.a = sberPayApikey;
        this.b = merchantLogin;
        this.c = orderId;
        this.d = orderNumber;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2204n)) {
            return false;
        }
        C2204n c2204n = (C2204n) obj;
        return Intrinsics.areEqual(this.a, c2204n.a) && Intrinsics.areEqual(this.b, c2204n.b) && Intrinsics.areEqual(this.c, c2204n.c) && Intrinsics.areEqual(this.d, c2204n.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "LoadSberPayInfoSuccess(sberPayApikey=" + this.a + ", merchantLogin=" + this.b + ", orderId=" + this.c + ", orderNumber=" + this.d + ")";
    }
}
