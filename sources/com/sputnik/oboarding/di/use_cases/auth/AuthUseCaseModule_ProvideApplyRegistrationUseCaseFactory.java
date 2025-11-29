package com.sputnik.oboarding.di.use_cases.auth;

import com.sputnik.domain.repositories.auth.IAuthRepository;
import com.sputnik.domain.usecases.auth.ApplyRegistrationUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AuthUseCaseModule_ProvideApplyRegistrationUseCaseFactory implements Factory<ApplyRegistrationUseCase> {
    private final AuthUseCaseModule module;
    private final Provider<IAuthRepository> repositoryProvider;

    public AuthUseCaseModule_ProvideApplyRegistrationUseCaseFactory(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        this.module = authUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public ApplyRegistrationUseCase get() {
        return provideApplyRegistrationUseCase(this.module, this.repositoryProvider.get());
    }

    public static AuthUseCaseModule_ProvideApplyRegistrationUseCaseFactory create(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        return new AuthUseCaseModule_ProvideApplyRegistrationUseCaseFactory(authUseCaseModule, provider);
    }

    public static ApplyRegistrationUseCase provideApplyRegistrationUseCase(AuthUseCaseModule authUseCaseModule, IAuthRepository iAuthRepository) {
        return (ApplyRegistrationUseCase) Preconditions.checkNotNullFromProvides(authUseCaseModule.provideApplyRegistrationUseCase(iAuthRepository));
    }
}
