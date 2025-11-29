package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.ui;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class S implements Z {
    public final List a;
    public final boolean b;
    public final String c;
    public final List d;

    public S(List bankList, boolean z, String searchText, List searchedBanks) {
        Intrinsics.checkNotNullParameter(bankList, "bankList");
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(searchedBanks, "searchedBanks");
        this.a = bankList;
        this.b = z;
        this.c = searchText;
        this.d = searchedBanks;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        S s = (S) obj;
        return Intrinsics.areEqual(this.a, s.a) && this.b == s.b && Intrinsics.areEqual(this.c, s.c) && Intrinsics.areEqual(this.d, s.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + AbstractC1553e.a(this.c, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "FullBankListContent(bankList=" + this.a + ", showBackNavigation=" + this.b + ", searchText=" + this.c + ", searchedBanks=" + this.d + ")";
    }
}
