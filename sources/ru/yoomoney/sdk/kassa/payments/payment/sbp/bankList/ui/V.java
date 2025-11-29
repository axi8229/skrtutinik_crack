package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class V implements Z {
    public final Throwable a;
    public final List b;
    public final List c;

    public V(Throwable throwable, List shortBankList, List fullBankList) {
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
        if (!(obj instanceof V)) {
            return false;
        }
        V v = (V) obj;
        return Intrinsics.areEqual(this.a, v.a) && Intrinsics.areEqual(this.b, v.b) && Intrinsics.areEqual(this.c, v.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PaymentShortBankListStatusError(throwable=" + this.a + ", shortBankList=" + this.b + ", fullBankList=" + this.c + ")";
    }
}
