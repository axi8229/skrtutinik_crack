package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class a0 extends e0 {
    public final String a;
    public final String b;
    public final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(String memberId, String title, String deeplink) {
        super(0);
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        this.a = memberId;
        this.b = title;
        this.c = deeplink;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Intrinsics.areEqual(this.a, a0Var.a) && Intrinsics.areEqual(this.b, a0Var.b) && Intrinsics.areEqual(this.c, a0Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "BankViewEntity(memberId=" + this.a + ", title=" + this.b + ", deeplink=" + this.c + ")";
    }
}
