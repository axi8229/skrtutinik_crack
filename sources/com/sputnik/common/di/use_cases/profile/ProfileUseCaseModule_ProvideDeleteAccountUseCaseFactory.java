package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.DeleteAccountUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideDeleteAccountUseCaseFactory implements Factory<DeleteAccountUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideDeleteAccountUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public DeleteAccountUseCase get() {
        return provideDeleteAccountUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideDeleteAccountUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideDeleteAccountUseCaseFactory(profileUseCaseModule, provider);
    }

    public static DeleteAccountUseCase provideDeleteAccountUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (DeleteAccountUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideDeleteAccountUseCase(iProfileRepository));
    }
}
