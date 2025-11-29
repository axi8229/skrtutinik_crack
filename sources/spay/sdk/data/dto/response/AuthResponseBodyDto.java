package spay.sdk.data.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import spay.sdk.domain.model.response.AuthResponseBody;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0002H\u0016J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\t\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lspay/sdk/data/dto/response/AuthResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/AuthResponseBody;", "sessionId", "", "userInfo", "Lspay/sdk/data/dto/response/UserInfoDto;", "merchantName", "logoUrl", "isOtpNeed", "", "(Ljava/lang/String;Lspay/sdk/data/dto/response/UserInfoDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLogoUrl", "()Ljava/lang/String;", "getMerchantName", "getSessionId", "getUserInfo", "()Lspay/sdk/data/dto/response/UserInfoDto;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lspay/sdk/data/dto/response/UserInfoDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lspay/sdk/data/dto/response/AuthResponseBodyDto;", "equals", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthResponseBodyDto implements DataDtoInterface<AuthResponseBody> {

    @SerializedName("isOtpNeed")
    private final Boolean isOtpNeed;

    @SerializedName("logoUrl")
    private final String logoUrl;

    @SerializedName("merchantName")
    private final String merchantName;

    @SerializedName("sessionId")
    private final String sessionId;

    @SerializedName("userInfo")
    private final UserInfoDto userInfo;

    public AuthResponseBodyDto(String str, UserInfoDto userInfoDto, String str2, String str3, Boolean bool) {
        this.sessionId = str;
        this.userInfo = userInfoDto;
        this.merchantName = str2;
        this.logoUrl = str3;
        this.isOtpNeed = bool;
    }

    public static /* synthetic */ AuthResponseBodyDto copy$default(AuthResponseBodyDto authResponseBodyDto, String str, UserInfoDto userInfoDto, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authResponseBodyDto.sessionId;
        }
        if ((i & 2) != 0) {
            userInfoDto = authResponseBodyDto.userInfo;
        }
        UserInfoDto userInfoDto2 = userInfoDto;
        if ((i & 4) != 0) {
            str2 = authResponseBodyDto.merchantName;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = authResponseBodyDto.logoUrl;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            bool = authResponseBodyDto.isOtpNeed;
        }
        return authResponseBodyDto.copy(str, userInfoDto2, str4, str5, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component2, reason: from getter */
    public final UserInfoDto getUserInfo() {
        return this.userInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMerchantName() {
        return this.merchantName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getIsOtpNeed() {
        return this.isOtpNeed;
    }

    public final AuthResponseBodyDto copy(String sessionId, UserInfoDto userInfo, String merchantName, String logoUrl, Boolean isOtpNeed) {
        return new AuthResponseBodyDto(sessionId, userInfo, merchantName, logoUrl, isOtpNeed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthResponseBodyDto)) {
            return false;
        }
        AuthResponseBodyDto authResponseBodyDto = (AuthResponseBodyDto) other;
        return Intrinsics.areEqual(this.sessionId, authResponseBodyDto.sessionId) && Intrinsics.areEqual(this.userInfo, authResponseBodyDto.userInfo) && Intrinsics.areEqual(this.merchantName, authResponseBodyDto.merchantName) && Intrinsics.areEqual(this.logoUrl, authResponseBodyDto.logoUrl) && Intrinsics.areEqual(this.isOtpNeed, authResponseBodyDto.isOtpNeed);
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final UserInfoDto getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        String str = this.sessionId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        UserInfoDto userInfoDto = this.userInfo;
        int iHashCode2 = (iHashCode + (userInfoDto == null ? 0 : userInfoDto.hashCode())) * 31;
        String str2 = this.merchantName;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.logoUrl;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.isOtpNeed;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public final Boolean isOtpNeed() {
        return this.isOtpNeed;
    }

    public String toString() {
        return "AuthResponseBodyDto(sessionId=" + this.sessionId + ", userInfo=" + this.userInfo + ", merchantName=" + this.merchantName + ", logoUrl=" + this.logoUrl + ", isOtpNeed=" + this.isOtpNeed + ')';
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public AuthResponseBody toModel() {
        String str = this.sessionId;
        if (str == null) {
            throw new Kg("sessionId");
        }
        UserInfoDto userInfoDto = this.userInfo;
        if (userInfoDto != null) {
            return new AuthResponseBody(str, userInfoDto, this.merchantName, this.logoUrl, this.isOtpNeed);
        }
        throw new Kg("userInfo");
    }
}
