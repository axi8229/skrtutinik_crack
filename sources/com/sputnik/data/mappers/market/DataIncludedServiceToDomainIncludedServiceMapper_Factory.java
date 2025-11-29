package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.DataSmallService;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataIncludedServiceToDomainIncludedServiceMapper_Factory implements Factory<DataIncludedServiceToDomainIncludedServiceMapper> {
    private final Provider<NullableInputListMapper<DataSmallService, DomainSmallServices>> mapperProvider;

    public DataIncludedServiceToDomainIncludedServiceMapper_Factory(Provider<NullableInputListMapper<DataSmallService, DomainSmallServices>> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataIncludedServiceToDomainIncludedServiceMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DataIncludedServiceToDomainIncludedServiceMapper_Factory create(Provider<NullableInputListMapper<DataSmallService, DomainSmallServices>> provider) {
        return new DataIncludedServiceToDomainIncludedServiceMapper_Factory(provider);
    }

    public static DataIncludedServiceToDomainIncludedServiceMapper newInstance(NullableInputListMapper<DataSmallService, DomainSmallServices> nullableInputListMapper) {
        return new DataIncludedServiceToDomainIncludedServiceMapper(nullableInputListMapper);
    }
}
