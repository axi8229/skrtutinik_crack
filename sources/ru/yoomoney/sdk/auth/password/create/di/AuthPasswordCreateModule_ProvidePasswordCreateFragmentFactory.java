package ru.yoomoney.sdk.auth.password.create.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.password.create.impl.AuthPasswordCreateInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuthPasswordCreateModule_ProvidePasswordCreateFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AuthPasswordCreateInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final AuthPasswordCreateModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public AuthPasswordCreateModule_ProvidePasswordCreateFragmentFactory(AuthPasswordCreateModule authPasswordCreateModule, Provider<AuthPasswordCreateInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<Config>> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<AnalyticsLogger> provider7) {
        this.module = authPasswordCreateModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.lazyConfigProvider = provider5;
        this.lazyRemoteConfigProvider = provider6;
        this.analyticsLoggerProvider = provider7;
    }

    public static AuthPasswordCreateModule_ProvidePasswordCreateFragmentFactory create(AuthPasswordCreateModule authPasswordCreateModule, Provider<AuthPasswordCreateInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<Config>> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<AnalyticsLogger> provider7) {
        return new AuthPasswordCreateModule_ProvidePasswordCreateFragmentFactory(authPasswordCreateModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment providePasswordCreateFragment(AuthPasswordCreateModule authPasswordCreateModule, AuthPasswordCreateInteractor authPasswordCreateInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<Config> lazy, Lazy<RemoteConfig> lazy2, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(authPasswordCreateModule.providePasswordCreateFragment(authPasswordCreateInteractor, router, processMapper, resourceMapper, lazy, lazy2, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePasswordCreateFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyConfigProvider.get(), this.lazyRemoteConfigProvider.get(), this.analyticsLoggerProvider.get());
    }
}
