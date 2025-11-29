package ru.yoomoney.sdk.auth.passport.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.passport.impl.PassportProfileInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class PassportProfileModule_ProvideProfileFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<PassportProfileInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final PassportProfileModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public PassportProfileModule_ProvideProfileFragmentFactory(PassportProfileModule passportProfileModule, Provider<PassportProfileInteractor> provider, Provider<ResultData> provider2, Provider<Lazy<Config>> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6, Provider<AnalyticsLogger> provider7, Provider<Lazy<RemoteConfig>> provider8) {
        this.module = passportProfileModule;
        this.interactorProvider = provider;
        this.resultDataProvider = provider2;
        this.lazyConfigProvider = provider3;
        this.routerProvider = provider4;
        this.processMapperProvider = provider5;
        this.resourceMapperProvider = provider6;
        this.analyticsLoggerProvider = provider7;
        this.lazyRemoteConfigProvider = provider8;
    }

    public static PassportProfileModule_ProvideProfileFragmentFactory create(PassportProfileModule passportProfileModule, Provider<PassportProfileInteractor> provider, Provider<ResultData> provider2, Provider<Lazy<Config>> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6, Provider<AnalyticsLogger> provider7, Provider<Lazy<RemoteConfig>> provider8) {
        return new PassportProfileModule_ProvideProfileFragmentFactory(passportProfileModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static Fragment provideProfileFragment(PassportProfileModule passportProfileModule, PassportProfileInteractor passportProfileInteractor, ResultData resultData, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger, Lazy<RemoteConfig> lazy2) {
        return (Fragment) Preconditions.checkNotNullFromProvides(passportProfileModule.provideProfileFragment(passportProfileInteractor, resultData, lazy, router, processMapper, resourceMapper, analyticsLogger, lazy2));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideProfileFragment(this.module, this.interactorProvider.get(), this.resultDataProvider.get(), this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.analyticsLoggerProvider.get(), this.lazyRemoteConfigProvider.get());
    }
}
