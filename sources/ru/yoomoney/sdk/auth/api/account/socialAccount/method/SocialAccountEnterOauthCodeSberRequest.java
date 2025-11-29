package ru.yoomoney.sdk.auth.api.account.socialAccount.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.a;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeSberRequest;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "code", "", "state", "redirectUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getRedirectUrl", "getState", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccountEnterOauthCodeSberRequest extends SocialAccountEnterOauthCodeRequest {

    @SerializedName("code")
    private final String code;

    @SerializedName("redirectUrl")
    private final String redirectUrl;

    @SerializedName("state")
    private final String state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialAccountEnterOauthCodeSberRequest(String code, String state, String redirectUrl) {
        super(OauthServiceProvider.SBER, null);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        this.code = code;
        this.state = state;
        this.redirectUrl = redirectUrl;
    }

    public static /* synthetic */ SocialAccountEnterOauthCodeSberRequest copy$default(SocialAccountEnterOauthCodeSberRequest socialAccountEnterOauthCodeSberRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = socialAccountEnterOauthCodeSberRequest.code;
        }
        if ((i & 2) != 0) {
            str2 = socialAccountEnterOauthCodeSberRequest.state;
        }
        if ((i & 4) != 0) {
            str3 = socialAccountEnterOauthCodeSberRequest.redirectUrl;
        }
        return socialAccountEnterOauthCodeSberRequest.copy(str, str2, str3);
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

    public final SocialAccountEnterOauthCodeSberRequest copy(String code, String state, String redirectUrl) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        return new SocialAccountEnterOauthCodeSberRequest(code, state, redirectUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SocialAccountEnterOauthCodeSberRequest)) {
            return false;
        }
        SocialAccountEnterOauthCodeSberRequest socialAccountEnterOauthCodeSberRequest = (SocialAccountEnterOauthCodeSberRequest) other;
        return Intrinsics.areEqual(this.code, socialAccountEnterOauthCodeSberRequest.code) && Intrinsics.areEqual(this.state, socialAccountEnterOauthCodeSberRequest.state) && Intrinsics.areEqual(this.redirectUrl, socialAccountEnterOauthCodeSberRequest.redirectUrl);
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest
    public String getCode() {
        return this.code;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.redirectUrl.hashCode() + a.a(this.state, this.code.hashCode() * 31, 31);
    }

    public String toString() {
        return "SocialAccountEnterOauthCodeSberRequest(code=" + this.code + ", state=" + this.state + ", redirectUrl=" + this.redirectUrl + ")";
    }
}
