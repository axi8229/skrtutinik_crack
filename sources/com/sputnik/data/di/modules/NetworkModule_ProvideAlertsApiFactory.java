package com.sputnik.data.di.modules;

import com.sputnik.data.api.AlertsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideAlertsApiFactory implements Factory<AlertsApi> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideAlertsApiFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    @Override // javax.inject.Provider
    public AlertsApi get() {
        return provideAlertsApi(this.module, this.retrofitProvider.get());
    }

    public static NetworkModule_ProvideAlertsApiFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideAlertsApiFactory(networkModule, provider);
    }

    public static AlertsApi provideAlertsApi(NetworkModule networkModule, Retrofit retrofit) {
        return (AlertsApi) Preconditions.checkNotNullFromProvides(networkModule.provideAlertsApi(retrofit));
    }
}
