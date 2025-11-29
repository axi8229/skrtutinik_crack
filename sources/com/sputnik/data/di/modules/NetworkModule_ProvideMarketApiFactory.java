package com.sputnik.data.di.modules;

import com.sputnik.data.api.MarketApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideMarketApiFactory implements Factory<MarketApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideMarketApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public MarketApi get() {
        return provideMarketApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideMarketApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideMarketApiFactory(networkModule, provider);
    }

    public static MarketApi provideMarketApi(NetworkModule networkModule, Retrofit retrofit) {
        return (MarketApi) Preconditions.checkNotNullFromProvides(networkModule.provideMarketApi(retrofit));
    }
}
