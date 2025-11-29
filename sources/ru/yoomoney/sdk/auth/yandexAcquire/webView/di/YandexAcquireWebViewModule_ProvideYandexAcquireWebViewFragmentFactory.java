package ru.yoomoney.sdk.auth.yandexAcquire.webView.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes3.dex */
public final class YandexAcquireWebViewModule_ProvideYandexAcquireWebViewFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final YandexAcquireWebViewModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public YandexAcquireWebViewModule_ProvideYandexAcquireWebViewFragmentFactory(YandexAcquireWebViewModule yandexAcquireWebViewModule, Provider<MigrationRepository> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<Lazy<Config>> provider4, Provider<ResourceMapper> provider5, Provider<ServerTimeRepository> provider6, Provider<AnalyticsLogger> provider7) {
        this.module = yandexAcquireWebViewModule;
        this.migrationRepositoryProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.lazyConfigProvider = provider4;
        this.resourceMapperProvider = provider5;
        this.serverTimeRepositoryProvider = provider6;
        this.analyticsLoggerProvider = provider7;
    }

    public static YandexAcquireWebViewModule_ProvideYandexAcquireWebViewFragmentFactory create(YandexAcquireWebViewModule yandexAcquireWebViewModule, Provider<MigrationRepository> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<Lazy<Config>> provider4, Provider<ResourceMapper> provider5, Provider<ServerTimeRepository> provider6, Provider<AnalyticsLogger> provider7) {
        return new YandexAcquireWebViewModule_ProvideYandexAcquireWebViewFragmentFactory(yandexAcquireWebViewModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment provideYandexAcquireWebViewFragment(YandexAcquireWebViewModule yandexAcquireWebViewModule, MigrationRepository migrationRepository, Router router, ProcessMapper processMapper, Lazy<Config> lazy, ResourceMapper resourceMapper, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(yandexAcquireWebViewModule.provideYandexAcquireWebViewFragment(migrationRepository, router, processMapper, lazy, resourceMapper, serverTimeRepository, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideYandexAcquireWebViewFragment(this.module, this.migrationRepositoryProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.lazyConfigProvider.get(), this.resourceMapperProvider.get(), this.serverTimeRepositoryProvider.get(), this.analyticsLoggerProvider.get());
    }
}
