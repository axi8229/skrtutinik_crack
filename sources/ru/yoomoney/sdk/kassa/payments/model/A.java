package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount;

/* loaded from: classes5.dex */
public final class A implements Parcelable {
    public static final Parcelable.Creator<A> CREATOR = new C2341z();
    public final Amount a;
    public final Amount b;

    public A(Amount amount, Amount amount2) {
        this.a = amount;
        this.b = amount2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
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
        Amount amount = this.a;
        int iHashCode = (amount == null ? 0 : amount.hashCode()) * 31;
        Amount amount2 = this.b;
        return iHashCode + (amount2 != null ? amount2.hashCode() : 0);
    }

    public final String toString() {
        return "Fee(service=" + this.a + ", counterparty=" + this.b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        Amount amount = this.a;
        if (amount == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            amount.writeToParcel(out, i);
        }
        Amount amount2 = this.b;
        if (amount2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            amount2.writeToParcel(out, i);
        }
    }
}
