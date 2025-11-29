package com.sputnik.data.di.modules;

import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideOkHttpFactory implements Factory<OkHttpClient> {
    private final Provider<IConfig> configProvider;
    private final NetworkModule module;
    private final Provider<OkHttpClient.Builder> okHttpClientBuilderProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public NetworkModule_ProvideOkHttpFactory(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<PrefManager> provider2, Provider<IConfig> provider3) {
        this.module = networkModule;
        this.okHttpClientBuilderProvider = provider;
        this.prefManagerProvider = provider2;
        this.configProvider = provider3;
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideOkHttp(this.module, this.okHttpClientBuilderProvider.get(), this.prefManagerProvider.get(), this.configProvider.get());
    }

    public static NetworkModule_ProvideOkHttpFactory create(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider, Provider<PrefManager> provider2, Provider<IConfig> provider3) {
        return new NetworkModule_ProvideOkHttpFactory(networkModule, provider, provider2, provider3);
    }

    public static OkHttpClient provideOkHttp(NetworkModule networkModule, OkHttpClient.Builder builder, PrefManager prefManager, IConfig iConfig) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.provideOkHttp(builder, prefManager, iConfig));
    }
}
