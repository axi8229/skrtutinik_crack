package com.sputnik.common.viewmodels;

import com.sputnik.common.mappers.alerts.DomainAlertToAlertMapper;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.usecases.alerts.GetAlertsUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AlertsViewModel_Factory implements Factory<AlertsViewModel> {
    private final Provider<IConfig> configProvider;
    private final Provider<DomainAlertToAlertMapper> domainAlertToAlertMapperProvider;
    private final Provider<GetAlertsUseCase> getAlertsUseCaseProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public AlertsViewModel_Factory(Provider<GetAlertsUseCase> provider, Provider<DomainAlertToAlertMapper> provider2, Provider<IConfig> provider3, Provider<PrefManager> provider4) {
        this.getAlertsUseCaseProvider = provider;
        this.domainAlertToAlertMapperProvider = provider2;
        this.configProvider = provider3;
        this.prefManagerProvider = provider4;
    }

    @Override // javax.inject.Provider
    public AlertsViewModel get() {
        return newInstance(this.getAlertsUseCaseProvider.get(), this.domainAlertToAlertMapperProvider.get(), this.configProvider.get(), this.prefManagerProvider.get());
    }

    public static AlertsViewModel_Factory create(Provider<GetAlertsUseCase> provider, Provider<DomainAlertToAlertMapper> provider2, Provider<IConfig> provider3, Provider<PrefManager> provider4) {
        return new AlertsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static AlertsViewModel newInstance(GetAlertsUseCase getAlertsUseCase, DomainAlertToAlertMapper domainAlertToAlertMapper, IConfig iConfig, PrefManager prefManager) {
        return new AlertsViewModel(getAlertsUseCase, domainAlertToAlertMapper, iConfig, prefManager);
    }
}
