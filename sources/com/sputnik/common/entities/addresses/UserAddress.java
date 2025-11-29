package com.sputnik.common.entities.addresses;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.updatesdk.service.otaupdate.UpdateKey;
import com.sputnik.domain.entities.profile.AddressStatus;
import com.sputnik.domain.entities.profile.ProfileNavigationState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserAddress.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015Jz\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u0019R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b,\u0010\u0019R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b0\u0010)R\"\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00101\u001a\u0004\b\n\u0010\u0015\"\u0004\b2\u00103R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b4\u0010\u0019R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b5\u0010\u0019R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00106\u001a\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/sputnik/common/entities/addresses/UserAddress;", "Landroid/os/Parcelable;", "", "id", "", "fullAddress", "fullAddressWithApartment", "", "addressVerificationRequired", "apartment", "isSelected", "flatUUID", "entryUUID", "Lcom/sputnik/domain/entities/profile/AddressStatus;", UpdateKey.STATUS, "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/profile/AddressStatus;)V", "Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "getNavigationStateForAddress", "()Lcom/sputnik/domain/entities/profile/ProfileNavigationState;", "isFullyValidated", "()Z", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Lcom/sputnik/domain/entities/profile/AddressStatus;)Lcom/sputnik/common/entities/addresses/UserAddress;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getFullAddress", "getFullAddressWithApartment", "Ljava/lang/Boolean;", "getAddressVerificationRequired", "()Ljava/lang/Boolean;", "getApartment", "Z", "setSelected", "(Z)V", "getFlatUUID", "getEntryUUID", "Lcom/sputnik/domain/entities/profile/AddressStatus;", "getStatus", "()Lcom/sputnik/domain/entities/profile/AddressStatus;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class UserAddress implements Parcelable {
    public static final Parcelable.Creator<UserAddress> CREATOR = new Creator();
    private final Boolean addressVerificationRequired;
    private final Integer apartment;
    private final String entryUUID;
    private final String flatUUID;
    private final String fullAddress;
    private final String fullAddressWithApartment;
    private final Integer id;
    private boolean isSelected;
    private final AddressStatus status;

    /* compiled from: UserAddress.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserAddress> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserAddress createFromParcel(Parcel parcel) {
            Boolean boolValueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer numValueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (parcel.readInt() == 0) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new UserAddress(numValueOf, string, string2, boolValueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : AddressStatus.valueOf(parcel.readString()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserAddress[] newArray(int i) {
            return new UserAddress[i];
        }
    }

    public final UserAddress copy(Integer id, String fullAddress, String fullAddressWithApartment, Boolean addressVerificationRequired, Integer apartment, boolean isSelected, String flatUUID, String entryUUID, AddressStatus status) {
        return new UserAddress(id, fullAddress, fullAddressWithApartment, addressVerificationRequired, apartment, isSelected, flatUUID, entryUUID, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserAddress)) {
            return false;
        }
        UserAddress userAddress = (UserAddress) other;
        return Intrinsics.areEqual(this.id, userAddress.id) && Intrinsics.areEqual(this.fullAddress, userAddress.fullAddress) && Intrinsics.areEqual(this.fullAddressWithApartment, userAddress.fullAddressWithApartment) && Intrinsics.areEqual(this.addressVerificationRequired, userAddress.addressVerificationRequired) && Intrinsics.areEqual(this.apartment, userAddress.apartment) && this.isSelected == userAddress.isSelected && Intrinsics.areEqual(this.flatUUID, userAddress.flatUUID) && Intrinsics.areEqual(this.entryUUID, userAddress.entryUUID) && this.status == userAddress.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.fullAddress;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fullAddressWithApartment;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.addressVerificationRequired;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.apartment;
        int iHashCode5 = (iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        boolean z = this.isSelected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (iHashCode5 + i) * 31;
        String str3 = this.flatUUID;
        int iHashCode6 = (i2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.entryUUID;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        AddressStatus addressStatus = this.status;
        return iHashCode7 + (addressStatus != null ? addressStatus.hashCode() : 0);
    }

    public String toString() {
        return "UserAddress(id=" + this.id + ", fullAddress=" + this.fullAddress + ", fullAddressWithApartment=" + this.fullAddressWithApartment + ", addressVerificationRequired=" + this.addressVerificationRequired + ", apartment=" + this.apartment + ", isSelected=" + this.isSelected + ", flatUUID=" + this.flatUUID + ", entryUUID=" + this.entryUUID + ", status=" + this.status + ")";
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
        parcel.writeString(this.fullAddress);
        parcel.writeString(this.fullAddressWithApartment);
        Boolean bool = this.addressVerificationRequired;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.apartment;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeInt(this.isSelected ? 1 : 0);
        parcel.writeString(this.flatUUID);
        parcel.writeString(this.entryUUID);
        AddressStatus addressStatus = this.status;
        if (addressStatus == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(addressStatus.name());
        }
    }

    public UserAddress(Integer num, String str, String str2, Boolean bool, Integer num2, boolean z, String str3, String str4, AddressStatus addressStatus) {
        this.id = num;
        this.fullAddress = str;
        this.fullAddressWithApartment = str2;
        this.addressVerificationRequired = bool;
        this.apartment = num2;
        this.isSelected = z;
        this.flatUUID = str3;
        this.entryUUID = str4;
        this.status = addressStatus;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final String getFullAddressWithApartment() {
        return this.fullAddressWithApartment;
    }

    public final Boolean getAddressVerificationRequired() {
        return this.addressVerificationRequired;
    }

    public final Integer getApartment() {
        return this.apartment;
    }

    /* renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final String getFlatUUID() {
        return this.flatUUID;
    }

    public final String getEntryUUID() {
        return this.entryUUID;
    }

    public final AddressStatus getStatus() {
        return this.status;
    }

    public final ProfileNavigationState getNavigationStateForAddress() {
        return (!(this.entryUUID == null && this.fullAddress == null) && Intrinsics.areEqual(this.addressVerificationRequired, Boolean.TRUE)) ? new ProfileNavigationState.ToVerifyAddressState() : (!(this.entryUUID == null && this.fullAddress == null) && Intrinsics.areEqual(this.addressVerificationRequired, Boolean.FALSE)) ? new ProfileNavigationState.ToEnterFlatNumberState() : new ProfileNavigationState.ToIntercomState();
    }

    public final boolean isFullyValidated() {
        return this.apartment != null;
    }
}
