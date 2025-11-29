package ru.yoomoney.sdk.two_fa.net;

import android.content.Context;
import android.util.Log;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

/* compiled from: OkHttpBuilderExtensions.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u001e\u0010\n\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000bH\u0000¨\u0006\u000e"}, d2 = {"createLoggingInterceptor", "Lokhttp3/Interceptor;", "getDefaultTrustManager", "Ljavax/net/ssl/X509TrustManager;", "context", "Landroid/content/Context;", "certsHost", "", "debugHost", "", "applySslSocketFactory", "Lokhttp3/OkHttpClient$Builder;", "buildWithDebugLogger", "Lokhttp3/OkHttpClient;", "two-fa_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OkHttpBuilderExtensionsKt {
    public static final OkHttpClient.Builder applySslSocketFactory(OkHttpClient.Builder builder, Context context, String str) throws NoSuchAlgorithmException, KeyManagementException {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        X509TrustManager defaultTrustManager = getDefaultTrustManager(context, str, false);
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new X509TrustManager[]{defaultTrustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
        return builder.sslSocketFactory(socketFactory, defaultTrustManager);
    }

    public static final OkHttpClient buildWithDebugLogger(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.build();
    }

    private static final Interceptor createLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: ru.yoomoney.sdk.two_fa.net.OkHttpBuilderExtensionsKt$$ExternalSyntheticLambda0
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                OkHttpBuilderExtensionsKt.createLoggingInterceptor$lambda$1(str);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLoggingInterceptor$lambda$1(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i("Money.2FA", message);
    }

    private static final X509TrustManager getDefaultTrustManager(Context context, String str, boolean z) {
        if (str == null || StringsKt.isBlank(str) || z) {
            return new X509TrustManager() { // from class: ru.yoomoney.sdk.two_fa.net.OkHttpBuilderExtensionsKt.getDefaultTrustManager.1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] chain, String authType) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] chain, String authType) {
                }

                public final void checkServerTrusted(X509Certificate[] chain, String authType, String host) {
                    Intrinsics.checkNotNullParameter(chain, "chain");
                    Intrinsics.checkNotNullParameter(authType, "authType");
                    Intrinsics.checkNotNullParameter(host, "host");
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
        }
        return PinningHelper.INSTANCE.getInstance(context, str).getTrustManager();
    }
}
