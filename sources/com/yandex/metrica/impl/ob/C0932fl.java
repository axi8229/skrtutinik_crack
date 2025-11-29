package com.yandex.metrica.impl.ob;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.yandex.metrica.impl.ob.fl, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0932fl implements Parcelable {
    public static final Parcelable.Creator<C0932fl> CREATOR = new a();
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final C1348wl e;
    public final C0982hl f;
    public final C0982hl g;
    public final C0982hl h;

    /* renamed from: com.yandex.metrica.impl.ob.fl$a */
    class a implements Parcelable.Creator<C0932fl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public C0932fl createFromParcel(Parcel parcel) {
            return new C0932fl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public C0932fl[] newArray(int i) {
            return new C0932fl[i];
        }
    }

    public C0932fl(C1178pi c1178pi) {
        this(c1178pi.f().j, c1178pi.f().l, c1178pi.f().k, c1178pi.f().m, c1178pi.T(), c1178pi.S(), c1178pi.R(), c1178pi.U());
    }

    public boolean a() {
        return (this.e == null || this.f == null || this.g == null || this.h == null) ? false : true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0932fl.class != obj.getClass()) {
            return false;
        }
        C0932fl c0932fl = (C0932fl) obj;
        if (this.a != c0932fl.a || this.b != c0932fl.b || this.c != c0932fl.c || this.d != c0932fl.d) {
            return false;
        }
        C1348wl c1348wl = this.e;
        if (c1348wl == null ? c0932fl.e != null : !c1348wl.equals(c0932fl.e)) {
            return false;
        }
        C0982hl c0982hl = this.f;
        if (c0982hl == null ? c0932fl.f != null : !c0982hl.equals(c0932fl.f)) {
            return false;
        }
        C0982hl c0982hl2 = this.g;
        if (c0982hl2 == null ? c0932fl.g != null : !c0982hl2.equals(c0932fl.g)) {
            return false;
        }
        C0982hl c0982hl3 = this.h;
        return c0982hl3 != null ? c0982hl3.equals(c0932fl.h) : c0932fl.h == null;
    }

    public int hashCode() {
        int i = (((((((this.a ? 1 : 0) * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31;
        C1348wl c1348wl = this.e;
        int iHashCode = (i + (c1348wl != null ? c1348wl.hashCode() : 0)) * 31;
        C0982hl c0982hl = this.f;
        int iHashCode2 = (iHashCode + (c0982hl != null ? c0982hl.hashCode() : 0)) * 31;
        C0982hl c0982hl2 = this.g;
        int iHashCode3 = (iHashCode2 + (c0982hl2 != null ? c0982hl2.hashCode() : 0)) * 31;
        C0982hl c0982hl3 = this.h;
        return iHashCode3 + (c0982hl3 != null ? c0982hl3.hashCode() : 0);
    }

    public String toString() {
        return "UiAccessConfig{uiParsingEnabled=" + this.a + ", uiEventSendingEnabled=" + this.b + ", uiCollectingForBridgeEnabled=" + this.c + ", uiRawEventSendingEnabled=" + this.d + ", uiParsingConfig=" + this.e + ", uiEventSendingConfig=" + this.f + ", uiCollectingForBridgeConfig=" + this.g + ", uiRawEventSendingConfig=" + this.h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
        parcel.writeParcelable(this.h, i);
    }

    public C0932fl(boolean z, boolean z2, boolean z3, boolean z4, C1348wl c1348wl, C0982hl c0982hl, C0982hl c0982hl2, C0982hl c0982hl3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = c1348wl;
        this.f = c0982hl;
        this.g = c0982hl2;
        this.h = c0982hl3;
    }

    protected C0932fl(Parcel parcel) {
        this.a = parcel.readByte() != 0;
        this.b = parcel.readByte() != 0;
        this.c = parcel.readByte() != 0;
        this.d = parcel.readByte() != 0;
        this.e = (C1348wl) parcel.readParcelable(C1348wl.class.getClassLoader());
        this.f = (C0982hl) parcel.readParcelable(C0982hl.class.getClassLoader());
        this.g = (C0982hl) parcel.readParcelable(C0982hl.class.getClassLoader());
        this.h = (C0982hl) parcel.readParcelable(C0982hl.class.getClassLoader());
    }
}
