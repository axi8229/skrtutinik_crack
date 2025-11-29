package ru.yoomoney.sdk.auth.password.enter.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.password.enter.PasswordEnter;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/password/enter/impl/BasePasswordEnterInteractor;", "", "checkExpiration", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action;", "action", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$CheckExpiration;", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$CheckExpiration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterPassword", "Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$Submit;", "(Lru/yoomoney/sdk/auth/password/enter/PasswordEnter$Action$Submit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverPassword", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BasePasswordEnterInteractor {
    Object checkExpiration(PasswordEnter.Action.CheckExpiration checkExpiration, Continuation<? super PasswordEnter.Action> continuation);

    Object enterPassword(PasswordEnter.Action.Submit submit, Continuation<? super PasswordEnter.Action> continuation);

    Object recoverPassword(Continuation<? super PasswordEnter.Action> continuation);
}
