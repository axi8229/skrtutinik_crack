package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class m extends o {
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String searchText) {
        super(0);
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        this.a = searchText;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m) && Intrinsics.areEqual(this.a, ((m) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Search(searchText=" + this.a + ")";
    }
}
