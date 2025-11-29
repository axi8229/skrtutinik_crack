package com.sputnik.data.di.modules;

import com.sputnik.data.entities.address.DataCustomAddress;
import com.sputnik.data.mappers.address.DataCustomAddressToDomainCustomAddressMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.address.DomainCustomAddress;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataCustomAddressToDomainCustomAddressFactory implements Factory<ListMapper<DataCustomAddress, DomainCustomAddress>> {
    public static ListMapper<DataCustomAddress, DomainCustomAddress> provideDataCustomAddressToDomainCustomAddress(ListMappersModule listMappersModule, DataCustomAddressToDomainCustomAddressMapper dataCustomAddressToDomainCustomAddressMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataCustomAddressToDomainCustomAddress(dataCustomAddressToDomainCustomAddressMapper));
    }
}
