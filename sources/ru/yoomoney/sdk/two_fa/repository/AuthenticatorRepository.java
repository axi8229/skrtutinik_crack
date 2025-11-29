package ru.yoomoney.sdk.two_fa.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.two_fa.domain.ActiveSession;
import ru.yoomoney.sdk.two_fa.domain.ActiveSessionType;
import ru.yoomoney.sdk.two_fa.domain.AuthContext;
import ru.yoomoney.sdk.two_fa.domain.Session;
import ru.yoomoney.sdk.two_fa.domain.SessionType;

/* compiled from: AuthenticatorRepository.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u0004H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Lru/yoomoney/sdk/two_fa/repository/AuthenticatorRepository;", "", "checkAuthSession", "Lkotlin/Result;", "", "authProcessId", "secret", "checkAuthSession-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthContext", "Lru/yoomoney/sdk/two_fa/domain/AuthContext;", "getAuthContext-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAuthSessionList", "", "Lru/yoomoney/sdk/two_fa/domain/ActiveSession;", "sessionTypes", "Lru/yoomoney/sdk/two_fa/domain/ActiveSessionType;", "getAuthSessionList-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAuthSession", "Lru/yoomoney/sdk/two_fa/domain/Session;", "type", "Lru/yoomoney/sdk/two_fa/domain/SessionType;", "startAuthSession-0E7RQCE", "(Ljava/lang/String;Lru/yoomoney/sdk/two_fa/domain/SessionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AuthenticatorRepository {
    /* renamed from: checkAuthSession-0E7RQCE, reason: not valid java name */
    Object mo3511checkAuthSession0E7RQCE(String str, String str2, Continuation<? super Result<String>> continuation);

    /* renamed from: getAuthContext-gIAlu-s, reason: not valid java name */
    Object mo3512getAuthContextgIAlus(String str, Continuation<? super Result<AuthContext>> continuation);

    /* renamed from: getAuthSessionList-gIAlu-s, reason: not valid java name */
    Object mo3513getAuthSessionListgIAlus(List<? extends ActiveSessionType> list, Continuation<? super Result<? extends List<? extends ActiveSession>>> continuation);

    /* renamed from: startAuthSession-0E7RQCE, reason: not valid java name */
    Object mo3514startAuthSession0E7RQCE(String str, SessionType sessionType, Continuation<? super Result<? extends Session>> continuation);
}
