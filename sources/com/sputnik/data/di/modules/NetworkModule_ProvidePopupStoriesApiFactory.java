package com.sputnik.data.di.modules;

import com.sputnik.data.api.PopupStoriesApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvidePopupStoriesApiFactory implements Factory<PopupStoriesApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvidePopupStoriesApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public PopupStoriesApi get() {
        return providePopupStoriesApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvidePopupStoriesApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvidePopupStoriesApiFactory(networkModule, provider);
    }

    public static PopupStoriesApi providePopupStoriesApi(NetworkModule networkModule, Retrofit retrofit) {
        return (PopupStoriesApi) Preconditions.checkNotNullFromProvides(networkModule.providePopupStoriesApi(retrofit));
    }
}
