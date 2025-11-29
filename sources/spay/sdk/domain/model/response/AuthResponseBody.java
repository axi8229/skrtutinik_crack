package spay.sdk.domain.model.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import spay.sdk.data.dto.response.UserInfoDto;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000bJF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\b\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lspay/sdk/domain/model/response/AuthResponseBody;", "", "sessionId", "", "userInfo", "Lspay/sdk/data/dto/response/UserInfoDto;", "merchantName", "logoUrl", "isOtpNeed", "", "(Ljava/lang/String;Lspay/sdk/data/dto/response/UserInfoDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLogoUrl", "()Ljava/lang/String;", "getMerchantName", "getSessionId", "getUserInfo", "()Lspay/sdk/data/dto/response/UserInfoDto;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lspay/sdk/data/dto/response/UserInfoDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lspay/sdk/domain/model/response/AuthResponseBody;", "equals", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthResponseBody {
    private final Boolean isOtpNeed;
    private final String logoUrl;
    private final String merchantName;
    private final String sessionId;
    private final UserInfoDto userInfo;

    public AuthResponseBody(String sessionId, UserInfoDto userInfo, String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        this.sessionId = sessionId;
        this.userInfo = userInfo;
        this.merchantName = str;
        this.logoUrl = str2;
        this.isOtpNeed = bool;
    }

    public static /* synthetic */ AuthResponseBody copy$default(AuthResponseBody authResponseBody, String str, UserInfoDto userInfoDto, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authResponseBody.sessionId;
        }
        if ((i & 2) != 0) {
            userInfoDto = authResponseBody.userInfo;
        }
        UserInfoDto userInfoDto2 = userInfoDto;
        if ((i & 4) != 0) {
            str2 = authResponseBody.merchantName;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = authResponseBody.logoUrl;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            bool = authResponseBody.isOtpNeed;
        }
        return authResponseBody.copy(str, userInfoDto2, str4, str5, bool);
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

    public final AuthResponseBody copy(String sessionId, UserInfoDto userInfo, String merchantName, String logoUrl, Boolean isOtpNeed) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        return new AuthResponseBody(sessionId, userInfo, merchantName, logoUrl, isOtpNeed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthResponseBody)) {
            return false;
        }
        AuthResponseBody authResponseBody = (AuthResponseBody) other;
        return Intrinsics.areEqual(this.sessionId, authResponseBody.sessionId) && Intrinsics.areEqual(this.userInfo, authResponseBody.userInfo) && Intrinsics.areEqual(this.merchantName, authResponseBody.merchantName) && Intrinsics.areEqual(this.logoUrl, authResponseBody.logoUrl) && Intrinsics.areEqual(this.isOtpNeed, authResponseBody.isOtpNeed);
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
        int iHashCode = (this.userInfo.hashCode() + (this.sessionId.hashCode() * 31)) * 31;
        String str = this.merchantName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.logoUrl;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isOtpNeed;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public final Boolean isOtpNeed() {
        return this.isOtpNeed;
    }

    public String toString() {
        return "AuthResponseBody(sessionId=" + this.sessionId + ", userInfo=" + this.userInfo + ", merchantName=" + this.merchantName + ", logoUrl=" + this.logoUrl + ", isOtpNeed=" + this.isOtpNeed + ')';
    }
}
