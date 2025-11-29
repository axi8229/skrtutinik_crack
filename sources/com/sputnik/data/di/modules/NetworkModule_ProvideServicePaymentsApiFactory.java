package com.sputnik.data.di.modules;

import com.sputnik.data.api.ServicePaymentsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideServicePaymentsApiFactory implements Factory<ServicePaymentsApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideServicePaymentsApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public ServicePaymentsApi get() {
        return provideServicePaymentsApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideServicePaymentsApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideServicePaymentsApiFactory(networkModule, provider);
    }

    public static ServicePaymentsApi provideServicePaymentsApi(NetworkModule networkModule, Retrofit retrofit) {
        return (ServicePaymentsApi) Preconditions.checkNotNullFromProvides(networkModule.provideServicePaymentsApi(retrofit));
    }
}
