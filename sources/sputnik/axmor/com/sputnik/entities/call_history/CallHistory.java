package sputnik.axmor.com.sputnik.entities.call_history;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.sputnik.domain.entities.call.CallState;
import flussonic.media.FFmpegMediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallHistory.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014Jª\u0001\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0018R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b.\u0010\u0018R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b/\u0010\u0018R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b0\u0010\u0018R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b1\u0010\u0018R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b2\u0010\u0018R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\b4\u00105R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010'\u001a\u0004\b6\u0010\u0018R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b7\u0010\u0018R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b=\u0010:¨\u0006>"}, d2 = {"Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;", "Landroid/os/Parcelable;", "", "imageUrl", "videoUrl", "flatUUID", "Lcom/sputnik/domain/entities/call/CallState;", "state", "address", FailedBinderCallBack.CALLER_ID, "creationDate", CrashHianalyticsData.TIME, FFmpegMediaMetadataRetriever.METADATA_KEY_DATE, "", "compareDate", "deviceUuid", "rawDateTime", "", "hasArchive", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Z)V", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/call/CallState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Z)Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getImageUrl", "getVideoUrl", "getFlatUUID", "Lcom/sputnik/domain/entities/call/CallState;", "getState", "()Lcom/sputnik/domain/entities/call/CallState;", "getAddress", "getCallId", "getCreationDate", "getTime", "getDate", "Ljava/lang/Long;", "getCompareDate", "()Ljava/lang/Long;", "getDeviceUuid", "getRawDateTime", "Z", "getHasArchive", "()Z", "setHasArchive", "(Z)V", "isCallDeclined", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CallHistory implements Parcelable {
    public static final Parcelable.Creator<CallHistory> CREATOR = new Creator();
    private final String address;
    private final String callId;
    private final Long compareDate;
    private final String creationDate;
    private final String date;
    private final String deviceUuid;
    private final String flatUUID;
    private boolean hasArchive;
    private final String imageUrl;
    private final String rawDateTime;
    private final CallState state;
    private final String time;
    private final String videoUrl;

    /* compiled from: CallHistory.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CallHistory> {
        @Override // android.os.Parcelable.Creator
        public final CallHistory createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CallHistory(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : CallState.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final CallHistory[] newArray(int i) {
            return new CallHistory[i];
        }
    }

    public CallHistory() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, 8191, null);
    }

    public final CallHistory copy(String imageUrl, String videoUrl, String flatUUID, CallState state, String address, String callId, String creationDate, String time, String date, Long compareDate, String deviceUuid, String rawDateTime, boolean hasArchive) {
        return new CallHistory(imageUrl, videoUrl, flatUUID, state, address, callId, creationDate, time, date, compareDate, deviceUuid, rawDateTime, hasArchive);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallHistory)) {
            return false;
        }
        CallHistory callHistory = (CallHistory) other;
        return Intrinsics.areEqual(this.imageUrl, callHistory.imageUrl) && Intrinsics.areEqual(this.videoUrl, callHistory.videoUrl) && Intrinsics.areEqual(this.flatUUID, callHistory.flatUUID) && this.state == callHistory.state && Intrinsics.areEqual(this.address, callHistory.address) && Intrinsics.areEqual(this.callId, callHistory.callId) && Intrinsics.areEqual(this.creationDate, callHistory.creationDate) && Intrinsics.areEqual(this.time, callHistory.time) && Intrinsics.areEqual(this.date, callHistory.date) && Intrinsics.areEqual(this.compareDate, callHistory.compareDate) && Intrinsics.areEqual(this.deviceUuid, callHistory.deviceUuid) && Intrinsics.areEqual(this.rawDateTime, callHistory.rawDateTime) && this.hasArchive == callHistory.hasArchive;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.imageUrl;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.videoUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.flatUUID;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        CallState callState = this.state;
        int iHashCode4 = (iHashCode3 + (callState == null ? 0 : callState.hashCode())) * 31;
        String str4 = this.address;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.callId;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.creationDate;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.time;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.date;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l = this.compareDate;
        int iHashCode10 = (iHashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        String str9 = this.deviceUuid;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.rawDateTime;
        int iHashCode12 = (iHashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        boolean z = this.hasArchive;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return iHashCode12 + i;
    }

    public String toString() {
        return "CallHistory(imageUrl=" + this.imageUrl + ", videoUrl=" + this.videoUrl + ", flatUUID=" + this.flatUUID + ", state=" + this.state + ", address=" + this.address + ", callId=" + this.callId + ", creationDate=" + this.creationDate + ", time=" + this.time + ", date=" + this.date + ", compareDate=" + this.compareDate + ", deviceUuid=" + this.deviceUuid + ", rawDateTime=" + this.rawDateTime + ", hasArchive=" + this.hasArchive + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
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
        parcel.writeString(this.creationDate);
        parcel.writeString(this.time);
        parcel.writeString(this.date);
        Long l = this.compareDate;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeString(this.deviceUuid);
        parcel.writeString(this.rawDateTime);
        parcel.writeInt(this.hasArchive ? 1 : 0);
    }

    public CallHistory(String str, String str2, String str3, CallState callState, String str4, String str5, String str6, String str7, String str8, Long l, String str9, String str10, boolean z) {
        this.imageUrl = str;
        this.videoUrl = str2;
        this.flatUUID = str3;
        this.state = callState;
        this.address = str4;
        this.callId = str5;
        this.creationDate = str6;
        this.time = str7;
        this.date = str8;
        this.compareDate = l;
        this.deviceUuid = str9;
        this.rawDateTime = str10;
        this.hasArchive = z;
    }

    public /* synthetic */ CallHistory(String str, String str2, String str3, CallState callState, String str4, String str5, String str6, String str7, String str8, Long l, String str9, String str10, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : callState, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : l, (i & 1024) != 0 ? null : str9, (i & 2048) == 0 ? str10 : null, (i & 4096) != 0 ? false : z);
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
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

    public final String getCreationDate() {
        return this.creationDate;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getDate() {
        return this.date;
    }

    public final Long getCompareDate() {
        return this.compareDate;
    }

    public final String getDeviceUuid() {
        return this.deviceUuid;
    }

    public final String getRawDateTime() {
        return this.rawDateTime;
    }

    public final boolean getHasArchive() {
        return this.hasArchive;
    }

    public final void setHasArchive(boolean z) {
        this.hasArchive = z;
    }

    public final boolean isCallDeclined() {
        return this.state == CallState.declined;
    }
}
