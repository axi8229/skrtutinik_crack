package com.sputnik.service_payments.di.use_cases.payments;

import com.sputnik.domain.repositories.service_payments.IServicePaymentsRepository;
import com.sputnik.domain.usecases.service_payments.GetReceiptByAccrualUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory implements Factory<GetReceiptByAccrualUseCase> {
    private final PaymentsUseCaseModule module;
    private final Provider<IServicePaymentsRepository> repositoryProvider;

    public PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        this.module = paymentsUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetReceiptByAccrualUseCase get() {
        return provideGetReceiptByAccrualUseCase(this.module, this.repositoryProvider.get());
    }

    public static PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory create(PaymentsUseCaseModule paymentsUseCaseModule, Provider<IServicePaymentsRepository> provider) {
        return new PaymentsUseCaseModule_ProvideGetReceiptByAccrualUseCaseFactory(paymentsUseCaseModule, provider);
    }

    public static GetReceiptByAccrualUseCase provideGetReceiptByAccrualUseCase(PaymentsUseCaseModule paymentsUseCaseModule, IServicePaymentsRepository iServicePaymentsRepository) {
        return (GetReceiptByAccrualUseCase) Preconditions.checkNotNullFromProvides(paymentsUseCaseModule.provideGetReceiptByAccrualUseCase(iServicePaymentsRepository));
    }
}
