package com.sputnik.data.di.modules;

import com.sputnik.data.api.ConnectIntercomApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideConnectIntercomApiFactory implements Factory<ConnectIntercomApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideConnectIntercomApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public ConnectIntercomApi get() {
        return provideConnectIntercomApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideConnectIntercomApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideConnectIntercomApiFactory(networkModule, provider);
    }

    public static ConnectIntercomApi provideConnectIntercomApi(NetworkModule networkModule, Retrofit retrofit) {
        return (ConnectIntercomApi) Preconditions.checkNotNullFromProvides(networkModule.provideConnectIntercomApi(retrofit));
    }
}
