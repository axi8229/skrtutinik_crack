package ru.yoomoney.sdk.auth.api.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;
import ru.yoomoney.sdk.auth.api.core.method.InstallationIdentifierResponse;
import ru.yoomoney.sdk.auth.api.core.model.UnixTime;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\b"}, d2 = {"Lru/yoomoney/sdk/auth/api/core/CoreApi;", "", "installationIdentifier", "Lretrofit2/Response;", "Lru/yoomoney/sdk/auth/api/core/method/InstallationIdentifierResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unixTime", "Lru/yoomoney/sdk/auth/api/core/model/UnixTime;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CoreApi {
    @GET("installation-identifier")
    Object installationIdentifier(Continuation<? super Response<InstallationIdentifierResponse>> continuation);

    @GET("unix-time")
    Object unixTime(Continuation<? super Response<UnixTime>> continuation);
}
