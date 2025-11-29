package ru.yoomoney.sdk.two_fa.net.interceptor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import ru.yoomoney.sdk.two_fa.net.UserAgent;

/* compiled from: UserAgentInterceptor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/yoomoney/sdk/two_fa/net/interceptor/UserAgentInterceptor;", "Lokhttp3/Interceptor;", "userAgent", "Lru/yoomoney/sdk/two_fa/net/UserAgent;", "(Lru/yoomoney/sdk/two_fa/net/UserAgent;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "two-fa_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserAgentInterceptor implements Interceptor {
    public static final int $stable = 0;
    private final UserAgent userAgent;

    public UserAgentInterceptor(UserAgent userAgent) {
        Intrinsics.checkNotNullParameter(userAgent, "userAgent");
        this.userAgent = userAgent;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().header("User-Agent", this.userAgent.getName()).build());
    }
}
