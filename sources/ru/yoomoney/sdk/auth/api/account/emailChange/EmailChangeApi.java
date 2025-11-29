package ru.yoomoney.sdk.auth.api.account.emailChange;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailForgotResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneForgotResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeEnterPasswordResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailRequest;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailChangeSetEmailResponse;
import ru.yoomoney.sdk.auth.api.account.emailChange.method.EmailSuccessResponse;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ2\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u001dH§@¢\u0006\u0002\u0010\u001eJ2\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020!H§@¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeApi;", "", "confirmEmail", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResponse;", "token", "", "changeEmailProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailForgotResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResendResponse;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneForgotResponse;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneResendResponse;", Scopes.EMAIL, "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailSuccessResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPassword", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface EmailChangeApi {
    @POST("account/email/{changeEmailProcessId}/confirm-email")
    Object confirmEmail(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, @Body EmailChangeConfirmEmailRequest emailChangeConfirmEmailRequest, Continuation<? super Response<EmailChangeConfirmEmailResponse>> continuation);

    @POST("account/email/{changeEmailProcessId}/confirm-email/forgot")
    Object confirmEmailForgot(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, Continuation<? super Response<EmailChangeConfirmEmailForgotResponse>> continuation);

    @POST("account/email/{changeEmailProcessId}/confirm-email/resend")
    Object confirmEmailResend(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, Continuation<? super Response<EmailChangeConfirmEmailResendResponse>> continuation);

    @POST("account/email/{changeEmailProcessId}/confirm-phone")
    Object confirmPhone(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, @Body EmailChangeConfirmPhoneRequest emailChangeConfirmPhoneRequest, Continuation<? super Response<EmailChangeConfirmPhoneResponse>> continuation);

    @POST("account/email/{changeEmailProcessId}/confirm-phone/forgot")
    Object confirmPhoneForgot(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, Continuation<? super Response<EmailChangeConfirmPhoneForgotResponse>> continuation);

    @POST("account/email/{changeEmailProcessId}/confirm-phone/resend")
    Object confirmPhoneResend(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, Continuation<? super Response<EmailChangeConfirmPhoneResendResponse>> continuation);

    @POST("account/email")
    Object email(@Header("Authorization") String str, Continuation<? super Response<EmailSuccessResponse>> continuation);

    @POST("account/email/{changeEmailProcessId}/enter-password")
    Object enterPassword(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, @Body EmailChangeEnterPasswordRequest emailChangeEnterPasswordRequest, Continuation<? super Response<EmailChangeEnterPasswordResponse>> continuation);

    @POST("account/email/{changeEmailProcessId}/set-email")
    Object setEmail(@Header("Authorization") String str, @Path("changeEmailProcessId") String str2, @Body EmailChangeSetEmailRequest emailChangeSetEmailRequest, Continuation<? super Response<EmailChangeSetEmailResponse>> continuation);
}
