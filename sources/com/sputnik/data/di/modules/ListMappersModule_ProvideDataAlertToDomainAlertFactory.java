package com.sputnik.data.di.modules;

import com.sputnik.data.entities.alerts.DataAlert;
import com.sputnik.data.mappers.alerts.DataAlertToDomainAlertMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.alers.DomainAlert;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataAlertToDomainAlertFactory implements Factory<ListMapper<DataAlert, DomainAlert>> {
    private final Provider<DataAlertToDomainAlertMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataAlertToDomainAlertFactory(ListMappersModule listMappersModule, Provider<DataAlertToDomainAlertMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataAlert, DomainAlert> get() {
        return provideDataAlertToDomainAlert(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataAlertToDomainAlertFactory create(ListMappersModule listMappersModule, Provider<DataAlertToDomainAlertMapper> provider) {
        return new ListMappersModule_ProvideDataAlertToDomainAlertFactory(listMappersModule, provider);
    }

    public static ListMapper<DataAlert, DomainAlert> provideDataAlertToDomainAlert(ListMappersModule listMappersModule, DataAlertToDomainAlertMapper dataAlertToDomainAlertMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataAlertToDomainAlert(dataAlertToDomainAlertMapper));
    }
}
