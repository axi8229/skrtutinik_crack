package ru.yoomoney.sdk.auth.api.enrollment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcceptTermsResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentAcquireAuthorizationResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResendResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmEmailResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetEmailResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPasswordRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPasswordResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.enrollment.method.EnrollmentSuggestAccountContinueResponse;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\bJ2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\bJ2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u0014H§@¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\bJ(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u001aH§@¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u001eH§@¢\u0006\u0002\u0010\u001fJ2\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\"H§@¢\u0006\u0002\u0010#J2\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020&H§@¢\u0006\u0002\u0010'J(\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\b¨\u0006*"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentApi;", "", "acceptTerms", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentAcceptTermsResponse;", "token", "", "enrollmentProcessId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireAuthorization", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentAcquireAuthorizationResponse;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResponse;", "request", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResendResponse;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneResendResponse;", "enrollment", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneRequest;", "(Ljava/lang/String;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suggestAccountContinue", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSuggestAccountContinueResponse;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface EnrollmentApi {
    @POST("enrollment/{enrollmentProcessId}/accept-terms")
    Object acceptTerms(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, Continuation<? super Response<EnrollmentAcceptTermsResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/acquire-authorization")
    Object acquireAuthorization(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, Continuation<? super Response<EnrollmentAcquireAuthorizationResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/confirm-email")
    Object confirmEmail(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, @Body EnrollmentConfirmEmailRequest enrollmentConfirmEmailRequest, Continuation<? super Response<EnrollmentConfirmEmailResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/confirm-email/resend")
    Object confirmEmailResend(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, Continuation<? super Response<EnrollmentConfirmEmailResendResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/confirm-phone")
    Object confirmPhone(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, @Body EnrollmentConfirmPhoneRequest enrollmentConfirmPhoneRequest, Continuation<? super Response<EnrollmentConfirmPhoneResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/confirm-phone/resend")
    Object confirmPhoneResend(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, Continuation<? super Response<EnrollmentConfirmPhoneResendResponse>> continuation);

    @POST("enrollment")
    Object enrollment(@Header("Authorization") String str, @Body EnrollmentRequest enrollmentRequest, Continuation<? super Response<EnrollmentResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/set-email")
    Object setEmail(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, @Body EnrollmentSetEmailRequest enrollmentSetEmailRequest, Continuation<? super Response<EnrollmentSetEmailResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/set-password")
    Object setPassword(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, @Body EnrollmentSetPasswordRequest enrollmentSetPasswordRequest, Continuation<? super Response<EnrollmentSetPasswordResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/set-phone")
    Object setPhone(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, @Body EnrollmentSetPhoneRequest enrollmentSetPhoneRequest, Continuation<? super Response<EnrollmentSetPhoneResponse>> continuation);

    @POST("enrollment/{enrollmentProcessId}/suggest-account/continue")
    Object suggestAccountContinue(@Header("Authorization") String str, @Path("enrollmentProcessId") String str2, Continuation<? super Response<EnrollmentSuggestAccountContinueResponse>> continuation);
}
