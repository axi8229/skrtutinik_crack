package com.sputnik.data.entities.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataConfirmRequest.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b!\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\"\u0010\rR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/sputnik/data/entities/auth/DataConfirmRequest;", "Landroid/os/Parcelable;", "", "requestId", "authCode", "platform", "app", "phone", "", CrashHianalyticsData.TIME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getRequestId", "getAuthCode", "getPlatform", "getApp", "getPhone", "J", "getTime", "()J", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataConfirmRequest implements Parcelable {
    public static final Parcelable.Creator<DataConfirmRequest> CREATOR = new Creator();
    private final String app;

    @SerializedName("auth_code")
    private final String authCode;
    private final String phone;
    private final String platform;

    @SerializedName("request_id")
    private final String requestId;
    private final long time;

    /* compiled from: DataConfirmRequest.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataConfirmRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataConfirmRequest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataConfirmRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataConfirmRequest[] newArray(int i) {
            return new DataConfirmRequest[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataConfirmRequest)) {
            return false;
        }
        DataConfirmRequest dataConfirmRequest = (DataConfirmRequest) other;
        return Intrinsics.areEqual(this.requestId, dataConfirmRequest.requestId) && Intrinsics.areEqual(this.authCode, dataConfirmRequest.authCode) && Intrinsics.areEqual(this.platform, dataConfirmRequest.platform) && Intrinsics.areEqual(this.app, dataConfirmRequest.app) && Intrinsics.areEqual(this.phone, dataConfirmRequest.phone) && this.time == dataConfirmRequest.time;
    }

    public int hashCode() {
        String str = this.requestId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.authCode;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.platform;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.app;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.phone;
        return ((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + Long.hashCode(this.time);
    }

    public String toString() {
        return "DataConfirmRequest(requestId=" + this.requestId + ", authCode=" + this.authCode + ", platform=" + this.platform + ", app=" + this.app + ", phone=" + this.phone + ", time=" + this.time + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.requestId);
        parcel.writeString(this.authCode);
        parcel.writeString(this.platform);
        parcel.writeString(this.app);
        parcel.writeString(this.phone);
        parcel.writeLong(this.time);
    }

    public DataConfirmRequest(String str, String str2, String str3, String str4, String str5, long j) {
        this.requestId = str;
        this.authCode = str2;
        this.platform = str3;
        this.app = str4;
        this.phone = str5;
        this.time = j;
    }

    public /* synthetic */ DataConfirmRequest(String str, String str2, String str3, String str4, String str5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, (i & 32) != 0 ? System.currentTimeMillis() / 1000 : j);
    }
}
