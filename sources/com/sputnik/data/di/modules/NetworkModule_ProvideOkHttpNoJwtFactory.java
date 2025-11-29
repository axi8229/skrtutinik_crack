package com.sputnik.data.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkModule_ProvideOkHttpNoJwtFactory implements Factory<OkHttpClient> {
    private final NetworkModule module;
    private final Provider<OkHttpClient.Builder> okHttpClientBuilderProvider;

    public NetworkModule_ProvideOkHttpNoJwtFactory(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider) {
        this.module = networkModule;
        this.okHttpClientBuilderProvider = provider;
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideOkHttpNoJwt(this.module, this.okHttpClientBuilderProvider.get());
    }

    public static NetworkModule_ProvideOkHttpNoJwtFactory create(NetworkModule networkModule, Provider<OkHttpClient.Builder> provider) {
        return new NetworkModule_ProvideOkHttpNoJwtFactory(networkModule, provider);
    }

    public static OkHttpClient provideOkHttpNoJwt(NetworkModule networkModule, OkHttpClient.Builder builder) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.provideOkHttpNoJwt(builder));
    }
}
