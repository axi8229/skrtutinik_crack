package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.DeleteFrUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory implements Factory<DeleteFrUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public DeleteFrUseCase get() {
        return provideDeleteFrUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideDeleteFrUseCaseFactory(profileUseCaseModule, provider);
    }

    public static DeleteFrUseCase provideDeleteFrUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (DeleteFrUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideDeleteFrUseCase(iProfileRepository));
    }
}
