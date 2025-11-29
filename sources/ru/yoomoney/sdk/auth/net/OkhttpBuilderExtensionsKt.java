package ru.yoomoney.sdk.auth.net;

import android.content.Context;
import android.util.Log;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.yoomoney.sdk.auth.net.interceptor.AcceptLanguageInterceptor;
import ru.yoomoney.sdk.auth.net.utils.SecuredLogUtilsKt;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\nH\u0002\u001a&\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\f\u0010\u000f\u001a\u00020\f*\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TAG", "", "createLoggingInterceptor", "Lokhttp3/Interceptor;", "getDefaultTrustManager", "Ljavax/net/ssl/X509TrustManager;", "context", "Landroid/content/Context;", "certsHost", "debugHost", "", "applySslSocketFactory", "Lokhttp3/OkHttpClient$Builder;", "buildWithDebugLogger", "Lokhttp3/OkHttpClient;", "withAcceptLanguage", "auth_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OkhttpBuilderExtensionsKt {
    private static final String TAG = "OkhttpBuilderExtensions";

    public static final OkHttpClient.Builder applySslSocketFactory(OkHttpClient.Builder builder, Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        X509TrustManager defaultTrustManager = getDefaultTrustManager(context, str, z);
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, new X509TrustManager[]{defaultTrustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
        return builder.sslSocketFactory(socketFactory, defaultTrustManager);
    }

    public static final OkHttpClient buildWithDebugLogger(OkHttpClient.Builder builder, boolean z) {
        Object next;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        if (z) {
            List<Interceptor> listInterceptors = builder.interceptors();
            Iterator<T> it = builder.interceptors().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Interceptor) next) instanceof HttpLoggingInterceptor) {
                    break;
                }
            }
            TypeIntrinsics.asMutableCollection(listInterceptors).remove(next);
            builder.addInterceptor(createLoggingInterceptor());
        }
        return builder.build();
    }

    private static final Interceptor createLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: ru.yoomoney.sdk.auth.net.OkhttpBuilderExtensionsKt$$ExternalSyntheticLambda0
            @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
            public final void log(String str) {
                OkhttpBuilderExtensionsKt.createLoggingInterceptor$lambda$1(str);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createLoggingInterceptor$lambda$1(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i("Money.Auth", SecuredLogUtilsKt.prepareSecureLog(message));
    }

    private static final X509TrustManager getDefaultTrustManager(Context context, String str, boolean z) {
        return (z || str == null || StringsKt.isBlank(str)) ? new X509TrustManager() { // from class: ru.yoomoney.sdk.auth.net.OkhttpBuilderExtensionsKt.getDefaultTrustManager.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }

            public final void checkServerTrusted(X509Certificate[] chain, String authType, String host) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                Intrinsics.checkNotNullParameter(authType, "authType");
                Intrinsics.checkNotNullParameter(host, "host");
            }
        } : PinningHelper.INSTANCE.getInstance(context, str).getTrustManager();
    }

    public static final OkHttpClient.Builder withAcceptLanguage(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.addInterceptor(new AcceptLanguageInterceptor());
        return builder;
    }
}
