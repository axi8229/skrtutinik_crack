package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a0 extends AbstractC2335t {
    public static final Parcelable.Creator<a0> CREATOR = new Z();
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(String returnUrl) {
        super(0);
        Intrinsics.checkNotNullParameter(returnUrl, "returnUrl");
        this.a = returnUrl;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && Intrinsics.areEqual(this.a, ((a0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RedirectConfirmation(returnUrl=" + this.a + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
    }
}
