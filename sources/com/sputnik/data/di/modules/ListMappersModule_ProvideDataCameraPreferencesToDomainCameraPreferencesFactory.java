package com.sputnik.data.di.modules;

import com.sputnik.data.entities.cameras.DataCamerasOrder;
import com.sputnik.data.mappers.cameras.DataCamerasOrderToDomainCamerasOrderMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.cameras.DomainCamerasOrder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataCameraPreferencesToDomainCameraPreferencesFactory implements Factory<NullableInputListMapper<DataCamerasOrder, DomainCamerasOrder>> {
    public static NullableInputListMapper<DataCamerasOrder, DomainCamerasOrder> provideDataCameraPreferencesToDomainCameraPreferences(ListMappersModule listMappersModule, DataCamerasOrderToDomainCamerasOrderMapper dataCamerasOrderToDomainCamerasOrderMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataCameraPreferencesToDomainCameraPreferences(dataCamerasOrderToDomainCamerasOrderMapper));
    }
}
