package ru.yoomoney.sdk.auth.api.webAuthorization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.yoomoney.sdk.auth.api.webAuthorization.method.WebAuthorizationRequest;
import ru.yoomoney.sdk.auth.api.webAuthorization.method.WebAuthorizationResponse;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/api/webAuthorization/WebAuthorizationApi;", "", "webAuthorization", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/webAuthorization/method/WebAuthorizationResponse;", "token", "", "request", "Lru/yoomoney/sdk/auth/api/webAuthorization/method/WebAuthorizationRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/webAuthorization/method/WebAuthorizationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface WebAuthorizationApi {
    @POST("web-authorization")
    Object webAuthorization(@Header("Authorization") String str, @Body WebAuthorizationRequest webAuthorizationRequest, Continuation<? super Response<WebAuthorizationResponse>> continuation);
}
