package com.sputnik.oboarding.di.use_cases.auth;

import com.sputnik.domain.repositories.auth.IAuthRepository;
import com.sputnik.domain.usecases.auth.RegisterUserByPhoneUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AuthUseCaseModule_ProvideRegisterUserByPhoneUseCaseFactory implements Factory<RegisterUserByPhoneUseCase> {
    private final AuthUseCaseModule module;
    private final Provider<IAuthRepository> repositoryProvider;

    public AuthUseCaseModule_ProvideRegisterUserByPhoneUseCaseFactory(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        this.module = authUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public RegisterUserByPhoneUseCase get() {
        return provideRegisterUserByPhoneUseCase(this.module, this.repositoryProvider.get());
    }

    public static AuthUseCaseModule_ProvideRegisterUserByPhoneUseCaseFactory create(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        return new AuthUseCaseModule_ProvideRegisterUserByPhoneUseCaseFactory(authUseCaseModule, provider);
    }

    public static RegisterUserByPhoneUseCase provideRegisterUserByPhoneUseCase(AuthUseCaseModule authUseCaseModule, IAuthRepository iAuthRepository) {
        return (RegisterUserByPhoneUseCase) Preconditions.checkNotNullFromProvides(authUseCaseModule.provideRegisterUserByPhoneUseCase(iAuthRepository));
    }
}
