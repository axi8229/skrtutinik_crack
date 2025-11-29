package ru.yoomoney.sdk.auth.api.registrationV2.api;

import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationAuthorizationAcquireResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationEmailConfirmResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationEmailSetRequest;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationEmailSetResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationInitResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPasswordSetRequest;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPasswordSetResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPhoneConfirmResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPhoneSetRequest;
import ru.yoomoney.sdk.auth.api.registrationV2.api.method.RegistrationPhoneSetResponse;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationPasswordSetRulesViolationError;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationRequestBase;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationSetEmailRulesViolationError;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.RegistrationSetPhoneRulesViolationError;
import ru.yoomoney.sdk.auth.api.registrationV2.api.model.StepProcessRulesViolationError;
import ru.yoomoney.sdk.auth.net.HttpHeaders;
import ru.yoomoney.sdk.core_api.ApiResponse;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J8\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\bH'J.\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'J:\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0013H'J8\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0007\u001a\u00020\bH'J.\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'J8\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u0007\u001a\u00020\bH'¨\u0006!"}, d2 = {"Lru/yoomoney/sdk/auth/api/registrationV2/api/RegistrationV2Api;", "", "registrationPost", "Lru/yoomoney/sdk/core_api/ApiResponse;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationInitResponse;", "registrationRequestBase", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationRequestBase;", "xApplicationUserAgent", "", "registrationRegistrationProcessIdAuthorizationAcquirePost", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationAuthorizationAcquireResponse;", "registrationProcessId", "geolocationHeader", "registrationRegistrationProcessIdEmailConfirmPost", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationEmailConfirmResponse;", "registrationRegistrationProcessIdEmailSetPost", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationEmailSetResponse;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationSetEmailRulesViolationError;", "registrationEmailSetRequest", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationEmailSetRequest;", "registrationRegistrationProcessIdPasswordSetPost", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationPasswordSetResponse;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationPasswordSetRulesViolationError;", "registrationPasswordSetRequest", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationPasswordSetRequest;", "registrationRegistrationProcessIdPhoneConfirmPost", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationPhoneConfirmResponse;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/StepProcessRulesViolationError;", "registrationRegistrationProcessIdPhoneSetPost", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationPhoneSetResponse;", "Lru/yoomoney/sdk/auth/api/registrationV2/api/model/RegistrationSetPhoneRulesViolationError;", "registrationPhoneSetRequest", "Lru/yoomoney/sdk/auth/api/registrationV2/api/method/RegistrationPhoneSetRequest;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface RegistrationV2Api {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ ApiResponse registrationRegistrationProcessIdEmailSetPost$default(RegistrationV2Api registrationV2Api, String str, String str2, RegistrationEmailSetRequest registrationEmailSetRequest, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registrationRegistrationProcessIdEmailSetPost");
            }
            if ((i & 4) != 0) {
                registrationEmailSetRequest = null;
            }
            return registrationV2Api.registrationRegistrationProcessIdEmailSetPost(str, str2, registrationEmailSetRequest);
        }
    }

    @POST("registration")
    ApiResponse<RegistrationInitResponse, Object, Object> registrationPost(@Body RegistrationRequestBase registrationRequestBase, @Header(HttpHeaders.X_APPLICATION_USER_AGENT) String xApplicationUserAgent);

    @POST("registration/{registrationProcessId}/authorization/acquire")
    ApiResponse<RegistrationAuthorizationAcquireResponse, Object, Object> registrationRegistrationProcessIdAuthorizationAcquirePost(@Path(encoded = true, value = "registrationProcessId") String registrationProcessId, @Header(HttpHeaders.X_APPLICATION_USER_AGENT) String xApplicationUserAgent, @Header("X-Geolocation") String geolocationHeader);

    @POST("registration/{registrationProcessId}/email/confirm")
    ApiResponse<RegistrationEmailConfirmResponse, Object, Object> registrationRegistrationProcessIdEmailConfirmPost(@Path(encoded = true, value = "registrationProcessId") String registrationProcessId, @Header(HttpHeaders.X_APPLICATION_USER_AGENT) String xApplicationUserAgent);

    @POST("registration/{registrationProcessId}/email/set")
    ApiResponse<RegistrationEmailSetResponse, RegistrationSetEmailRulesViolationError, Object> registrationRegistrationProcessIdEmailSetPost(@Path(encoded = true, value = "registrationProcessId") String registrationProcessId, @Header(HttpHeaders.X_APPLICATION_USER_AGENT) String xApplicationUserAgent, @Body RegistrationEmailSetRequest registrationEmailSetRequest);

    @POST("registration/{registrationProcessId}/password/set")
    ApiResponse<RegistrationPasswordSetResponse, RegistrationPasswordSetRulesViolationError, Object> registrationRegistrationProcessIdPasswordSetPost(@Path(encoded = true, value = "registrationProcessId") String registrationProcessId, @Body RegistrationPasswordSetRequest registrationPasswordSetRequest, @Header(HttpHeaders.X_APPLICATION_USER_AGENT) String xApplicationUserAgent);

    @POST("registration/{registrationProcessId}/phone/confirm")
    ApiResponse<RegistrationPhoneConfirmResponse, StepProcessRulesViolationError, Object> registrationRegistrationProcessIdPhoneConfirmPost(@Path(encoded = true, value = "registrationProcessId") String registrationProcessId, @Header(HttpHeaders.X_APPLICATION_USER_AGENT) String xApplicationUserAgent);

    @POST("registration/{registrationProcessId}/phone/set")
    ApiResponse<RegistrationPhoneSetResponse, RegistrationSetPhoneRulesViolationError, Object> registrationRegistrationProcessIdPhoneSetPost(@Path(encoded = true, value = "registrationProcessId") String registrationProcessId, @Body RegistrationPhoneSetRequest registrationPhoneSetRequest, @Header(HttpHeaders.X_APPLICATION_USER_AGENT) String xApplicationUserAgent);
}
