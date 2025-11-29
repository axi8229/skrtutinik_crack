package com.sputnik.data.di.modules;

import android.app.Application;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideBaseOkHttpFactory implements Factory<OkHttpClient.Builder> {
    private final Provider<Application> applicationProvider;
    private final Provider<IConfig> configProvider;
    private final NetworkModule module;
    private final Provider<PrefManager> prefManagerProvider;

    public NetworkModule_ProvideBaseOkHttpFactory(NetworkModule networkModule, Provider<Application> provider, Provider<PrefManager> provider2, Provider<IConfig> provider3) {
        this.module = networkModule;
        this.applicationProvider = provider;
        this.prefManagerProvider = provider2;
        this.configProvider = provider3;
    }

    @Override // javax.inject.Provider
    public OkHttpClient.Builder get() {
        return provideBaseOkHttp(this.module, this.applicationProvider.get(), this.prefManagerProvider.get(), this.configProvider.get());
    }

    public static NetworkModule_ProvideBaseOkHttpFactory create(NetworkModule networkModule, Provider<Application> provider, Provider<PrefManager> provider2, Provider<IConfig> provider3) {
        return new NetworkModule_ProvideBaseOkHttpFactory(networkModule, provider, provider2, provider3);
    }

    public static OkHttpClient.Builder provideBaseOkHttp(NetworkModule networkModule, Application application, PrefManager prefManager, IConfig iConfig) {
        return (OkHttpClient.Builder) Preconditions.checkNotNullFromProvides(networkModule.provideBaseOkHttp(application, prefManager, iConfig));
    }
}
