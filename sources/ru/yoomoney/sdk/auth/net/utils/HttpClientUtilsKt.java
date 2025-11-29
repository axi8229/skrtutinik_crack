package ru.yoomoney.sdk.auth.net.utils;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.auth.R;
import ru.yoomoney.sdk.auth.net.OkhttpBuilderExtensionsKt;
import ru.yoomoney.sdk.auth.net.UserAgent;
import ru.yoomoney.sdk.auth.net.XApplicationUserAgent;
import ru.yoomoney.sdk.auth.net.interceptor.AuthorizationInterceptor;
import ru.yoomoney.sdk.auth.net.interceptor.UserAgentInterceptor;
import ru.yoomoney.sdk.auth.qrAuth.QrAuthDeclineWorkerKt;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"DEFAULT_TIMEOUT", "", "KEEP_ALIVE_DURATION", "MAX_IDLE_CONNECTIONS", "", "createHttpClient", "Lokhttp3/OkHttpClient;", "context", "Landroid/content/Context;", "certsHost", "", "debugHost", "", QrAuthDeclineWorkerKt.KEY_APPLICATION_USER_AGENT, "authorizationInterceptor", "Lru/yoomoney/sdk/auth/net/interceptor/AuthorizationInterceptor;", "isTablet", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpClientUtilsKt {
    private static final long DEFAULT_TIMEOUT = 30;
    private static final long KEEP_ALIVE_DURATION = 10;
    private static final int MAX_IDLE_CONNECTIONS = 4;

    public static final OkHttpClient createHttpClient(Context context, String str, boolean z, String str2, AuthorizationInterceptor authorizationInterceptor) {
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderFollowRedirects = builder.readTimeout(DEFAULT_TIMEOUT, timeUnit).connectTimeout(DEFAULT_TIMEOUT, timeUnit).connectionPool(new ConnectionPool(4, KEEP_ALIVE_DURATION, TimeUnit.MINUTES)).followSslRedirects(false).followRedirects(false);
        if (authorizationInterceptor != null) {
            builderFollowRedirects.addInterceptor(authorizationInterceptor);
        }
        OkHttpClient.Builder builderApplySslSocketFactory = OkhttpBuilderExtensionsKt.applySslSocketFactory(OkhttpBuilderExtensionsKt.withAcceptLanguage(builderFollowRedirects.addInterceptor(new UserAgentInterceptor(new UserAgent(isTablet(context), null, null, 6, null), str2 != null ? new XApplicationUserAgent(str2) : null))), context, str, z);
        if (z) {
            builderApplySslSocketFactory.hostnameVerifier(new HostnameVerifier() { // from class: ru.yoomoney.sdk.auth.net.utils.HttpClientUtilsKt$$ExternalSyntheticLambda0
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str3, SSLSession sSLSession) {
                    return HttpClientUtilsKt.createHttpClient$lambda$3(str3, sSLSession);
                }
            });
        }
        return OkhttpBuilderExtensionsKt.buildWithDebugLogger(builderApplySslSocketFactory, z);
    }

    public static /* synthetic */ OkHttpClient createHttpClient$default(Context context, String str, boolean z, String str2, AuthorizationInterceptor authorizationInterceptor, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            authorizationInterceptor = null;
        }
        return createHttpClient(context, str, z, str2, authorizationInterceptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createHttpClient$lambda$3(String str, SSLSession sSLSession) {
        return true;
    }

    public static final boolean isTablet(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getBoolean(R.bool.is_tablet);
    }
}
