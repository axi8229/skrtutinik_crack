package com.sputnik.data.entities.call_history;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.domain.entities.call.CallState;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCallHistory.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b!\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b\"\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b#\u0010\u000fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b'\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b(\u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b)\u0010\u000f¨\u0006*"}, d2 = {"Lcom/sputnik/data/entities/call_history/DataCallHistory;", "Landroid/os/Parcelable;", "", "createdAt", "imageUrl", "videoUrl", "flatUUID", "Lcom/sputnik/domain/entities/call/CallState;", "state", "address", FailedBinderCallBack.CALLER_ID, "deviceUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getCreatedAt", "getImageUrl", "getVideoUrl", "getFlatUUID", "Lcom/sputnik/domain/entities/call/CallState;", "getState", "()Lcom/sputnik/domain/entities/call/CallState;", "getAddress", "getCallId", "getDeviceUuid", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataCallHistory implements Parcelable {
    public static final Parcelable.Creator<DataCallHistory> CREATOR = new Creator();
    private final String address;

    @SerializedName("call_id")
    private final String callId;

    @SerializedName("started_at")
    private final String createdAt;

    @SerializedName("device_uuid")
    private final String deviceUuid;

    @SerializedName("flat_uuid")
    private final String flatUUID;

    @SerializedName("image_url")
    private final String imageUrl;
    private final CallState state;

    @SerializedName("video_url")
    private final String videoUrl;

    /* compiled from: DataCallHistory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataCallHistory> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCallHistory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataCallHistory(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : CallState.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataCallHistory[] newArray(int i) {
            return new DataCallHistory[i];
        }
    }

    public DataCallHistory() {
        this(null, null, null, null, null, null, null, null, KotlinVersion.MAX_COMPONENT_VALUE, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCallHistory)) {
            return false;
        }
        DataCallHistory dataCallHistory = (DataCallHistory) other;
        return Intrinsics.areEqual(this.createdAt, dataCallHistory.createdAt) && Intrinsics.areEqual(this.imageUrl, dataCallHistory.imageUrl) && Intrinsics.areEqual(this.videoUrl, dataCallHistory.videoUrl) && Intrinsics.areEqual(this.flatUUID, dataCallHistory.flatUUID) && this.state == dataCallHistory.state && Intrinsics.areEqual(this.address, dataCallHistory.address) && Intrinsics.areEqual(this.callId, dataCallHistory.callId) && Intrinsics.areEqual(this.deviceUuid, dataCallHistory.deviceUuid);
    }

    public int hashCode() {
        String str = this.createdAt;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.videoUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.flatUUID;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        CallState callState = this.state;
        int iHashCode5 = (iHashCode4 + (callState == null ? 0 : callState.hashCode())) * 31;
        String str5 = this.address;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.callId;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.deviceUuid;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "DataCallHistory(createdAt=" + this.createdAt + ", imageUrl=" + this.imageUrl + ", videoUrl=" + this.videoUrl + ", flatUUID=" + this.flatUUID + ", state=" + this.state + ", address=" + this.address + ", callId=" + this.callId + ", deviceUuid=" + this.deviceUuid + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.createdAt);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.flatUUID);
        CallState callState = this.state;
        if (callState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(callState.name());
        }
        parcel.writeString(this.address);
        parcel.writeString(this.callId);
        parcel.writeString(this.deviceUuid);
    }

    public DataCallHistory(String str, String str2, String str3, String str4, CallState callState, String str5, String str6, String str7) {
        this.createdAt = str;
        this.imageUrl = str2;
        this.videoUrl = str3;
        this.flatUUID = str4;
        this.state = callState;
        this.address = str5;
        this.callId = str6;
        this.deviceUuid = str7;
    }

    public /* synthetic */ DataCallHistory(String str, String str2, String str3, String str4, CallState callState, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : callState, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null);
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getFlatUUID() {
        return this.flatUUID;
    }

    public final CallState getState() {
        return this.state;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final String getDeviceUuid() {
        return this.deviceUuid;
    }
}
