package ru.yoomoney.sdk.two_fa.phoneCall.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;
import ru.yoomoney.sdk.two_fa.domain.SessionType;
import ru.yoomoney.sdk.two_fa.phoneCall.PhoneCall;

/* compiled from: PhoneCallInteractor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ&\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH¦@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lru/yoomoney/sdk/two_fa/phoneCall/impl/PhoneCallInteractor;", "", "checkCode", "Lru/yoomoney/sdk/two_fa/phoneCall/PhoneCall$Action;", "code", "", "codeLength", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "confirmCode", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "attemptsLeft", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nextAvailableSessionOption", "type", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "(Lru/yoomoney/sdk/two_fa/domain/SessionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthSession", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PhoneCallInteractor {
    Object checkCode(String str, int i, Continuation<? super PhoneCall.Action> continuation);

    Object confirmCode(String str, String str2, int i, Continuation<? super PhoneCall.Action> continuation);

    Object nextAvailableSessionOption(SessionType sessionType, Continuation<? super PhoneCall.Action> continuation);

    Object startAuthSession(String str, Continuation<? super PhoneCall.Action> continuation);
}
