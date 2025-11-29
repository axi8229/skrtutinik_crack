package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.UpdateUseNameUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory implements Factory<UpdateUseNameUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public UpdateUseNameUseCase get() {
        return provideUpdateUseNameUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideUpdateUseNameUseCaseFactory(profileUseCaseModule, provider);
    }

    public static UpdateUseNameUseCase provideUpdateUseNameUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (UpdateUseNameUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideUpdateUseNameUseCase(iProfileRepository));
    }
}
