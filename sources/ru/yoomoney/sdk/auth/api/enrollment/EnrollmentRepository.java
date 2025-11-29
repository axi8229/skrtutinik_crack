package ru.yoomoney.sdk.auth.api.enrollment;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
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

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\bJ,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\bJ,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0017H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\bJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u000e\u001a\u00020\u001fH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J,\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020$H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&J,\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020)H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J,\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020.H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J$\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\b\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Lru/yoomoney/sdk/auth/api/enrollment/EnrollmentRepository;", "", "acceptTerms", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentAcceptTermsResponse;", "enrollmentProcessId", "", "acceptTerms-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireAuthorization", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentAcquireAuthorizationResponse;", "acquireAuthorization-gIAlu-s", "confirmEmail", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResponse;", "request", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enrollment", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentRequest;", "enrollment-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailRequest;", "setEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneRequest;", "setPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suggestAccount", "Lru/yoomoney/sdk/auth/api/enrollment/method/EnrollmentSuggestAccountContinueResponse;", "suggestAccount-gIAlu-s", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface EnrollmentRepository {
    /* renamed from: acceptTerms-gIAlu-s, reason: not valid java name */
    Object mo3248acceptTermsgIAlus(String str, Continuation<? super Result<? extends EnrollmentAcceptTermsResponse>> continuation);

    /* renamed from: acquireAuthorization-gIAlu-s, reason: not valid java name */
    Object mo3249acquireAuthorizationgIAlus(String str, Continuation<? super Result<? extends EnrollmentAcquireAuthorizationResponse>> continuation);

    /* renamed from: confirmEmail-0E7RQCE, reason: not valid java name */
    Object mo3250confirmEmail0E7RQCE(String str, EnrollmentConfirmEmailRequest enrollmentConfirmEmailRequest, Continuation<? super Result<? extends EnrollmentConfirmEmailResponse>> continuation);

    /* renamed from: confirmEmailResend-gIAlu-s, reason: not valid java name */
    Object mo3251confirmEmailResendgIAlus(String str, Continuation<? super Result<? extends EnrollmentConfirmEmailResendResponse>> continuation);

    /* renamed from: confirmPhone-0E7RQCE, reason: not valid java name */
    Object mo3252confirmPhone0E7RQCE(String str, EnrollmentConfirmPhoneRequest enrollmentConfirmPhoneRequest, Continuation<? super Result<? extends EnrollmentConfirmPhoneResponse>> continuation);

    /* renamed from: confirmPhoneResend-gIAlu-s, reason: not valid java name */
    Object mo3253confirmPhoneResendgIAlus(String str, Continuation<? super Result<? extends EnrollmentConfirmPhoneResendResponse>> continuation);

    /* renamed from: enrollment-gIAlu-s, reason: not valid java name */
    Object mo3254enrollmentgIAlus(EnrollmentRequest enrollmentRequest, Continuation<? super Result<EnrollmentResponse>> continuation);

    /* renamed from: setEmail-0E7RQCE, reason: not valid java name */
    Object mo3255setEmail0E7RQCE(String str, EnrollmentSetEmailRequest enrollmentSetEmailRequest, Continuation<? super Result<? extends EnrollmentSetEmailResponse>> continuation);

    /* renamed from: setPassword-0E7RQCE, reason: not valid java name */
    Object mo3256setPassword0E7RQCE(String str, EnrollmentSetPasswordRequest enrollmentSetPasswordRequest, Continuation<? super Result<? extends EnrollmentSetPasswordResponse>> continuation);

    /* renamed from: setPhone-0E7RQCE, reason: not valid java name */
    Object mo3257setPhone0E7RQCE(String str, EnrollmentSetPhoneRequest enrollmentSetPhoneRequest, Continuation<? super Result<? extends EnrollmentSetPhoneResponse>> continuation);

    /* renamed from: suggestAccount-gIAlu-s, reason: not valid java name */
    Object mo3258suggestAccountgIAlus(String str, Continuation<? super Result<? extends EnrollmentSuggestAccountContinueResponse>> continuation);
}
