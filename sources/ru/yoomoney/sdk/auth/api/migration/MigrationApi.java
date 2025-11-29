package ru.yoomoney.sdk.auth.api.migration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationAcquireAuthorizationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetEmailResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenRequest;
import ru.yoomoney.sdk.auth.api.migration.method.MigrationSetYandexTokenResponse;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0011J(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ2\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\"H§@¢\u0006\u0002\u0010#J2\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020&H§@¢\u0006\u0002\u0010'J2\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020*H§@¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"Lru/yoomoney/sdk/auth/api/migration/MigrationApi;", "", "acquireAuthorization", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationAcquireAuthorizationResponse;", "token", "", "geolocationHeader", "migrationProcessId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResponse;", "request", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmEmailResendResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationConfirmPhoneResendResponse;", "migration", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setYandexToken", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenResponse;", "Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/migration/method/MigrationSetYandexTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MigrationApi {
    @POST("migration/{migrationProcessId}/acquire-authorization")
    Object acquireAuthorization(@Header("Authorization") String str, @Header("X-Geolocation") String str2, @Path("migrationProcessId") String str3, Continuation<? super Response<MigrationAcquireAuthorizationResponse>> continuation);

    @POST("migration/{migrationProcessId}/confirm-email")
    Object confirmEmail(@Header("Authorization") String str, @Path("migrationProcessId") String str2, @Body MigrationConfirmEmailRequest migrationConfirmEmailRequest, Continuation<? super Response<MigrationConfirmEmailResponse>> continuation);

    @POST("migration/{migrationProcessId}/confirm-email/resend")
    Object confirmEmailResend(@Header("Authorization") String str, @Path("migrationProcessId") String str2, Continuation<? super Response<MigrationConfirmEmailResendResponse>> continuation);

    @POST("migration/{migrationProcessId}/confirm-phone")
    Object confirmPhone(@Header("Authorization") String str, @Path("migrationProcessId") String str2, @Body MigrationConfirmPhoneRequest migrationConfirmPhoneRequest, Continuation<? super Response<MigrationConfirmPhoneResponse>> continuation);

    @POST("migration/{migrationProcessId}/confirm-phone/resend")
    Object confirmPhoneResend(@Header("Authorization") String str, @Path("migrationProcessId") String str2, Continuation<? super Response<MigrationConfirmPhoneResendResponse>> continuation);

    @POST("migration")
    Object migration(@Header("Authorization") String str, @Body MigrationRequest migrationRequest, Continuation<? super Response<MigrationResponse>> continuation);

    @POST("migration/{migrationProcessId}/set-email")
    Object setEmail(@Header("Authorization") String str, @Path("migrationProcessId") String str2, @Body MigrationSetEmailRequest migrationSetEmailRequest, Continuation<? super Response<MigrationSetEmailResponse>> continuation);

    @POST("migration/{migrationProcessId}/set-password")
    Object setPassword(@Header("Authorization") String str, @Path("migrationProcessId") String str2, @Body MigrationSetPasswordRequest migrationSetPasswordRequest, Continuation<? super Response<MigrationSetPasswordResponse>> continuation);

    @POST("migration/{migrationProcessId}/set-phone")
    Object setPhone(@Header("Authorization") String str, @Path("migrationProcessId") String str2, @Body MigrationSetPhoneRequest migrationSetPhoneRequest, Continuation<? super Response<MigrationSetPhoneResponse>> continuation);

    @POST("migration/{migrationProcessId}/set-yandex-token")
    Object setYandexToken(@Header("Authorization") String str, @Path("migrationProcessId") String str2, @Body MigrationSetYandexTokenRequest migrationSetYandexTokenRequest, Continuation<? super Response<MigrationSetYandexTokenResponse>> continuation);
}
