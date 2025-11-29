package ru.yoomoney.sdk.auth.api.login.method;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeEsiaRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;", "code", "", "state", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getState", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class LoginEnterOauthCodeEsiaRequest extends LoginEnterOauthCodeRequest {

    @SerializedName("code")
    private final String code;

    @SerializedName("state")
    private final String state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginEnterOauthCodeEsiaRequest(String code, String state) {
        super(OauthServiceProvider.ESIA, null);
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(state, "state");
        this.code = code;
        this.state = state;
    }

    public static /* synthetic */ LoginEnterOauthCodeEsiaRequest copy$default(LoginEnterOauthCodeEsiaRequest loginEnterOauthCodeEsiaRequest, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginEnterOauthCodeEsiaRequest.code;
        }
        if ((i & 2) != 0) {
            str2 = loginEnterOauthCodeEsiaRequest.state;
        }
        return loginEnterOauthCodeEsiaRequest.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getState() {
        return this.state;
    }

    public final LoginEnterOauthCodeEsiaRequest copy(String code, String state) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(state, "state");
        return new LoginEnterOauthCodeEsiaRequest(code, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginEnterOauthCodeEsiaRequest)) {
            return false;
        }
        LoginEnterOauthCodeEsiaRequest loginEnterOauthCodeEsiaRequest = (LoginEnterOauthCodeEsiaRequest) other;
        return Intrinsics.areEqual(this.code, loginEnterOauthCodeEsiaRequest.code) && Intrinsics.areEqual(this.state, loginEnterOauthCodeEsiaRequest.state);
    }

    @Override // ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeRequest
    public String getCode() {
        return this.code;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode() + (this.code.hashCode() * 31);
    }

    public String toString() {
        return "LoginEnterOauthCodeEsiaRequest(code=" + this.code + ", state=" + this.state + ")";
    }
}
