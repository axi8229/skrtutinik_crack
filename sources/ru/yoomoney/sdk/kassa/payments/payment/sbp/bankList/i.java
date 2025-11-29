package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class i extends o {
    public final List a;
    public final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(List shortBankList, List fullBankList) {
        super(0);
        Intrinsics.checkNotNullParameter(shortBankList, "shortBankList");
        Intrinsics.checkNotNullParameter(fullBankList, "fullBankList");
        this.a = shortBankList;
        this.b = fullBankList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.areEqual(this.a, iVar.a) && Intrinsics.areEqual(this.b, iVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "LoadShortBankListSuccess(shortBankList=" + this.a + ", fullBankList=" + this.b + ")";
    }
}
