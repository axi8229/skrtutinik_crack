package npi.spay;

import com.google.android.gms.location.DeviceOrientationRequest;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: classes4.dex */
public final class Ah implements Factory {
    public final Jc a;
    public final Provider b;
    public final Provider c;
    public final Provider d;

    public Ah(Jc jc, C2042xf c2042xf, Jg jg, Provider provider) {
        this.a = jc;
        this.b = c2042xf;
        this.c = jg;
        this.d = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Jc jc = this.a;
        Interceptor interceptor = (Interceptor) this.b.get();
        HttpLoggingInterceptor loggingInterceptor = (HttpLoggingInterceptor) this.c.get();
        InterfaceC1997vk sslInteractor = (InterfaceC1997vk) this.d.get();
        jc.getClass();
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        Intrinsics.checkNotNullParameter(loggingInterceptor, "loggingInterceptor");
        Intrinsics.checkNotNullParameter(sslInteractor, "sslInteractor");
        OkHttpClient.Builder timeout = new OkHttpClient().newBuilder().addNetworkInterceptor(loggingInterceptor).addInterceptor(interceptor).readTimeout(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT, TimeUnit.MILLISECONDS);
        SSLSocketFactory socketFactory = sslInteractor.c().getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "sslInteractor.customSSLContext.socketFactory");
        return (OkHttpClient.Builder) Preconditions.checkNotNullFromProvides(timeout.sslSocketFactory(socketFactory, sslInteractor.a()).hostnameVerifier(sslInteractor.b()));
    }
}
