package ru.yoomoney.sdk.auth.qrAuth.info.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.qrAuth.info.QrAuthInfo;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/qrAuth/info/impl/QrAuthInfoInteractor;", "", "accept", "Lru/yoomoney/sdk/auth/qrAuth/info/QrAuthInfo$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadInfo", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface QrAuthInfoInteractor {
    Object accept(String str, Continuation<? super QrAuthInfo.Action> continuation);

    Object loadInfo(String str, Continuation<? super QrAuthInfo.Action> continuation);
}
