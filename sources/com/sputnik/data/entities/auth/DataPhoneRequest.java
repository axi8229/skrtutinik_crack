package com.sputnik.data.entities.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataPhoneRequest.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\tR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/sputnik/data/entities/auth/DataPhoneRequest;", "Landroid/os/Parcelable;", "", CrashHianalyticsData.MESSAGE, "limitExpiresAt", "smsCodeExpiresAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMessage", "getLimitExpiresAt", "getSmsCodeExpiresAt", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataPhoneRequest implements Parcelable {
    public static final Parcelable.Creator<DataPhoneRequest> CREATOR = new Creator();

    @SerializedName("limit_expires_at")
    private final String limitExpiresAt;
    private final String message;

    @SerializedName("sms_code_expires")
    private final String smsCodeExpiresAt;

    /* compiled from: DataPhoneRequest.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataPhoneRequest> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPhoneRequest createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataPhoneRequest(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataPhoneRequest[] newArray(int i) {
            return new DataPhoneRequest[i];
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
        if (!(other instanceof DataPhoneRequest)) {
            return false;
        }
        DataPhoneRequest dataPhoneRequest = (DataPhoneRequest) other;
        return Intrinsics.areEqual(this.message, dataPhoneRequest.message) && Intrinsics.areEqual(this.limitExpiresAt, dataPhoneRequest.limitExpiresAt) && Intrinsics.areEqual(this.smsCodeExpiresAt, dataPhoneRequest.smsCodeExpiresAt);
    }

    public int hashCode() {
        String str = this.message;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.limitExpiresAt;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.smsCodeExpiresAt;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DataPhoneRequest(message=" + this.message + ", limitExpiresAt=" + this.limitExpiresAt + ", smsCodeExpiresAt=" + this.smsCodeExpiresAt + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.message);
        parcel.writeString(this.limitExpiresAt);
        parcel.writeString(this.smsCodeExpiresAt);
    }

    public DataPhoneRequest(String str, String str2, String str3) {
        this.message = str;
        this.limitExpiresAt = str2;
        this.smsCodeExpiresAt = str3;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getLimitExpiresAt() {
        return this.limitExpiresAt;
    }

    public final String getSmsCodeExpiresAt() {
        return this.smsCodeExpiresAt;
    }
}
