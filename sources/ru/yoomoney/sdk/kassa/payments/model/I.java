package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class I extends AbstractC2335t {
    public static final Parcelable.Creator<I> CREATOR = new H();
    public final String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(String returnUrl) {
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
        return (obj instanceof I) && Intrinsics.areEqual(this.a, ((I) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "MobileApplication(returnUrl=" + this.a + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
    }
}
