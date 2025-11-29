package ru.yoomoney.sdk.auth.acceptTerms.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.acceptTerms.AcceptTerms;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/yoomoney/sdk/auth/acceptTerms/impl/AcceptTermsInteractor;", "", "acceptTerms", "Lru/yoomoney/sdk/auth/acceptTerms/AcceptTerms$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AcceptTermsInteractor {
    Object acceptTerms(String str, Continuation<? super AcceptTerms.Action> continuation);
}
