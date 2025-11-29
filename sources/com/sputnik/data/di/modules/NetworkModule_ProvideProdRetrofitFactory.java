package com.sputnik.data.di.modules;

import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideProdRetrofitFactory implements Factory<Retrofit> {
    private final Provider<IConfig> configProvider;
    private final NetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public NetworkModule_ProvideProdRetrofitFactory(NetworkModule networkModule, Provider<IConfig> provider, Provider<OkHttpClient> provider2, Provider<PrefManager> provider3) {
        this.module = networkModule;
        this.configProvider = provider;
        this.okHttpClientProvider = provider2;
        this.prefManagerProvider = provider3;
    }

    @Override // javax.inject.Provider
    public Retrofit get() {
        return provideProdRetrofit(this.module, this.configProvider.get(), this.okHttpClientProvider.get(), this.prefManagerProvider.get());
    }

    public static NetworkModule_ProvideProdRetrofitFactory create(NetworkModule networkModule, Provider<IConfig> provider, Provider<OkHttpClient> provider2, Provider<PrefManager> provider3) {
        return new NetworkModule_ProvideProdRetrofitFactory(networkModule, provider, provider2, provider3);
    }

    public static Retrofit provideProdRetrofit(NetworkModule networkModule, IConfig iConfig, OkHttpClient okHttpClient, PrefManager prefManager) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(networkModule.provideProdRetrofit(iConfig, okHttpClient, prefManager));
    }
}
