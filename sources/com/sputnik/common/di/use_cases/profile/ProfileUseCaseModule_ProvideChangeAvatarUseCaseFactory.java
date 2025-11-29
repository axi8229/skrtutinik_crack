package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.ChangeAvatarUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideChangeAvatarUseCaseFactory implements Factory<ChangeAvatarUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideChangeAvatarUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public ChangeAvatarUseCase get() {
        return provideChangeAvatarUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideChangeAvatarUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideChangeAvatarUseCaseFactory(profileUseCaseModule, provider);
    }

    public static ChangeAvatarUseCase provideChangeAvatarUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (ChangeAvatarUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideChangeAvatarUseCase(iProfileRepository));
    }
}
