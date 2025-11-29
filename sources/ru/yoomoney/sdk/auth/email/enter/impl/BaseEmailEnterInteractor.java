package ru.yoomoney.sdk.auth.email.enter.impl;

import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.email.enter.EmailEnter;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u0010"}, d2 = {"Lru/yoomoney/sdk/auth/email/enter/impl/BaseEmailEnterInteractor;", "", "checkExpiration", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action;", "action", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$CheckExpiration;", "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$CheckExpiration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registrationConfirmEmail", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEmail", "Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;", Scopes.EMAIL, "(Lru/yoomoney/sdk/auth/email/enter/EmailEnter$Action$SendEmail;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateEmail", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BaseEmailEnterInteractor {
    Object checkExpiration(EmailEnter.Action.CheckExpiration checkExpiration, Continuation<? super EmailEnter.Action> continuation);

    Object registrationConfirmEmail(String str, Continuation<? super EmailEnter.Action> continuation);

    Object sendEmail(EmailEnter.Action.SendEmail sendEmail, String str, Continuation<? super EmailEnter.Action> continuation);

    Object validateEmail(String str, Continuation<? super EmailEnter.Action> continuation);
}
