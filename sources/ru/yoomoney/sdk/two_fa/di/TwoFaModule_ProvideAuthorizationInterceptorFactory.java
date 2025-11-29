package ru.yoomoney.sdk.two_fa.di;

import dagger.internal.Factory;
import javax.inject.Provider;
import ru.yoomoney.sdk.two_fa.Config;
import ru.yoomoney.sdk.two_fa.net.interceptor.AuthorizationInterceptor;

/* loaded from: classes5.dex */
public final class TwoFaModule_ProvideAuthorizationInterceptorFactory implements Factory<AuthorizationInterceptor> {
    private final Provider<Config> configProvider;
    private final TwoFaModule module;

    public TwoFaModule_ProvideAuthorizationInterceptorFactory(TwoFaModule twoFaModule, Provider<Config> provider) {
        this.module = twoFaModule;
        this.configProvider = provider;
    }

    @Override // javax.inject.Provider
    public AuthorizationInterceptor get() {
        return provideAuthorizationInterceptor(this.module, this.configProvider.get());
    }

    public static TwoFaModule_ProvideAuthorizationInterceptorFactory create(TwoFaModule twoFaModule, Provider<Config> provider) {
        return new TwoFaModule_ProvideAuthorizationInterceptorFactory(twoFaModule, provider);
    }

    public static AuthorizationInterceptor provideAuthorizationInterceptor(TwoFaModule twoFaModule, Config config) {
        return twoFaModule.provideAuthorizationInterceptor(config);
    }
}
