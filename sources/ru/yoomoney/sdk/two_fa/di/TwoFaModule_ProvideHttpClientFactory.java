package ru.yoomoney.sdk.two_fa.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.net.interceptor.AuthorizationInterceptor;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvideHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<Config> configProvider;
    private final Provider<Context> contextProvider;
    private final Provider<AuthorizationInterceptor> interceptorProvider;
    private final TwoFaModule module;

    public TwoFaModule_ProvideHttpClientFactory(TwoFaModule twoFaModule, Provider<Context> provider, Provider<Config> provider2, Provider<AuthorizationInterceptor> provider3) {
        this.module = twoFaModule;
        this.contextProvider = provider;
        this.configProvider = provider2;
        this.interceptorProvider = provider3;
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideHttpClient(this.module, this.contextProvider.get(), this.configProvider.get(), this.interceptorProvider.get());
    }

    public static TwoFaModule_ProvideHttpClientFactory create(TwoFaModule twoFaModule, Provider<Context> provider, Provider<Config> provider2, Provider<AuthorizationInterceptor> provider3) {
        return new TwoFaModule_ProvideHttpClientFactory(twoFaModule, provider, provider2, provider3);
    }

    public static OkHttpClient provideHttpClient(TwoFaModule twoFaModule, Context context, Config config, AuthorizationInterceptor authorizationInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(twoFaModule.provideHttpClient(context, config, authorizationInterceptor));
    }
}
