package sputnik.axmor.com.sputnik.di;

import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.family.DomainFamily;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import sputnik.axmor.com.sputnik.entities.family.Family;
import sputnik.axmor.com.sputnik.mappers.family.DomainFamilyToFamilyMapper;

/* loaded from: classes5.dex */
public final class DomainListMapperModule_ProvideDomainFamilyToFamilyFactory implements Factory<ListMapper<DomainFamily, Family>> {
    public static ListMapper<DomainFamily, Family> provideDomainFamilyToFamily(DomainListMapperModule domainListMapperModule, DomainFamilyToFamilyMapper domainFamilyToFamilyMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainListMapperModule.provideDomainFamilyToFamily(domainFamilyToFamilyMapper));
    }
}
