package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.market.market.SubsPlans;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.DomainSubsPlans;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainSubsPlansToSubsPlansMapper;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainSubsPlansToSubsPlansFactory implements Factory<NullableInputListMapper<DomainSubsPlans, SubsPlans>> {
    public static NullableInputListMapper<DomainSubsPlans, SubsPlans> provideDomainSubsPlansToSubsPlans(DomainListMapperModule domainListMapperModule, DomainSubsPlansToSubsPlansMapper domainSubsPlansToSubsPlansMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainSubsPlansToSubsPlans(domainSubsPlansToSubsPlansMapper));
    }
}
