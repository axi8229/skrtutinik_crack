package spay.sdk.data.dto.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.Kg;
import spay.sdk.domain.model.response.SessionIdResponseBody;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bi\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0086\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\b\u0010-\u001a\u00020\u0002H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\t\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006/"}, d2 = {"Lspay/sdk/data/dto/response/SessionIdResponseBodyDto;", "Lspay/sdk/data/dto/response/DataDtoInterface;", "Lspay/sdk/domain/model/response/SessionIdResponseBody;", "deeplink", "", "state", "sessionId", "clientId", "nonce", "isBnplEnabled", "", "codeChallengeMethod", "codeChallenge", "scope", "refreshTokenIsActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getClientId", "()Ljava/lang/String;", "getCodeChallenge", "getCodeChallengeMethod", "getDeeplink", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNonce", "getRefreshTokenIsActive", "getScope", "getSessionId", "getState", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lspay/sdk/data/dto/response/SessionIdResponseBodyDto;", "equals", "other", "", "hashCode", "", "toModel", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionIdResponseBodyDto implements DataDtoInterface<SessionIdResponseBody> {

    @SerializedName("clientId")
    private final String clientId;

    @SerializedName("codeChallenge")
    private final String codeChallenge;

    @SerializedName("codeChallengeMethod")
    private final String codeChallengeMethod;

    @SerializedName("deeplink")
    private final String deeplink;

    @SerializedName("isBnplEnabled")
    private final Boolean isBnplEnabled;

    @SerializedName("nonce")
    private final String nonce;

    @SerializedName("refreshTokenIsActive")
    private final Boolean refreshTokenIsActive;

    @SerializedName("scope")
    private final String scope;

    @SerializedName("sessionId")
    private final String sessionId;

    @SerializedName("state")
    private final String state;

    public SessionIdResponseBodyDto(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, Boolean bool2) {
        this.deeplink = str;
        this.state = str2;
        this.sessionId = str3;
        this.clientId = str4;
        this.nonce = str5;
        this.isBnplEnabled = bool;
        this.codeChallengeMethod = str6;
        this.codeChallenge = str7;
        this.scope = str8;
        this.refreshTokenIsActive = bool2;
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeeplink() {
        return this.deeplink;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getRefreshTokenIsActive() {
        return this.refreshTokenIsActive;
    }

    /* renamed from: component2, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getIsBnplEnabled() {
        return this.isBnplEnabled;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCodeChallengeMethod() {
        return this.codeChallengeMethod;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    /* renamed from: component9, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    public final SessionIdResponseBodyDto copy(String deeplink, String state, String sessionId, String clientId, String nonce, Boolean isBnplEnabled, String codeChallengeMethod, String codeChallenge, String scope, Boolean refreshTokenIsActive) {
        return new SessionIdResponseBodyDto(deeplink, state, sessionId, clientId, nonce, isBnplEnabled, codeChallengeMethod, codeChallenge, scope, refreshTokenIsActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionIdResponseBodyDto)) {
            return false;
        }
        SessionIdResponseBodyDto sessionIdResponseBodyDto = (SessionIdResponseBodyDto) other;
        return Intrinsics.areEqual(this.deeplink, sessionIdResponseBodyDto.deeplink) && Intrinsics.areEqual(this.state, sessionIdResponseBodyDto.state) && Intrinsics.areEqual(this.sessionId, sessionIdResponseBodyDto.sessionId) && Intrinsics.areEqual(this.clientId, sessionIdResponseBodyDto.clientId) && Intrinsics.areEqual(this.nonce, sessionIdResponseBodyDto.nonce) && Intrinsics.areEqual(this.isBnplEnabled, sessionIdResponseBodyDto.isBnplEnabled) && Intrinsics.areEqual(this.codeChallengeMethod, sessionIdResponseBodyDto.codeChallengeMethod) && Intrinsics.areEqual(this.codeChallenge, sessionIdResponseBodyDto.codeChallenge) && Intrinsics.areEqual(this.scope, sessionIdResponseBodyDto.scope) && Intrinsics.areEqual(this.refreshTokenIsActive, sessionIdResponseBodyDto.refreshTokenIsActive);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    public final String getCodeChallengeMethod() {
        return this.codeChallengeMethod;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final Boolean getRefreshTokenIsActive() {
        return this.refreshTokenIsActive;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        String str = this.deeplink;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.state;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.clientId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.nonce;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool = this.isBnplEnabled;
        int iHashCode6 = (iHashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str6 = this.codeChallengeMethod;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.codeChallenge;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.scope;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool2 = this.refreshTokenIsActive;
        return iHashCode9 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final Boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "SessionIdResponseBodyDto(deeplink=" + this.deeplink + ", state=" + this.state + ", sessionId=" + this.sessionId + ", clientId=" + this.clientId + ", nonce=" + this.nonce + ", isBnplEnabled=" + this.isBnplEnabled + ", codeChallengeMethod=" + this.codeChallengeMethod + ", codeChallenge=" + this.codeChallenge + ", scope=" + this.scope + ", refreshTokenIsActive=" + this.refreshTokenIsActive + ')';
    }

    @Override // spay.sdk.data.dto.response.DataDtoInterface
    public SessionIdResponseBody toModel() {
        String str = this.deeplink;
        if (str == null) {
            throw new Kg("deeplink");
        }
        String str2 = this.state;
        if (str2 == null) {
            throw new Kg("state");
        }
        String str3 = this.sessionId;
        if (str3 == null) {
            throw new Kg("sessionId");
        }
        String str4 = this.clientId;
        if (str4 == null) {
            throw new Kg("clientId");
        }
        String str5 = this.nonce;
        if (str5 == null) {
            throw new Kg("nonce");
        }
        Boolean bool = this.isBnplEnabled;
        String str6 = this.codeChallengeMethod;
        if (str6 == null) {
            throw new Kg("codeChallengeMethod");
        }
        String str7 = this.codeChallenge;
        if (str7 == null) {
            throw new Kg("codeChallenge");
        }
        String str8 = this.scope;
        if (str8 != null) {
            return new SessionIdResponseBody(str, str2, str3, str4, str5, bool, str6, str7, str8, this.refreshTokenIsActive);
        }
        throw new Kg("scope");
    }
}
