package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class D extends U {
    public static final Parcelable.Creator<D> CREATOR = new C();
    public final String a;
    public final String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(String paymentMethodToken, String googleTransactionId) {
        super(0);
        Intrinsics.checkNotNullParameter(paymentMethodToken, "paymentMethodToken");
        Intrinsics.checkNotNullParameter(googleTransactionId, "googleTransactionId");
        this.a = paymentMethodToken;
        this.b = googleTransactionId;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof D)) {
            return false;
        }
        D d = (D) obj;
        return Intrinsics.areEqual(this.a, d.a) && Intrinsics.areEqual(this.b, d.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "GooglePayInfo(paymentMethodToken=" + this.a + ", googleTransactionId=" + this.b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
        out.writeString(this.b);
    }
}
