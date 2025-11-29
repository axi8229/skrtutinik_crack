package ru.yoomoney.sdk.auth.yandexAcquire.registration.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.api.registrationV2.RegistrationV2Repository;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;
import ru.yoomoney.sdk.yooprofiler.YooProfiler;

/* loaded from: classes3.dex */
public final class YandexAcquireRegistrationModule_ProvideYandexAcquireEnrollmentFragmentFactory implements Factory<Fragment> {
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final YandexAcquireRegistrationModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<YooProfiler> profilerProvider;
    private final Provider<RegistrationV2Repository> registrationV2RepositoryProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public YandexAcquireRegistrationModule_ProvideYandexAcquireEnrollmentFragmentFactory(YandexAcquireRegistrationModule yandexAcquireRegistrationModule, Provider<Lazy<Config>> provider, Provider<RegistrationV2Repository> provider2, Provider<YooProfiler> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6) {
        this.module = yandexAcquireRegistrationModule;
        this.lazyConfigProvider = provider;
        this.registrationV2RepositoryProvider = provider2;
        this.profilerProvider = provider3;
        this.routerProvider = provider4;
        this.processMapperProvider = provider5;
        this.resourceMapperProvider = provider6;
    }

    public static YandexAcquireRegistrationModule_ProvideYandexAcquireEnrollmentFragmentFactory create(YandexAcquireRegistrationModule yandexAcquireRegistrationModule, Provider<Lazy<Config>> provider, Provider<RegistrationV2Repository> provider2, Provider<YooProfiler> provider3, Provider<Router> provider4, Provider<ProcessMapper> provider5, Provider<ResourceMapper> provider6) {
        return new YandexAcquireRegistrationModule_ProvideYandexAcquireEnrollmentFragmentFactory(yandexAcquireRegistrationModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static Fragment provideYandexAcquireEnrollmentFragment(YandexAcquireRegistrationModule yandexAcquireRegistrationModule, Lazy<Config> lazy, RegistrationV2Repository registrationV2Repository, YooProfiler yooProfiler, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(yandexAcquireRegistrationModule.provideYandexAcquireEnrollmentFragment(lazy, registrationV2Repository, yooProfiler, router, processMapper, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideYandexAcquireEnrollmentFragment(this.module, this.lazyConfigProvider.get(), this.registrationV2RepositoryProvider.get(), this.profilerProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get());
    }
}
