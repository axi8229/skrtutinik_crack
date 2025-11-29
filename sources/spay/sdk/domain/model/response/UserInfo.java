package spay.sdk.domain.model.response;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;
import npi.spay.Q1;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\""}, d2 = {"Lspay/sdk/domain/model/response/UserInfo;", "Landroid/os/Parcelable;", "lastName", "", "firstName", "gender", "", "mobilePhone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFirstName", "()Ljava/lang/String;", "getGender", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastName", "getMobilePhone", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lspay/sdk/domain/model/response/UserInfo;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserInfo implements Parcelable {
    public static final Parcelable.Creator<UserInfo> CREATOR = new Creator();
    private final String firstName;
    private final Integer gender;
    private final String lastName;
    private final String mobilePhone;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserInfo> {
        @Override // android.os.Parcelable.Creator
        public final UserInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserInfo(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    }

    public UserInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfo.lastName;
        }
        if ((i & 2) != 0) {
            str2 = userInfo.firstName;
        }
        if ((i & 4) != 0) {
            num = userInfo.gender;
        }
        if ((i & 8) != 0) {
            str3 = userInfo.mobilePhone;
        }
        return userInfo.copy(str, str2, num, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLastName() {
        return this.lastName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFirstName() {
        return this.firstName;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getGender() {
        return this.gender;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMobilePhone() {
        return this.mobilePhone;
    }

    public final UserInfo copy(String lastName, String firstName, Integer gender, String mobilePhone) {
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        return new UserInfo(lastName, firstName, gender, mobilePhone);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.lastName, userInfo.lastName) && Intrinsics.areEqual(this.firstName, userInfo.firstName) && Intrinsics.areEqual(this.gender, userInfo.gender) && Intrinsics.areEqual(this.mobilePhone, userInfo.mobilePhone);
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final Integer getGender() {
        return this.gender;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getMobilePhone() {
        return this.mobilePhone;
    }

    public int hashCode() {
        int iA = AbstractC1553e.a(this.firstName, this.lastName.hashCode() * 31, 31);
        Integer num = this.gender;
        int iHashCode = (iA + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.mobilePhone;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserInfo(lastName=");
        sb.append(this.lastName);
        sb.append(", firstName=");
        sb.append(this.firstName);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", mobilePhone=");
        return Q1.a(sb, this.mobilePhone, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iIntValue;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.lastName);
        parcel.writeString(this.firstName);
        Integer num = this.gender;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeString(this.mobilePhone);
    }

    public UserInfo(String lastName, String firstName, Integer num, String str) {
        Intrinsics.checkNotNullParameter(lastName, "lastName");
        Intrinsics.checkNotNullParameter(firstName, "firstName");
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = num;
        this.mobilePhone = str;
    }

    public /* synthetic */ UserInfo(String str, String str2, Integer num, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "-1" : str, (i & 2) != 0 ? "-1" : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str3);
    }
}
