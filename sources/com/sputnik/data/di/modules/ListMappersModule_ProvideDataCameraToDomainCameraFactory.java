package com.sputnik.data.di.modules;

import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.cameras.DomainCamera;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ListMappersModule_ProvideDataCameraToDomainCameraFactory implements Factory<NullableInputListMapper<DataCamera, DomainCamera>> {
    private final Provider<DataCameraToDomainCameraMapper> mapperProvider;
    private final ListMappersModule module;

    public ListMappersModule_ProvideDataCameraToDomainCameraFactory(ListMappersModule listMappersModule, Provider<DataCameraToDomainCameraMapper> provider) {
        this.module = listMappersModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DataCamera, DomainCamera> get() {
        return provideDataCameraToDomainCamera(this.module, this.mapperProvider.get());
    }

    public static ListMappersModule_ProvideDataCameraToDomainCameraFactory create(ListMappersModule listMappersModule, Provider<DataCameraToDomainCameraMapper> provider) {
        return new ListMappersModule_ProvideDataCameraToDomainCameraFactory(listMappersModule, provider);
    }

    public static NullableInputListMapper<DataCamera, DomainCamera> provideDataCameraToDomainCamera(ListMappersModule listMappersModule, DataCameraToDomainCameraMapper dataCameraToDomainCameraMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(listMappersModule.provideDataCameraToDomainCamera(dataCameraToDomainCameraMapper));
    }
}
