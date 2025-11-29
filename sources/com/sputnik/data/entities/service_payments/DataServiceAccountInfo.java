package com.sputnik.data.entities.service_payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.sputnik.domain.entities.service_payments.ServicePaymentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataServiceAccountInfo.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b(\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b)\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b*\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b+\u0010\u0014R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b/\u0010\u0014R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010#\u001a\u0004\b3\u0010\u0014R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b4\u0010.¨\u00065"}, d2 = {"Lcom/sputnik/data/entities/service_payments/DataServiceAccountInfo;", "Landroid/os/Parcelable;", "", "uuid", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "type", "number", "fullAddress", "currentDebt", "accrualUuid", "", "promiseAvailable", "promiseExpiresAt", "Lcom/sputnik/data/entities/service_payments/DataPartnerInfo;", "partner", "lastAccruedAt", "offerAccepted", "<init>", "(Ljava/lang/String;Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/sputnik/data/entities/service_payments/DataPartnerInfo;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUuid", "Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getType", "()Lcom/sputnik/domain/entities/service_payments/ServicePaymentType;", "getNumber", "getFullAddress", "getCurrentDebt", "getAccrualUuid", "Ljava/lang/Boolean;", "getPromiseAvailable", "()Ljava/lang/Boolean;", "getPromiseExpiresAt", "Lcom/sputnik/data/entities/service_payments/DataPartnerInfo;", "getPartner", "()Lcom/sputnik/data/entities/service_payments/DataPartnerInfo;", "getLastAccruedAt", "getOfferAccepted", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataServiceAccountInfo implements Parcelable {
    public static final Parcelable.Creator<DataServiceAccountInfo> CREATOR = new Creator();

    @SerializedName("current_accrual_uuid")
    private final String accrualUuid;

    @SerializedName("current_debt")
    private final String currentDebt;

    @SerializedName("full_address")
    private final String fullAddress;

    @SerializedName("last_accrued_at")
    private final String lastAccruedAt;
    private final String number;

    @SerializedName("offer_accepted")
    private final Boolean offerAccepted;
    private final DataPartnerInfo partner;

    @SerializedName("promise_available")
    private final Boolean promiseAvailable;

    @SerializedName("promise_expires_at")
    private final String promiseExpiresAt;
    private final ServicePaymentType type;
    private final String uuid;

    /* compiled from: DataServiceAccountInfo.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataServiceAccountInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataServiceAccountInfo createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            ServicePaymentType servicePaymentTypeValueOf = parcel.readInt() == 0 ? null : ServicePaymentType.valueOf(parcel.readString());
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String string6 = parcel.readString();
            DataPartnerInfo dataPartnerInfoCreateFromParcel = parcel.readInt() == 0 ? null : DataPartnerInfo.CREATOR.createFromParcel(parcel);
            String string7 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf2 = null;
            } else {
                boolValueOf2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DataServiceAccountInfo(string, servicePaymentTypeValueOf, string2, string3, string4, string5, boolValueOf, string6, dataPartnerInfoCreateFromParcel, string7, boolValueOf2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataServiceAccountInfo[] newArray(int i) {
            return new DataServiceAccountInfo[i];
        }
    }

    public DataServiceAccountInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataServiceAccountInfo)) {
            return false;
        }
        DataServiceAccountInfo dataServiceAccountInfo = (DataServiceAccountInfo) other;
        return Intrinsics.areEqual(this.uuid, dataServiceAccountInfo.uuid) && this.type == dataServiceAccountInfo.type && Intrinsics.areEqual(this.number, dataServiceAccountInfo.number) && Intrinsics.areEqual(this.fullAddress, dataServiceAccountInfo.fullAddress) && Intrinsics.areEqual(this.currentDebt, dataServiceAccountInfo.currentDebt) && Intrinsics.areEqual(this.accrualUuid, dataServiceAccountInfo.accrualUuid) && Intrinsics.areEqual(this.promiseAvailable, dataServiceAccountInfo.promiseAvailable) && Intrinsics.areEqual(this.promiseExpiresAt, dataServiceAccountInfo.promiseExpiresAt) && Intrinsics.areEqual(this.partner, dataServiceAccountInfo.partner) && Intrinsics.areEqual(this.lastAccruedAt, dataServiceAccountInfo.lastAccruedAt) && Intrinsics.areEqual(this.offerAccepted, dataServiceAccountInfo.offerAccepted);
    }

    public int hashCode() {
        String str = this.uuid;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        ServicePaymentType servicePaymentType = this.type;
        int iHashCode2 = (iHashCode + (servicePaymentType == null ? 0 : servicePaymentType.hashCode())) * 31;
        String str2 = this.number;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fullAddress;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.currentDebt;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.accrualUuid;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.promiseAvailable;
        int iHashCode7 = (iHashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.promiseExpiresAt;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        DataPartnerInfo dataPartnerInfo = this.partner;
        int iHashCode9 = (iHashCode8 + (dataPartnerInfo == null ? 0 : dataPartnerInfo.hashCode())) * 31;
        String str7 = this.lastAccruedAt;
        int iHashCode10 = (iHashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool2 = this.offerAccepted;
        return iHashCode10 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "DataServiceAccountInfo(uuid=" + this.uuid + ", type=" + this.type + ", number=" + this.number + ", fullAddress=" + this.fullAddress + ", currentDebt=" + this.currentDebt + ", accrualUuid=" + this.accrualUuid + ", promiseAvailable=" + this.promiseAvailable + ", promiseExpiresAt=" + this.promiseExpiresAt + ", partner=" + this.partner + ", lastAccruedAt=" + this.lastAccruedAt + ", offerAccepted=" + this.offerAccepted + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.uuid);
        ServicePaymentType servicePaymentType = this.type;
        if (servicePaymentType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(servicePaymentType.name());
        }
        parcel.writeString(this.number);
        parcel.writeString(this.fullAddress);
        parcel.writeString(this.currentDebt);
        parcel.writeString(this.accrualUuid);
        Boolean bool = this.promiseAvailable;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.promiseExpiresAt);
        DataPartnerInfo dataPartnerInfo = this.partner;
        if (dataPartnerInfo == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dataPartnerInfo.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.lastAccruedAt);
        Boolean bool2 = this.offerAccepted;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
    }

    public DataServiceAccountInfo(String str, ServicePaymentType servicePaymentType, String str2, String str3, String str4, String str5, Boolean bool, String str6, DataPartnerInfo dataPartnerInfo, String str7, Boolean bool2) {
        this.uuid = str;
        this.type = servicePaymentType;
        this.number = str2;
        this.fullAddress = str3;
        this.currentDebt = str4;
        this.accrualUuid = str5;
        this.promiseAvailable = bool;
        this.promiseExpiresAt = str6;
        this.partner = dataPartnerInfo;
        this.lastAccruedAt = str7;
        this.offerAccepted = bool2;
    }

    public /* synthetic */ DataServiceAccountInfo(String str, ServicePaymentType servicePaymentType, String str2, String str3, String str4, String str5, Boolean bool, String str6, DataPartnerInfo dataPartnerInfo, String str7, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : servicePaymentType, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : dataPartnerInfo, (i & 512) != 0 ? null : str7, (i & 1024) == 0 ? bool2 : null);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final ServicePaymentType getType() {
        return this.type;
    }

    public final String getNumber() {
        return this.number;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final String getCurrentDebt() {
        return this.currentDebt;
    }

    public final String getAccrualUuid() {
        return this.accrualUuid;
    }

    public final Boolean getPromiseAvailable() {
        return this.promiseAvailable;
    }

    public final String getPromiseExpiresAt() {
        return this.promiseExpiresAt;
    }

    public final DataPartnerInfo getPartner() {
        return this.partner;
    }

    public final String getLastAccruedAt() {
        return this.lastAccruedAt;
    }

    public final Boolean getOfferAccepted() {
        return this.offerAccepted;
    }
}
