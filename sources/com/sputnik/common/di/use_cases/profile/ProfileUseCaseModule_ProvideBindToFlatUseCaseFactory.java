package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.BindToFlatUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideBindToFlatUseCaseFactory implements Factory<BindToFlatUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideBindToFlatUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public BindToFlatUseCase get() {
        return provideBindToFlatUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideBindToFlatUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideBindToFlatUseCaseFactory(profileUseCaseModule, provider);
    }

    public static BindToFlatUseCase provideBindToFlatUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (BindToFlatUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideBindToFlatUseCase(iProfileRepository));
    }
}
