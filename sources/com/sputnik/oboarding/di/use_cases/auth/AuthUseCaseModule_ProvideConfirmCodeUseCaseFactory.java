package com.sputnik.oboarding.di.use_cases.auth;

import com.sputnik.domain.repositories.auth.IAuthRepository;
import com.sputnik.domain.usecases.auth.ConfirmCodeUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AuthUseCaseModule_ProvideConfirmCodeUseCaseFactory implements Factory<ConfirmCodeUseCase> {
    private final AuthUseCaseModule module;
    private final Provider<IAuthRepository> repositoryProvider;

    public AuthUseCaseModule_ProvideConfirmCodeUseCaseFactory(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        this.module = authUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public ConfirmCodeUseCase get() {
        return provideConfirmCodeUseCase(this.module, this.repositoryProvider.get());
    }

    public static AuthUseCaseModule_ProvideConfirmCodeUseCaseFactory create(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        return new AuthUseCaseModule_ProvideConfirmCodeUseCaseFactory(authUseCaseModule, provider);
    }

    public static ConfirmCodeUseCase provideConfirmCodeUseCase(AuthUseCaseModule authUseCaseModule, IAuthRepository iAuthRepository) {
        return (ConfirmCodeUseCase) Preconditions.checkNotNullFromProvides(authUseCaseModule.provideConfirmCodeUseCase(iAuthRepository));
    }
}
