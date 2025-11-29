package ru.yoomoney.sdk.auth.api.passwordRecovery;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryChooseAccountResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryEnterPhoneResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoveryResponse;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordRequest;
import ru.yoomoney.sdk.auth.api.passwordRecovery.method.PasswordRecoverySetPasswordResponse;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0011J2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0011J2\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ<\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020#H§@¢\u0006\u0002\u0010$¨\u0006%"}, d2 = {"Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryApi;", "", "chooseAccount", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountResponse;", "token", "", "passwordRecoveryProcessId", "request", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResendResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResendResponse;", "enterPhone", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecovery", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordResponse;", "geolocationHeader", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PasswordRecoveryApi {
    @POST("password-recovery/{passwordRecoveryProcessId}/choose-account")
    Object chooseAccount(@Header("Authorization") String str, @Path("passwordRecoveryProcessId") String str2, @Body PasswordRecoveryChooseAccountRequest passwordRecoveryChooseAccountRequest, Continuation<? super Response<PasswordRecoveryChooseAccountResponse>> continuation);

    @POST("password-recovery/{passwordRecoveryProcessId}/confirm-email")
    Object confirmEmail(@Header("Authorization") String str, @Path("passwordRecoveryProcessId") String str2, @Body PasswordRecoveryConfirmEmailRequest passwordRecoveryConfirmEmailRequest, Continuation<? super Response<PasswordRecoveryConfirmEmailResponse>> continuation);

    @POST("password-recovery/{passwordRecoveryProcessId}/confirm-email/resend")
    Object confirmEmailResend(@Header("Authorization") String str, @Path("passwordRecoveryProcessId") String str2, Continuation<? super Response<PasswordRecoveryConfirmEmailResendResponse>> continuation);

    @POST("password-recovery/{passwordRecoveryProcessId}/confirm-phone")
    Object confirmPhone(@Header("Authorization") String str, @Path("passwordRecoveryProcessId") String str2, @Body PasswordRecoveryConfirmPhoneRequest passwordRecoveryConfirmPhoneRequest, Continuation<? super Response<PasswordRecoveryConfirmPhoneResponse>> continuation);

    @POST("password-recovery/{passwordRecoveryProcessId}/confirm-phone/resend")
    Object confirmPhoneResend(@Header("Authorization") String str, @Path("passwordRecoveryProcessId") String str2, Continuation<? super Response<PasswordRecoveryConfirmPhoneResendResponse>> continuation);

    @POST("password-recovery/{passwordRecoveryProcessId}/enter-phone")
    Object enterPhone(@Header("Authorization") String str, @Path("passwordRecoveryProcessId") String str2, @Body PasswordRecoveryEnterPhoneRequest passwordRecoveryEnterPhoneRequest, Continuation<? super Response<PasswordRecoveryEnterPhoneResponse>> continuation);

    @POST("password-recovery")
    Object passwordRecovery(@Header("Authorization") String str, @Body PasswordRecoveryRequest passwordRecoveryRequest, Continuation<? super Response<PasswordRecoveryResponse>> continuation);

    @POST("password-recovery/{passwordRecoveryProcessId}/set-password")
    Object setPassword(@Header("Authorization") String str, @Header("X-Geolocation") String str2, @Path("passwordRecoveryProcessId") String str3, @Body PasswordRecoverySetPasswordRequest passwordRecoverySetPasswordRequest, Continuation<? super Response<PasswordRecoverySetPasswordResponse>> continuation);
}
