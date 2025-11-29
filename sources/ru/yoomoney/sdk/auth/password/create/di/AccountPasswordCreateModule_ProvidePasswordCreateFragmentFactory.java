package ru.yoomoney.sdk.auth.password.create.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.password.create.impl.AccountPasswordCreateInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AccountPasswordCreateModule_ProvidePasswordCreateFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AccountPasswordCreateInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final AccountPasswordCreateModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public AccountPasswordCreateModule_ProvidePasswordCreateFragmentFactory(AccountPasswordCreateModule accountPasswordCreateModule, Provider<AccountPasswordCreateInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<RemoteConfig>> provider5, Provider<Lazy<Config>> provider6, Provider<AnalyticsLogger> provider7) {
        this.module = accountPasswordCreateModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.lazyRemoteConfigProvider = provider5;
        this.lazyConfigProvider = provider6;
        this.analyticsLoggerProvider = provider7;
    }

    public static AccountPasswordCreateModule_ProvidePasswordCreateFragmentFactory create(AccountPasswordCreateModule accountPasswordCreateModule, Provider<AccountPasswordCreateInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<RemoteConfig>> provider5, Provider<Lazy<Config>> provider6, Provider<AnalyticsLogger> provider7) {
        return new AccountPasswordCreateModule_ProvidePasswordCreateFragmentFactory(accountPasswordCreateModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment providePasswordCreateFragment(AccountPasswordCreateModule accountPasswordCreateModule, AccountPasswordCreateInteractor accountPasswordCreateInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazy, Lazy<Config> lazy2, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(accountPasswordCreateModule.providePasswordCreateFragment(accountPasswordCreateInteractor, router, processMapper, resourceMapper, lazy, lazy2, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePasswordCreateFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyRemoteConfigProvider.get(), this.lazyConfigProvider.get(), this.analyticsLoggerProvider.get());
    }
}
