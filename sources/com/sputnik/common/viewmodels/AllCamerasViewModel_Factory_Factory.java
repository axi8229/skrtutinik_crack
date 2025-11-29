package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.camera.Camera;
import com.sputnik.common.mappers.cameras.DomainCameraToCameraMapper;
import com.sputnik.common.viewmodels.AllCamerasViewModel;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.ListMapper;
import com.sputnik.domain.entities.cameras.DomainCamera;
import com.sputnik.domain.usecases.cameras.GetAllCamerasUseCase;
import com.sputnik.domain.usecases.cameras.GetCamerasDemoUseCase;
import com.sputnik.domain.usecases.cameras.OpenDoorUseCase;
import com.sputnik.domain.usecases.cameras.OpenSecondDoorUseCase;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AllCamerasViewModel_Factory_Factory {
    private final Provider<DomainCameraToCameraMapper> domainCameraToCameraMapperProvider;
    private final Provider<GetAllCamerasUseCase> getAllCamerasUseCaseProvider;
    private final Provider<GetCamerasDemoUseCase> getDemoCamerasUseCaseProvider;
    private final Provider<ListMapper<DomainCamera, Camera>> listMapperProvider;
    private final Provider<OpenDoorUseCase> openDoorUseCaseProvider;
    private final Provider<OpenSecondDoorUseCase> openSecondDoorUseCaseProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public AllCamerasViewModel_Factory_Factory(Provider<GetAllCamerasUseCase> provider, Provider<GetCamerasDemoUseCase> provider2, Provider<OpenDoorUseCase> provider3, Provider<OpenSecondDoorUseCase> provider4, Provider<DomainCameraToCameraMapper> provider5, Provider<ListMapper<DomainCamera, Camera>> provider6, Provider<PrefManager> provider7) {
        this.getAllCamerasUseCaseProvider = provider;
        this.getDemoCamerasUseCaseProvider = provider2;
        this.openDoorUseCaseProvider = provider3;
        this.openSecondDoorUseCaseProvider = provider4;
        this.domainCameraToCameraMapperProvider = provider5;
        this.listMapperProvider = provider6;
        this.prefManagerProvider = provider7;
    }

    public AllCamerasViewModel.Factory get(String str) {
        return newInstance(str, this.getAllCamerasUseCaseProvider.get(), this.getDemoCamerasUseCaseProvider.get(), this.openDoorUseCaseProvider.get(), this.openSecondDoorUseCaseProvider.get(), this.domainCameraToCameraMapperProvider.get(), this.listMapperProvider.get(), this.prefManagerProvider.get());
    }

    public static AllCamerasViewModel_Factory_Factory create(Provider<GetAllCamerasUseCase> provider, Provider<GetCamerasDemoUseCase> provider2, Provider<OpenDoorUseCase> provider3, Provider<OpenSecondDoorUseCase> provider4, Provider<DomainCameraToCameraMapper> provider5, Provider<ListMapper<DomainCamera, Camera>> provider6, Provider<PrefManager> provider7) {
        return new AllCamerasViewModel_Factory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static AllCamerasViewModel.Factory newInstance(String str, GetAllCamerasUseCase getAllCamerasUseCase, GetCamerasDemoUseCase getCamerasDemoUseCase, OpenDoorUseCase openDoorUseCase, OpenSecondDoorUseCase openSecondDoorUseCase, DomainCameraToCameraMapper domainCameraToCameraMapper, ListMapper<DomainCamera, Camera> listMapper, PrefManager prefManager) {
        return new AllCamerasViewModel.Factory(str, getAllCamerasUseCase, getCamerasDemoUseCase, openDoorUseCase, openSecondDoorUseCase, domainCameraToCameraMapper, listMapper, prefManager);
    }
}
