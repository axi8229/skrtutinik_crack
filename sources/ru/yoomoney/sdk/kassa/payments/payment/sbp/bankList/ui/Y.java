package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class Y implements Z {
    public final List a;
    public final List b;

    public Y(List shortBankList, List fullBankList) {
        Intrinsics.checkNotNullParameter(shortBankList, "shortBankList");
        Intrinsics.checkNotNullParameter(fullBankList, "fullBankList");
        this.a = shortBankList;
        this.b = fullBankList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Y)) {
            return false;
        }
        Y y = (Y) obj;
        return Intrinsics.areEqual(this.a, y.a) && Intrinsics.areEqual(this.b, y.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ShortBankListStatusProgress(shortBankList=" + this.a + ", fullBankList=" + this.b + ")";
    }
}
