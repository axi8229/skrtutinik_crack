package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class n0 extends U {
    public static final Parcelable.Creator<n0> CREATOR = new m0();
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(String phone) {
        super(0);
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.a = phone;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n0) && Intrinsics.areEqual(this.a, ((n0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "SbolSmsInvoicingInfo(phone=" + this.a + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
    }
}
