package ru.yoomoney.sdk.two_fa.net;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.two_fa.R;
import ru.yoomoney.sdk.two_fa.net.interceptor.AuthorizationInterceptor;
import ru.yoomoney.sdk.two_fa.net.interceptor.UserAgentInterceptor;

/* compiled from: HttpClientUtils.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"DEFAULT_TIMEOUT", "", "KEEP_ALIVE_DURATION", "MAX_IDLE_CONNECTIONS", "", "createHttpClient", "Lokhttp3/OkHttpClient;", "context", "Landroid/content/Context;", "certsHost", "", "authorizationInterceptor", "Lru/yoomoney/sdk/two_fa/net/interceptor/AuthorizationInterceptor;", "isTablet", "", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HttpClientUtilsKt {
    private static final long DEFAULT_TIMEOUT = 30;
    private static final long KEEP_ALIVE_DURATION = 10;
    private static final int MAX_IDLE_CONNECTIONS = 4;

    private static final boolean createHttpClient$lambda$2(String str, SSLSession sSLSession) {
        return true;
    }

    public static /* synthetic */ OkHttpClient createHttpClient$default(Context context, String str, AuthorizationInterceptor authorizationInterceptor, int i, Object obj) {
        if ((i & 4) != 0) {
            authorizationInterceptor = null;
        }
        return createHttpClient(context, str, authorizationInterceptor);
    }

    public static final OkHttpClient createHttpClient(Context context, String str, AuthorizationInterceptor authorizationInterceptor) {
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderFollowRedirects = builder.readTimeout(DEFAULT_TIMEOUT, timeUnit).connectTimeout(DEFAULT_TIMEOUT, timeUnit).connectionPool(new ConnectionPool(4, KEEP_ALIVE_DURATION, TimeUnit.MINUTES)).followSslRedirects(false).followRedirects(false);
        if (authorizationInterceptor != null) {
            builderFollowRedirects.addInterceptor(authorizationInterceptor);
        }
        return OkHttpBuilderExtensionsKt.buildWithDebugLogger(OkHttpBuilderExtensionsKt.applySslSocketFactory(builderFollowRedirects.addInterceptor(new UserAgentInterceptor(new UserAgent(isTablet(context), null, null, 6, null))), context, str));
    }

    public static final boolean isTablet(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getBoolean(R.bool.is_tablet);
    }
}
