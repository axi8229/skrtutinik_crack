package ru.yoomoney.sdk.auth.api.account.passwordChange;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailForgotResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneForgotResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordForgotResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordRequest;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordChangeSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.passwordChange.method.PasswordSuccessResponse;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ2\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010 J<\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010#\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020$H§@¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeApi;", "", "confirmEmail", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResponse;", "authorizationHeader", "", "changePasswordProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailForgotResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResendResponse;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneForgotResponse;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneResendResponse;", "enterPassword", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPasswordForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordForgotResponse;", "password", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordSuccessResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordResponse;", "geolocationHeader", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PasswordChangeApi {
    @POST("account/password/{changePasswordProcessId}/confirm-email")
    Object confirmEmail(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, @Body PasswordChangeConfirmEmailRequest passwordChangeConfirmEmailRequest, Continuation<? super Response<PasswordChangeConfirmEmailResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/confirm-email/forgot")
    Object confirmEmailForgot(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, Continuation<? super Response<PasswordChangeConfirmEmailForgotResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/confirm-email/resend")
    Object confirmEmailResend(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, Continuation<? super Response<PasswordChangeConfirmEmailResendResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/confirm-phone")
    Object confirmPhone(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, @Body PasswordChangeConfirmPhoneRequest passwordChangeConfirmPhoneRequest, Continuation<? super Response<PasswordChangeConfirmPhoneResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/confirm-phone/forgot")
    Object confirmPhoneForgot(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, Continuation<? super Response<PasswordChangeConfirmPhoneForgotResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/confirm-phone/resend")
    Object confirmPhoneResend(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, Continuation<? super Response<PasswordChangeConfirmPhoneResendResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/enter-password")
    Object enterPassword(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, @Body PasswordChangeEnterPasswordRequest passwordChangeEnterPasswordRequest, Continuation<? super Response<PasswordChangeEnterPasswordResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/enter-password/forgot")
    Object enterPasswordForgot(@Header("Authorization") String str, @Path("changePasswordProcessId") String str2, Continuation<? super Response<PasswordChangeEnterPasswordForgotResponse>> continuation);

    @POST("account/password")
    Object password(@Header("Authorization") String str, Continuation<? super Response<PasswordSuccessResponse>> continuation);

    @POST("account/password/{changePasswordProcessId}/set-password")
    Object setPassword(@Header("Authorization") String str, @Header("X-Geolocation") String str2, @Path("changePasswordProcessId") String str3, @Body PasswordChangeSetPasswordRequest passwordChangeSetPasswordRequest, Continuation<? super Response<PasswordChangeSetPasswordResponse>> continuation);
}
