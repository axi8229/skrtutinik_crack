package com.sputnik.data.di.modules;

import com.sputnik.data.api.CamerasApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideCamerasApiFactory implements Factory<CamerasApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideCamerasApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public CamerasApi get() {
        return provideCamerasApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideCamerasApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideCamerasApiFactory(networkModule, provider);
    }

    public static CamerasApi provideCamerasApi(NetworkModule networkModule, Retrofit retrofit) {
        return (CamerasApi) Preconditions.checkNotNullFromProvides(networkModule.provideCamerasApi(retrofit));
    }
}
