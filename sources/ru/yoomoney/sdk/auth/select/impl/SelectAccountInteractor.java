package ru.yoomoney.sdk.auth.select.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.api.ProcessType;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.auth.select.SelectAccount;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ0\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lru/yoomoney/sdk/auth/select/impl/SelectAccountInteractor;", "", "checkExpiration", "Lru/yoomoney/sdk/auth/select/SelectAccount$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "uid", "processType", "Lru/yoomoney/sdk/auth/api/ProcessType;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Ljava/lang/String;Lru/yoomoney/sdk/auth/api/ProcessType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "prefilledEmail", "addToBackStack", "", "(Lru/yoomoney/sdk/auth/api/ProcessType;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SelectAccountInteractor {
    Object checkExpiration(String str, OffsetDateTime offsetDateTime, String str2, ProcessType processType, Continuation<? super SelectAccount.Action> continuation);

    Object setEmail(ProcessType processType, String str, String str2, boolean z, Continuation<? super SelectAccount.Action> continuation);
}
