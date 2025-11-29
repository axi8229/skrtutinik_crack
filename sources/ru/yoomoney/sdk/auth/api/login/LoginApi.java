package ru.yoomoney.sdk.auth.api.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.login.method.LoginAcquireAuthorizationResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginChooseAccountResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterIdentifierRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterIdentifierResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterOauthCodeResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterPasswordRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.login.method.LoginRequest;
import ru.yoomoney.sdk.auth.api.login.method.LoginResponse;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\tJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0015J2\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0015J2\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ2\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\"H§@¢\u0006\u0002\u0010#J2\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020&H§@¢\u0006\u0002\u0010'J(\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020*H§@¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginApi;", "", "acquireAuthorization", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/login/method/LoginAcquireAuthorizationResponse;", "token", "", "geolocationHeader", "loginProcessId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chooseAccount", "Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountResponse;", "request", "Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResendResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneResendResponse;", "enterIdentifier", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCode", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPassword", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lru/yoomoney/sdk/auth/api/login/method/LoginResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LoginApi {
    @POST("login/{loginProcessId}/acquire-authorization")
    Object acquireAuthorization(@Header("Authorization") String str, @Header("X-Geolocation") String str2, @Path("loginProcessId") String str3, Continuation<? super Response<LoginAcquireAuthorizationResponse>> continuation);

    @POST("login/{loginProcessId}/choose-account")
    Object chooseAccount(@Header("Authorization") String str, @Path("loginProcessId") String str2, @Body LoginChooseAccountRequest loginChooseAccountRequest, Continuation<? super Response<LoginChooseAccountResponse>> continuation);

    @POST("login/{loginProcessId}/confirm-email")
    Object confirmEmail(@Header("Authorization") String str, @Path("loginProcessId") String str2, @Body LoginConfirmEmailRequest loginConfirmEmailRequest, Continuation<? super Response<LoginConfirmEmailResponse>> continuation);

    @POST("login/{loginProcessId}/confirm-email/resend")
    Object confirmEmailResend(@Header("Authorization") String str, @Path("loginProcessId") String str2, Continuation<? super Response<LoginConfirmEmailResendResponse>> continuation);

    @POST("login/{loginProcessId}/confirm-phone")
    Object confirmPhone(@Header("Authorization") String str, @Path("loginProcessId") String str2, @Body LoginConfirmPhoneRequest loginConfirmPhoneRequest, Continuation<? super Response<LoginConfirmPhoneResponse>> continuation);

    @POST("login/{loginProcessId}/confirm-phone/resend")
    Object confirmPhoneResend(@Header("Authorization") String str, @Path("loginProcessId") String str2, Continuation<? super Response<LoginConfirmPhoneResendResponse>> continuation);

    @POST("login/{loginProcessId}/enter-identifier")
    Object enterIdentifier(@Header("Authorization") String str, @Path("loginProcessId") String str2, @Body LoginEnterIdentifierRequest loginEnterIdentifierRequest, Continuation<? super Response<LoginEnterIdentifierResponse>> continuation);

    @POST("login/{loginProcessId}/enter-oauth-code")
    Object enterOauthCode(@Header("Authorization") String str, @Path("loginProcessId") String str2, @Body LoginEnterOauthCodeRequest loginEnterOauthCodeRequest, Continuation<? super Response<LoginEnterOauthCodeResponse>> continuation);

    @POST("login/{loginProcessId}/enter-password")
    Object enterPassword(@Header("Authorization") String str, @Path("loginProcessId") String str2, @Body LoginEnterPasswordRequest loginEnterPasswordRequest, Continuation<? super Response<LoginEnterPasswordResponse>> continuation);

    @POST("login")
    Object login(@Header("Authorization") String str, @Body LoginRequest loginRequest, Continuation<? super Response<LoginResponse>> continuation);
}
