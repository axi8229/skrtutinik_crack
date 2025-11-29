package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class x extends C {
    public final Throwable a;
    public final List b;
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Throwable throwable, List bankList, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(bankList, "bankList");
        this.a = throwable;
        this.b = bankList;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.areEqual(this.a, xVar.a) && Intrinsics.areEqual(this.b, xVar.b) && this.c == xVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PaymentFullBankListStatusError(throwable=" + this.a + ", bankList=" + this.b + ", showBackNavigation=" + this.c + ")";
    }
}
