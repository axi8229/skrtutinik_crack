package ru.yoomoney.sdk.auth.api.core;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.core.model.UnixTime;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/api/core/CoreApiRepository;", "", "getInstallationIdentifier", "Lkotlin/Result;", "", "getInstallationIdentifier-d1pmJ48", "()Ljava/lang/Object;", "getUnixTime", "Lru/yoomoney/sdk/auth/api/core/model/UnixTime;", "getUnixTime-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CoreApiRepository {
    /* renamed from: getInstallationIdentifier-d1pmJ48, reason: not valid java name */
    Object mo3244getInstallationIdentifierd1pmJ48();

    /* renamed from: getUnixTime-IoAF18A, reason: not valid java name */
    Object mo3245getUnixTimeIoAF18A(Continuation<? super Result<UnixTime>> continuation);
}
