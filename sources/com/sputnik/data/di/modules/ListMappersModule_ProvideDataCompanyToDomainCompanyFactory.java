package com.sputnik.data.di.modules;

import com.sputnik.data.entities.company.DataCompany;
import com.sputnik.data.mappers.company.DataCompanyToDomainCompanyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.company.DomainCompany;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataCompanyToDomainCompanyFactory implements Factory<ListMapper<DataCompany, DomainCompany>> {
    public static ListMapper<DataCompany, DomainCompany> provideDataCompanyToDomainCompany(ListMappersModule listMappersModule, DataCompanyToDomainCompanyMapper dataCompanyToDomainCompanyMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataCompanyToDomainCompany(dataCompanyToDomainCompanyMapper));
    }
}
