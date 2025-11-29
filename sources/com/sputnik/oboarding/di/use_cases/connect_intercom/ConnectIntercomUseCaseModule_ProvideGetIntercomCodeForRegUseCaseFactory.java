package com.sputnik.oboarding.di.use_cases.connect_intercom;

import com.sputnik.domain.repositories.registration.IConnectIntercomRepository;
import com.sputnik.domain.usecases.registration.GetIntercomCodeForRegUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ConnectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory implements Factory<GetIntercomCodeForRegUseCase> {
    private final ConnectIntercomUseCaseModule module;
    private final Provider<IConnectIntercomRepository> repositoryProvider;

    public ConnectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory(ConnectIntercomUseCaseModule connectIntercomUseCaseModule, Provider<IConnectIntercomRepository> provider) {
        this.module = connectIntercomUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetIntercomCodeForRegUseCase get() {
        return provideGetIntercomCodeForRegUseCase(this.module, this.repositoryProvider.get());
    }

    public static ConnectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory create(ConnectIntercomUseCaseModule connectIntercomUseCaseModule, Provider<IConnectIntercomRepository> provider) {
        return new ConnectIntercomUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory(connectIntercomUseCaseModule, provider);
    }

    public static GetIntercomCodeForRegUseCase provideGetIntercomCodeForRegUseCase(ConnectIntercomUseCaseModule connectIntercomUseCaseModule, IConnectIntercomRepository iConnectIntercomRepository) {
        return (GetIntercomCodeForRegUseCase) Preconditions.checkNotNullFromProvides(connectIntercomUseCaseModule.provideGetIntercomCodeForRegUseCase(iConnectIntercomRepository));
    }
}
