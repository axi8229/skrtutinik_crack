package com.sputnik.oboarding.ui.registration.viewmodel;

import com.sputnik.domain.usecases.registration.GetIntercomCodeForRegUseCase;
import com.sputnik.oboarding.mappers.connect_intercom.DomainActivationCodeToActivationCodeMapper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ConnectIntercomViewModel_Factory implements Factory<ConnectIntercomViewModel> {
    private final Provider<DomainActivationCodeToActivationCodeMapper> domainActivationCodeToActivationCodeMapperProvider;
    private final Provider<GetIntercomCodeForRegUseCase> getIntercomCodeForRegUseCaseProvider;

    public ConnectIntercomViewModel_Factory(Provider<GetIntercomCodeForRegUseCase> provider, Provider<DomainActivationCodeToActivationCodeMapper> provider2) {
        this.getIntercomCodeForRegUseCaseProvider = provider;
        this.domainActivationCodeToActivationCodeMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public ConnectIntercomViewModel get() {
        return newInstance(this.getIntercomCodeForRegUseCaseProvider.get(), this.domainActivationCodeToActivationCodeMapperProvider.get());
    }

    public static ConnectIntercomViewModel_Factory create(Provider<GetIntercomCodeForRegUseCase> provider, Provider<DomainActivationCodeToActivationCodeMapper> provider2) {
        return new ConnectIntercomViewModel_Factory(provider, provider2);
    }

    public static ConnectIntercomViewModel newInstance(GetIntercomCodeForRegUseCase getIntercomCodeForRegUseCase, DomainActivationCodeToActivationCodeMapper domainActivationCodeToActivationCodeMapper) {
        return new ConnectIntercomViewModel(getIntercomCodeForRegUseCase, domainActivationCodeToActivationCodeMapper);
    }
}
