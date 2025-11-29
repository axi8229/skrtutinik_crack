package ru.yoomoney.sdk.auth.api.sessionTicket;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketResponse;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyRequest;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyResponse;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nH¦@ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketRepository;", "", "sessionTicket", "Lkotlin/Result;", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketResponse;", "sessionTicket-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verify", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyResponse;", "request", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyRequest;", "verify-gIAlu-s", "(Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SessionTicketRepository {
    /* renamed from: sessionTicket-IoAF18A, reason: not valid java name */
    Object mo3301sessionTicketIoAF18A(Continuation<? super Result<SessionTicketResponse>> continuation);

    /* renamed from: verify-gIAlu-s, reason: not valid java name */
    Object mo3302verifygIAlus(SessionTicketVerifyRequest sessionTicketVerifyRequest, Continuation<? super Result<SessionTicketVerifyResponse>> continuation);
}
