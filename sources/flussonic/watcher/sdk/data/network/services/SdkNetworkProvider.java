package flussonic.watcher.sdk.data.network.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import flussonic.watcher.sdk.data.network.dto.FlussonicSdkAdapterFactory;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class SdkNetworkProvider {
    private static Interceptor getLoggingInterceptor() {
        return null;
    }

    static {
        RxJavaPlugins.setErrorHandler(new Consumer() { // from class: flussonic.watcher.sdk.data.network.services.SdkNetworkProvider$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                SdkNetworkProvider.lambda$static$0((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(Throwable e) throws Exception {
        if (e instanceof UndeliverableException) {
            Timber.d(e.getCause());
        }
    }

    private OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Interceptor loggingInterceptor = getLoggingInterceptor();
        if (loggingInterceptor != null) {
            builder.addInterceptor(loggingInterceptor);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(15L, timeUnit);
        builder.writeTimeout(15L, timeUnit);
        builder.readTimeout(15L, timeUnit);
        return builder.build();
    }

    private Retrofit provideRetrofit(String baseUrl) {
        return new Retrofit.Builder().baseUrl(baseUrl).client(provideOkHttpClient()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(provideGsonConverterFactory(provideGson())).build();
    }

    private GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    private Gson provideGson() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().registerTypeAdapterFactory(FlussonicSdkAdapterFactory.create()).create();
    }

    public StreamerNetworkService provideStreamerNetworkService(String baseUrl) {
        return (StreamerNetworkService) provideRetrofit(baseUrl).create(StreamerNetworkService.class);
    }

    public WatcherNetworkService provideWatcherNetworkService(String baseUrl) {
        return (WatcherNetworkService) provideRetrofit(baseUrl).create(WatcherNetworkService.class);
    }
}
