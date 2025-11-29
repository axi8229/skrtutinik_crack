package com.sputnik.data.di.modules;

import com.sputnik.data.api.StoriesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideStoriesApiFactory implements Factory<StoriesApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideStoriesApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public StoriesApi get() {
        return provideStoriesApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideStoriesApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideStoriesApiFactory(networkModule, provider);
    }

    public static StoriesApi provideStoriesApi(NetworkModule networkModule, Retrofit retrofit) {
        return (StoriesApi) Preconditions.checkNotNullFromProvides(networkModule.provideStoriesApi(retrofit));
    }
}
