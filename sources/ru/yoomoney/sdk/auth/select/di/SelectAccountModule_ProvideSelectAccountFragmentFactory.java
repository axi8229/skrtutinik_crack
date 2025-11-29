package ru.yoomoney.sdk.auth.select.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.select.impl.SelectAccountInteractor;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class SelectAccountModule_ProvideSelectAccountFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<SelectAccountInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final SelectAccountModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public SelectAccountModule_ProvideSelectAccountFragmentFactory(SelectAccountModule selectAccountModule, Provider<SelectAccountInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<Config>> provider5, Provider<AnalyticsLogger> provider6) {
        this.module = selectAccountModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.lazyConfigProvider = provider5;
        this.analyticsLoggerProvider = provider6;
    }

    public static SelectAccountModule_ProvideSelectAccountFragmentFactory create(SelectAccountModule selectAccountModule, Provider<SelectAccountInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<Config>> provider5, Provider<AnalyticsLogger> provider6) {
        return new SelectAccountModule_ProvideSelectAccountFragmentFactory(selectAccountModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Fragment provideSelectAccountFragment(SelectAccountModule selectAccountModule, SelectAccountInteractor selectAccountInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<Config> lazy, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(selectAccountModule.provideSelectAccountFragment(selectAccountInteractor, router, processMapper, resourceMapper, lazy, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideSelectAccountFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyConfigProvider.get(), this.analyticsLoggerProvider.get());
    }
}
