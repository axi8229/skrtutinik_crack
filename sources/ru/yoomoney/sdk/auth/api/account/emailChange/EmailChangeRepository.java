package ru.yoomoney.sdk.auth.api.account.emailChange;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
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

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\u0006\u0010\u000b\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\u0006\u0010\u000b\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0013J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0019H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\u000b\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u0013J$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\t2\u0006\u0010\u000b\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0013J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\tH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J,\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020(H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J,\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020-H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/emailChange/EmailChangeRepository;", "", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "confirmEmail", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResponse;", "changeEmailProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailForgotResponse;", "confirmEmailForgot-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "confirmPhone", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneForgotResponse;", "confirmPhoneForgot-gIAlu-s", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", Scopes.EMAIL, "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailSuccessResponse;", "email-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPassword", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordRequest;", "enterPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeEnterPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailResponse;", "Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailRequest;", "setEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/emailChange/method/EmailChangeSetEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface EmailChangeRepository {
    /* renamed from: confirmEmail-0E7RQCE, reason: not valid java name */
    Object mo3214confirmEmail0E7RQCE(String str, EmailChangeConfirmEmailRequest emailChangeConfirmEmailRequest, Continuation<? super Result<? extends EmailChangeConfirmEmailResponse>> continuation);

    /* renamed from: confirmEmailForgot-gIAlu-s, reason: not valid java name */
    Object mo3215confirmEmailForgotgIAlus(String str, Continuation<? super Result<? extends EmailChangeConfirmEmailForgotResponse>> continuation);

    /* renamed from: confirmEmailResend-gIAlu-s, reason: not valid java name */
    Object mo3216confirmEmailResendgIAlus(String str, Continuation<? super Result<? extends EmailChangeConfirmEmailResendResponse>> continuation);

    /* renamed from: confirmPhone-0E7RQCE, reason: not valid java name */
    Object mo3217confirmPhone0E7RQCE(String str, EmailChangeConfirmPhoneRequest emailChangeConfirmPhoneRequest, Continuation<? super Result<? extends EmailChangeConfirmPhoneResponse>> continuation);

    /* renamed from: confirmPhoneForgot-gIAlu-s, reason: not valid java name */
    Object mo3218confirmPhoneForgotgIAlus(String str, Continuation<? super Result<? extends EmailChangeConfirmPhoneForgotResponse>> continuation);

    /* renamed from: confirmPhoneResend-gIAlu-s, reason: not valid java name */
    Object mo3219confirmPhoneResendgIAlus(String str, Continuation<? super Result<? extends EmailChangeConfirmPhoneResendResponse>> continuation);

    /* renamed from: email-IoAF18A, reason: not valid java name */
    Object mo3220emailIoAF18A(Continuation<? super Result<EmailSuccessResponse>> continuation);

    /* renamed from: enterPassword-0E7RQCE, reason: not valid java name */
    Object mo3221enterPassword0E7RQCE(String str, EmailChangeEnterPasswordRequest emailChangeEnterPasswordRequest, Continuation<? super Result<? extends EmailChangeEnterPasswordResponse>> continuation);

    String getToken();

    /* renamed from: setEmail-0E7RQCE, reason: not valid java name */
    Object mo3222setEmail0E7RQCE(String str, EmailChangeSetEmailRequest emailChangeSetEmailRequest, Continuation<? super Result<? extends EmailChangeSetEmailResponse>> continuation);

    void setToken(String str);
}
