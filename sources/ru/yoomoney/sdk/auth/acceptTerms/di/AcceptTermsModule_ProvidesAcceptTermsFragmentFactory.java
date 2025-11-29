package ru.yoomoney.sdk.auth.acceptTerms.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.acceptTerms.impl.AcceptTermsInteractor;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AcceptTermsModule_ProvidesAcceptTermsFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AcceptTermsInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final AcceptTermsModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public AcceptTermsModule_ProvidesAcceptTermsFragmentFactory(AcceptTermsModule acceptTermsModule, Provider<AcceptTermsInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<AnalyticsLogger> provider5, Provider<Lazy<Config>> provider6) {
        this.module = acceptTermsModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.analyticsLoggerProvider = provider5;
        this.lazyConfigProvider = provider6;
    }

    public static AcceptTermsModule_ProvidesAcceptTermsFragmentFactory create(AcceptTermsModule acceptTermsModule, Provider<AcceptTermsInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<AnalyticsLogger> provider5, Provider<Lazy<Config>> provider6) {
        return new AcceptTermsModule_ProvidesAcceptTermsFragmentFactory(acceptTermsModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Fragment providesAcceptTermsFragment(AcceptTermsModule acceptTermsModule, AcceptTermsInteractor acceptTermsInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger, Lazy<Config> lazy) {
        return (Fragment) Preconditions.checkNotNullFromProvides(acceptTermsModule.providesAcceptTermsFragment(acceptTermsInteractor, router, processMapper, resourceMapper, analyticsLogger, lazy));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providesAcceptTermsFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.analyticsLoggerProvider.get(), this.lazyConfigProvider.get());
    }
}
