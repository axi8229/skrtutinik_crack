package ru.yoomoney.sdk.kassa.payments.model;

import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType;

/* loaded from: classes5.dex */
public final class r {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final EnumC2333q e;
    public final PaymentMethodType f;

    public r(String str, String last, String expiryYear, String expiryMonth, EnumC2333q cardType, PaymentMethodType source) {
        Intrinsics.checkNotNullParameter(last, "last");
        Intrinsics.checkNotNullParameter(expiryYear, "expiryYear");
        Intrinsics.checkNotNullParameter(expiryMonth, "expiryMonth");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(source, "source");
        this.a = str;
        this.b = last;
        this.c = expiryYear;
        this.d = expiryMonth;
        this.e = cardType;
        this.f = source;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Intrinsics.areEqual(this.a, rVar.a) && Intrinsics.areEqual(this.b, rVar.b) && Intrinsics.areEqual(this.c, rVar.c) && Intrinsics.areEqual(this.d, rVar.d) && this.e == rVar.e && this.f == rVar.f;
    }

    public final int hashCode() {
        String str = this.a;
        return this.f.hashCode() + ((this.e.hashCode() + AbstractC1553e.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, (str == null ? 0 : str.hashCode()) * 31, 31), 31), 31)) * 31);
    }

    public final String toString() {
        return "CardInfo(first=" + this.a + ", last=" + this.b + ", expiryYear=" + this.c + ", expiryMonth=" + this.d + ", cardType=" + this.e + ", source=" + this.f + ")";
    }
}
