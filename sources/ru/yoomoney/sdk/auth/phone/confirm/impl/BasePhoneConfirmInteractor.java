package ru.yoomoney.sdk.auth.phone.confirm.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.phone.confirm.PhoneConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0015H¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lru/yoomoney/sdk/auth/phone/confirm/impl/BasePhoneConfirmInteractor;", "", "confirmPhone", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action;", "action", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeValid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneForgot", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Forgot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmPhoneResend", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$Retry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecoveryConfirmPhone", "code", "", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecoveryConfirmPhoneResend", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateCode", "Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeChanged;", "(Lru/yoomoney/sdk/auth/phone/confirm/PhoneConfirm$Action$CodeChanged;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BasePhoneConfirmInteractor {
    Object confirmPhone(PhoneConfirm.Action.CodeValid codeValid, Continuation<? super PhoneConfirm.Action> continuation);

    Object confirmPhoneForgot(PhoneConfirm.Action.Forgot forgot, Continuation<? super PhoneConfirm.Action> continuation);

    Object confirmPhoneResend(PhoneConfirm.Action.Retry retry, Continuation<? super PhoneConfirm.Action> continuation);

    Object passwordRecoveryConfirmPhone(String str, String str2, Continuation<? super PhoneConfirm.Action> continuation);

    Object passwordRecoveryConfirmPhoneResend(String str, Continuation<? super PhoneConfirm.Action> continuation);

    Object validateCode(PhoneConfirm.Action.CodeChanged codeChanged, Continuation<? super PhoneConfirm.Action> continuation);
}
