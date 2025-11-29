package ru.yoomoney.sdk.auth.phone.confirm.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AuthPhoneConfirmInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuthPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AuthPhoneConfirmInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final AuthPhoneConfirmModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AuthPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory(AuthPhoneConfirmModule authPhoneConfirmModule, Provider<AuthPhoneConfirmInteractor> provider, Provider<Lazy<Config>> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<ServerTimeRepository> provider7, Provider<AnalyticsLogger> provider8) {
        this.module = authPhoneConfirmModule;
        this.interactorProvider = provider;
        this.lazyConfigProvider = provider2;
        this.routerProvider = provider3;
        this.processMapperProvider = provider4;
        this.resourceMapperProvider = provider5;
        this.resultDataProvider = provider6;
        this.serverTimeRepositoryProvider = provider7;
        this.analyticsLoggerProvider = provider8;
    }

    public static AuthPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory create(AuthPhoneConfirmModule authPhoneConfirmModule, Provider<AuthPhoneConfirmInteractor> provider, Provider<Lazy<Config>> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<ServerTimeRepository> provider7, Provider<AnalyticsLogger> provider8) {
        return new AuthPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory(authPhoneConfirmModule, provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static Fragment providePhoneConfirmFragment(AuthPhoneConfirmModule authPhoneConfirmModule, AuthPhoneConfirmInteractor authPhoneConfirmInteractor, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, ServerTimeRepository serverTimeRepository, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(authPhoneConfirmModule.providePhoneConfirmFragment(authPhoneConfirmInteractor, lazy, router, processMapper, resourceMapper, resultData, serverTimeRepository, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePhoneConfirmFragment(this.module, this.interactorProvider.get(), this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.resultDataProvider.get(), this.serverTimeRepositoryProvider.get(), this.analyticsLoggerProvider.get());
    }
}
