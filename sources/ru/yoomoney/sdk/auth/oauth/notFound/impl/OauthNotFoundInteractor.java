package ru.yoomoney.sdk.auth.oauth.notFound.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.oauth.notFound.OauthNotFound;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/oauth/notFound/impl/OauthNotFoundInteractor;", "", "initAuthorization", "Lru/yoomoney/sdk/auth/oauth/notFound/OauthNotFound$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initRegistration", "processType", "Lru/yoomoney/sdk/auth/Config$ProcessType;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/Config$ProcessType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface OauthNotFoundInteractor {
    Object initAuthorization(String str, Continuation<? super OauthNotFound.Action> continuation);

    Object initRegistration(String str, Config.ProcessType processType, Continuation<? super OauthNotFound.Action> continuation);
}
