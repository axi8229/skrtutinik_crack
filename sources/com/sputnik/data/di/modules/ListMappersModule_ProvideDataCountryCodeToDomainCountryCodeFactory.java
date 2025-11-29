package com.sputnik.data.di.modules;

import com.sputnik.data.entities.country_code.DataCountryCode;
import com.sputnik.data.mappers.country_code.DataCountryCodeToDomainCountryCodeMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory implements Factory<ListMapper<DataCountryCode, DomainCountryCode>> {
    private final Provider<DataCountryCodeToDomainCountryCodeMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory(ListMappersModule listMappersModule, Provider<DataCountryCodeToDomainCountryCodeMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DataCountryCode, DomainCountryCode> get() {
        return provideDataCountryCodeToDomainCountryCode(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory create(ListMappersModule listMappersModule, Provider<DataCountryCodeToDomainCountryCodeMapper> provider) {
        return new ListMappersModule_ProvideDataCountryCodeToDomainCountryCodeFactory(listMappersModule, provider);
    }

    public static ListMapper<DataCountryCode, DomainCountryCode> provideDataCountryCodeToDomainCountryCode(ListMappersModule listMappersModule, DataCountryCodeToDomainCountryCodeMapper dataCountryCodeToDomainCountryCodeMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataCountryCodeToDomainCountryCode(dataCountryCodeToDomainCountryCodeMapper));
    }
}
