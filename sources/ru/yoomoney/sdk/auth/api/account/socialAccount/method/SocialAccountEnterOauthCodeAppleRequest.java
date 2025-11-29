package ru.yoomoney.sdk.auth.api.account.socialAccount.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeAppleRequest;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "code", "", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SocialAccountEnterOauthCodeAppleRequest extends SocialAccountEnterOauthCodeRequest {

    @SerializedName("code")
    private final String code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialAccountEnterOauthCodeAppleRequest(String code) {
        super(OauthServiceProvider.APPLE, null);
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
    }

    public static /* synthetic */ SocialAccountEnterOauthCodeAppleRequest copy$default(SocialAccountEnterOauthCodeAppleRequest socialAccountEnterOauthCodeAppleRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = socialAccountEnterOauthCodeAppleRequest.code;
        }
        return socialAccountEnterOauthCodeAppleRequest.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final SocialAccountEnterOauthCodeAppleRequest copy(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        return new SocialAccountEnterOauthCodeAppleRequest(code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SocialAccountEnterOauthCodeAppleRequest) && Intrinsics.areEqual(this.code, ((SocialAccountEnterOauthCodeAppleRequest) other).code);
    }

    @Override // ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest
    public String getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public String toString() {
        return "SocialAccountEnterOauthCodeAppleRequest(code=" + this.code + ")";
    }
}
