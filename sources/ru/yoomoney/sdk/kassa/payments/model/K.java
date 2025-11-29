package ru.yoomoney.sdk.kassa.payments.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import npi.spay.AbstractC1553e;

/* loaded from: classes5.dex */
public final class K extends U {
    public static final Parcelable.Creator<K> CREATOR = new J();
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(String number, String expirationMonth, String expirationYear, String csc) {
        super(0);
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(expirationMonth, "expirationMonth");
        Intrinsics.checkNotNullParameter(expirationYear, "expirationYear");
        Intrinsics.checkNotNullParameter(csc, "csc");
        this.a = number;
        this.b = expirationMonth;
        this.c = expirationYear;
        this.d = csc;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K)) {
            return false;
        }
        K k = (K) obj;
        return Intrinsics.areEqual(this.a, k.a) && Intrinsics.areEqual(this.b, k.b) && Intrinsics.areEqual(this.c, k.c) && Intrinsics.areEqual(this.d, k.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + AbstractC1553e.a(this.c, AbstractC1553e.a(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        return "NewCardInfo(number='**** **** **** " + StringsKt.takeLast(this.a, 4) + "', expirationMonth='**', expirationYear='**', csc='***')";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel out, int i) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.a);
        out.writeString(this.b);
        out.writeString(this.c);
        out.writeString(this.d);
    }
}
