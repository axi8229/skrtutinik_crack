package ru.yoomoney.sdk.auth.api.auxAuthorization;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.yoomoney.sdk.auth.api.auxAuthorization.method.AuxAuthorizationInfoRequest;
import ru.yoomoney.sdk.auth.api.auxAuthorization.method.AuxAuthorizationRequest;
import ru.yoomoney.sdk.auth.api.auxAuthorization.model.AuxToken;
import ru.yoomoney.sdk.auth.api.model.ApplicationInfo;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lru/yoomoney/sdk/auth/api/auxAuthorization/AuxAuthorizationApi;", "", "auxAuthorization", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/model/AuxToken;", "token", "", "request", "Lru/yoomoney/sdk/auth/api/auxAuthorization/method/AuxAuthorizationRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/auxAuthorization/method/AuxAuthorizationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auxAuthorizationInfo", "Lru/yoomoney/sdk/auth/api/model/ApplicationInfo;", "Lru/yoomoney/sdk/auth/api/auxAuthorization/method/AuxAuthorizationInfoRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/auxAuthorization/method/AuxAuthorizationInfoRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AuxAuthorizationApi {
    @POST("aux-authorization")
    Object auxAuthorization(@Header("Authorization") String str, @Body AuxAuthorizationRequest auxAuthorizationRequest, Continuation<? super Response<AuxToken>> continuation);

    @POST("aux-authorization/issue-info")
    Object auxAuthorizationInfo(@Header("Authorization") String str, @Body AuxAuthorizationInfoRequest auxAuthorizationInfoRequest, Continuation<? super Response<ApplicationInfo>> continuation);
}
