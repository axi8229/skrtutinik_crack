package com.sputnik.data.di.modules;

import com.sputnik.data.api.LocalizationApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideLocalizationApiFactory implements Factory<LocalizationApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideLocalizationApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public LocalizationApi get() {
        return provideLocalizationApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideLocalizationApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideLocalizationApiFactory(networkModule, provider);
    }

    public static LocalizationApi provideLocalizationApi(NetworkModule networkModule, Retrofit retrofit) {
        return (LocalizationApi) Preconditions.checkNotNullFromProvides(networkModule.provideLocalizationApi(retrofit));
    }
}
