package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w extends C {
    public final List a;
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(boolean z, List fullBankList) {
        super(0);
        Intrinsics.checkNotNullParameter(fullBankList, "fullBankList");
        this.a = fullBankList;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return Intrinsics.areEqual(this.a, wVar.a) && this.b == wVar.b;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "FullBankListStatusProgress(fullBankList=" + this.a + ", showBackNavigation=" + this.b + ")";
    }
}
