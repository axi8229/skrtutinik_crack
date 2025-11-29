package ru.yoomoney.sdk.auth.support.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;
import ru.yoomoney.sdk.auth.Config;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory implements Factory<Fragment> {
    private final Provider<Lazy<Config>> lazyConfigProvider;
    private final TechnicalSupportModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory(TechnicalSupportModule technicalSupportModule, Provider<Lazy<Config>> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4) {
        this.module = technicalSupportModule;
        this.lazyConfigProvider = provider;
        this.routerProvider = provider2;
        this.processMapperProvider = provider3;
        this.resourceMapperProvider = provider4;
    }

    public static TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory create(TechnicalSupportModule technicalSupportModule, Provider<Lazy<Config>> provider, Provider<Router> provider2, Provider<ProcessMapper> provider3, Provider<ResourceMapper> provider4) {
        return new TechnicalSupportModule_ProvideTechnicalSupportFragmentFactory(technicalSupportModule, provider, provider2, provider3, provider4);
    }

    public static Fragment provideTechnicalSupportFragment(TechnicalSupportModule technicalSupportModule, Lazy<Config> lazy, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(technicalSupportModule.provideTechnicalSupportFragment(lazy, router, processMapper, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideTechnicalSupportFragment(this.module, this.lazyConfigProvider.get(), this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get());
    }
}
