package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class U implements Z {
    public final Throwable a;
    public final List b;
    public final boolean c;

    public U(Throwable throwable, List bankList, boolean z) {
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
        if (!(obj instanceof U)) {
            return false;
        }
        U u = (U) obj;
        return Intrinsics.areEqual(this.a, u.a) && Intrinsics.areEqual(this.b, u.b) && this.c == u.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PaymentFullBankListStatusError(throwable=" + this.a + ", bankList=" + this.b + ", showBackNavigation=" + this.c + ")";
    }
}
