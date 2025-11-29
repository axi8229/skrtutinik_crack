package com.sputnik.oboarding.di.use_cases.auth;

import com.sputnik.domain.repositories.auth.IAuthRepository;
import com.sputnik.domain.usecases.auth.GetRequestUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AuthUseCaseModule_ProvideGetRequestUseCaseFactory implements Factory<GetRequestUseCase> {
    private final AuthUseCaseModule module;
    private final Provider<IAuthRepository> repositoryProvider;

    public AuthUseCaseModule_ProvideGetRequestUseCaseFactory(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        this.module = authUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetRequestUseCase get() {
        return provideGetRequestUseCase(this.module, this.repositoryProvider.get());
    }

    public static AuthUseCaseModule_ProvideGetRequestUseCaseFactory create(AuthUseCaseModule authUseCaseModule, Provider<IAuthRepository> provider) {
        return new AuthUseCaseModule_ProvideGetRequestUseCaseFactory(authUseCaseModule, provider);
    }

    public static GetRequestUseCase provideGetRequestUseCase(AuthUseCaseModule authUseCaseModule, IAuthRepository iAuthRepository) {
        return (GetRequestUseCase) Preconditions.checkNotNullFromProvides(authUseCaseModule.provideGetRequestUseCase(iAuthRepository));
    }
}
