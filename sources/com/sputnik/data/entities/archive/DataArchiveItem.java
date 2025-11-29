package com.sputnik.data.entities.archive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataArchiveItem.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b!\u0010\fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\"\u0010\f¨\u0006#"}, d2 = {"Lcom/sputnik/data/entities/archive/DataArchiveItem;", "Landroid/os/Parcelable;", "", "cameraUUID", "deviceUUID", "playerUrl", "domain", "sdkUrl", "archiveToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCameraUUID", "getDeviceUUID", "getPlayerUrl", "getDomain", "getSdkUrl", "getArchiveToken", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataArchiveItem implements Parcelable {
    public static final Parcelable.Creator<DataArchiveItem> CREATOR = new Creator();

    @SerializedName("archive_token")
    private final String archiveToken;

    @SerializedName("camera_uuid")
    private final String cameraUUID;

    @SerializedName("device_uuid")
    private final String deviceUUID;
    private final String domain;

    @SerializedName("player_url")
    private final String playerUrl;

    @SerializedName("sdk_url")
    private final String sdkUrl;

    /* compiled from: DataArchiveItem.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataArchiveItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataArchiveItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataArchiveItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataArchiveItem[] newArray(int i) {
            return new DataArchiveItem[i];
        }
    }

    public DataArchiveItem() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataArchiveItem)) {
            return false;
        }
        DataArchiveItem dataArchiveItem = (DataArchiveItem) other;
        return Intrinsics.areEqual(this.cameraUUID, dataArchiveItem.cameraUUID) && Intrinsics.areEqual(this.deviceUUID, dataArchiveItem.deviceUUID) && Intrinsics.areEqual(this.playerUrl, dataArchiveItem.playerUrl) && Intrinsics.areEqual(this.domain, dataArchiveItem.domain) && Intrinsics.areEqual(this.sdkUrl, dataArchiveItem.sdkUrl) && Intrinsics.areEqual(this.archiveToken, dataArchiveItem.archiveToken);
    }

    public int hashCode() {
        String str = this.cameraUUID;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceUUID;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.playerUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.domain;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.sdkUrl;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.archiveToken;
        return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DataArchiveItem(cameraUUID=" + this.cameraUUID + ", deviceUUID=" + this.deviceUUID + ", playerUrl=" + this.playerUrl + ", domain=" + this.domain + ", sdkUrl=" + this.sdkUrl + ", archiveToken=" + this.archiveToken + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.cameraUUID);
        parcel.writeString(this.deviceUUID);
        parcel.writeString(this.playerUrl);
        parcel.writeString(this.domain);
        parcel.writeString(this.sdkUrl);
        parcel.writeString(this.archiveToken);
    }

    public DataArchiveItem(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cameraUUID = str;
        this.deviceUUID = str2;
        this.playerUrl = str3;
        this.domain = str4;
        this.sdkUrl = str5;
        this.archiveToken = str6;
    }

    public /* synthetic */ DataArchiveItem(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    public final String getCameraUUID() {
        return this.cameraUUID;
    }

    public final String getDeviceUUID() {
        return this.deviceUUID;
    }

    public final String getPlayerUrl() {
        return this.playerUrl;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getSdkUrl() {
        return this.sdkUrl;
    }

    public final String getArchiveToken() {
        return this.archiveToken;
    }
}
