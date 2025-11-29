package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class T implements Z {
    public final List a;
    public final boolean b;

    public T(boolean z, List fullBankList) {
        Intrinsics.checkNotNullParameter(fullBankList, "fullBankList");
        this.a = fullBankList;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T)) {
            return false;
        }
        T t = (T) obj;
        return Intrinsics.areEqual(this.a, t.a) && this.b == t.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "FullBankListStatusProgress(fullBankList=" + this.a + ", showBackNavigation=" + this.b + ")";
    }
}
