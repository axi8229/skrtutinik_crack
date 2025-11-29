package com.sputnik.data.entities.invites;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataFamilyInvite.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u000fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b#\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b$\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b%\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b&\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b'\u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b(\u0010\u000f¨\u0006)"}, d2 = {"Lcom/sputnik/data/entities/invites/DataFamilyInvite;", "Landroid/os/Parcelable;", "", "id", "", "phone", "state", "flatUuid", "flatNumber", "fullAddress", "createdAt", "updatedAt", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getPhone", "getState", "getFlatUuid", "getFlatNumber", "getFullAddress", "getCreatedAt", "getUpdatedAt", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DataFamilyInvite implements Parcelable {
    public static final Parcelable.Creator<DataFamilyInvite> CREATOR = new Creator();

    @SerializedName("created_at")
    private final String createdAt;

    @SerializedName("flat_number")
    private final Integer flatNumber;

    @SerializedName("flat_id")
    private final String flatUuid;

    @SerializedName("full_address")
    private final String fullAddress;
    private final Integer id;
    private final String phone;
    private final String state;

    @SerializedName("updated_at")
    private final String updatedAt;

    /* compiled from: DataFamilyInvite.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DataFamilyInvite> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFamilyInvite createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DataFamilyInvite(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataFamilyInvite[] newArray(int i) {
            return new DataFamilyInvite[i];
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
        if (!(other instanceof DataFamilyInvite)) {
            return false;
        }
        DataFamilyInvite dataFamilyInvite = (DataFamilyInvite) other;
        return Intrinsics.areEqual(this.id, dataFamilyInvite.id) && Intrinsics.areEqual(this.phone, dataFamilyInvite.phone) && Intrinsics.areEqual(this.state, dataFamilyInvite.state) && Intrinsics.areEqual(this.flatUuid, dataFamilyInvite.flatUuid) && Intrinsics.areEqual(this.flatNumber, dataFamilyInvite.flatNumber) && Intrinsics.areEqual(this.fullAddress, dataFamilyInvite.fullAddress) && Intrinsics.areEqual(this.createdAt, dataFamilyInvite.createdAt) && Intrinsics.areEqual(this.updatedAt, dataFamilyInvite.updatedAt);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.phone;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.state;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.flatUuid;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.flatNumber;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.fullAddress;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.createdAt;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.updatedAt;
        return iHashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DataFamilyInvite(id=" + this.id + ", phone=" + this.phone + ", state=" + this.state + ", flatUuid=" + this.flatUuid + ", flatNumber=" + this.flatNumber + ", fullAddress=" + this.fullAddress + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.phone);
        parcel.writeString(this.state);
        parcel.writeString(this.flatUuid);
        Integer num2 = this.flatNumber;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.fullAddress);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.updatedAt);
    }

    public DataFamilyInvite(Integer num, String str, String str2, String str3, Integer num2, String str4, String str5, String str6) {
        this.id = num;
        this.phone = str;
        this.state = str2;
        this.flatUuid = str3;
        this.flatNumber = num2;
        this.fullAddress = str4;
        this.createdAt = str5;
        this.updatedAt = str6;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getState() {
        return this.state;
    }

    public final String getFlatUuid() {
        return this.flatUuid;
    }

    public final Integer getFlatNumber() {
        return this.flatNumber;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }
}
