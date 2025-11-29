package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.DeactivateAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideDeactivateAddressUseCaseFactory implements Factory<DeactivateAddressUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideDeactivateAddressUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public DeactivateAddressUseCase get() {
        return provideDeactivateAddressUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideDeactivateAddressUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideDeactivateAddressUseCaseFactory(profileUseCaseModule, provider);
    }

    public static DeactivateAddressUseCase provideDeactivateAddressUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (DeactivateAddressUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideDeactivateAddressUseCase(iProfileRepository));
    }
}
