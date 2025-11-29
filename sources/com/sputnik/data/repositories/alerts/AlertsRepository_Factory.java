package com.sputnik.data.repositories.alerts;

import com.sputnik.data.api.AlertsApi;
import com.sputnik.data.entities.alerts.DataAlert;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.alers.DomainAlert;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AlertsRepository_Factory implements Factory<AlertsRepository> {
    private final Provider<ListMapper<DataAlert, DomainAlert>> alertMapperProvider;
    private final Provider<AlertsApi> apiProvider;

    public AlertsRepository_Factory(Provider<AlertsApi> provider, Provider<ListMapper<DataAlert, DomainAlert>> provider2) {
        this.apiProvider = provider;
        this.alertMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public AlertsRepository get() {
        return newInstance(this.apiProvider.get(), this.alertMapperProvider.get());
    }

    public static AlertsRepository_Factory create(Provider<AlertsApi> provider, Provider<ListMapper<DataAlert, DomainAlert>> provider2) {
        return new AlertsRepository_Factory(provider, provider2);
    }

    public static AlertsRepository newInstance(AlertsApi alertsApi, ListMapper<DataAlert, DomainAlert> listMapper) {
        return new AlertsRepository(alertsApi, listMapper);
    }
}
