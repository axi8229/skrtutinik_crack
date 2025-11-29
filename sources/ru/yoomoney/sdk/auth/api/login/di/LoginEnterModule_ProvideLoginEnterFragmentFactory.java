package ru.yoomoney.sdk.auth.api.login.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.login.impl.LoginEnterInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class LoginEnterModule_ProvideLoginEnterFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<LoginEnterInteractor> loginEnterInteractorProvider;
    private final LoginEnterModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public LoginEnterModule_ProvideLoginEnterFragmentFactory(LoginEnterModule loginEnterModule, Provider<Lazy<Config>> provider, Provider<LoginEnterInteractor> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<AnalyticsLogger> provider7) {
        this.module = loginEnterModule;
        this.lazyConfigProvider = provider;
        this.loginEnterInteractorProvider = provider2;
        this.routerProvider = provider3;
        this.processMapperProvider = provider4;
        this.resourceMapperProvider = provider5;
        this.resultDataProvider = provider6;
        this.analyticsLoggerProvider = provider7;
    }

    public static LoginEnterModule_ProvideLoginEnterFragmentFactory create(LoginEnterModule loginEnterModule, Provider<Lazy<Config>> provider, Provider<LoginEnterInteractor> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<AnalyticsLogger> provider7) {
        return new LoginEnterModule_ProvideLoginEnterFragmentFactory(loginEnterModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment provideLoginEnterFragment(LoginEnterModule loginEnterModule, Lazy<Config> lazy, LoginEnterInteractor loginEnterInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(loginEnterModule.provideLoginEnterFragment(lazy, loginEnterInteractor, router, processMapper, resourceMapper, resultData, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideLoginEnterFragment(this.module, this.lazyConfigProvider.get(), this.loginEnterInteractorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.resultDataProvider.get(), this.analyticsLoggerProvider.get());
    }
}
