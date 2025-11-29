package ru.yoomoney.sdk.auth.api.account.passwordChange;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
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

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0011J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0017H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00072\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u0011J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0011J,\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\"H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J$\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00072\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010\u0011J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0007H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J,\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020.H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/passwordChange/PasswordChangeRepository;", "", "token", "", "getToken", "()Ljava/lang/String;", "confirmEmail", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResponse;", "changePasswordProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailForgotResponse;", "confirmEmailForgot-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneForgotResponse;", "confirmPhoneForgot-gIAlu-s", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enterPassword", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordRequest;", "enterPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPasswordForgot", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeEnterPasswordForgotResponse;", "enterPasswordForgot-gIAlu-s", "password", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordSuccessResponse;", "password-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/passwordChange/method/PasswordChangeSetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PasswordChangeRepository {
    /* renamed from: confirmEmail-0E7RQCE, reason: not valid java name */
    Object mo3223confirmEmail0E7RQCE(String str, PasswordChangeConfirmEmailRequest passwordChangeConfirmEmailRequest, Continuation<? super Result<? extends PasswordChangeConfirmEmailResponse>> continuation);

    /* renamed from: confirmEmailForgot-gIAlu-s, reason: not valid java name */
    Object mo3224confirmEmailForgotgIAlus(String str, Continuation<? super Result<? extends PasswordChangeConfirmEmailForgotResponse>> continuation);

    /* renamed from: confirmEmailResend-gIAlu-s, reason: not valid java name */
    Object mo3225confirmEmailResendgIAlus(String str, Continuation<? super Result<? extends PasswordChangeConfirmEmailResendResponse>> continuation);

    /* renamed from: confirmPhone-0E7RQCE, reason: not valid java name */
    Object mo3226confirmPhone0E7RQCE(String str, PasswordChangeConfirmPhoneRequest passwordChangeConfirmPhoneRequest, Continuation<? super Result<? extends PasswordChangeConfirmPhoneResponse>> continuation);

    /* renamed from: confirmPhoneForgot-gIAlu-s, reason: not valid java name */
    Object mo3227confirmPhoneForgotgIAlus(String str, Continuation<? super Result<? extends PasswordChangeConfirmPhoneForgotResponse>> continuation);

    /* renamed from: confirmPhoneResend-gIAlu-s, reason: not valid java name */
    Object mo3228confirmPhoneResendgIAlus(String str, Continuation<? super Result<? extends PasswordChangeConfirmPhoneResendResponse>> continuation);

    /* renamed from: enterPassword-0E7RQCE, reason: not valid java name */
    Object mo3229enterPassword0E7RQCE(String str, PasswordChangeEnterPasswordRequest passwordChangeEnterPasswordRequest, Continuation<? super Result<? extends PasswordChangeEnterPasswordResponse>> continuation);

    /* renamed from: enterPasswordForgot-gIAlu-s, reason: not valid java name */
    Object mo3230enterPasswordForgotgIAlus(String str, Continuation<? super Result<? extends PasswordChangeEnterPasswordForgotResponse>> continuation);

    String getToken();

    /* renamed from: password-IoAF18A, reason: not valid java name */
    Object mo3231passwordIoAF18A(Continuation<? super Result<PasswordSuccessResponse>> continuation);

    /* renamed from: setPassword-0E7RQCE, reason: not valid java name */
    Object mo3232setPassword0E7RQCE(String str, PasswordChangeSetPasswordRequest passwordChangeSetPasswordRequest, Continuation<? super Result<? extends PasswordChangeSetPasswordResponse>> continuation);
}
