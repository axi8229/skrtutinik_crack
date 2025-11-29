package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.VerifyAddressUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideVerifyAddressUseCaseFactory implements Factory<VerifyAddressUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideVerifyAddressUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public VerifyAddressUseCase get() {
        return provideVerifyAddressUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideVerifyAddressUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideVerifyAddressUseCaseFactory(profileUseCaseModule, provider);
    }

    public static VerifyAddressUseCase provideVerifyAddressUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (VerifyAddressUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideVerifyAddressUseCase(iProfileRepository));
    }
}
