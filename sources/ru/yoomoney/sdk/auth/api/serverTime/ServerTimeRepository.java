package ru.yoomoney.sdk.auth.api.serverTime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.threeten.bp.OffsetDateTime;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "", "getCurrentDateTime", "Lorg/threeten/bp/OffsetDateTime;", "getCurrentTimeMillis", "", "init", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ServerTimeRepository {
    OffsetDateTime getCurrentDateTime();

    long getCurrentTimeMillis();

    Object init(Continuation<? super Unit> continuation);
}
