package ru.yoomoney.sdk.auth.api.account.phoneChange;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneForgotResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResendResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeConfirmPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneRequest;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneChangeSetPhoneResponse;
import ru.yoomoney.sdk.auth.api.account.phoneChange.method.PhoneSuccessResponse;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\t\u001a\u00020\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0011J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u001bH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/api/account/phoneChange/PhoneChangeRepository;", "", "token", "", "getToken", "()Ljava/lang/String;", "confirmPhone", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneResponse;", "changePhoneProcessId", "request", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneRequest;", "confirmPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneForgotResponse;", "confirmPhoneForgot-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeConfirmPhoneResendResponse;", "confirmPhoneResend-gIAlu-s", "phone", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneSuccessResponse;", "phone-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPhone", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneResponse;", "Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneRequest;", "setPhone-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/account/phoneChange/method/PhoneChangeSetPhoneRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PhoneChangeRepository {
    /* renamed from: confirmPhone-0E7RQCE, reason: not valid java name */
    Object mo3233confirmPhone0E7RQCE(String str, PhoneChangeConfirmPhoneRequest phoneChangeConfirmPhoneRequest, Continuation<? super Result<? extends PhoneChangeConfirmPhoneResponse>> continuation);

    /* renamed from: confirmPhoneForgot-gIAlu-s, reason: not valid java name */
    Object mo3234confirmPhoneForgotgIAlus(String str, Continuation<? super Result<? extends PhoneChangeConfirmPhoneForgotResponse>> continuation);

    /* renamed from: confirmPhoneResend-gIAlu-s, reason: not valid java name */
    Object mo3235confirmPhoneResendgIAlus(String str, Continuation<? super Result<? extends PhoneChangeConfirmPhoneResendResponse>> continuation);

    String getToken();

    /* renamed from: phone-IoAF18A, reason: not valid java name */
    Object mo3236phoneIoAF18A(Continuation<? super Result<PhoneSuccessResponse>> continuation);

    /* renamed from: setPhone-0E7RQCE, reason: not valid java name */
    Object mo3237setPhone0E7RQCE(String str, PhoneChangeSetPhoneRequest phoneChangeSetPhoneRequest, Continuation<? super Result<? extends PhoneChangeSetPhoneResponse>> continuation);
}
