package ru.yoomoney.sdk.kassa.payments.payment.sbp.bankList.model;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public a(String memberId, String nameRus, String nameEng, String deeplink) {
        Intrinsics.checkNotNullParameter(memberId, "memberId");
        Intrinsics.checkNotNullParameter(nameRus, "nameRus");
        Intrinsics.checkNotNullParameter(nameEng, "nameEng");
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        this.a = memberId;
        this.b = nameRus;
        this.c = nameEng;
        this.d = deeplink;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "SbpBankInfoDomain(memberId=" + this.a + ", nameRus=" + this.b + ", nameEng=" + this.c + ", deeplink=" + this.d + ")";
    }
}
