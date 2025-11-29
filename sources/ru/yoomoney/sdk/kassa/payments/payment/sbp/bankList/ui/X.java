package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class X implements Z {
    public final List a;
    public final List b;

    public X(List shortBankList, List fullBankList) {
        Intrinsics.checkNotNullParameter(shortBankList, "shortBankList");
        Intrinsics.checkNotNullParameter(fullBankList, "fullBankList");
        this.a = shortBankList;
        this.b = fullBankList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X)) {
            return false;
        }
        X x = (X) obj;
        return Intrinsics.areEqual(this.a, x.a) && Intrinsics.areEqual(this.b, x.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ShortBankListContent(shortBankList=" + this.a + ", fullBankList=" + this.b + ")";
    }
}
