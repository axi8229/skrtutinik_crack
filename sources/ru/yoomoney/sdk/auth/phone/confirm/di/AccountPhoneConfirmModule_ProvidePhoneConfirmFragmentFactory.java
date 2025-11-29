package ru.yoomoney.sdk.auth.phone.confirm.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.api.serverTime.ServerTimeRepository;
import ru.yoomoney.sdk.auth.phone.confirm.impl.AccountPhoneConfirmInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AccountPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory implements Factory<Fragment> {
    private final Provider<AccountPhoneConfirmInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final AccountPhoneConfirmModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;
    private final Provider<ServerTimeRepository> serverTimeRepositoryProvider;

    public AccountPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory(AccountPhoneConfirmModule accountPhoneConfirmModule, Provider<AccountPhoneConfirmInteractor> provider, Provider<Lazy<Config>> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<ServerTimeRepository> provider7) {
        this.module = accountPhoneConfirmModule;
        this.interactorProvider = provider;
        this.lazyConfigProvider = provider2;
        this.routerProvider = provider3;
        this.processMapperProvider = provider4;
        this.resourceMapperProvider = provider5;
        this.resultDataProvider = provider6;
        this.serverTimeRepositoryProvider = provider7;
    }

    public static AccountPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory create(AccountPhoneConfirmModule accountPhoneConfirmModule, Provider<AccountPhoneConfirmInteractor> provider, Provider<Lazy<Config>> provider2, Provider<Router> provider3, Provider<ProcessMapper> provider4, Provider<ResourceMapper> provider5, Provider<ResultData> provider6, Provider<ServerTimeRepository> provider7) {
        return new AccountPhoneConfirmModule_ProvidePhoneConfirmFragmentFactory(accountPhoneConfirmModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment providePhoneConfirmFragment(AccountPhoneConfirmModule accountPhoneConfirmModule, AccountPhoneConfirmInteractor accountPhoneConfirmInteractor, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, ResultData resultData, ServerTimeRepository serverTimeRepository) {
        return (Fragment) Preconditions.checkNotNullFromProvides(accountPhoneConfirmModule.providePhoneConfirmFragment(accountPhoneConfirmInteractor, lazy, router, processMapper, resourceMapper, resultData, serverTimeRepository));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePhoneConfirmFragment(this.module, this.interactorProvider.get(), this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.resultDataProvider.get(), this.serverTimeRepositoryProvider.get());
    }
}
