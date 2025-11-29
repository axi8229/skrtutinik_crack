package ru.yoomoney.sdk.auth.finishing.success.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.finishing.success.impl.AuthFinishingSuccessInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuthFinishingSuccessModule_ProvidesAuthLoadingFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AuthFinishingSuccessInteractor> interactorProvider;
    private final AuthFinishingSuccessModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public AuthFinishingSuccessModule_ProvidesAuthLoadingFragmentFactory(AuthFinishingSuccessModule authFinishingSuccessModule, Provider<AuthFinishingSuccessInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<AnalyticsLogger> provider5) {
        this.module = authFinishingSuccessModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.analyticsLoggerProvider = provider5;
    }

    public static AuthFinishingSuccessModule_ProvidesAuthLoadingFragmentFactory create(AuthFinishingSuccessModule authFinishingSuccessModule, Provider<AuthFinishingSuccessInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<AnalyticsLogger> provider5) {
        return new AuthFinishingSuccessModule_ProvidesAuthLoadingFragmentFactory(authFinishingSuccessModule, provider, provider2, provider3, provider4, provider5);
    }

    public static Fragment providesAuthLoadingFragment(AuthFinishingSuccessModule authFinishingSuccessModule, AuthFinishingSuccessInteractor authFinishingSuccessInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(authFinishingSuccessModule.providesAuthLoadingFragment(authFinishingSuccessInteractor, router, processMapper, resourceMapper, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providesAuthLoadingFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.analyticsLoggerProvider.get());
    }
}
