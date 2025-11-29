package com.sputnik.oboarding.di.use_cases.auth;

import com.sputnik.domain.repositories.auth.IAuthRepository;
import com.sputnik.domain.usecases.auth.ConfirmRegistrationUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AuthUseCaseModule_ProvideConfirmRegistrationUseCaseFactory implements Factory<ConfirmRegistrationUseCase> {
    private final AuthUseCaseModule module;
    private final Provider<IAuthRepository> repositoryProvider;

    public AuthUseCaseModule_ProvideConfirmRegistrationUseCaseFactory(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        this.module = authUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public ConfirmRegistrationUseCase get() {
        return provideConfirmRegistrationUseCase(this.module, this.repositoryProvider.get());
    }

    public static AuthUseCaseModule_ProvideConfirmRegistrationUseCaseFactory create(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        return new AuthUseCaseModule_ProvideConfirmRegistrationUseCaseFactory(authUseCaseModule, provider);
    }

    public static ConfirmRegistrationUseCase provideConfirmRegistrationUseCase(AuthUseCaseModule authUseCaseModule, IAuthRepository iAuthRepository) {
        return (ConfirmRegistrationUseCase) Preconditions.checkNotNullFromProvides(authUseCaseModule.provideConfirmRegistrationUseCase(iAuthRepository));
    }
}
