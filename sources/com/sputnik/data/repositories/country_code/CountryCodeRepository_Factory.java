package com.sputnik.data.repositories.country_code;

import com.sputnik.data.entities.country_code.DataCountryCode;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CountryCodeRepository_Factory implements Factory<CountryCodeRepository> {
    private final Provider<ListMapper<DataCountryCode, DomainCountryCode>> dataCountryCodeToDomainCountryCodeMapperProvider;
    private final Provider<CountryCodeSource> sourceProvider;

    public CountryCodeRepository_Factory(Provider<CountryCodeSource> provider, Provider<ListMapper<DataCountryCode, DomainCountryCode>> provider2) {
        this.sourceProvider = provider;
        this.dataCountryCodeToDomainCountryCodeMapperProvider = provider2;
    }

    @Override // javax.inject.Provider
    public CountryCodeRepository get() {
        return newInstance(this.sourceProvider.get(), this.dataCountryCodeToDomainCountryCodeMapperProvider.get());
    }

    public static CountryCodeRepository_Factory create(Provider<CountryCodeSource> provider, Provider<ListMapper<DataCountryCode, DomainCountryCode>> provider2) {
        return new CountryCodeRepository_Factory(provider, provider2);
    }

    public static CountryCodeRepository newInstance(CountryCodeSource countryCodeSource, ListMapper<DataCountryCode, DomainCountryCode> listMapper) {
        return new CountryCodeRepository(countryCodeSource, listMapper);
    }
}
