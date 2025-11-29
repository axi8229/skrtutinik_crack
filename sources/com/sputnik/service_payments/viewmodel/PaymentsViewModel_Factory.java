package com.sputnik.service_payments.viewmodel;

import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.service_payments.GetPaymentStatusUseCase;
import com.sputnik.domain.usecases.service_payments.PayIntercomUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PaymentsViewModel_Factory implements Factory<PaymentsViewModel> {
    private final Provider<IConfig> configProvider;
    private final Provider<GetPaymentStatusUseCase> getPaymentStatusUseCaseProvider;
    private final Provider<PayIntercomUseCase> payIntercomUseCaseProvider;
    private final Provider<PrefManager> prefsProvider;

    public PaymentsViewModel_Factory(Provider<IConfig> provider, Provider<PrefManager> provider2, Provider<PayIntercomUseCase> provider3, Provider<GetPaymentStatusUseCase> provider4) {
        this.configProvider = provider;
        this.prefsProvider = provider2;
        this.payIntercomUseCaseProvider = provider3;
        this.getPaymentStatusUseCaseProvider = provider4;
    }

    @Override // javax.inject.Provider
    public PaymentsViewModel get() {
        return newInstance(this.configProvider.get(), this.prefsProvider.get(), this.payIntercomUseCaseProvider.get(), this.getPaymentStatusUseCaseProvider.get());
    }

    public static PaymentsViewModel_Factory create(Provider<IConfig> provider, Provider<PrefManager> provider2, Provider<PayIntercomUseCase> provider3, Provider<GetPaymentStatusUseCase> provider4) {
        return new PaymentsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static PaymentsViewModel newInstance(IConfig iConfig, PrefManager prefManager, PayIntercomUseCase payIntercomUseCase, GetPaymentStatusUseCase getPaymentStatusUseCase) {
        return new PaymentsViewModel(iConfig, prefManager, payIntercomUseCase, getPaymentStatusUseCase);
    }
}
