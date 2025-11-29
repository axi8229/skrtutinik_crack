package ru.yoomoney.sdk.auth.auxToken.di;

import androidx.fragment.app.Fragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.yoomoney.sdk.auth.auxToken.impl.AuxTokenIssueInteractor;
import ru.yoomoney.sdk.auth.utils.ResourceMapper;

/* loaded from: classes4.dex */
public final class AuxTokenIssueModule_ProvidePasswordCreateFragmentFactory implements Factory<Fragment> {
    private final Provider<AuxTokenIssueInteractor> interactorProvider;
    private final AuxTokenIssueModule module;
    private final Provider<ResourceMapper> resourceMapperProvider;

    public AuxTokenIssueModule_ProvidePasswordCreateFragmentFactory(AuxTokenIssueModule auxTokenIssueModule, Provider<AuxTokenIssueInteractor> provider, Provider<ResourceMapper> provider2) {
        this.module = auxTokenIssueModule;
        this.interactorProvider = provider;
        this.resourceMapperProvider = provider2;
    }

    public static AuxTokenIssueModule_ProvidePasswordCreateFragmentFactory create(AuxTokenIssueModule auxTokenIssueModule, Provider<AuxTokenIssueInteractor> provider, Provider<ResourceMapper> provider2) {
        return new AuxTokenIssueModule_ProvidePasswordCreateFragmentFactory(auxTokenIssueModule, provider, provider2);
    }

    public static Fragment providePasswordCreateFragment(AuxTokenIssueModule auxTokenIssueModule, AuxTokenIssueInteractor auxTokenIssueInteractor, ResourceMapper resourceMapper) {
        return (Fragment) Preconditions.checkNotNullFromProvides(auxTokenIssueModule.providePasswordCreateFragment(auxTokenIssueInteractor, resourceMapper));
    }

    @Override // javax.inject.Provider
    public Fragment get() {
        return providePasswordCreateFragment(this.module, this.interactorProvider.get(), this.resourceMapperProvider.get());
    }
}
