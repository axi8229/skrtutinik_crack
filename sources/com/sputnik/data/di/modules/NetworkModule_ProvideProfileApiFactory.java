package com.sputnik.data.di.modules;

import com.sputnik.data.api.ProfileApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideProfileApiFactory implements Factory<ProfileApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideProfileApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public ProfileApi get() {
        return provideProfileApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideProfileApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideProfileApiFactory(networkModule, provider);
    }

    public static ProfileApi provideProfileApi(NetworkModule networkModule, Retrofit retrofit) {
        return (ProfileApi) Preconditions.checkNotNullFromProvides(networkModule.provideProfileApi(retrofit));
    }
}
