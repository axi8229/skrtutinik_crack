package ru.yoomoney.sdk.auth.finishing.success.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.finishing.success.AuthFinishingSuccess;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH¦@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lru/yoomoney/sdk/auth/finishing/success/impl/AuthFinishingSuccessInteractor;", "", "account", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action;", "action", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAccount;", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAccount;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireAuthorization", "Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAcquire;", "(Lru/yoomoney/sdk/auth/finishing/success/AuthFinishingSuccess$Action$LoadAcquire;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AuthFinishingSuccessInteractor {
    Object account(AuthFinishingSuccess.Action.LoadAccount loadAccount, Continuation<? super AuthFinishingSuccess.Action> continuation);

    Object acquireAuthorization(AuthFinishingSuccess.Action.LoadAcquire loadAcquire, Continuation<? super AuthFinishingSuccess.Action> continuation);
}
