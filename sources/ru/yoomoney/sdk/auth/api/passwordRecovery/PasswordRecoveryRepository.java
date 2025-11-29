package ru.yoomoney.sdk.auth.api.passwordRecovery;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
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

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\rH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0016H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0013J,\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u001eH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J$\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\u0006\u0010\u0007\u001a\u00020#H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J,\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020(H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Lru/yoomoney/sdk/auth/api/passwordRecovery/PasswordRecoveryRepository;", "", "chooseAccount", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountResponse;", "passwordRecoveryProcessId", "", "request", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountRequest;", "chooseAccount-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryChooseAccountRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailRequest;", "confirmEmail-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmEmailResendResponse;", "confirmEmailResend-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhone", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "enterPhone", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneRequest;", "enterPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryEnterPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecovery", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryRequest;", "passwordRecovery-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoveryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPassword", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordResponse;", "Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordRequest;", "setPassword-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/passwordRecovery/method/PasswordRecoverySetPasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PasswordRecoveryRepository {
    /* renamed from: chooseAccount-0E7RQCE, reason: not valid java name */
    Object mo3286chooseAccount0E7RQCE(String str, PasswordRecoveryChooseAccountRequest passwordRecoveryChooseAccountRequest, Continuation<? super Result<PasswordRecoveryChooseAccountResponse>> continuation);

    /* renamed from: confirmEmail-0E7RQCE, reason: not valid java name */
    Object mo3287confirmEmail0E7RQCE(String str, PasswordRecoveryConfirmEmailRequest passwordRecoveryConfirmEmailRequest, Continuation<? super Result<? extends PasswordRecoveryConfirmEmailResponse>> continuation);

    /* renamed from: confirmEmailResend-gIAlu-s, reason: not valid java name */
    Object mo3288confirmEmailResendgIAlus(String str, Continuation<? super Result<? extends PasswordRecoveryConfirmEmailResendResponse>> continuation);

    /* renamed from: confirmPhone-0E7RQCE, reason: not valid java name */
    Object mo3289confirmPhone0E7RQCE(String str, PasswordRecoveryConfirmPhoneRequest passwordRecoveryConfirmPhoneRequest, Continuation<? super Result<? extends PasswordRecoveryConfirmPhoneResponse>> continuation);

    /* renamed from: confirmPhoneResend-gIAlu-s, reason: not valid java name */
    Object mo3290confirmPhoneResendgIAlus(String str, Continuation<? super Result<? extends PasswordRecoveryConfirmPhoneResendResponse>> continuation);

    /* renamed from: enterPhone-0E7RQCE, reason: not valid java name */
    Object mo3291enterPhone0E7RQCE(String str, PasswordRecoveryEnterPhoneRequest passwordRecoveryEnterPhoneRequest, Continuation<? super Result<? extends PasswordRecoveryEnterPhoneResponse>> continuation);

    /* renamed from: passwordRecovery-gIAlu-s, reason: not valid java name */
    Object mo3292passwordRecoverygIAlus(PasswordRecoveryRequest passwordRecoveryRequest, Continuation<? super Result<? extends PasswordRecoveryResponse>> continuation);

    /* renamed from: setPassword-0E7RQCE, reason: not valid java name */
    Object mo3293setPassword0E7RQCE(String str, PasswordRecoverySetPasswordRequest passwordRecoverySetPasswordRequest, Continuation<? super Result<? extends PasswordRecoverySetPasswordResponse>> continuation);
}
