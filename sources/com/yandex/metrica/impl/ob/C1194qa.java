package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.yandex.metrica.impl.ob.qa, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1194qa implements Parcelable {
    public static final Parcelable.Creator<C1194qa> CREATOR = new a();
    public final long a;
    public final int b;

    /* renamed from: com.yandex.metrica.impl.ob.qa$a */
    class a implements Parcelable.Creator<C1194qa> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public C1194qa createFromParcel(Parcel parcel) {
            return new C1194qa(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C1194qa[] newArray(int i) {
            return new C1194qa[i];
        }
    }

    public C1194qa(long j, int i) {
        this.a = j;
        this.b = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DiagnosticsConfig{expirationTimestampSeconds=" + this.a + ", intervalSeconds=" + this.b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.a);
        parcel.writeInt(this.b);
    }

    protected C1194qa(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readInt();
    }
}
