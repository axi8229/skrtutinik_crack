package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.yandex.metrica.impl.ob.zl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1420zl implements Parcelable {
    public static final Parcelable.Creator<C1420zl> CREATOR = new a();
    public final b a;
    public final String b;

    /* renamed from: com.yandex.metrica.impl.ob.zl$a */
    class a implements Parcelable.Creator<C1420zl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public C1420zl createFromParcel(Parcel parcel) {
            return new C1420zl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C1420zl[] newArray(int i) {
            return new C1420zl[i];
        }
    }

    /* renamed from: com.yandex.metrica.impl.ob.zl$b */
    public enum b {
        EQUALS(0),
        CONTAINS(1),
        MATCHES(2),
        DOES_NOT_MATCH(3);

        public final int a;

        b(int i) {
            this.a = i;
        }

        public static b a(int i) {
            b[] bVarArrValues = values();
            for (int i2 = 0; i2 < 4; i2++) {
                b bVar = bVarArrValues[i2];
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return EQUALS;
        }
    }

    public C1420zl(b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1420zl.class != obj.getClass()) {
            return false;
        }
        C1420zl c1420zl = (C1420zl) obj;
        if (this.a != c1420zl.a) {
            return false;
        }
        return this.b.equals(c1420zl.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "UiParsingFilter{type=" + this.a + ", value='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.a);
        parcel.writeString(this.b);
    }

    protected C1420zl(Parcel parcel) {
        this.a = b.a(parcel.readInt());
        this.b = (String) Tl.a(parcel.readString(), "");
    }
}
