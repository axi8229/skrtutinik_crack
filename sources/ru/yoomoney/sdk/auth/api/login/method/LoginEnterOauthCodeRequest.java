package ru.yoomoney.sdk.auth.api.login.method;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;
import ru.yoomoney.sdk.auth.api.login.serializer.LoginEnterOauthCodeRequestSerializer;

@JsonAdapter(LoginEnterOauthCodeRequestSerializer.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;", "", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;)V", "code", "", "getCode", "()Ljava/lang/String;", "getOauthService", "()Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeAppleRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeEsiaRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeSberRequest;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeVkRequest;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class LoginEnterOauthCodeRequest {

    @SerializedName("oauthService")
    private final OauthServiceProvider oauthService;

    private LoginEnterOauthCodeRequest(OauthServiceProvider oauthServiceProvider) {
        this.oauthService = oauthServiceProvider;
    }

    public abstract String getCode();

    public final OauthServiceProvider getOauthService() {
        return this.oauthService;
    }

    public /* synthetic */ LoginEnterOauthCodeRequest(OauthServiceProvider oauthServiceProvider, DefaultConstructorMarker defaultConstructorMarker) {
        this(oauthServiceProvider);
    }
}
