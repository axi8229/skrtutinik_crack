package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class G extends U {
    public static final Parcelable.Creator<G> CREATOR = new F();
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public G(String csc) {
        super(0);
        Intrinsics.checkNotNullParameter(csc, "csc");
        this.a = csc;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof G) && Intrinsics.areEqual(this.a, ((G) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "LinkedCardInfo(csc='***')";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
    }
}
