package ru.yoomoney.sdk.auth.net.interceptor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import ru.yoomoney.sdk.auth.api.ClientAppParams;
import ru.yoomoney.sdk.auth.api.TokenUtils;
import ru.yoomoney.sdk.auth.api.crypt.ApiKeyProvider;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/yoomoney/sdk/auth/net/interceptor/AuthorizationInterceptor;", "Lokhttp3/Interceptor;", "apiKeyProvider", "Lru/yoomoney/sdk/auth/api/crypt/ApiKeyProvider;", "clientAppParams", "Lru/yoomoney/sdk/auth/api/ClientAppParams;", "serverTimeRepository", "Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;", "(Lru/yoomoney/sdk/auth/api/crypt/ApiKeyProvider;Lru/yoomoney/sdk/auth/api/ClientAppParams;Lru/yoomoney/sdk/auth/api/serverTime/ServerTimeRepository;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AuthorizationInterceptor implements Interceptor {
    private final ApiKeyProvider apiKeyProvider;
    private final ClientAppParams clientAppParams;
    private final ServerTimeRepository serverTimeRepository;

    public AuthorizationInterceptor(ApiKeyProvider apiKeyProvider, ClientAppParams clientAppParams, ServerTimeRepository serverTimeRepository) {
        Intrinsics.checkNotNullParameter(apiKeyProvider, "apiKeyProvider");
        Intrinsics.checkNotNullParameter(clientAppParams, "clientAppParams");
        Intrinsics.checkNotNullParameter(serverTimeRepository, "serverTimeRepository");
        this.apiKeyProvider = apiKeyProvider;
        this.clientAppParams = clientAppParams;
        this.serverTimeRepository = serverTimeRepository;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().header("Authorization", TokenUtils.INSTANCE.generateTokenHeader(this.apiKeyProvider, this.clientAppParams, this.serverTimeRepository)).build());
    }
}
