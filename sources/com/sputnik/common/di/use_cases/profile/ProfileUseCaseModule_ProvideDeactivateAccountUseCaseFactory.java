package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.DeactivateAccountUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideDeactivateAccountUseCaseFactory implements Factory<DeactivateAccountUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideDeactivateAccountUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public DeactivateAccountUseCase get() {
        return provideDeactivateAccountUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideDeactivateAccountUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideDeactivateAccountUseCaseFactory(profileUseCaseModule, provider);
    }

    public static DeactivateAccountUseCase provideDeactivateAccountUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (DeactivateAccountUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideDeactivateAccountUseCase(iProfileRepository));
    }
}
