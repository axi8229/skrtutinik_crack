package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.country_code.CountryCode;
import com.sputnik.common.mappers.country_code.DomainCountryCodeToCountryCodeMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.county_code.DomainCountryCode;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactory implements Factory<ListMapper<DomainCountryCode, CountryCode>> {
    private final Provider<DomainCountryCodeToCountryCodeMapper> mapperProvider;
    private final DomainCommonListMapperModule module;

    public DomainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactory(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainCountryCodeToCountryCodeMapper> provider) {
        this.module = domainCommonListMapperModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DomainCountryCode, CountryCode> get() {
        return provideDomainCountryCodeToCountryCode(this.module, this.mapperProvider.get());
    }

    public static DomainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactory create(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainCountryCodeToCountryCodeMapper> provider) {
        return new DomainCommonListMapperModule_ProvideDomainCountryCodeToCountryCodeFactory(domainCommonListMapperModule, provider);
    }

    public static ListMapper<DomainCountryCode, CountryCode> provideDomainCountryCodeToCountryCode(DomainCommonListMapperModule domainCommonListMapperModule, DomainCountryCodeToCountryCodeMapper domainCountryCodeToCountryCodeMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainCommonListMapperModule.provideDomainCountryCodeToCountryCode(domainCountryCodeToCountryCodeMapper));
    }
}
