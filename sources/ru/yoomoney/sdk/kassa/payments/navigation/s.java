package ru.yoomoney.sdk.kassa.payments.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class s implements Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new r();
    public final String a;

    public s(String panUnbindingCard) {
        Intrinsics.checkNotNullParameter(panUnbindingCard, "panUnbindingCard");
        this.a = panUnbindingCard;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s) && Intrinsics.areEqual(this.a, ((s) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Success(panUnbindingCard=" + this.a + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
    }
}
