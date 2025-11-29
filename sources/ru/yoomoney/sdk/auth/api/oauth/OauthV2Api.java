package ru.yoomoney.sdk.auth.api.oauth;

import kotlin.Metadata;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateAuthorizationCodeRequestApi;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateAuthorizationCodeResponseApi;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateProcessRequestApi;
import ru.yoomoney.sdk.auth.api.oauth.domain.CreateProcessResponseApi;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/api/oauth/OauthV2Api;", "", "authorizationCode", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/oauth/domain/CreateAuthorizationCodeResponseApi;", "token", "", "request", "Lru/yoomoney/sdk/auth/api/oauth/domain/CreateAuthorizationCodeRequestApi;", "createProcess", "Lru/yoomoney/sdk/auth/api/oauth/domain/CreateProcessResponseApi;", "Lru/yoomoney/sdk/auth/api/oauth/domain/CreateProcessRequestApi;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface OauthV2Api {
    @POST("authorization-code")
    Response<CreateAuthorizationCodeResponseApi> authorizationCode(@Header("Authorization") String token, @Body CreateAuthorizationCodeRequestApi request);

    @POST("create-process")
    Response<CreateProcessResponseApi> createProcess(@Header("Authorization") String token, @Body CreateProcessRequestApi request);
}
