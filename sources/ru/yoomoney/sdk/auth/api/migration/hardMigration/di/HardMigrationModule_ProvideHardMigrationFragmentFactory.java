package ru.yoomoney.sdk.auth.api.migration.hardMigration.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.migration.MigrationRepository;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes4.dex */
public final class HardMigrationModule_ProvideHardMigrationFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final Provider<MigrationRepository> migrationRepositoryProvider;
    private final HardMigrationModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public HardMigrationModule_ProvideHardMigrationFragmentFactory(HardMigrationModule hardMigrationModule, Provider<MigrationRepository> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<RemoteConfig>> provider5, Provider<YooProfiler> provider6, Provider<ResultData> provider7, Provider<ServerTimeRepository> provider8, Provider<AnalyticsLogger> provider9) {
        this.module = hardMigrationModule;
        this.migrationRepositoryProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.lazyRemoteConfigProvider = provider5;
        this.profilerProvider = provider6;
        this.resultDataProvider = provider7;
        this.serverTimeRepositoryProvider = provider8;
        this.analyticsLoggerProvider = provider9;
    }

    public static HardMigrationModule_ProvideHardMigrationFragmentFactory create(HardMigrationModule hardMigrationModule, Provider<MigrationRepository> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<RemoteConfig>> provider5, Provider<YooProfiler> provider6, Provider<ResultData> provider7, Provider<ServerTimeRepository> provider8, Provider<AnalyticsLogger> provider9) {
        return new HardMigrationModule_ProvideHardMigrationFragmentFactory(hardMigrationModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Fragment provideHardMigrationFragment(HardMigrationModule hardMigrationModule, MigrationRepository migrationRepository, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazy, YooProfiler yooProfiler, ResultData resultData, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(hardMigrationModule.provideHardMigrationFragment(migrationRepository, router, processMapper, resourceMapper, lazy, yooProfiler, resultData, serverTimeRepository, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideHardMigrationFragment(this.module, this.migrationRepositoryProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyRemoteConfigProvider.get(), this.profilerProvider.get(), this.resultDataProvider.get(), this.serverTimeRepositoryProvider.get(), this.analyticsLoggerProvider.get());
    }
}
