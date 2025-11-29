package com.sputnik.data.di.modules;

import com.sputnik.data.entities.family.DataFamily;
import com.sputnik.data.mappers.family.DataFamilyToDomainFamilyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.family.DomainFamily;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataFamilyToDomainFamilyFactory implements Factory<ListMapper<DataFamily, DomainFamily>> {
    public static ListMapper<DataFamily, DomainFamily> provideDataFamilyToDomainFamily(ListMappersModule listMappersModule, DataFamilyToDomainFamilyMapper dataFamilyToDomainFamilyMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataFamilyToDomainFamily(dataFamilyToDomainFamilyMapper));
    }
}
