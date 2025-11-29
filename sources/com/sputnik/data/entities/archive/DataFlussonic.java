package com.sputnik.data.entities.archive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFlussonic.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u000bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u000b¨\u0006!"}, d2 = {"Lcom/sputnik/data/entities/archive/DataFlussonic;", "Landroid/os/Parcelable;", "", "domain", "sdkUrl", "cameraUUID", "archiveToken", "deviceUUID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDomain", "getSdkUrl", "getCameraUUID", "getArchiveToken", "getDeviceUUID", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataFlussonic implements Parcelable {
    public static final Parcelable.Creator<DataFlussonic> CREATOR = new Creator();

    @SerializedName("archive_token")
    private final String archiveToken;

    @SerializedName("camera_uuid")
    private final String cameraUUID;

    @SerializedName("device_uuid")
    private final String deviceUUID;
    private final String domain;

    @SerializedName("sdk_url")
    private final String sdkUrl;

    /* compiled from: DataFlussonic.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataFlussonic> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFlussonic createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataFlussonic(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFlussonic[] newArray(int i) {
            return new DataFlussonic[i];
        }
    }

    public DataFlussonic() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataFlussonic)) {
            return false;
        }
        DataFlussonic dataFlussonic = (DataFlussonic) other;
        return Intrinsics.areEqual(this.domain, dataFlussonic.domain) && Intrinsics.areEqual(this.sdkUrl, dataFlussonic.sdkUrl) && Intrinsics.areEqual(this.cameraUUID, dataFlussonic.cameraUUID) && Intrinsics.areEqual(this.archiveToken, dataFlussonic.archiveToken) && Intrinsics.areEqual(this.deviceUUID, dataFlussonic.deviceUUID);
    }

    public int hashCode() {
        String str = this.domain;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sdkUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cameraUUID;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.archiveToken;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.deviceUUID;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "DataFlussonic(domain=" + this.domain + ", sdkUrl=" + this.sdkUrl + ", cameraUUID=" + this.cameraUUID + ", archiveToken=" + this.archiveToken + ", deviceUUID=" + this.deviceUUID + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.domain);
        parcel.writeString(this.sdkUrl);
        parcel.writeString(this.cameraUUID);
        parcel.writeString(this.archiveToken);
        parcel.writeString(this.deviceUUID);
    }

    public DataFlussonic(String str, String str2, String str3, String str4, String str5) {
        this.domain = str;
        this.sdkUrl = str2;
        this.cameraUUID = str3;
        this.archiveToken = str4;
        this.deviceUUID = str5;
    }

    public /* synthetic */ DataFlussonic(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getSdkUrl() {
        return this.sdkUrl;
    }

    public final String getCameraUUID() {
        return this.cameraUUID;
    }

    public final String getArchiveToken() {
        return this.archiveToken;
    }

    public final String getDeviceUUID() {
        return this.deviceUUID;
    }
}
