package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.market.market.SmallServices;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.market.services.DomainSmallServices;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sputnik.axmor.com.sputnik.mappers.market.market.DomainSmallServicesToSmallServicesMapper;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainSmallServiceToSmallServicesFactory implements Factory<NullableInputListMapper<DomainSmallServices, SmallServices>> {
    public static NullableInputListMapper<DomainSmallServices, SmallServices> provideDomainSmallServiceToSmallServices(DomainListMapperModule domainListMapperModule, DomainSmallServicesToSmallServicesMapper domainSmallServicesToSmallServicesMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainSmallServiceToSmallServices(domainSmallServicesToSmallServicesMapper));
    }
}
