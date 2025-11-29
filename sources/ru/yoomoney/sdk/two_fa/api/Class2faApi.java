package ru.yoomoney.sdk.two_fa.api;

import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.core_api.ApiResponse;
import ru.yoomoney.sdk.two_fa.api.method.CheckAuthSessionApiRequest;
import ru.yoomoney.sdk.two_fa.api.method.CheckAuthSessionApiResponse;
import ru.yoomoney.sdk.two_fa.api.method.GetAuthContextApiResponse;
import ru.yoomoney.sdk.two_fa.api.method.ListAuthSessionApiRequest;
import ru.yoomoney.sdk.two_fa.api.method.ListAuthSessionApiResponse;
import ru.yoomoney.sdk.two_fa.api.method.StartAuthSessionApiRequest;
import ru.yoomoney.sdk.two_fa.api.method.StartAuthSessionApiResponse;
import ru.yoomoney.sdk.two_fa.api.model.CheckAuthSessionRuleViolationError;
import ru.yoomoney.sdk.two_fa.api.model.StartAuthSessionRuleViolationError;

/* compiled from: Class2faApi.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J$\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH'J$\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'J$\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/two_fa/api/Class2faApi;", "", "authContextAuthProcessIdGet", "Lru/yoomoney/sdk/core_api/ApiResponse;", "Lru/yoomoney/sdk/two_fa/api/method/GetAuthContextApiResponse;", "authProcessId", "", "authSessionCheckPost", "Lru/yoomoney/sdk/two_fa/api/method/CheckAuthSessionApiResponse;", "Lru/yoomoney/sdk/two_fa/api/model/CheckAuthSessionRuleViolationError;", "checkAuthSessionApiRequest", "Lru/yoomoney/sdk/two_fa/api/method/CheckAuthSessionApiRequest;", "authSessionListPost", "Lru/yoomoney/sdk/two_fa/api/method/ListAuthSessionApiResponse;", "listAuthSessionApiRequest", "Lru/yoomoney/sdk/two_fa/api/method/ListAuthSessionApiRequest;", "authSessionStartPost", "Lru/yoomoney/sdk/two_fa/api/method/StartAuthSessionApiResponse;", "Lru/yoomoney/sdk/two_fa/api/model/StartAuthSessionRuleViolationError;", "startAuthSessionApiRequest", "Lru/yoomoney/sdk/two_fa/api/method/StartAuthSessionApiRequest;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface Class2faApi {
    @GET("auth/context/{authProcessId}")
    ApiResponse<GetAuthContextApiResponse, Object, Object> authContextAuthProcessIdGet(@Path(encoded = true, value = "authProcessId") String authProcessId);

    @POST("auth/session/check")
    ApiResponse<CheckAuthSessionApiResponse, CheckAuthSessionRuleViolationError, Object> authSessionCheckPost(@Body CheckAuthSessionApiRequest checkAuthSessionApiRequest);

    @POST("auth/session/list")
    ApiResponse<ListAuthSessionApiResponse, Object, Object> authSessionListPost(@Body ListAuthSessionApiRequest listAuthSessionApiRequest);

    @POST("auth/session/start")
    ApiResponse<StartAuthSessionApiResponse, StartAuthSessionRuleViolationError, Object> authSessionStartPost(@Body StartAuthSessionApiRequest startAuthSessionApiRequest);
}
