package com.sputnik.data.di.modules;

import com.sputnik.data.entities.digital_keys.DataDigitalKey;
import com.sputnik.data.mappers.digital_keys.DataDigitalKeyToDomainDigitalKeyMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.digital_keys.DomainDigitalKey;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataDigitalKeyToDomainDigitalKeyFactory implements Factory<ListMapper<DataDigitalKey, DomainDigitalKey>> {
    public static ListMapper<DataDigitalKey, DomainDigitalKey> provideDataDigitalKeyToDomainDigitalKey(ListMappersModule listMappersModule, DataDigitalKeyToDomainDigitalKeyMapper dataDigitalKeyToDomainDigitalKeyMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataDigitalKeyToDomainDigitalKey(dataDigitalKeyToDomainDigitalKeyMapper));
    }
}
