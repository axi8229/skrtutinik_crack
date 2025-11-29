package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.UnlinkAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideUnlinkAddressUseCaseFactory implements Factory<UnlinkAddressUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideUnlinkAddressUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public UnlinkAddressUseCase get() {
        return provideUnlinkAddressUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideUnlinkAddressUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideUnlinkAddressUseCaseFactory(profileUseCaseModule, provider);
    }

    public static UnlinkAddressUseCase provideUnlinkAddressUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (UnlinkAddressUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideUnlinkAddressUseCase(iProfileRepository));
    }
}
