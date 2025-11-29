package ru.yoomoney.sdk.auth.email.enter.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.email.enter.impl.AuthEmailEnterInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuthEmailEnterModule_ProvideEnterEmailFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AuthEmailEnterInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final AuthEmailEnterModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public AuthEmailEnterModule_ProvideEnterEmailFragmentFactory(AuthEmailEnterModule authEmailEnterModule, Provider<AuthEmailEnterInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<ResultData> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<AnalyticsLogger> provider7, Provider<Lazy<Config>> provider8) {
        this.module = authEmailEnterModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.resultDataProvider = provider5;
        this.lazyRemoteConfigProvider = provider6;
        this.analyticsLoggerProvider = provider7;
        this.lazyConfigProvider = provider8;
    }

    public static AuthEmailEnterModule_ProvideEnterEmailFragmentFactory create(AuthEmailEnterModule authEmailEnterModule, Provider<AuthEmailEnterInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<ResultData> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<AnalyticsLogger> provider7, Provider<Lazy<Config>> provider8) {
        return new AuthEmailEnterModule_ProvideEnterEmailFragmentFactory(authEmailEnterModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static Fragment provideEnterEmailFragment(AuthEmailEnterModule authEmailEnterModule, AuthEmailEnterInteractor authEmailEnterInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, Lazy<RemoteConfig> lazy, AnalyticsLogger analyticsLogger, Lazy<Config> lazy2) {
        return (Fragment) Preconditions.checkNotNullFromProvides(authEmailEnterModule.provideEnterEmailFragment(authEmailEnterInteractor, router, processMapper, resourceMapper, resultData, lazy, analyticsLogger, lazy2));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideEnterEmailFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.resultDataProvider.get(), this.lazyRemoteConfigProvider.get(), this.analyticsLoggerProvider.get(), this.lazyConfigProvider.get());
    }
}
