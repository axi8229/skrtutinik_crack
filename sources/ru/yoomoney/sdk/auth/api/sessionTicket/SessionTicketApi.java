package ru.yoomoney.sdk.auth.api.sessionTicket;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketResponse;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyRequest;
import ru.yoomoney.sdk.auth.api.sessionTicket.method.SessionTicketVerifyResponse;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/api/sessionTicket/SessionTicketApi;", "", "sessionTicket", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketResponse;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verify", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyResponse;", "request", "Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyRequest;", "(Ljava/lang/String;Lru/yoomoney/sdk/auth/api/sessionTicket/method/SessionTicketVerifyRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SessionTicketApi {
    @POST("session-ticket")
    Object sessionTicket(@Header("Authorization") String str, Continuation<? super Response<SessionTicketResponse>> continuation);

    @POST("session-ticket/verify")
    Object verify(@Header("Authorization") String str, @Body SessionTicketVerifyRequest sessionTicketVerifyRequest, Continuation<? super Response<SessionTicketVerifyResponse>> continuation);
}
