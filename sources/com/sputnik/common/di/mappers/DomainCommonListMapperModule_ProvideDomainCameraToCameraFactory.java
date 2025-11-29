package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.cameras.DomainCamera;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory implements Factory<ListMapper<DomainCamera, Camera>> {
    private final Provider<DomainCameraToCameraMapper> mapperProvider;
    private final DomainCommonListMapperModule module;

    public DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainCameraToCameraMapper> provider) {
        this.module = domainCommonListMapperModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public ListMapper<DomainCamera, Camera> get() {
        return provideDomainCameraToCamera(this.module, this.mapperProvider.get());
    }

    public static DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory create(DomainCommonListMapperModule domainCommonListMapperModule, Provider<DomainCameraToCameraMapper> provider) {
        return new DomainCommonListMapperModule_ProvideDomainCameraToCameraFactory(domainCommonListMapperModule, provider);
    }

    public static ListMapper<DomainCamera, Camera> provideDomainCameraToCamera(DomainCommonListMapperModule domainCommonListMapperModule, DomainCameraToCameraMapper domainCameraToCameraMapper) {
        return (ListMapper) Preconditions.checkNotNullFromProvides(domainCommonListMapperModule.provideDomainCameraToCamera(domainCameraToCameraMapper));
    }
}
