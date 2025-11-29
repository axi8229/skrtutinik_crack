package com.sputnik.data.entities.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.auth.RegistrationState;
import com.sputnik.domain.entities.auth.RegistrationWay;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataApplyRegistrationResponse.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0014J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b(\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b)\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b*\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b+\u0010\u0011R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/sputnik/data/entities/auth/DataApplyRegistrationResponse;", "Landroid/os/Parcelable;", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "way", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "state", "", "userSmsCode", "userSmsPhone", "limitExpiresAt", "requestId", "expiresAtUnused", "", "showHelpOnFail", "<init>", "(Lcom/sputnik/domain/entities/auth/RegistrationWay;Lcom/sputnik/domain/entities/auth/RegistrationState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/sputnik/domain/entities/auth/RegistrationWay;", "getWay", "()Lcom/sputnik/domain/entities/auth/RegistrationWay;", "Lcom/sputnik/domain/entities/auth/RegistrationState;", "getState", "()Lcom/sputnik/domain/entities/auth/RegistrationState;", "Ljava/lang/String;", "getUserSmsCode", "getUserSmsPhone", "getLimitExpiresAt", "getRequestId", "getExpiresAtUnused", "Ljava/lang/Boolean;", "getShowHelpOnFail", "()Ljava/lang/Boolean;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataApplyRegistrationResponse implements Parcelable {
    public static final Parcelable.Creator<DataApplyRegistrationResponse> CREATOR = new Creator();

    @SerializedName("expires_at")
    private final String expiresAtUnused;

    @SerializedName("limit_expires_at")
    private final String limitExpiresAt;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("show_help_on_fail")
    private final Boolean showHelpOnFail;
    private final RegistrationState state;

    @SerializedName("user_sms_code")
    private final String userSmsCode;

    @SerializedName("user_sms_phone")
    private final String userSmsPhone;
    private final RegistrationWay way;

    /* compiled from: DataApplyRegistrationResponse.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataApplyRegistrationResponse> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataApplyRegistrationResponse createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            RegistrationWay registrationWayValueOf = parcel.readInt() == 0 ? null : RegistrationWay.valueOf(parcel.readString());
            RegistrationState registrationStateValueOf = parcel.readInt() == 0 ? null : RegistrationState.valueOf(parcel.readString());
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataApplyRegistrationResponse(registrationWayValueOf, registrationStateValueOf, string, string2, string3, string4, string5, boolValueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataApplyRegistrationResponse[] newArray(int i) {
            return new DataApplyRegistrationResponse[i];
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
        if (!(other instanceof DataApplyRegistrationResponse)) {
            return false;
        }
        DataApplyRegistrationResponse dataApplyRegistrationResponse = (DataApplyRegistrationResponse) other;
        return this.way == dataApplyRegistrationResponse.way && this.state == dataApplyRegistrationResponse.state && Intrinsics.areEqual(this.userSmsCode, dataApplyRegistrationResponse.userSmsCode) && Intrinsics.areEqual(this.userSmsPhone, dataApplyRegistrationResponse.userSmsPhone) && Intrinsics.areEqual(this.limitExpiresAt, dataApplyRegistrationResponse.limitExpiresAt) && Intrinsics.areEqual(this.requestId, dataApplyRegistrationResponse.requestId) && Intrinsics.areEqual(this.expiresAtUnused, dataApplyRegistrationResponse.expiresAtUnused) && Intrinsics.areEqual(this.showHelpOnFail, dataApplyRegistrationResponse.showHelpOnFail);
    }

    public int hashCode() {
        RegistrationWay registrationWay = this.way;
        int iHashCode = (registrationWay == null ? 0 : registrationWay.hashCode()) * 31;
        RegistrationState registrationState = this.state;
        int iHashCode2 = (iHashCode + (registrationState == null ? 0 : registrationState.hashCode())) * 31;
        String str = this.userSmsCode;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userSmsPhone;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.limitExpiresAt;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.requestId;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.expiresAtUnused;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.showHelpOnFail;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "DataApplyRegistrationResponse(way=" + this.way + ", state=" + this.state + ", userSmsCode=" + this.userSmsCode + ", userSmsPhone=" + this.userSmsPhone + ", limitExpiresAt=" + this.limitExpiresAt + ", requestId=" + this.requestId + ", expiresAtUnused=" + this.expiresAtUnused + ", showHelpOnFail=" + this.showHelpOnFail + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
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
        parcel.writeString(this.userSmsCode);
        parcel.writeString(this.userSmsPhone);
        parcel.writeString(this.limitExpiresAt);
        parcel.writeString(this.requestId);
        parcel.writeString(this.expiresAtUnused);
        Boolean bool = this.showHelpOnFail;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    }

    public DataApplyRegistrationResponse(RegistrationWay registrationWay, RegistrationState registrationState, String str, String str2, String str3, String str4, String str5, Boolean bool) {
        this.way = registrationWay;
        this.state = registrationState;
        this.userSmsCode = str;
        this.userSmsPhone = str2;
        this.limitExpiresAt = str3;
        this.requestId = str4;
        this.expiresAtUnused = str5;
        this.showHelpOnFail = bool;
    }

    public final RegistrationWay getWay() {
        return this.way;
    }

    public final RegistrationState getState() {
        return this.state;
    }

    public final String getUserSmsCode() {
        return this.userSmsCode;
    }

    public final String getUserSmsPhone() {
        return this.userSmsPhone;
    }

    public final String getLimitExpiresAt() {
        return this.limitExpiresAt;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getExpiresAtUnused() {
        return this.expiresAtUnused;
    }

    public final Boolean getShowHelpOnFail() {
        return this.showHelpOnFail;
    }
}
