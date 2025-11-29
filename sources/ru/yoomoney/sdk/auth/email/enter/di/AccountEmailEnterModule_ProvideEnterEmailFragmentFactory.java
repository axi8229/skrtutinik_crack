package ru.yoomoney.sdk.auth.email.enter.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.email.enter.impl.AccountEmailEnterInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AccountEmailEnterModule_ProvideEnterEmailFragmentFactory implements Factory<Fragment> {
    private final Provider<AccountEmailEnterInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final AccountEmailEnterModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public AccountEmailEnterModule_ProvideEnterEmailFragmentFactory(AccountEmailEnterModule accountEmailEnterModule, Provider<AccountEmailEnterInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<ResultData> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<Lazy<Config>> provider7) {
        this.module = accountEmailEnterModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.resultDataProvider = provider5;
        this.lazyRemoteConfigProvider = provider6;
        this.lazyConfigProvider = provider7;
    }

    public static AccountEmailEnterModule_ProvideEnterEmailFragmentFactory create(AccountEmailEnterModule accountEmailEnterModule, Provider<AccountEmailEnterInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<ResultData> provider5, Provider<Lazy<RemoteConfig>> provider6, Provider<Lazy<Config>> provider7) {
        return new AccountEmailEnterModule_ProvideEnterEmailFragmentFactory(accountEmailEnterModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment provideEnterEmailFragment(AccountEmailEnterModule accountEmailEnterModule, AccountEmailEnterInteractor accountEmailEnterInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, Lazy<RemoteConfig> lazy, Lazy<Config> lazy2) {
        return (Fragment) Preconditions.checkNotNullFromProvides(accountEmailEnterModule.provideEnterEmailFragment(accountEmailEnterInteractor, router, processMapper, resourceMapper, resultData, lazy, lazy2));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideEnterEmailFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.resultDataProvider.get(), this.lazyRemoteConfigProvider.get(), this.lazyConfigProvider.get());
    }
}
