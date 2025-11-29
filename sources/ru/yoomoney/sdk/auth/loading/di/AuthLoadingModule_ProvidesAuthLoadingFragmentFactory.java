package ru.yoomoney.sdk.auth.loading.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.RemoteConfig;
import ru.yoomoney.sdk.auth.ResultData;
import ru.yoomoney.sdk.auth.loading.impl.AuthLoadingInteractor;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuthLoadingModule_ProvidesAuthLoadingFragmentFactory implements Factory<Fragment> {
    private final Provider<AuthLoadingInteractor> interactorProvider;
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<Lazy<RemoteConfig>> lazyRemoteConfigProvider;
    private final AuthLoadingModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<ResultData> resultDataProvider;
    private final Provider<Router> routerProvider;

    public AuthLoadingModule_ProvidesAuthLoadingFragmentFactory(AuthLoadingModule authLoadingModule, Provider<AuthLoadingInteractor> provider, Provider<ResultData> provider2, Provider<Lazy<Config>> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6, Provider<Lazy<RemoteConfig>> provider7) {
        this.module = authLoadingModule;
        this.interactorProvider = provider;
        this.resultDataProvider = provider2;
        this.lazyConfigProvider = provider3;
        this.routerProvider = provider4;
        this.processMapperProvider = provider5;
        this.resourceMapperProvider = provider6;
        this.lazyRemoteConfigProvider = provider7;
    }

    public static AuthLoadingModule_ProvidesAuthLoadingFragmentFactory create(AuthLoadingModule authLoadingModule, Provider<AuthLoadingInteractor> provider, Provider<ResultData> provider2, Provider<Lazy<Config>> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6, Provider<Lazy<RemoteConfig>> provider7) {
        return new AuthLoadingModule_ProvidesAuthLoadingFragmentFactory(authLoadingModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static Fragment providesAuthLoadingFragment(AuthLoadingModule authLoadingModule, AuthLoadingInteractor authLoadingInteractor, ResultData resultData, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper, Lazy<RemoteConfig> lazy2) {
        return (Fragment) Preconditions.checkNotNullFromProvides(authLoadingModule.providesAuthLoadingFragment(authLoadingInteractor, resultData, lazy, router, processMapper, resourceMapper, lazy2));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providesAuthLoadingFragment(this.module, this.interactorProvider.get(), this.resultDataProvider.get(), this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get(), this.lazyRemoteConfigProvider.get());
    }
}
