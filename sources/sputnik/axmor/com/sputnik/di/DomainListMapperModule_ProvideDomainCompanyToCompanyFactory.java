package sputnik.axmor.com.sputnik.di;

import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.company.DomainCompany;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sputnik.axmor.com.sputnik.entities.company.Company;
import sputnik.axmor.com.sputnik.mappers.company.DomainCompanyToCompanyMapper;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainCompanyToCompanyFactory implements Factory<ListMapper<DomainCompany, Company>> {
    public static ListMapper<DomainCompany, Company> provideDomainCompanyToCompany(DomainListMapperModule domainListMapperModule, DomainCompanyToCompanyMapper domainCompanyToCompanyMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainCompanyToCompany(domainCompanyToCompanyMapper));
    }
}
