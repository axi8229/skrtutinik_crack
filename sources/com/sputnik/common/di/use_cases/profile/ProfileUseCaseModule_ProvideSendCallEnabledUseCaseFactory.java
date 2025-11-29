package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.SendCallEnabledUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideSendCallEnabledUseCaseFactory implements Factory<SendCallEnabledUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideSendCallEnabledUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public SendCallEnabledUseCase get() {
        return provideSendCallEnabledUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideSendCallEnabledUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideSendCallEnabledUseCaseFactory(profileUseCaseModule, provider);
    }

    public static SendCallEnabledUseCase provideSendCallEnabledUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (SendCallEnabledUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideSendCallEnabledUseCase(iProfileRepository));
    }
}
