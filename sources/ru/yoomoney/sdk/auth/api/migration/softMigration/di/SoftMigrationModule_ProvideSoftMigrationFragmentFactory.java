package ru.yoomoney.sdk.auth.api.migration.softMigration.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class SoftMigrationModule_ProvideSoftMigrationFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final SoftMigrationModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public SoftMigrationModule_ProvideSoftMigrationFragmentFactory(SoftMigrationModule softMigrationModule, Provider<Lazy<Config>> provider, Provider<MigrationRepository> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<YooProfiler> provider7, Provider<ResultData> provider8, Provider<AnalyticsLogger> provider9) {
        this.module = softMigrationModule;
        this.lazyConfigProvider = provider;
        this.migrationRepositoryProvider = provider2;
        this.routerProvider = provider3;
        this.processMapperProvider = provider4;
        this.resourceMapperProvider = provider5;
        this.lazyRemoteConfigProvider = provider6;
        this.profilerProvider = provider7;
        this.resultDataProvider = provider8;
        this.analyticsLoggerProvider = provider9;
    }

    public static SoftMigrationModule_ProvideSoftMigrationFragmentFactory create(SoftMigrationModule softMigrationModule, Provider<Lazy<Config>> provider, Provider<MigrationRepository> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<YooProfiler> provider7, Provider<ResultData> provider8, Provider<AnalyticsLogger> provider9) {
        return new SoftMigrationModule_ProvideSoftMigrationFragmentFactory(softMigrationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Fragment provideSoftMigrationFragment(SoftMigrationModule softMigrationModule, Lazy<Config> lazy, MigrationRepository migrationRepository, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazy2, YooProfiler yooProfiler, ResultData resultData, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(softMigrationModule.provideSoftMigrationFragment(lazy, migrationRepository, router, processMapper, resourceMapper, lazy2, yooProfiler, resultData, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideSoftMigrationFragment(this.module, this.lazyConfigProvider.get(), this.migrationRepositoryProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyRemoteConfigProvider.get(), this.profilerProvider.get(), this.resultDataProvider.get(), this.analyticsLoggerProvider.get());
    }
}
