package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class y extends C {
    public final Throwable a;
    public final List b;
    public final List c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Throwable throwable, List shortBankList, List fullBankList) {
        super(0);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(shortBankList, "shortBankList");
        Intrinsics.checkNotNullParameter(fullBankList, "fullBankList");
        this.a = throwable;
        this.b = shortBankList;
        this.c = fullBankList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Intrinsics.areEqual(this.a, yVar.a) && Intrinsics.areEqual(this.b, yVar.b) && Intrinsics.areEqual(this.c, yVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PaymentShortBankListStatusError(throwable=" + this.a + ", shortBankList=" + this.b + ", fullBankList=" + this.c + ")";
    }
}
