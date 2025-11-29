package com.sputnik.data.entities.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.auth.RegistrationState;
import com.sputnik.domain.entities.auth.RegistrationWay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataRequestInfo.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\rR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b%\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b&\u0010\r¨\u0006'"}, d2 = {"Lcom/sputnik/data/entities/auth/DataRequestInfo;", "Landroid/os/Parcelable;", "", "phone", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "state", "expiresAt", "requestId", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/auth/RegistrationWay;Lcom/sputnik/domain/entities/auth/RegistrationState;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getPhone", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "getWay", "()Lcom/sputnik/domain/entities/auth/RegistrationWay;", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "getState", "()Lcom/sputnik/domain/entities/auth/RegistrationState;", "getExpiresAt", "getRequestId", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataRequestInfo implements Parcelable {
    public static final Parcelable.Creator<DataRequestInfo> CREATOR = new Creator();

    @SerializedName("expires_at")
    private final String expiresAt;
    private final String phone;

    @SerializedName("request_id")
    private final String requestId;
    private final RegistrationState state;
    private final RegistrationWay way;

    /* compiled from: DataRequestInfo.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataRequestInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataRequestInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataRequestInfo(parcel.readString(), parcel.readInt() == 0 ? null : RegistrationWay.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : RegistrationState.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataRequestInfo[] newArray(int i) {
            return new DataRequestInfo[i];
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
        if (!(other instanceof DataRequestInfo)) {
            return false;
        }
        DataRequestInfo dataRequestInfo = (DataRequestInfo) other;
        return Intrinsics.areEqual(this.phone, dataRequestInfo.phone) && this.way == dataRequestInfo.way && this.state == dataRequestInfo.state && Intrinsics.areEqual(this.expiresAt, dataRequestInfo.expiresAt) && Intrinsics.areEqual(this.requestId, dataRequestInfo.requestId);
    }

    public int hashCode() {
        String str = this.phone;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        RegistrationWay registrationWay = this.way;
        int iHashCode2 = (iHashCode + (registrationWay == null ? 0 : registrationWay.hashCode())) * 31;
        RegistrationState registrationState = this.state;
        int iHashCode3 = (iHashCode2 + (registrationState == null ? 0 : registrationState.hashCode())) * 31;
        String str2 = this.expiresAt;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestId;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DataRequestInfo(phone=" + this.phone + ", way=" + this.way + ", state=" + this.state + ", expiresAt=" + this.expiresAt + ", requestId=" + this.requestId + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.phone);
        RegistrationWay registrationWay = this.way;
        if (registrationWay == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(registrationWay.name());
        }
        RegistrationState registrationState = this.state;
        if (registrationState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(registrationState.name());
        }
        parcel.writeString(this.expiresAt);
        parcel.writeString(this.requestId);
    }

    public DataRequestInfo(String str, RegistrationWay registrationWay, RegistrationState registrationState, String str2, String str3) {
        this.phone = str;
        this.way = registrationWay;
        this.state = registrationState;
        this.expiresAt = str2;
        this.requestId = str3;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final RegistrationWay getWay() {
        return this.way;
    }

    public final RegistrationState getState() {
        return this.state;
    }

    public final String getExpiresAt() {
        return this.expiresAt;
    }

    public final String getRequestId() {
        return this.requestId;
    }
}
