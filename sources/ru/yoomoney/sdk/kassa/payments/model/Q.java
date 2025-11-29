package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class Q implements Parcelable {
    public static final Parcelable.Creator<Q> CREATOR = new P();
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final EnumC2333q e;
    public final String f;

    public Q(String paymentInstrumentId, String last4, String first6, boolean z, EnumC2333q cardType) {
        Intrinsics.checkNotNullParameter(paymentInstrumentId, "paymentInstrumentId");
        Intrinsics.checkNotNullParameter(last4, "last4");
        Intrinsics.checkNotNullParameter(first6, "first6");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        this.a = paymentInstrumentId;
        this.b = last4;
        this.c = first6;
        this.d = z;
        this.e = cardType;
        this.f = first6 + "••••••" + last4;
    }

    public final String a() {
        return this.f;
    }

    public final EnumC2333q b() {
        return this.e;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q = (Q) obj;
        return Intrinsics.areEqual(this.a, q.a) && Intrinsics.areEqual(this.b, q.b) && Intrinsics.areEqual(this.c, q.c) && this.d == q.d && this.e == q.e;
    }

    public final int hashCode() {
        return this.e.hashCode() + ru.yoomoney.sdk.kassa.payments.api.model.packageoptions.a.a(this.d, AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31), 31);
    }

    public final String toString() {
        return "PaymentInstrumentBankCard(paymentInstrumentId=" + this.a + ", last4=" + this.b + ", first6=" + this.c + ", cscRequired=" + this.d + ", cardType=" + this.e + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
        out.writeString(this.b);
        out.writeString(this.c);
        out.writeInt(this.d ? 1 : 0);
        out.writeString(this.e.name());
    }
}
