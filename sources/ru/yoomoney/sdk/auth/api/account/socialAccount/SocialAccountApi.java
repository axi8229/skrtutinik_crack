package ru.yoomoney.sdk.auth.api.account.socialAccount;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.account.model.UserAccount;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.ConnectSocialAccountResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.EnterOauthCodeResponse;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountEnterOauthCodeRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.method.SocialAccountRequest;
import ru.yoomoney.sdk.auth.api.account.socialAccount.model.OauthServiceProvider;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/socialAccount/SocialAccountApi;", "", "deleteSocialAccount", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/account/model/UserAccount;", "authorizationHeader", "", "oauthService", "Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/model/OauthServiceProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOAuthCode", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/EnterOauthCodeResponse;", "connectSocialAccountProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountEnterOauthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "socialAccount", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/ConnectSocialAccountResponse;", "Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/socialAccount/method/SocialAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SocialAccountApi {
    @DELETE("account/social-account/{oauthService}")
    Object deleteSocialAccount(@Header("Authorization") String str, @Path("oauthService") OauthServiceProvider oauthServiceProvider, Continuation<? super Response<UserAccount>> continuation);

    @POST("account/social-account/{connectSocialAccountProcessId}/enter-oauth-code")
    Object enterOAuthCode(@Header("Authorization") String str, @Path("connectSocialAccountProcessId") String str2, @Body SocialAccountEnterOauthCodeRequest socialAccountEnterOauthCodeRequest, Continuation<? super Response<EnterOauthCodeResponse>> continuation);

    @POST("account/social-account/")
    Object socialAccount(@Header("Authorization") String str, @Body SocialAccountRequest socialAccountRequest, Continuation<? super Response<ConnectSocialAccountResponse>> continuation);
}
