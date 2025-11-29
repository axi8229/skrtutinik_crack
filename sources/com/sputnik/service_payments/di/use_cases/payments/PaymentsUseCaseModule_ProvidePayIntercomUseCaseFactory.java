package com.sputnik.service_payments.di.use_cases.payments;

import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import com.sputnik.domain.usecases.service_payments.PayIntercomUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory implements Factory<PayIntercomUseCase> {
    private final PaymentsUseCaseModule module;
    private final Provider<IServicePaymentsRepository> repositoryProvider;

    public PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        this.module = paymentsUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public PayIntercomUseCase get() {
        return providePayIntercomUseCase(this.module, this.repositoryProvider.get());
    }

    public static PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory create(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        return new PaymentsUseCaseModule_ProvidePayIntercomUseCaseFactory(paymentsUseCaseModule, provider);
    }

    public static PayIntercomUseCase providePayIntercomUseCase(PaymentsUseCaseModule paymentsUseCaseModule, IServicePaymentsRepository iServicePaymentsRepository) {
        return (PayIntercomUseCase) Preconditions.checkNotNullFromProvides(paymentsUseCaseModule.providePayIntercomUseCase(iServicePaymentsRepository));
    }
}
