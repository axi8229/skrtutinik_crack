package com.sputnik.service_payments.di.use_cases.payments;

import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import com.sputnik.domain.usecases.service_payments.GetPaymentStatusUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory implements Factory<GetPaymentStatusUseCase> {
    private final PaymentsUseCaseModule module;
    private final Provider<IServicePaymentsRepository> repositoryProvider;

    public PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        this.module = paymentsUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetPaymentStatusUseCase get() {
        return provideGetPaymentStatusUseCase(this.module, this.repositoryProvider.get());
    }

    public static PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory create(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        return new PaymentsUseCaseModule_ProvideGetPaymentStatusUseCaseFactory(paymentsUseCaseModule, provider);
    }

    public static GetPaymentStatusUseCase provideGetPaymentStatusUseCase(PaymentsUseCaseModule paymentsUseCaseModule, IServicePaymentsRepository iServicePaymentsRepository) {
        return (GetPaymentStatusUseCase) Preconditions.checkNotNullFromProvides(paymentsUseCaseModule.provideGetPaymentStatusUseCase(iServicePaymentsRepository));
    }
}
