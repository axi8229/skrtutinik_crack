package ru.yoomoney.sdk.auth.yandexAcquire.login.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.login.LoginRepository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes3.dex */
public final class YandexAcquireLoginModule_ProvideYandexAcquireLoginFragmentFactory implements Factory<Fragment> {
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final Provider<LoginRepository> loginRepositoryProvider;
    private final YandexAcquireLoginModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public YandexAcquireLoginModule_ProvideYandexAcquireLoginFragmentFactory(YandexAcquireLoginModule yandexAcquireLoginModule, Provider<Lazy<Config>> provider, Provider<LoginRepository> provider2, Provider<YooProfiler> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6) {
        this.module = yandexAcquireLoginModule;
        this.lazyConfigProvider = provider;
        this.loginRepositoryProvider = provider2;
        this.profilerProvider = provider3;
        this.routerProvider = provider4;
        this.processMapperProvider = provider5;
        this.resourceMapperProvider = provider6;
    }

    public static YandexAcquireLoginModule_ProvideYandexAcquireLoginFragmentFactory create(YandexAcquireLoginModule yandexAcquireLoginModule, Provider<Lazy<Config>> provider, Provider<LoginRepository> provider2, Provider<YooProfiler> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6) {
        return new YandexAcquireLoginModule_ProvideYandexAcquireLoginFragmentFactory(yandexAcquireLoginModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Fragment provideYandexAcquireLoginFragment(YandexAcquireLoginModule yandexAcquireLoginModule, Lazy<Config> lazy, LoginRepository loginRepository, YooProfiler yooProfiler, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(yandexAcquireLoginModule.provideYandexAcquireLoginFragment(lazy, loginRepository, yooProfiler, router, processMapper, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideYandexAcquireLoginFragment(this.module, this.lazyConfigProvider.get(), this.loginRepositoryProvider.get(), this.profilerProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get());
    }
}
