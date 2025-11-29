package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class Xh implements Parcelable {
    public static final a CREATOR = new a(null);
    private final Boolean a;
    private final U0 b;
    private final String c;

    public static final class a implements Parcelable.Creator<Xh> {
        private a() {
        }

        @Override // android.os.Parcelable.Creator
        public Xh createFromParcel(Parcel parcel) {
            Object value = parcel.readValue(Boolean.TYPE.getClassLoader());
            if (!(value instanceof Boolean)) {
                value = null;
            }
            U0 u0A = U0.a(parcel.readString());
            Intrinsics.checkNotNullExpressionValue(u0A, "IdentifierStatus.from(parcel.readString())");
            return new Xh((Boolean) value, u0A, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public Xh[] newArray(int i) {
            return new Xh[i];
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Xh(Boolean bool, U0 u0, String str) {
        this.a = bool;
        this.b = u0;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final Boolean b() {
        return this.a;
    }

    public final U0 c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Xh)) {
            return false;
        }
        Xh xh = (Xh) obj;
        return Intrinsics.areEqual(this.a, xh.a) && Intrinsics.areEqual(this.b, xh.b) && Intrinsics.areEqual(this.c, xh.c);
    }

    public int hashCode() {
        Boolean bool = this.a;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        U0 u0 = this.b;
        int iHashCode2 = (iHashCode + (u0 != null ? u0.hashCode() : 0)) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "FeaturesInternal(sslPinning=" + this.a + ", status=" + this.b + ", errorExplanation=" + this.c + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.a);
        parcel.writeString(this.b.a());
        parcel.writeString(this.c);
    }

    public Xh() {
        this(null, U0.UNKNOWN, null);
    }
}
