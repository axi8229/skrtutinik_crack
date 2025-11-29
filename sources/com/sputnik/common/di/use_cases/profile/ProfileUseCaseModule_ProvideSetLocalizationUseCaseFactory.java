package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.SetLocalizationUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideSetLocalizationUseCaseFactory implements Factory<SetLocalizationUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideSetLocalizationUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public SetLocalizationUseCase get() {
        return provideSetLocalizationUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideSetLocalizationUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideSetLocalizationUseCaseFactory(profileUseCaseModule, provider);
    }

    public static SetLocalizationUseCase provideSetLocalizationUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (SetLocalizationUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideSetLocalizationUseCase(iProfileRepository));
    }
}
