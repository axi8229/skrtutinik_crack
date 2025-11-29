package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes2.dex */
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new Parcelable.Creator<AppInfoTable>() { // from class: com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoTable createFromParcel(Parcel in) {
            return new AppInfoTable(in.readInt(), (String) Assertions.checkNotNull(in.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoTable[] newArray(int size) {
            return new AppInfoTable[size];
        }
    };
    public final int controlCode;
    public final String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppInfoTable(int controlCode, String url) {
        this.controlCode = controlCode;
        this.url = url;
    }

    public String toString() {
        return "Ait(controlCode=" + this.controlCode + ",url=" + this.url + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.controlCode);
    }
}
