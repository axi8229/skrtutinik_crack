package spay.sdk.data.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import npi.spay.Q1;
import spay.sdk.domain.model.response.UserInfo;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lspay/sdk/data/dto/response/UserInfoDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/UserInfo;", "lastName", "", "firstName", "gender", "", "mobilePhone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getFirstName", "()Ljava/lang/String;", "getGender", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLastName", "getMobilePhone", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lspay/sdk/data/dto/response/UserInfoDto;", "equals", "", "other", "", "hashCode", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserInfoDto implements DataDtoInterface<UserInfo> {

    @SerializedName("firstName")
    private final String firstName;

    @SerializedName("gender")
    private final Integer gender;

    @SerializedName("lastName")
    private final String lastName;

    @SerializedName("mobilePhone")
    private final String mobilePhone;

    public UserInfoDto(String str, String str2, Integer num, String str3) {
        this.lastName = str;
        this.firstName = str2;
        this.gender = num;
        this.mobilePhone = str3;
    }

    public static /* synthetic */ UserInfoDto copy$default(UserInfoDto userInfoDto, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userInfoDto.lastName;
        }
        if ((i & 2) != 0) {
            str2 = userInfoDto.firstName;
        }
        if ((i & 4) != 0) {
            num = userInfoDto.gender;
        }
        if ((i & 8) != 0) {
            str3 = userInfoDto.mobilePhone;
        }
        return userInfoDto.copy(str, str2, num, str3);
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

    public final UserInfoDto copy(String lastName, String firstName, Integer gender, String mobilePhone) {
        return new UserInfoDto(lastName, firstName, gender, mobilePhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfoDto)) {
            return false;
        }
        UserInfoDto userInfoDto = (UserInfoDto) other;
        return Intrinsics.areEqual(this.lastName, userInfoDto.lastName) && Intrinsics.areEqual(this.firstName, userInfoDto.firstName) && Intrinsics.areEqual(this.gender, userInfoDto.gender) && Intrinsics.areEqual(this.mobilePhone, userInfoDto.mobilePhone);
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
        String str = this.lastName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.firstName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.gender;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.mobilePhone;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserInfoDto(lastName=");
        sb.append(this.lastName);
        sb.append(", firstName=");
        sb.append(this.firstName);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", mobilePhone=");
        return Q1.a(sb, this.mobilePhone, ')');
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public UserInfo toModel() {
        String str = this.lastName;
        if (str == null) {
            throw new Kg("lastName");
        }
        String str2 = this.firstName;
        if (str2 != null) {
            return new UserInfo(str, str2, this.gender, this.mobilePhone);
        }
        throw new Kg("firstName");
    }
}
