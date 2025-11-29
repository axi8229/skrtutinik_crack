package ru.yoomoney.sdk.auth.password.create.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.password.create.PasswordCreate;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\tJ\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0011H¦@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0007H&¨\u0006\u0015"}, d2 = {"Lru/yoomoney/sdk/auth/password/create/impl/BasePasswordCreateInteractor;", "", "generatePassword", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverPassword", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitPassword", "action", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Submit;", "(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$Submit;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateBeforeSubmit", "state", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;", "Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$ValidateBeforeSubmit;", "(Lru/yoomoney/sdk/auth/password/create/PasswordCreate$State$Content;Lru/yoomoney/sdk/auth/password/create/PasswordCreate$Action$ValidateBeforeSubmit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validatePassword", "firstPassword", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface BasePasswordCreateInteractor {
    Object generatePassword(Continuation<? super PasswordCreate.Action> continuation);

    Object recoverPassword(String str, String str2, Continuation<? super PasswordCreate.Action> continuation);

    Object submitPassword(PasswordCreate.Action.Submit submit, String str, Continuation<? super PasswordCreate.Action> continuation);

    Object validateBeforeSubmit(PasswordCreate.State.Content content, PasswordCreate.Action.ValidateBeforeSubmit validateBeforeSubmit, Continuation<? super PasswordCreate.Action> continuation);

    PasswordCreate.Action validatePassword(String firstPassword);
}
