package ru.yoomoney.sdk.auth.api.login;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
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
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0012H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\bJ,\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u001aH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\bJ,\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\"H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J,\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020'H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J,\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020,H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J$\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\u0006\u0010\f\u001a\u000201H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Lru/yoomoney/sdk/auth/api/login/LoginRepository;", "", "acquireAuthorization", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/login/method/LoginAcquireAuthorizationResponse;", "loginProcessId", "", "acquireAuthorization-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "chooseAccount", "Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountResponse;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "request", "Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountRequest;", "chooseAccount-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginChooseAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/login/method/LoginConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enterIdentifier", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierRequest;", "enterIdentifier-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterIdentifierRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterOauthCode", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;", "enterOauthCode-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterOauthCodeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPassword", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordRequest;", "enterPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/login/method/LoginEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lru/yoomoney/sdk/auth/api/login/method/LoginResponse;", "Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;", "login-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/login/method/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LoginRepository {
    /* renamed from: acquireAuthorization-gIAlu-s, reason: not valid java name */
    Object mo3261acquireAuthorizationgIAlus(String str, Continuation<? super Result<? extends LoginAcquireAuthorizationResponse>> continuation);

    /* renamed from: chooseAccount-0E7RQCE, reason: not valid java name */
    Object mo3262chooseAccount0E7RQCE(String str, LoginChooseAccountRequest loginChooseAccountRequest, Continuation<? super Result<? extends LoginChooseAccountResponse>> continuation);

    /* renamed from: confirmEmail-0E7RQCE, reason: not valid java name */
    Object mo3263confirmEmail0E7RQCE(String str, LoginConfirmEmailRequest loginConfirmEmailRequest, Continuation<? super Result<? extends LoginConfirmEmailResponse>> continuation);

    /* renamed from: confirmEmailResend-gIAlu-s, reason: not valid java name */
    Object mo3264confirmEmailResendgIAlus(String str, Continuation<? super Result<? extends LoginConfirmEmailResendResponse>> continuation);

    /* renamed from: confirmPhone-0E7RQCE, reason: not valid java name */
    Object mo3265confirmPhone0E7RQCE(String str, LoginConfirmPhoneRequest loginConfirmPhoneRequest, Continuation<? super Result<? extends LoginConfirmPhoneResponse>> continuation);

    /* renamed from: confirmPhoneResend-gIAlu-s, reason: not valid java name */
    Object mo3266confirmPhoneResendgIAlus(String str, Continuation<? super Result<? extends LoginConfirmPhoneResendResponse>> continuation);

    /* renamed from: enterIdentifier-0E7RQCE, reason: not valid java name */
    Object mo3267enterIdentifier0E7RQCE(String str, LoginEnterIdentifierRequest loginEnterIdentifierRequest, Continuation<? super Result<? extends LoginEnterIdentifierResponse>> continuation);

    /* renamed from: enterOauthCode-0E7RQCE, reason: not valid java name */
    Object mo3268enterOauthCode0E7RQCE(String str, LoginEnterOauthCodeRequest loginEnterOauthCodeRequest, Continuation<? super Result<? extends LoginEnterOauthCodeResponse>> continuation);

    /* renamed from: enterPassword-0E7RQCE, reason: not valid java name */
    Object mo3269enterPassword0E7RQCE(String str, LoginEnterPasswordRequest loginEnterPasswordRequest, Continuation<? super Result<? extends LoginEnterPasswordResponse>> continuation);

    /* renamed from: login-gIAlu-s, reason: not valid java name */
    Object mo3270logingIAlus(LoginRequest loginRequest, Continuation<? super Result<? extends LoginResponse>> continuation);
}
