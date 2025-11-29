package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f extends o {
    public final List a;
    public final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(List fullBankList, List shortBankList) {
        super(0);
        Intrinsics.checkNotNullParameter(fullBankList, "fullBankList");
        Intrinsics.checkNotNullParameter(shortBankList, "shortBankList");
        this.a = fullBankList;
        this.b = shortBankList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.areEqual(this.a, fVar.a) && Intrinsics.areEqual(this.b, fVar.b);
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "LoadFullBankListSuccess(fullBankList=" + this.a + ", shortBankList=" + this.b + ", showBackNavigation=false)";
    }
}
