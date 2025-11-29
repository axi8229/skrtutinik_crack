package ru.yoomoney.sdk.auth.net.interceptor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ru.yoomoney.sdk.auth.net.HttpHeaders;
import ru.yoomoney.sdk.auth.net.UserAgent;
import ru.yoomoney.sdk.auth.net.XApplicationUserAgent;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/yoomoney/sdk/auth/net/interceptor/UserAgentInterceptor;", "Lokhttp3/Interceptor;", "userAgent", "Lru/yoomoney/sdk/auth/net/UserAgent;", "xApplicationUserAgent", "Lru/yoomoney/sdk/auth/net/XApplicationUserAgent;", "(Lru/yoomoney/sdk/auth/net/UserAgent;Lru/yoomoney/sdk/auth/net/XApplicationUserAgent;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "auth_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAgentInterceptor implements Interceptor {
    private final UserAgent userAgent;
    private final XApplicationUserAgent xApplicationUserAgent;

    public UserAgentInterceptor(UserAgent userAgent, XApplicationUserAgent xApplicationUserAgent) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        this.userAgent = userAgent;
        this.xApplicationUserAgent = xApplicationUserAgent;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderHeader = chain.request().newBuilder().header("User-Agent", this.userAgent.getName());
        XApplicationUserAgent xApplicationUserAgent = this.xApplicationUserAgent;
        if (xApplicationUserAgent != null) {
            builderHeader.header(HttpHeaders.X_APPLICATION_USER_AGENT, xApplicationUserAgent.getName());
        }
        return chain.proceed(builderHeader.build());
    }
}
