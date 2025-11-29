package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.yandex.metrica.impl.ob.ra, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1217ra implements Parcelable {
    public static final Parcelable.Creator<C1217ra> CREATOR = new a();
    public final C1194qa a;
    public final C1194qa b;
    public final C1194qa c;

    /* renamed from: com.yandex.metrica.impl.ob.ra$a */
    class a implements Parcelable.Creator<C1217ra> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public C1217ra createFromParcel(Parcel parcel) {
            return new C1217ra(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C1217ra[] newArray(int i) {
            return new C1217ra[i];
        }
    }

    public C1217ra() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DiagnosticsConfigsHolder{activationConfig=" + this.a + ", clidsInfoConfig=" + this.b + ", preloadInfoConfig=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }

    public C1217ra(C1194qa c1194qa, C1194qa c1194qa2, C1194qa c1194qa3) {
        this.a = c1194qa;
        this.b = c1194qa2;
        this.c = c1194qa3;
    }

    protected C1217ra(Parcel parcel) {
        this.a = (C1194qa) parcel.readParcelable(C1194qa.class.getClassLoader());
        this.b = (C1194qa) parcel.readParcelable(C1194qa.class.getClassLoader());
        this.c = (C1194qa) parcel.readParcelable(C1194qa.class.getClassLoader());
    }
}
