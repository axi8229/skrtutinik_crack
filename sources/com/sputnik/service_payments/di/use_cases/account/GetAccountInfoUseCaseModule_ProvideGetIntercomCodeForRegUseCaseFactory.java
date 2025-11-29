package com.sputnik.service_payments.di.use_cases.account;

import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import com.sputnik.domain.usecases.service_payments.GetServiceAccountInfoUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory implements Factory<GetServiceAccountInfoUseCase> {
    private final GetAccountInfoUseCaseModule module;
    private final Provider<IServicePaymentsRepository> repositoryProvider;

    public GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory(GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        this.module = getAccountInfoUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetServiceAccountInfoUseCase get() {
        return provideGetIntercomCodeForRegUseCase(this.module, this.repositoryProvider.get());
    }

    public static GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory create(GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        return new GetAccountInfoUseCaseModule_ProvideGetIntercomCodeForRegUseCaseFactory(getAccountInfoUseCaseModule, provider);
    }

    public static GetServiceAccountInfoUseCase provideGetIntercomCodeForRegUseCase(GetAccountInfoUseCaseModule getAccountInfoUseCaseModule, IServicePaymentsRepository iServicePaymentsRepository) {
        return (GetServiceAccountInfoUseCase) Preconditions.checkNotNullFromProvides(getAccountInfoUseCaseModule.provideGetIntercomCodeForRegUseCase(iServicePaymentsRepository));
    }
}
