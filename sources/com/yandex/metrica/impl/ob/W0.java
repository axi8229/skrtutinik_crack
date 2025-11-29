package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class W0 implements Parcelable {
    public static final Parcelable.Creator<W0> CREATOR = new a();
    public final String a;
    public final U0 b;
    public final String c;

    class a implements Parcelable.Creator<W0> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public W0 createFromParcel(Parcel parcel) {
            return new W0(parcel.readString(), U0.a(parcel.readString()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public W0[] newArray(int i) {
            return new W0[i];
        }
    }

    public W0(String str, U0 u0, String str2) {
        this.a = str;
        this.b = u0;
        this.c = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || W0.class != obj.getClass()) {
            return false;
        }
        W0 w0 = (W0) obj;
        String str = this.a;
        if (str == null ? w0.a != null : !str.equals(w0.a)) {
            return false;
        }
        if (this.b != w0.b) {
            return false;
        }
        String str2 = this.c;
        return str2 != null ? str2.equals(w0.c) : w0.c == null;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b.hashCode()) * 31;
        String str2 = this.c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "IdentifiersResultInternal{mId='" + this.a + "', mStatus=" + this.b + ", mErrorExplanation='" + this.c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b.a());
        parcel.writeString(this.c);
    }
}
