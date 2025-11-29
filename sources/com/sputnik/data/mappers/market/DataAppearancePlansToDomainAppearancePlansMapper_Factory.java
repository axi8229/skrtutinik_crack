package com.sputnik.data.mappers.market;

import com.sputnik.data.entities.market.DataSubsPlans;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DataAppearancePlansToDomainAppearancePlansMapper_Factory implements Factory<DataAppearancePlansToDomainAppearancePlansMapper> {
    private final Provider<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> mapperProvider;

    public DataAppearancePlansToDomainAppearancePlansMapper_Factory(Provider<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> provider) {
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public DataAppearancePlansToDomainAppearancePlansMapper get() {
        return newInstance(this.mapperProvider.get());
    }

    public static DataAppearancePlansToDomainAppearancePlansMapper_Factory create(Provider<NullableInputListMapper<DataSubsPlans, DomainSubsPlans>> provider) {
        return new DataAppearancePlansToDomainAppearancePlansMapper_Factory(provider);
    }

    public static DataAppearancePlansToDomainAppearancePlansMapper newInstance(NullableInputListMapper<DataSubsPlans, DomainSubsPlans> nullableInputListMapper) {
        return new DataAppearancePlansToDomainAppearancePlansMapper(nullableInputListMapper);
    }
}
