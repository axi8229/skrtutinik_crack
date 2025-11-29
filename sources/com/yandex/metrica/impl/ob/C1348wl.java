package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.wl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1348wl implements Parcelable {
    public static final Parcelable.Creator<C1348wl> CREATOR = new a();
    public final int a;
    public final int b;
    public final int c;
    public final long d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final List<C1420zl> h;

    /* renamed from: com.yandex.metrica.impl.ob.wl$a */
    class a implements Parcelable.Creator<C1348wl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public C1348wl createFromParcel(Parcel parcel) {
            return new C1348wl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C1348wl[] newArray(int i) {
            return new C1348wl[i];
        }
    }

    public C1348wl(int i, int i2, int i3, long j, boolean z, boolean z2, boolean z3, List<C1420zl> list) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = j;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1348wl.class != obj.getClass()) {
            return false;
        }
        C1348wl c1348wl = (C1348wl) obj;
        if (this.a == c1348wl.a && this.b == c1348wl.b && this.c == c1348wl.c && this.d == c1348wl.d && this.e == c1348wl.e && this.f == c1348wl.f && this.g == c1348wl.g) {
            return this.h.equals(c1348wl.h);
        }
        return false;
    }

    public int hashCode() {
        int i = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        long j = this.d;
        return ((((((((i + ((int) (j ^ (j >>> 32)))) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "UiParsingConfig{tooLongTextBound=" + this.a + ", truncatedTextBound=" + this.b + ", maxVisitedChildrenInLevel=" + this.c + ", afterCreateTimeout=" + this.d + ", relativeTextSizeCalculation=" + this.e + ", errorReporting=" + this.f + ", parsingAllowedByDefault=" + this.g + ", filters=" + this.h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeList(this.h);
    }

    protected C1348wl(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, C1420zl.class.getClassLoader());
        this.h = arrayList;
    }
}
