package ru.yoomoney.sdk.auth.about.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.router.ProcessMapper;
import ru.yoomoney.sdk.auth.router.Router;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class IdentificationModule_ProvideIdentificationInfoFragmentFactory implements Factory<Fragment> {
    private final IdentificationModule module;
    private final Provider<ProcessMapper> processMapperProvider;
    private final Provider<ResourceMapper> resourceMapperProvider;
    private final Provider<Router> routerProvider;

    public IdentificationModule_ProvideIdentificationInfoFragmentFactory(IdentificationModule identificationModule, Provider<Router> provider, Provider<ProcessMapper> provider2, Provider<ResourceMapper> provider3) {
        this.module = identificationModule;
        this.routerProvider = provider;
        this.processMapperProvider = provider2;
        this.resourceMapperProvider = provider3;
    }

    public static IdentificationModule_ProvideIdentificationInfoFragmentFactory create(IdentificationModule identificationModule, Provider<Router> provider, Provider<ProcessMapper> provider2, Provider<ResourceMapper> provider3) {
        return new IdentificationModule_ProvideIdentificationInfoFragmentFactory(identificationModule, provider, provider2, provider3);
    }

    public static Fragment provideIdentificationInfoFragment(IdentificationModule identificationModule, Router router, ProcessMapper processMapper, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(identificationModule.provideIdentificationInfoFragment(router, processMapper, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return provideIdentificationInfoFragment(this.module, this.routerProvider.get(), this.processMapperProvider.get(), this.resourceMapperProvider.get());
    }
}
