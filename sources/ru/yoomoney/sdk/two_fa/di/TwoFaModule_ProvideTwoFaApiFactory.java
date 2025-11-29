package ru.yoomoney.sdk.two_fa.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.api.Class2faApi;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvideTwoFaApiFactory implements Factory<Class2faApi> {
    private final Provider<Config> configProvider;
    private final Provider<OkHttpClient> httpClientProvider;
    private final TwoFaModule module;

    public TwoFaModule_ProvideTwoFaApiFactory(TwoFaModule twoFaModule, Provider<Config> provider, Provider<OkHttpClient> provider2) {
        this.module = twoFaModule;
        this.configProvider = provider;
        this.httpClientProvider = provider2;
    }

    @Override // javax.inject.Provider
    public Class2faApi get() {
        return provideTwoFaApi(this.module, this.configProvider.get(), this.httpClientProvider.get());
    }

    public static TwoFaModule_ProvideTwoFaApiFactory create(TwoFaModule twoFaModule, Provider<Config> provider, Provider<OkHttpClient> provider2) {
        return new TwoFaModule_ProvideTwoFaApiFactory(twoFaModule, provider, provider2);
    }

    public static Class2faApi provideTwoFaApi(TwoFaModule twoFaModule, Config config, OkHttpClient okHttpClient) {
        return (Class2faApi) Preconditions.checkNotNullFromProvides(twoFaModule.provideTwoFaApi(config, okHttpClient));
    }
}
