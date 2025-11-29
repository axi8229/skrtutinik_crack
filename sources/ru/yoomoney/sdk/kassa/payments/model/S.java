package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* loaded from: classes5.dex */
public final class S {
    public final PaymentMethodType a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final r f;

    public S(PaymentMethodType type, String id, boolean z, boolean z2, String str, r rVar) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(id, "id");
        this.a = type;
        this.b = id;
        this.c = z;
        this.d = z2;
        this.e = str;
        this.f = rVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof S)) {
            return false;
        }
        S s = (S) obj;
        return this.a == s.a && Intrinsics.areEqual(this.b, s.b) && this.c == s.c && this.d == s.d && Intrinsics.areEqual(this.e, s.e) && Intrinsics.areEqual(this.f, s.f);
    }

    public final int hashCode() {
        int iA = ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.d, ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31), 31);
        String str = this.e;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        r rVar = this.f;
        return iHashCode + (rVar != null ? rVar.hashCode() : 0);
    }

    public final String toString() {
        return "PaymentMethodBankCard(type=" + this.a + ", id=" + this.b + ", saved=" + this.c + ", cscRequired=" + this.d + ", title=" + this.e + ", card=" + this.f + ")";
    }
}
