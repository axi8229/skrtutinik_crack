package sputnik.axmor.com.sputnik.di.use_cases.manage_cameras;

import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
import com.sputnik.domain.usecases.manage_cameras.SetCameraParamsUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class ManageCamerasUseCaseModule_ProvideSetCameraParamsUseCaseFactory implements Factory<SetCameraParamsUseCase> {
    public static SetCameraParamsUseCase provideSetCameraParamsUseCase(ManageCamerasUseCaseModule manageCamerasUseCaseModule, IManageCamerasRepository iManageCamerasRepository) {
        return (SetCameraParamsUseCase) Preconditions.checkNotNullFromProvides(manageCamerasUseCaseModule.provideSetCameraParamsUseCase(iManageCamerasRepository));
    }
}
