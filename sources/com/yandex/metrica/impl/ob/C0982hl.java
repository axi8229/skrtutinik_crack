package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.yandex.metrica.impl.ob.hl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0982hl implements Parcelable {
    public static final Parcelable.Creator<C0982hl> CREATOR = new a();
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final List<C1420zl> p;

    /* renamed from: com.yandex.metrica.impl.ob.hl$a */
    class a implements Parcelable.Creator<C0982hl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public C0982hl createFromParcel(Parcel parcel) {
            return new C0982hl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C0982hl[] newArray(int i) {
            return new C0982hl[i];
        }
    }

    public C0982hl(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, int i2, int i3, int i4, int i5, List<C1420zl> list) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
        this.g = z7;
        this.h = z8;
        this.i = z9;
        this.j = z10;
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = i4;
        this.o = i5;
        this.p = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0982hl.class != obj.getClass()) {
            return false;
        }
        C0982hl c0982hl = (C0982hl) obj;
        if (this.a == c0982hl.a && this.b == c0982hl.b && this.c == c0982hl.c && this.d == c0982hl.d && this.e == c0982hl.e && this.f == c0982hl.f && this.g == c0982hl.g && this.h == c0982hl.h && this.i == c0982hl.i && this.j == c0982hl.j && this.k == c0982hl.k && this.l == c0982hl.l && this.m == c0982hl.m && this.n == c0982hl.n && this.o == c0982hl.o) {
            return this.p.equals(c0982hl.p);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0)) * 31) + (this.j ? 1 : 0)) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p.hashCode();
    }

    public String toString() {
        return "UiCollectingConfig{textSizeCollecting=" + this.a + ", relativeTextSizeCollecting=" + this.b + ", textVisibilityCollecting=" + this.c + ", textStyleCollecting=" + this.d + ", infoCollecting=" + this.e + ", nonContentViewCollecting=" + this.f + ", textLengthCollecting=" + this.g + ", viewHierarchical=" + this.h + ", ignoreFiltered=" + this.i + ", webViewUrlsCollecting=" + this.j + ", tooLongTextBound=" + this.k + ", truncatedTextBound=" + this.l + ", maxEntitiesCount=" + this.m + ", maxFullContentLength=" + this.n + ", webViewUrlLimit=" + this.o + ", filters=" + this.p + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeList(this.p);
    }

    protected C0982hl(Parcel parcel) {
        this.a = parcel.readByte() != 0;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        this.i = parcel.readByte() != 0;
        this.j = parcel.readByte() != 0;
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = parcel.readInt();
        this.o = parcel.readInt();
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, C1420zl.class.getClassLoader());
        this.p = arrayList;
    }
}
