package ru.yoomoney.sdk.auth.email.select.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.threeten.bp.OffsetDateTime;
import ru.yoomoney.sdk.auth.email.select.EmailSelect;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lru/yoomoney/sdk/auth/email/select/impl/EmailSelectInteractor;", "", "checkExpiration", "Lru/yoomoney/sdk/auth/email/select/EmailSelect$Action;", QrAuthDeclineWorkerKt.KEY_PROCESS_ID, "", "expireAt", "Lorg/threeten/bp/OffsetDateTime;", "(Ljava/lang/String;Lorg/threeten/bp/OffsetDateTime;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEmail", "suggestionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface EmailSelectInteractor {
    Object checkExpiration(String str, OffsetDateTime offsetDateTime, Continuation<? super EmailSelect.Action> continuation);

    Object setEmail(String str, String str2, Continuation<? super EmailSelect.Action> continuation);
}
