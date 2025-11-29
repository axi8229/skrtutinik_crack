package com.sputnik.data.repositories.cameras;

import com.sputnik.data.api.CamerasApi;
import com.sputnik.data.entities.cameras.DataCamera;
import com.sputnik.data.local.PrefManager;
import com.sputnik.data.mappers.cameras.DataCameraToDomainCameraMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.cameras.DomainCamera;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class CamerasRepository_Factory implements Factory<CamerasRepository> {
    private final Provider<DataCameraToDomainCameraMapper> cameraMapperProvider;
    private final Provider<CamerasApi> camerasApiProvider;
    private final Provider<NullableInputListMapper<DataCamera, DomainCamera>> mapperProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public CamerasRepository_Factory(Provider<CamerasApi> provider, Provider<NullableInputListMapper<DataCamera, DomainCamera>> provider2, Provider<DataCameraToDomainCameraMapper> provider3, Provider<PrefManager> provider4) {
        this.camerasApiProvider = provider;
        this.mapperProvider = provider2;
        this.cameraMapperProvider = provider3;
        this.prefManagerProvider = provider4;
    }

    @Override // javax.inject.Provider
    public CamerasRepository get() {
        return newInstance(this.camerasApiProvider.get(), this.mapperProvider.get(), this.cameraMapperProvider.get(), this.prefManagerProvider.get());
    }

    public static CamerasRepository_Factory create(Provider<CamerasApi> provider, Provider<NullableInputListMapper<DataCamera, DomainCamera>> provider2, Provider<DataCameraToDomainCameraMapper> provider3, Provider<PrefManager> provider4) {
        return new CamerasRepository_Factory(provider, provider2, provider3, provider4);
    }

    public static CamerasRepository newInstance(CamerasApi camerasApi, NullableInputListMapper<DataCamera, DomainCamera> nullableInputListMapper, DataCameraToDomainCameraMapper dataCameraToDomainCameraMapper, PrefManager prefManager) {
        return new CamerasRepository(camerasApi, nullableInputListMapper, dataCameraToDomainCameraMapper, prefManager);
    }
}
