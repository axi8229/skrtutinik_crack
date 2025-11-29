package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.LogoutUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideLogoutUseCaseFactory implements Factory<LogoutUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideLogoutUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public LogoutUseCase get() {
        return provideLogoutUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideLogoutUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideLogoutUseCaseFactory(profileUseCaseModule, provider);
    }

    public static LogoutUseCase provideLogoutUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (LogoutUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideLogoutUseCase(iProfileRepository));
    }
}
