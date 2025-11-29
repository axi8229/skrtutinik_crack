package ru.yoomoney.sdk.auth.api.account.socialAccount.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeVkRequest;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "code", "", "state", "redirectUrl", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getRedirectUrl", "getSessionId", "getState", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccountEnterOauthCodeVkRequest extends SocialAccountEnterOauthCodeRequest {

    @SerializedName("code")
    private final String code;

    @SerializedName("redirectUrl")
    private final String redirectUrl;

    @SerializedName("sessionId")
    private final String sessionId;

    @SerializedName("state")
    private final String state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialAccountEnterOauthCodeVkRequest(String code, String state, String redirectUrl, String sessionId) {
        super(OauthServiceProvider.VK, null);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.code = code;
        this.state = state;
        this.redirectUrl = redirectUrl;
        this.sessionId = sessionId;
    }

    public static /* synthetic */ SocialAccountEnterOauthCodeVkRequest copy$default(SocialAccountEnterOauthCodeVkRequest socialAccountEnterOauthCodeVkRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = socialAccountEnterOauthCodeVkRequest.code;
        }
        if ((i & 2) != 0) {
            str2 = socialAccountEnterOauthCodeVkRequest.state;
        }
        if ((i & 4) != 0) {
            str3 = socialAccountEnterOauthCodeVkRequest.redirectUrl;
        }
        if ((i & 8) != 0) {
            str4 = socialAccountEnterOauthCodeVkRequest.sessionId;
        }
        return socialAccountEnterOauthCodeVkRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public final SocialAccountEnterOauthCodeVkRequest copy(String code, String state, String redirectUrl, String sessionId) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new SocialAccountEnterOauthCodeVkRequest(code, state, redirectUrl, sessionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialAccountEnterOauthCodeVkRequest)) {
            return false;
        }
        SocialAccountEnterOauthCodeVkRequest socialAccountEnterOauthCodeVkRequest = (SocialAccountEnterOauthCodeVkRequest) other;
        return Intrinsics.areEqual(this.code, socialAccountEnterOauthCodeVkRequest.code) && Intrinsics.areEqual(this.state, socialAccountEnterOauthCodeVkRequest.state) && Intrinsics.areEqual(this.redirectUrl, socialAccountEnterOauthCodeVkRequest.redirectUrl) && Intrinsics.areEqual(this.sessionId, socialAccountEnterOauthCodeVkRequest.sessionId);
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest
    public String getCode() {
        return this.code;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.sessionId.hashCode() + a.a(this.redirectUrl, a.a(this.state, this.code.hashCode() * 31, 31), 31);
    }

    public String toString() {
        return "SocialAccountEnterOauthCodeVkRequest(code=" + this.code + ", state=" + this.state + ", redirectUrl=" + this.redirectUrl + ", sessionId=" + this.sessionId + ")";
    }
}
