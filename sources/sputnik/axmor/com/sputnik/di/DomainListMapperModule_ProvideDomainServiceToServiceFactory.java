package sputnik.axmor.com.sputnik.di;

import com.sputnik.common.entities.market.service.Service;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.market.services.DomainService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sputnik.axmor.com.sputnik.mappers.market.service.DomainServiceToServiceMapper;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainServiceToServiceFactory implements Factory<ListMapper<DomainService, Service>> {
    public static ListMapper<DomainService, Service> provideDomainServiceToService(DomainListMapperModule domainListMapperModule, DomainServiceToServiceMapper domainServiceToServiceMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainServiceToService(domainServiceToServiceMapper));
    }
}
