package spay.sdk.domain.model.response;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import npi.spay.AbstractC1553e;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003Jv\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Lspay/sdk/domain/model/response/SessionIdResponseBody;", "", "deeplink", "", "state", "sessionId", "clientId", "nonce", "isBnplEnabled", "", "codeChallengeMethod", "codeChallenge", "scope", "refreshTokenIsActive", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getClientId", "()Ljava/lang/String;", "getCodeChallenge", "getCodeChallengeMethod", "getDeeplink", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNonce", "getRefreshTokenIsActive", "getScope", "getSessionId", "getState", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lspay/sdk/domain/model/response/SessionIdResponseBody;", "equals", "other", "hashCode", "", "toString", "SPaySDK_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionIdResponseBody {
    private final String clientId;
    private final String codeChallenge;
    private final String codeChallengeMethod;
    private final String deeplink;
    private final Boolean isBnplEnabled;
    private final String nonce;
    private final Boolean refreshTokenIsActive;
    private final String scope;
    private final String sessionId;
    private final String state;

    public SessionIdResponseBody() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
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

    public final SessionIdResponseBody copy(String deeplink, String state, String sessionId, String clientId, String nonce, Boolean isBnplEnabled, String codeChallengeMethod, String codeChallenge, String scope, Boolean refreshTokenIsActive) {
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
        Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new SessionIdResponseBody(deeplink, state, sessionId, clientId, nonce, isBnplEnabled, codeChallengeMethod, codeChallenge, scope, refreshTokenIsActive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionIdResponseBody)) {
            return false;
        }
        SessionIdResponseBody sessionIdResponseBody = (SessionIdResponseBody) other;
        return Intrinsics.areEqual(this.deeplink, sessionIdResponseBody.deeplink) && Intrinsics.areEqual(this.state, sessionIdResponseBody.state) && Intrinsics.areEqual(this.sessionId, sessionIdResponseBody.sessionId) && Intrinsics.areEqual(this.clientId, sessionIdResponseBody.clientId) && Intrinsics.areEqual(this.nonce, sessionIdResponseBody.nonce) && Intrinsics.areEqual(this.isBnplEnabled, sessionIdResponseBody.isBnplEnabled) && Intrinsics.areEqual(this.codeChallengeMethod, sessionIdResponseBody.codeChallengeMethod) && Intrinsics.areEqual(this.codeChallenge, sessionIdResponseBody.codeChallenge) && Intrinsics.areEqual(this.scope, sessionIdResponseBody.scope) && Intrinsics.areEqual(this.refreshTokenIsActive, sessionIdResponseBody.refreshTokenIsActive);
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
        int iA = AbstractC1553e.a(this.nonce, AbstractC1553e.a(this.clientId, AbstractC1553e.a(this.sessionId, AbstractC1553e.a(this.state, this.deeplink.hashCode() * 31, 31), 31), 31), 31);
        Boolean bool = this.isBnplEnabled;
        int iA2 = AbstractC1553e.a(this.scope, AbstractC1553e.a(this.codeChallenge, AbstractC1553e.a(this.codeChallengeMethod, (iA + (bool == null ? 0 : bool.hashCode())) * 31, 31), 31), 31);
        Boolean bool2 = this.refreshTokenIsActive;
        return iA2 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final Boolean isBnplEnabled() {
        return this.isBnplEnabled;
    }

    public String toString() {
        return "SessionIdResponseBody(deeplink=" + this.deeplink + ", state=" + this.state + ", sessionId=" + this.sessionId + ", clientId=" + this.clientId + ", nonce=" + this.nonce + ", isBnplEnabled=" + this.isBnplEnabled + ", codeChallengeMethod=" + this.codeChallengeMethod + ", codeChallenge=" + this.codeChallenge + ", scope=" + this.scope + ", refreshTokenIsActive=" + this.refreshTokenIsActive + ')';
    }

    public SessionIdResponseBody(String deeplink, String state, String sessionId, String clientId, String nonce, Boolean bool, String codeChallengeMethod, String codeChallenge, String scope, Boolean bool2) {
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        Intrinsics.checkNotNullParameter(codeChallengeMethod, "codeChallengeMethod");
        Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.deeplink = deeplink;
        this.state = state;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.nonce = nonce;
        this.isBnplEnabled = bool;
        this.codeChallengeMethod = codeChallengeMethod;
        this.codeChallenge = codeChallenge;
        this.scope = scope;
        this.refreshTokenIsActive = bool2;
    }

    public /* synthetic */ SessionIdResponseBody(String str, String str2, String str3, String str4, String str5, Boolean bool, String str6, String str7, String str8, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "-1" : str, (i & 2) != 0 ? "-1" : str2, (i & 4) != 0 ? "-1" : str3, (i & 8) != 0 ? "-1" : str4, (i & 16) != 0 ? "-1" : str5, (i & 32) != 0 ? null : bool, (i & 64) != 0 ? "-1" : str6, (i & 128) != 0 ? "-1" : str7, (i & 256) == 0 ? str8 : "-1", (i & 512) == 0 ? bool2 : null);
    }
}
