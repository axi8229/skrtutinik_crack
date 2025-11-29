package ru.yoomoney.sdk.kassa.payments.http;

import android.content.Context;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import ru.yoomoney.sdk.yoopinning.PinningHelper;

/* loaded from: classes5.dex */
public abstract class k {
    public static final j a = new j();

    public static final OkHttpClient.Builder a(OkHttpClient.Builder builder, Context context, String str, boolean z) throws NoSuchAlgorithmException, KeyManagementException {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zB = ru.yoomoney.sdk.kassa.payments.utils.d.b();
        Intrinsics.checkNotNullParameter(context, "context");
        X509TrustManager trustManager = (str == null || StringsKt.isBlank(str) || zB) ? a : PinningHelper.INSTANCE.getInstance(context, str).getTrustManager();
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        sSLContext.init(null, new X509TrustManager[]{trustManager}, new SecureRandom());
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "getSSLSocketFactoryAndInit(...)");
        builder.sslSocketFactory(socketFactory, trustManager);
        if (z) {
            builder.hostnameVerifier(new HostnameVerifier() { // from class: ru.yoomoney.sdk.kassa.payments.http.k$$ExternalSyntheticLambda0
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str2, SSLSession sSLSession) {
                    return k.a(str2, sSLSession);
                }
            });
        }
        return builder;
    }

    public static final boolean a(String str, SSLSession sSLSession) {
        return true;
    }

    public static final OkHttpClient.Builder a(Context context, boolean z, String str, boolean z2) throws NoSuchAlgorithmException, KeyManagementException {
        HttpLoggingInterceptor httpLoggingInterceptor;
        HttpLoggingInterceptor.Level level;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient.Builder builderA = a(builder.readTimeout(30L, timeUnit).connectTimeout(30L, timeUnit).connectionPool(new ConnectionPool(4, 10L, TimeUnit.MINUTES)).followSslRedirects(false).followRedirects(false), context, str, z2);
        Intrinsics.checkNotNullParameter(builderA, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        OkHttpClient.Builder builderAddInterceptor = builderA.addInterceptor(new m(l.a(context)));
        Intrinsics.checkNotNullParameter(builderAddInterceptor, "<this>");
        if (ru.yoomoney.sdk.kassa.payments.utils.d.b() && z) {
            httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            level = HttpLoggingInterceptor.Level.HEADERS;
        } else {
            httpLoggingInterceptor = new HttpLoggingInterceptor(null, 1, null);
            level = HttpLoggingInterceptor.Level.NONE;
        }
        return builderAddInterceptor.addInterceptor(httpLoggingInterceptor.setLevel(level));
    }
}
