package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class w0 extends U {
    public static final Parcelable.Creator<w0> CREATOR = new v0();

    public w0() {
        super(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof w0);
    }

    public final int hashCode() {
        return w0.class.hashCode();
    }

    public final String toString() {
        return "WalletInfo()";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(1);
    }
}
