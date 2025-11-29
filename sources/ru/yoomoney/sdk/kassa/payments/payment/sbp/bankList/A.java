package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class A extends C {
    public final List a;
    public final List b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(List shortBankList, List fullBankList) {
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
        if (!(obj instanceof A)) {
            return false;
        }
        A a = (A) obj;
        return Intrinsics.areEqual(this.a, a.a) && Intrinsics.areEqual(this.b, a.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ShortBankListContent(shortBankList=" + this.a + ", fullBankList=" + this.b + ")";
    }
}
