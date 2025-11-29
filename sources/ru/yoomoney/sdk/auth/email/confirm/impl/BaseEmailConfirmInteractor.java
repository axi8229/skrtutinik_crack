package ru.yoomoney.sdk.auth.email.confirm.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.email.confirm.EmailConfirm;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH¦@¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"Lru/yoomoney/sdk/auth/email/confirm/impl/BaseEmailConfirmInteractor;", "", "checkExpiration", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action;", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmail", "code", "action", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Submit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailForgot", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Forgot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmEmailResend", "Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;", "(Lru/yoomoney/sdk/auth/email/confirm/EmailConfirm$Action$Retry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecoveryConfirmEmail", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "passwordRecoveryConfirmEmailResend", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateCode", "secretLength", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BaseEmailConfirmInteractor {
    Object checkExpiration(ProcessType processType, String str, OffsetDateTime offsetDateTime, Continuation<? super EmailConfirm.Action> continuation);

    Object confirmEmail(String str, EmailConfirm.Action.Submit submit, Continuation<? super EmailConfirm.Action> continuation);

    Object confirmEmailForgot(EmailConfirm.Action.Forgot forgot, Continuation<? super EmailConfirm.Action> continuation);

    Object confirmEmailResend(EmailConfirm.Action.Retry retry, Continuation<? super EmailConfirm.Action> continuation);

    Object passwordRecoveryConfirmEmail(String str, String str2, Continuation<? super EmailConfirm.Action> continuation);

    Object passwordRecoveryConfirmEmailResend(String str, Continuation<? super EmailConfirm.Action> continuation);

    Object validateCode(String str, int i, Continuation<? super EmailConfirm.Action> continuation);
}
