package ru.yoomoney.sdk.auth.phone.enter.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.analytics.AnalyticsLogger;
import ru.yoomoney.sdk.auth.phone.enter.impl.AccountPhoneEnterInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AccountPhoneEnterModule_ProvidePhoneEnterFragmentFactory implements Factory<Fragment> {
    private final Provider<AnalyticsLogger> analyticsLoggerProvider;
    private final Provider<AccountPhoneEnterInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final AccountPhoneEnterModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public AccountPhoneEnterModule_ProvidePhoneEnterFragmentFactory(AccountPhoneEnterModule accountPhoneEnterModule, Provider<AccountPhoneEnterInteractor> provider, Provider<Router> provider2, Provider<Lazy<Config>> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<AnalyticsLogger> provider7) {
        this.module = accountPhoneEnterModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.lazyConfigProvider = provider3;
        this.processMapperProvider = provider4;
        this.resourceMapperProvider = provider5;
        this.resultDataProvider = provider6;
        this.analyticsLoggerProvider = provider7;
    }

    public static AccountPhoneEnterModule_ProvidePhoneEnterFragmentFactory create(AccountPhoneEnterModule accountPhoneEnterModule, Provider<AccountPhoneEnterInteractor> provider, Provider<Router> provider2, Provider<Lazy<Config>> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<AnalyticsLogger> provider7) {
        return new AccountPhoneEnterModule_ProvidePhoneEnterFragmentFactory(accountPhoneEnterModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment providePhoneEnterFragment(AccountPhoneEnterModule accountPhoneEnterModule, AccountPhoneEnterInteractor accountPhoneEnterInteractor, Router router, Lazy<Config> lazy, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, AnalyticsLogger analyticsLogger) {
        return (Fragment) Preconditions.checkNotNullFromProvides(accountPhoneEnterModule.providePhoneEnterFragment(accountPhoneEnterInteractor, router, lazy, processMapper, resourceMapper, resultData, analyticsLogger));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePhoneEnterFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.lazyConfigProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.resultDataProvider.get(), this.analyticsLoggerProvider.get());
    }
}
