package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f0 {
    public final String a;
    public final String b;

    public f0(String paymentId, String url) {
        Intrinsics.checkNotNullParameter(paymentId, "paymentId");
        Intrinsics.checkNotNullParameter(url, "url");
        this.a = paymentId;
        this.b = url;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return Intrinsics.areEqual(this.a, f0Var.a) && Intrinsics.areEqual(this.b, f0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "SBPConfirmationDetails(paymentId=" + this.a + ", url=" + this.b + ")";
    }
}
