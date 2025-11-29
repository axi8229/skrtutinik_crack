package com.sputnik.data.di.modules;

import com.sputnik.data.api.AuthApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideAuthApiFactory implements Factory<AuthApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideAuthApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public AuthApi get() {
        return provideAuthApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideAuthApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideAuthApiFactory(networkModule, provider);
    }

    public static AuthApi provideAuthApi(NetworkModule networkModule, Retrofit retrofit) {
        return (AuthApi) Preconditions.checkNotNullFromProvides(networkModule.provideAuthApi(retrofit));
    }
}
