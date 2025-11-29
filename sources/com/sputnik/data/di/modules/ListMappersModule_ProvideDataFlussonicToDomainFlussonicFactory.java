package com.sputnik.data.di.modules;

import com.sputnik.data.entities.archive.DataFlussonic;
import com.sputnik.data.mappers.archive.DataFlussonicToDomainFlussonicMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.archive.DomainFlussonic;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataFlussonicToDomainFlussonicFactory implements Factory<ListMapper<DataFlussonic, DomainFlussonic>> {
    public static ListMapper<DataFlussonic, DomainFlussonic> provideDataFlussonicToDomainFlussonic(ListMappersModule listMappersModule, DataFlussonicToDomainFlussonicMapper dataFlussonicToDomainFlussonicMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataFlussonicToDomainFlussonic(dataFlussonicToDomainFlussonicMapper));
    }
}
