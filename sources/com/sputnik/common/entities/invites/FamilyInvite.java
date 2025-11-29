package com.sputnik.common.entities.invites;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.android.SystemUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FamilyInvite.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001:\u00010Bc\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ|\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b*\u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b+\u0010\u0013R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b,\u0010$R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b-\u0010\u0013R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b.\u0010\u0013R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b/\u0010\u0013¨\u00061"}, d2 = {"Lcom/sputnik/common/entities/invites/FamilyInvite;", "Landroid/os/Parcelable;", "", "id", "", "phone", "Lcom/sputnik/common/entities/invites/FamilyInvite$FamilyInviteState;", "state", "stateHuman", "flatUuid", "flatNumber", "fullAddress", "createdAt", "updatedAt", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/sputnik/common/entities/invites/FamilyInvite$FamilyInviteState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/sputnik/common/entities/invites/FamilyInvite$FamilyInviteState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/sputnik/common/entities/invites/FamilyInvite;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getPhone", "Lcom/sputnik/common/entities/invites/FamilyInvite$FamilyInviteState;", "getState", "()Lcom/sputnik/common/entities/invites/FamilyInvite$FamilyInviteState;", "getStateHuman", "getFlatUuid", "getFlatNumber", "getFullAddress", "getCreatedAt", "getUpdatedAt", "FamilyInviteState", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FamilyInvite implements Parcelable {
    public static final Parcelable.Creator<FamilyInvite> CREATOR = new Creator();
    private final String createdAt;
    private final Integer flatNumber;
    private final String flatUuid;
    private final String fullAddress;
    private final Integer id;
    private final String phone;
    private final FamilyInviteState state;
    private final String stateHuman;
    private final String updatedAt;

    /* compiled from: FamilyInvite.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FamilyInvite> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyInvite createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FamilyInvite(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : FamilyInviteState.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FamilyInvite[] newArray(int i) {
            return new FamilyInvite[i];
        }
    }

    public final FamilyInvite copy(Integer id, String phone, FamilyInviteState state, String stateHuman, String flatUuid, Integer flatNumber, String fullAddress, String createdAt, String updatedAt) {
        return new FamilyInvite(id, phone, state, stateHuman, flatUuid, flatNumber, fullAddress, createdAt, updatedAt);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FamilyInvite)) {
            return false;
        }
        FamilyInvite familyInvite = (FamilyInvite) other;
        return Intrinsics.areEqual(this.id, familyInvite.id) && Intrinsics.areEqual(this.phone, familyInvite.phone) && this.state == familyInvite.state && Intrinsics.areEqual(this.stateHuman, familyInvite.stateHuman) && Intrinsics.areEqual(this.flatUuid, familyInvite.flatUuid) && Intrinsics.areEqual(this.flatNumber, familyInvite.flatNumber) && Intrinsics.areEqual(this.fullAddress, familyInvite.fullAddress) && Intrinsics.areEqual(this.createdAt, familyInvite.createdAt) && Intrinsics.areEqual(this.updatedAt, familyInvite.updatedAt);
    }

    public int hashCode() {
        Integer num = this.id;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.phone;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        FamilyInviteState familyInviteState = this.state;
        int iHashCode3 = (iHashCode2 + (familyInviteState == null ? 0 : familyInviteState.hashCode())) * 31;
        String str2 = this.stateHuman;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.flatUuid;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.flatNumber;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.fullAddress;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.createdAt;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.updatedAt;
        return iHashCode8 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "FamilyInvite(id=" + this.id + ", phone=" + this.phone + ", state=" + this.state + ", stateHuman=" + this.stateHuman + ", flatUuid=" + this.flatUuid + ", flatNumber=" + this.flatNumber + ", fullAddress=" + this.fullAddress + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
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
        FamilyInviteState familyInviteState = this.state;
        if (familyInviteState == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            familyInviteState.writeToParcel(parcel, flags);
        }
        parcel.writeString(this.stateHuman);
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

    public FamilyInvite(Integer num, String str, FamilyInviteState familyInviteState, String str2, String str3, Integer num2, String str4, String str5, String str6) {
        this.id = num;
        this.phone = str;
        this.state = familyInviteState;
        this.stateHuman = str2;
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

    public final FamilyInviteState getState() {
        return this.state;
    }

    public final String getStateHuman() {
        return this.stateHuman;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FamilyInvite.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/sputnik/common/entities/invites/FamilyInvite$FamilyInviteState;", "", "Landroid/os/Parcelable;", "(Ljava/lang/String;I)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "sent", "denied", "accepted", SystemUtils.UNKNOWN, "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FamilyInviteState implements Parcelable {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FamilyInviteState[] $VALUES;
        public static final Parcelable.Creator<FamilyInviteState> CREATOR;
        public static final FamilyInviteState sent = new FamilyInviteState("sent", 0);
        public static final FamilyInviteState denied = new FamilyInviteState("denied", 1);
        public static final FamilyInviteState accepted = new FamilyInviteState("accepted", 2);
        public static final FamilyInviteState unknown = new FamilyInviteState(SystemUtils.UNKNOWN, 3);

        /* compiled from: FamilyInvite.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FamilyInviteState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FamilyInviteState createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return FamilyInviteState.valueOf(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final FamilyInviteState[] newArray(int i) {
                return new FamilyInviteState[i];
            }
        }

        private static final /* synthetic */ FamilyInviteState[] $values() {
            return new FamilyInviteState[]{sent, denied, accepted, unknown};
        }

        public static FamilyInviteState valueOf(String str) {
            return (FamilyInviteState) Enum.valueOf(FamilyInviteState.class, str);
        }

        public static FamilyInviteState[] values() {
            return (FamilyInviteState[]) $VALUES.clone();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(name());
        }

        private FamilyInviteState(String str, int i) {
        }

        static {
            FamilyInviteState[] familyInviteStateArr$values = $values();
            $VALUES = familyInviteStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(familyInviteStateArr$values);
            CREATOR = new Creator();
        }
    }
}
