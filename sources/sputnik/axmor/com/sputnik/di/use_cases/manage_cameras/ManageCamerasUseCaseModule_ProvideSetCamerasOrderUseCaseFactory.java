package sputnik.axmor.com.sputnik.di.use_cases.manage_cameras;

import com.sputnik.domain.repositories.manage_cameras.IManageCamerasRepository;
import com.sputnik.domain.usecases.manage_cameras.SetCamerasOrderUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes5.dex */
public final class ManageCamerasUseCaseModule_ProvideSetCamerasOrderUseCaseFactory implements Factory<SetCamerasOrderUseCase> {
    public static SetCamerasOrderUseCase provideSetCamerasOrderUseCase(ManageCamerasUseCaseModule manageCamerasUseCaseModule, IManageCamerasRepository iManageCamerasRepository) {
        return (SetCamerasOrderUseCase) Preconditions.checkNotNullFromProvides(manageCamerasUseCaseModule.provideSetCamerasOrderUseCase(iManageCamerasRepository));
    }
}
