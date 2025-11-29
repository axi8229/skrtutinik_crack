package com.sputnik.common.di.use_cases.profile;

import com.sputnik.domain.repositories.profile.IProfileRepository;
import com.sputnik.domain.usecases.profile.SendPushTokenUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileUseCaseModule_ProvideSendPushTokenUseCaseFactory implements Factory<SendPushTokenUseCase> {
    private final ProfileUseCaseModule module;
    private final Provider<IProfileRepository> repositoryProvider;

    public ProfileUseCaseModule_ProvideSendPushTokenUseCaseFactory(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        this.module = profileUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public SendPushTokenUseCase get() {
        return provideSendPushTokenUseCase(this.module, this.repositoryProvider.get());
    }

    public static ProfileUseCaseModule_ProvideSendPushTokenUseCaseFactory create(ProfileUseCaseModule profileUseCaseModule, Provider<IProfileRepository> provider) {
        return new ProfileUseCaseModule_ProvideSendPushTokenUseCaseFactory(profileUseCaseModule, provider);
    }

    public static SendPushTokenUseCase provideSendPushTokenUseCase(ProfileUseCaseModule profileUseCaseModule, IProfileRepository iProfileRepository) {
        return (SendPushTokenUseCase) Preconditions.checkNotNullFromProvides(profileUseCaseModule.provideSendPushTokenUseCase(iProfileRepository));
    }
}
