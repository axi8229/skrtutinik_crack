package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class v extends C {
    public final List a;
    public final boolean b;
    public final String c;
    public final List d;

    public /* synthetic */ v(List list, boolean z) {
        this(list, z, "", CollectionsKt.emptyList());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return Intrinsics.areEqual(this.a, vVar.a) && this.b == vVar.b && Intrinsics.areEqual(this.c, vVar.c) && Intrinsics.areEqual(this.d, vVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + AbstractC1553e.a(this.c, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "FullBankListContent(bankList=" + this.a + ", showBackNavigation=" + this.b + ", searchText=" + this.c + ", searchedBanks=" + this.d + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(List bankList, boolean z, String searchText, List searchedBanks) {
        super(0);
        Intrinsics.checkNotNullParameter(bankList, "bankList");
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        Intrinsics.checkNotNullParameter(searchedBanks, "searchedBanks");
        this.a = bankList;
        this.b = z;
        this.c = searchText;
        this.d = searchedBanks;
    }
}
