package com.sputnik.data.di.modules;

import com.sputnik.data.api.PhysicalKeysApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvidePhysicalKeysApiFactory implements Factory<PhysicalKeysApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvidePhysicalKeysApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public PhysicalKeysApi get() {
        return providePhysicalKeysApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvidePhysicalKeysApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvidePhysicalKeysApiFactory(networkModule, provider);
    }

    public static PhysicalKeysApi providePhysicalKeysApi(NetworkModule networkModule, Retrofit retrofit) {
        return (PhysicalKeysApi) Preconditions.checkNotNullFromProvides(networkModule.providePhysicalKeysApi(retrofit));
    }
}
