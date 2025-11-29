package ru.yoomoney.sdk.auth.password.enter.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.password.enter.impl.AuthPasswordEnterInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuthPasswordEnterModule_ProvidePasswordEnterFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AuthPasswordEnterInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final AuthPasswordEnterModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public AuthPasswordEnterModule_ProvidePasswordEnterFragmentFactory(AuthPasswordEnterModule authPasswordEnterModule, Provider<Router> provider, Provider<ProcessMapper> provider2, Provider<Lazy<Config>> provider3, Provider<ResultData> provider4, Provider<AuthPasswordEnterInteractor> provider5, Provider<ResourceMapper> provider6, Provider<AnalyticsLogger> provider7) {
        this.module = authPasswordEnterModule;
        this.routerProvider = provider;
        this.processMapperProvider = provider2;
        this.lazyConfigProvider = provider3;
        this.resultDataProvider = provider4;
        this.interactorProvider = provider5;
        this.resourceMapperProvider = provider6;
        this.analyticsLoggerProvider = provider7;
    }

    public static AuthPasswordEnterModule_ProvidePasswordEnterFragmentFactory create(AuthPasswordEnterModule authPasswordEnterModule, Provider<Router> provider, Provider<ProcessMapper> provider2, Provider<Lazy<Config>> provider3, Provider<ResultData> provider4, Provider<AuthPasswordEnterInteractor> provider5, Provider<ResourceMapper> provider6, Provider<AnalyticsLogger> provider7) {
        return new AuthPasswordEnterModule_ProvidePasswordEnterFragmentFactory(authPasswordEnterModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment providePasswordEnterFragment(AuthPasswordEnterModule authPasswordEnterModule, Router router, ProcessMapper processMapper, Lazy<Config> lazy, ResultData resultData, AuthPasswordEnterInteractor authPasswordEnterInteractor, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(authPasswordEnterModule.providePasswordEnterFragment(router, processMapper, lazy, resultData, authPasswordEnterInteractor, resourceMapper, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePasswordEnterFragment(this.module, this.routerProvider.get(), this.processMapperProvider.get(), this.lazyConfigProvider.get(), this.resultDataProvider.get(), this.interactorProvider.get(), this.resourceMapperProvider.get(), this.analyticsLoggerProvider.get());
    }
}
