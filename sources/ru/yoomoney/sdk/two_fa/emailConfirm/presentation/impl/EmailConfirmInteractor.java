package ru.yoomoney.sdk.two_fa.emailConfirm.presentation.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.two_fa.emailConfirm.EmailConfirm;

/* compiled from: EmailConfirmInteractor.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\bH¦@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/yoomoney/sdk/two_fa/emailConfirm/presentation/impl/EmailConfirmInteractor;", "", "confirmCode", "Lru/yoomoney/sdk/two_fa/emailConfirm/EmailConfirm$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "code", "attemptsLeft", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthSession", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateCode", "validCodeLenght", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface EmailConfirmInteractor {
    Object confirmCode(String str, String str2, int i, Continuation<? super EmailConfirm.Action> continuation);

    Object startAuthSession(String str, Continuation<? super EmailConfirm.Action> continuation);

    Object validateCode(String str, int i, Continuation<? super EmailConfirm.Action> continuation);
}
