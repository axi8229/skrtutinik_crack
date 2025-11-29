package ru.yoomoney.sdk.auth.email.confirm.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.email.confirm.impl.AccountEmailConfirmInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AccountEmailConfirmModule_ProvideEmailConfirmFragmentFactory implements Factory<Fragment> {
    private final Provider<AccountEmailConfirmInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final AccountEmailConfirmModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountEmailConfirmModule_ProvideEmailConfirmFragmentFactory(AccountEmailConfirmModule accountEmailConfirmModule, Provider<AccountEmailConfirmInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<Config>> provider5, Provider<ResultData> provider6, Provider<ServerTimeRepository> provider7) {
        this.module = accountEmailConfirmModule;
        this.interactorProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
        this.lazyConfigProvider = provider5;
        this.resultDataProvider = provider6;
        this.serverTimeRepositoryProvider = provider7;
    }

    public static AccountEmailConfirmModule_ProvideEmailConfirmFragmentFactory create(AccountEmailConfirmModule accountEmailConfirmModule, Provider<AccountEmailConfirmInteractor> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4, Provider<Lazy<Config>> provider5, Provider<ResultData> provider6, Provider<ServerTimeRepository> provider7) {
        return new AccountEmailConfirmModule_ProvideEmailConfirmFragmentFactory(accountEmailConfirmModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment provideEmailConfirmFragment(AccountEmailConfirmModule accountEmailConfirmModule, AccountEmailConfirmInteractor accountEmailConfirmInteractor, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<Config> lazy, ResultData resultData, ServerTimeRepository serverTimeRepository) {
        return (Fragment) Preconditions.checkNotNullFromProvides(accountEmailConfirmModule.provideEmailConfirmFragment(accountEmailConfirmInteractor, router, processMapper, resourceMapper, lazy, resultData, serverTimeRepository));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideEmailConfirmFragment(this.module, this.interactorProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyConfigProvider.get(), this.resultDataProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
