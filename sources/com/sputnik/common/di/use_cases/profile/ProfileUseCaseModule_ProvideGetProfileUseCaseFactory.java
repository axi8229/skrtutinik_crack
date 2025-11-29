package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.GetProfileUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideGetProfileUseCaseFactory implements Factory<GetProfileUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideGetProfileUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetProfileUseCase get() {
        return provideGetProfileUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideGetProfileUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideGetProfileUseCaseFactory(profileUseCaseModule, provider);
    }

    public static GetProfileUseCase provideGetProfileUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (GetProfileUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideGetProfileUseCase(iProfileRepository));
    }
}
